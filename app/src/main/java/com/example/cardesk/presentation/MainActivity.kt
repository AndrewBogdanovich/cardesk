package com.example.cardesk.presentation

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.cardesk.R
import com.example.cardesk.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Log.e("DDDD", "activity created")
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setSupportActionBar(binding.appToolbar)
        setupNavigationController()
        testAlarm()
    }

    private fun setupNavigationController() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        binding.bottomNavigationView.apply {
            navController.let { navController ->
                NavigationUI.setupWithNavController(this, navController)
                setOnItemSelectedListener { item ->
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                setOnItemReselectedListener {
                    navController.popBackStack(destinationId = it.itemId, inclusive = false)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("DDDD", "activity destroyed")
    }

    private fun testAlarm() {
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val calendar = Calendar.getInstance()
        val pendingIntent =
            PendingIntent.getBroadcast(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis+40000,
            pendingIntent
        )
    }
}

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("AlarmManager", "Received Intent")
        showNotification(p0 as Context)
    }

    private fun showNotification(context: Context) {
        val channelId = "idChanel"

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.stab_app_logo)
            .setContentTitle("Notification from alarmManager")
            .setContentText("content of the notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        val name = "notificationChannel"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }

        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

        with(NotificationManagerCompat.from(context)) {
            notify(1223, builder.build())
        }
    }
}