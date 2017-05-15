package com.rdc.goospet.receiver;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;

import com.rdc.goospet.R;
import com.rdc.goospet.view.widget.FloatingPetView;

/**
 * Created by Shower on 2017/5/14.
 */

public class ComeWxMessage {
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    public static final String SEND_WX_BROADCAST="SEND_WX_BROADCAST";
    public static final String QQ="com.tencent.mobileqq";
    public static final String WX="com.tencent.mm";
    public static final String MMS="com.android.mms";
    public static final String CALL="com.android.incallui";
    private MyMessage myMessage;
    private Context context;

    public ComeWxMessage(MyMessage myMessage, Context context) {
        this.myMessage = myMessage;
        this.context = context;
        registBroadCast();
    }

    private BroadcastReceiver b=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle=intent.getExtras();
            String pachageName=bundle.getString("packageName");
            switch (pachageName){
                case WX:
                    myMessage.comeWxMessage();
                    //这里写调用让宠物换微信图标的方法 参数换为微信图片
                    FloatingPetView.mIvPet.setBackgroundResource(R.drawable.ic_pet_hide_right);
                    break;
                case QQ:
                    myMessage.comeQQmessage();
                    //这里写调用让宠物换qq图标的方法
                    FloatingPetView.mIvPet.setBackgroundResource(R.drawable.ic_pet_hide_right);

                    break;
                case MMS:
                    myMessage.comeShortMessage();
                    //这里写调用让宠物换图标的方法
                    FloatingPetView.mIvPet.setBackgroundResource(R.drawable.ic_pet_hide_right);
                    break;
                case CALL:
                    myMessage.comePhone();
                    //这里写调用让宠物换图标的方法
                    FloatingPetView.mIvPet.setBackgroundResource(R.drawable.ic_pet_hide_right);
                    break;
            }
        }
    };
    private void registBroadCast() {
        IntentFilter filter=new IntentFilter(SEND_WX_BROADCAST);
        context.registerReceiver(b,filter);
    }
    public void unRegistBroadcast(){
        context.unregisterReceiver(b);
    }
    public void openSetting(){
        if (!isEnabled()) {
            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "已开启服务权限", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isEnabled() {
        String pkgName = context.getPackageName();
        final String flat = Settings.Secure.getString(context.getContentResolver(),
                ENABLED_NOTIFICATION_LISTENERS);
        if (!TextUtils.isEmpty(flat)) {
            final String[] names = flat.split(":");
            for (int i = 0; i < names.length; i++) {
                final ComponentName cn = ComponentName.unflattenFromString(names[i]);
                if (cn != null) {
                    if (TextUtils.equals(pkgName, cn.getPackageName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void toggleNotificationListenerService() {
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(
                new ComponentName(context,com.rdc.goospet.receiver.NotifyService.class),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);

        pm.setComponentEnabledSetting(
                new ComponentName(context,com.rdc.goospet.receiver.NotifyService.class),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
    }
}
