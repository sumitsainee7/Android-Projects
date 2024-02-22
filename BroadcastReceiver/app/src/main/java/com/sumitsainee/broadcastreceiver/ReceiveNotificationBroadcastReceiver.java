package com.sumitsainee.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ReceiveNotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if("com.broadcastreceiver.NOTIFICATION_RECEIVED".equals(intent.getAction())){
            //String receivedText=intent.getStringExtra("com.travelindiaapp.EXTRA_TEXT");
            Toast.makeText(context, "Received Notification", Toast.LENGTH_SHORT).show();
            Log.d("Notification BroadCast","Successfull");
        }

    }
}
