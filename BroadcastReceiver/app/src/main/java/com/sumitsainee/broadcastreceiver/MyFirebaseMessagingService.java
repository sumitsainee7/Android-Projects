package com.sumitsainee.broadcastreceiver;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("FCM Notification", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d("FCM Notification", "Message data payload: " + remoteMessage.getData());

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
                scheduleJob();
            } else {
                // Handle message within 10 seconds
                handleNow();
            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Intent intent=new Intent("com.travelindiaapp.NOTIFICATION_RECEIVED");
            intent.putExtra("com.travelindiaapp.EXTRA_TEXT","Notification Received");
            sendBroadcast(intent);
            Log.d("FCM Notification", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendN
        showNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }

    private void handleNow() {

    }

    private void scheduleJob() {

    }

    public void showNotification(String title, String message) {
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"MyNotification")
                .setContentTitle(title)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setAutoCancel(true)
                .setContentText(message);
        Log.d("showNotification","showed Notification");
        notificationManager.notify(0,builder.build());
    }
}

