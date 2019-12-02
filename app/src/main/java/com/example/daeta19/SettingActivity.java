package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    private ImageButton btn_back;
    private Button btn_inquire;
    private Button btn_otherSetting;
    private Button btn_notice;
    private Button btn_viewStyle;
    private Button btn_notification_setting;

    UserSessionManager userSessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        userSessionManager = new UserSessionManager(this);

        // 뒤로가기
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 기타설정
        btn_otherSetting = (Button) findViewById(R.id.btn_otherSetting);
        btn_otherSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, OtherSettingActivity.class);
                startActivity(intent);
            }
        });

        // 문의하기
        btn_inquire = (Button) findViewById(R.id.btn_inquire);
        btn_inquire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, InquireActivity.class);
                startActivity(intent);
            }
        });

        // 공지사항
        btn_notice = (Button) findViewById(R.id.btn_notice);
        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, NoticeActivity.class);
                startActivity(intent);
            }
        });

        // 보기방식변경
        btn_viewStyle = (Button) findViewById(R.id.btn_viewStyle);
        btn_viewStyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ViewSettingActivity.class);
                startActivity(intent);
            }
        });

        // 알림설정
        btn_notification_setting = (Button) findViewById(R.id.btn_notification_setting);
        btn_notification_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, NotificationSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
