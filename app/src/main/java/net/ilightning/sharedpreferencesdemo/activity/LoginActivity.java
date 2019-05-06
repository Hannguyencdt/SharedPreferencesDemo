package net.ilightning.sharedpreferencesdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.ilightning.sharedpreferencesdemo.R;
import net.ilightning.sharedpreferencesdemo.config.Constant;
import net.ilightning.sharedpreferencesdemo.config.SharedPreferencesUtils;

import static net.ilightning.sharedpreferencesdemo.config.Constant.KEY_CHECK_LOGIN;

public class LoginActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SharedPreferencesUtils.getBoolean(this, KEY_CHECK_LOGIN)) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        this.edtName = findViewById(R.id.edtName);
        this.edtPass = findViewById(R.id.edtPass);
        this.btnLogin = findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String password = edtPass.getText().toString();

                SharedPreferencesUtils.setString(LoginActivity.this,
                        Constant.KEY_NAME, name);

                SharedPreferencesUtils.setString(LoginActivity.this,
                        Constant.KEY_PASSWORD, password);


                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
