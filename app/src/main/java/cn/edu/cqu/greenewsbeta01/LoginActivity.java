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

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private ProgressDialog progressDialog;
    private SessionManager session;
    private Feedback feedback;
    private Button btnLogin;
    private Button btnSwitchToRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail=findViewById(R.id.txtEmali);
        inputPassword=findViewById(R.id.txtPsw);
        btnLogin=findViewById(R.id.btnLogin);
        btnSwitchToRegister=findViewById(R.id.btnSitch2Register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String LogMail=inputEmail.getText().toString().trim();
                String LogPswd=inputPassword.getText().toString().trim();
//                if (!LogMail.isEmpty() && !LogPswd.isEmpty() ) {
//                    // Avoid repeated clicks by disabling the button
//                    btnLogin.setClickable(false);
//                    //Register the user
//                    try {
//                        Login( LogMail, LogPswd);
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
//
//
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "Please enter your details!", Toast.LENGTH_LONG).show();
//                }



                if(true)
                {Intent intent =new Intent(LoginActivity.this,DrawerHomeActivity.class);
                    startActivity(intent);
                    finish();}

            }
        });


        btnSwitchToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //切换为注册界面
                Intent intent =new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void Login(final String email,final String pswd) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";//MySQL 驱动
        String url = "jdbc:mysql://IP:3306/数据库";//MYSQL数据库连接Url
        Connection conn=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection(url);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        conn.close();

    }


}
