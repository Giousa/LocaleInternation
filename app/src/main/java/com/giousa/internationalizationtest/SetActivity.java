package com.giousa.internationalizationtest;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Description:
 * Author:Giousa
 * Date:2017/1/11
 * Email:65489469@qq.com
 */
public class SetActivity extends AppCompatActivity {

    private final String TAG = SetActivity.class.getSimpleName();

    private final String action = "com.giousa.internationalizationtest.language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ButterKnife.inject(this);
        Log.d(TAG,"onCreate  我被调用了");
    }

    @OnClick({R.id.btn_simple_cn, R.id.btn_tra_cn, R.id.btn_en})
    public void onClick(View view) {

        Intent intent = new Intent(action);

        switch (view.getId()) {
            case R.id.btn_simple_cn:
                switchLanguage(Locale.SIMPLIFIED_CHINESE);
                sendBroadcast(intent);
                finish();
//                enterHome();
                break;
            case R.id.btn_tra_cn:
                switchLanguage(Locale.TRADITIONAL_CHINESE);
                sendBroadcast(intent);
                finish();
//                enterHome();
                break;
            case R.id.btn_en:
                switchLanguage(Locale.ENGLISH);
                sendBroadcast(intent);
                finish();
//                enterHome();
                break;
        }
    }

    private void enterHome() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        // 杀掉进程
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public void switchLanguage(Locale locale) {
        Resources resources = getResources();
        Configuration config = resources.getConfiguration();
        DisplayMetrics dm = resources.getDisplayMetrics();
        config.locale = locale;
        resources.updateConfiguration(config, dm);
    }


}
