package cn.edu.cqu.greenewsbeta01;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.edu.cqu.greenewsbeta01.LoginActivity;
import cn.edu.cqu.greenewsbeta01.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputUserName;
    private EditText inputRegEmail;
    private EditText inputRegPassword;
    private Button btnRegister;
    private Button btnSwitchToLogin;
    private String name;
    private ProgressDialog pDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        inputUserName=findViewById(R.id.txtRegUsername);
        inputRegEmail=findViewById(R.id.txtRegEmali);
        inputRegPassword=findViewById(R.id.txtRegPsw);
        btnRegister = findViewById(R.id.btnSignUp);
        btnSwitchToLogin = findViewById(R.id.btnSwitch2Login);


        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);




        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //验证注册
                name=inputUserName.getText().toString().trim();
                String email=inputRegEmail.getText().toString().trim();
                String pswd=inputRegPassword.getText().toString().trim();
                if (!name.isEmpty() && !email.isEmpty() && !pswd.isEmpty()) {
                    // Avoid repeated clicks by disabling the button
                    btnRegister.setClickable(false);
                    //Register the user
                    registerUser(name, email, pswd);


                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSwitchToLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //切换为主屏
                Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

        });
    }


    private void registerUser(final String name, final String email,
                              final String password) {

        //向服务器数据库进行注册
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:filename");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




}
