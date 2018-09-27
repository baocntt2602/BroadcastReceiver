package com.example.administrator.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class InternetReceiver extends BroadcastReceiver {
    static boolean isAirplaneEnabled;
    @Override
    public void onReceive(Context context, Intent intent) {
        isAirplaneEnabled = Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 1;


        if (isAirplaneEnabled) {
            Toast.makeText(context, "Air plane is ON", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Air plane is OFF", Toast.LENGTH_SHORT).show();
            NotificationHelper notificationHelper = new NotificationHelper(context);
            NotificationCompat.Builder nb = notificationHelper.getChannel1Notification("có wifi", "có mạng lại rồi kìa");
            notificationHelper.getManager().notify(1, nb.build());
        }
    }

}
