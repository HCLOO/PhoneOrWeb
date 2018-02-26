package com.example.think.phoneorweb;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edt;
    Button bnt1;
    Button bnt2;
    Button bnt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = (EditText) findViewById(R.id.editText);
        bnt1 = (Button) findViewById(R.id.button);
        bnt2 = (Button) findViewById(R.id.button1);
        bnt3 = (Button) findViewById(R.id.button2);
        //实例化以上控件
        bnt1.setOnClickListener(this);
        bnt2.setOnClickListener(this);
        bnt3.setOnClickListener(this);
        //设置以上按钮的点击事件
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                if (edt.getText().toString().trim() == null || edt.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "对不起，电话不能为空", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                            + edt.getText().toString().trim()));
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        return;
                    startActivity(intent);
                }
                break;
            case R.id.button1:
                if (v.getId() == R.id.button1) {
                    if (edt.getText().toString().trim() == null || edt.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "对不起，网址不能为空", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"
                                + edt.getText().toString().trim()));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED)
                            return;
                        startActivity(intent);
                    }
                }
                break;
            case R.id.button2:
                System.exit(0);
                break;
        }
    }
}
