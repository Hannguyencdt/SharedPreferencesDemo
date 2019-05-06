package net.ilightning.sharedpreferencesdemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.ilightning.sharedpreferencesdemo.R;
import net.ilightning.sharedpreferencesdemo.config.Constant;
import net.ilightning.sharedpreferencesdemo.config.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvName;
    private TextView tvPassword;
    private Button btnSave;
    private Button btnDelete;
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferencesUtils.setBoolean(MainActivity.this,
                Constant.KEY_CHECK_LOGIN, true);
        initView();

    }

    private void initView() {
        this.tvName = findViewById(R.id.tvName);
        this.tvPassword = findViewById(R.id.tvPassword);
        this.btnSave = findViewById(R.id.btnSave);
        this.btnDelete = findViewById(R.id.btnDelete);
        this.btnShow = findViewById(R.id.btnShow);

        this.btnSave.setOnClickListener(this);
        this.btnDelete.setOnClickListener(this);
        this.btnShow.setOnClickListener(this);

        this.tvName.setText(SharedPreferencesUtils.getString(MainActivity.this, Constant.KEY_NAME));
        this.tvPassword.setText(SharedPreferencesUtils.getString(MainActivity.this, Constant.KEY_PASSWORD));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                SharedPreferences.Editor editor =
                        getSharedPreferences("MY_SHARE_PREFERENCES", MODE_PRIVATE).edit();
                editor.putString("KEY_NAME", "HoangTV");
                editor.apply();

                break;
            case R.id.btnDelete:
//                SharedPreferencesUtils.setBoolean(MainActivity.this,
//                        Constant.KEY_CHECK_LOGIN, false);
//
//                SharedPreferencesUtils.setString(MainActivity.this,
//                        Constant.KEY_NAME, "");
//
//                SharedPreferencesUtils.setString(MainActivity.this,
//                        Constant.KEY_PASSWORD, "");

                SharedPreferencesUtils.clearAllSharedPreferences(MainActivity.this);

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.btnShow:
                SharedPreferences prefs =
                        getSharedPreferences("MY_SHARE_PREFERENCES", MODE_PRIVATE);
                String name = prefs.getString("KEY_NAME", "ten");
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
