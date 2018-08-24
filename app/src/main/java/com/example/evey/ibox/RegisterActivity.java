package com.example.evey.ibox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.evey.ibox.SQLlite.User;
import com.example.evey.ibox.SQLlite.UserRepo;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.btn_close_register)
    ImageView close;
    @BindView(R.id.btn_register)
    Button register;
    @BindView(R.id.userTel)
    EditText userTel;
    @BindView(R.id.userPwd)
    EditText userPwd;


    private int user_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserRepo repo = new UserRepo(RegisterActivity.this);
                User user = new User();
                user.name = "Evey";
                user.tel = userTel.getText().toString();
                user.password = userPwd.getText().toString();
                user.User_ID = user_id;

                if (user_id == 0){
                    user_id = repo.insert(user);
                    Toast.makeText(RegisterActivity.this,"您的用户已创建成功！可以登录啦！",Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });

    }
}
