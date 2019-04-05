package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

    }
    public void onClickBack(View v){
        Intent intent =new Intent(SettingActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
