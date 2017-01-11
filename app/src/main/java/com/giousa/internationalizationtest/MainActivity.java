package com.giousa.internationalizationtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Log.d(TAG,"onCreate  我被调用了");
    }

    @OnClick({R.id.btn_simple_cn})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_simple_cn:
                Intent intent1 = new Intent(MainActivity.this,SetActivity.class);
                startActivity(intent1);
                finish();
                break;

        }
    }

}
