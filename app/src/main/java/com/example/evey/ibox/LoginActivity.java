package com.example.evey.ibox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.evey.ibox.SQLlite.User;
import com.example.evey.ibox.SQLlite.UserRepo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_register)
    TextView register;
    @BindView(R.id.btn_cancel_login)
    TextView cancel;
    @BindView(R.id.btn_login)
    Button login;

    @BindView(R.id.userTel)
    EditText userTel;
    @BindView(R.id.userPwd)
    EditText userPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRepo repo = new UserRepo(LoginActivity.this);
                User user = repo.getUserByTel(userTel.getText().toString());
                if(user != null){
                    if (user.password.equals(userPwd.getText().toString())){
                        Intent intent = new Intent();
                        intent.putExtra("user_name",user.name);
                        setResult(101,intent);
                        finish();
                    }
                }

            }
        });
    }
}
