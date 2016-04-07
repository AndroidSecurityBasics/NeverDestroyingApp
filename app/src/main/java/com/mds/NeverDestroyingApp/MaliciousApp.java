package com.mds.NeverDestroyingApp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MaliciousApp extends Service {

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(new Intent(getApplicationContext(), NeverDestroyingActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK), startId);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent intent1 = new Intent(getApplicationContext(), NeverDestroyingActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent1);
        return super.onStartCommand(intent1, Intent.FLAG_ACTIVITY_NEW_TASK, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}