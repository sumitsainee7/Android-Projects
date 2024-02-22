package com.sumitsainee.broadcastreceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    ConnectionChangeBroadcastReceiver connectionChangeBroadcastReceiver=new ConnectionChangeBroadcastReceiver();
    ReceiveNotificationBroadcastReceiver receiveNotificationBroadcastReceiver=new ReceiveNotificationBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get notification for general topics
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "failed";
                        }
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
        // create a channelid for notification
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("MyNotification","MyNotification", NotificationManager.IMPORTANCE_DEFAULT);
        }
        //Broadscast receiver service on notification received
        IntentFilter intentFilterNR=new IntentFilter("com.broadcastreceiver.NOTIFICATION_RECEIVED");
        registerReceiver(receiveNotificationBroadcastReceiver,intentFilterNR);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectionChangeBroadcastReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(connectionChangeBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiveNotificationBroadcastReceiver);
    }

    public void signInToast() {
        Toast.makeText(MainActivity.this, "Sign In SuccessFull", Toast.LENGTH_SHORT).show();
    }
}