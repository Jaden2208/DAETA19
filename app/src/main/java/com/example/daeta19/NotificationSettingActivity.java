package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class NotificationSettingActivity extends AppCompatActivity {

    private ImageButton btn_back;

    private ImageView imb_sound_on;
    private ImageView imb_sound_off;
    private ImageView imb_vibrate;

    private ImageView imb_sound_on2;
    private ImageView imb_sound_off2;
    private ImageView imb_vibrate2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_setting);

        // 뒤로가기
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        imb_sound_on=(ImageView)findViewById(R.id.imb_sound_on);
        imb_sound_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "중요 알림 받음", Toast.LENGTH_SHORT).show();
            }
        });
        imb_sound_off=(ImageView)findViewById(R.id.imb_sound_off);
        imb_sound_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "중요 알림 안 받음", Toast.LENGTH_SHORT).show();
            }
        });
        imb_sound_on2=(ImageView)findViewById(R.id.imb_sound_on2);
        imb_sound_on2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "기타 알림 받음", Toast.LENGTH_SHORT).show();
            }
        });
        imb_sound_off2=(ImageView)findViewById(R.id.imb_sound_off2);
        imb_sound_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "기타 알림 안 받음", Toast.LENGTH_SHORT).show();
            }
        });
        imb_vibrate=(ImageView)findViewById(R.id.imb_vibrate);
        imb_vibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "중요 알림 진동으로 받음", Toast.LENGTH_SHORT).show();
            }
        });
        imb_vibrate2=(ImageView)findViewById(R.id.imb_vibrate2);
        imb_vibrate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NotificationSettingActivity.this, "기타 알림 진동으로 받음", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
