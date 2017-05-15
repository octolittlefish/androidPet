package com.rdc.goospet.receiver;

import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by Shower on 2017/5/14.
 */

public class NotifyService extends NotificationListenerService {

    public static final String SEND_WX_BROADCAST="SEND_WX_BROADCAST";

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn, RankingMap rankingMap) {
        Log.e("AAA", "=2==onNotificationPosted   ID :"
                + sbn.getId() + "\t"
                + sbn.getNotification().tickerText + "\t"
                + sbn.getPackageName());
        String packageName=sbn.getPackageName();
        Intent intent=new Intent();
        intent.setAction(SEND_WX_BROADCAST);
        Bundle bundle=new Bundle();
        bundle.putString("packageName",packageName);
        intent.putExtras(bundle);
        this.sendBroadcast(intent);

    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn, RankingMap rankingMap) {
        Log.e("AAA", "=4==onNotificationRemoved   ID :"
                + sbn.getId() + "\t"
                + sbn.getNotification().tickerText
                + "\t" + sbn.getPackageName());
    }
}
