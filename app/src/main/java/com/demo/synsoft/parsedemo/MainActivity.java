package com.demo.synsoft.parsedemo;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import com.facebook.stetho.Stetho;

import me.everything.providers.stetho.ProvidersStetho;

public class MainActivity extends AppCompatActivity {

   // MediaPlayer mediaPlayer =null;
  //  int length=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Context context = this;
//        ProvidersStetho providersStetho = new ProvidersStetho(context);
//        providersStetho.enableDefaults();



        // stetho init
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(context)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
//                        .enableWebKitInspector(providersStetho.defaultInspectorModulesProvider())
//                        .build());
    }
//https://ia802508.us.archive.org/5/items/testmp3testfile/mpthreetest.mp3
    public void addMedialPlayer(View view)
    {
//        if (mediaPlayer==null)
//         mediaPlayer = MediaPlayer.create(this, R.raw.test);
//         length=0;
       // no need to call prepare(); create() does that for you
    }
    public void startMediaPlayer(View view)
    {
        Intent intent=new Intent(this,MediaService.class);
        startService(intent);
        //mediaPlayer.start();
    }
    public  void stopMediaPlayer(View view)
    {
       // mediaPlayer.stop();
      //  length=0;
        Intent intent=new Intent(this,MediaService.class);
        stopService(intent);
    }
    public  void pauseMediaPlayer(View view)
    {
//        mediaPlayer.pause();
//        length=mediaPlayer.getCurrentPosition();
    }
    public  void resumeMediaPlyer(View view)
    {
//        mediaPlayer.seekTo(length);
//        mediaPlayer.start();
        //showCustomNotification();
        createNotication();
    }

   // int icon = R.drawable.i;
    //
    public void showCustomNotification()
    {
        long when = System.currentTimeMillis();
        Notification notification = new Notification(R.mipmap.ic_launcher, "Custom Notification", when);

        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.custom_notification_layout);
        contentView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        contentView.setTextViewText(R.id.title, "Custom notification");
        contentView.setTextViewText(R.id.text, "This is a custom layout");
        notification.contentView = contentView;

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        notification.contentIntent = contentIntent;

        notification.flags |= Notification.FLAG_NO_CLEAR; //Do not clear the notification
        notification.defaults |= Notification.DEFAULT_LIGHTS; // LED
        notification.defaults |= Notification.DEFAULT_VIBRATE; //Vibration
        notification.defaults |= Notification.DEFAULT_SOUND; // Sound

        mNotificationManager.notify(1, notification);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void createNotication()
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher).setContentTitle("My notification").setContentText("Hello World!");
        RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.custom_notification_layout);
        contentView.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        contentView.setTextViewText(R.id.title, "Custom notification");
        contentView.setTextViewText(R.id.text, "This is a custom layout");
        Notification notificationCompat=mBuilder.build();
        mBuilder.setOngoing(true);
        notificationCompat.bigContentView=contentView;
        int mNotificationId = 001;
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, notificationCompat);
    }

}
