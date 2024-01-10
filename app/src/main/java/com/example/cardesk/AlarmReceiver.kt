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

class AlarmReceiver: BroadcastReceiver() {
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
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(1223, builder.build())
        }
    }
}