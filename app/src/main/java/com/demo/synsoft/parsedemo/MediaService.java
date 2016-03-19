package com.demo.synsoft.parsedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MediaService extends Service {
    MediaPlayer mediaPlayer =null;
    int length=0;
    public MediaService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mediaPlayer==null)
            mediaPlayer = MediaPlayer.create(this, R.raw.test);
        length=0;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        mediaPlayer.start();
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;

    }
}
