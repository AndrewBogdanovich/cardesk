package com.example.cardesk

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class AlarmReceiver : BroadcastReceiver() {
    private val channelId = "idChanel"

    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.d("AlarmManager", "Received Intent")
        prepareNotification(p0 as Context)
    }

    private fun prepareNotification(context: Context) {
        createNotificationChannel(context)
        showNotification(context)
    }

    private fun createNotificationChannel(context: Context) {
        val name = "notificationChannel"
        val descriptionText = "description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun showNotification(context: Context){
        with(NotificationManagerCompat.from(context)) {
            if(!checkNotificationPermission(context)) return
            notify(Random.nextInt(), getNotificationViewBuilder(context).build())
        }
    }

    private fun checkNotificationPermission(context: Context): Boolean {
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED
    }

    private fun getNotificationViewBuilder(
        context: Context
    ): NotificationCompat.Builder =
        NotificationCompat.Builder(context, channelId).setSmallIcon(R.drawable.stab_app_logo)
            .setContentTitle("Notification from alarmManager")
            .setContentText("content of the notification")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
}