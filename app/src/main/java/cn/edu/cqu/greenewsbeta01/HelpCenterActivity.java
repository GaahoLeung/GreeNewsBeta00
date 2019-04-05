package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.edu.cqu.greenewsbeta01.R;

public class HelpCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
    }
    public void onClickBack(View v){
        Intent intent =new Intent(HelpCenterActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
