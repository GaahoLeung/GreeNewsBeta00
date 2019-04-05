package cn.edu.cqu.greenewsbeta01;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


    }
    public void onClickBack(View v){
        Intent intent =new Intent(ProfileActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickMsg(View v){
        replaceFragment(new FragMessage());
    }

    public void onClickLike(View v){
        replaceFragment(new FragLikes());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameProfile, fragment);
        transaction.commit();
    }


}
