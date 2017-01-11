package com.giousa.internationalizationtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Description:
 * Author:Giousa
 * Date:2017/1/11
 * Email:65489469@qq.com
 */
public class SwitchReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.d("","SwitchReceiver 被调用了");
        Intent it = new Intent(context,MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//这个必须加
        context.startActivity(it);
    }

}