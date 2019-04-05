package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cqu.greenewsbeta01.utils.ThreadUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {
                //停留2s
                SystemClock.sleep(2000);
                //进入登录界面
                Intent intent =new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
