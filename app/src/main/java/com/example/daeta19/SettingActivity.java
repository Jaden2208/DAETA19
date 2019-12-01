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
                showDialog();
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


    private void showDialog() {
        LayoutInflater dialog = LayoutInflater.from(this);
        final View dialogLayout = dialog.inflate(R.layout.view_style_dialog, null);
        final Dialog myDialog = new Dialog(this);

        final String[] style = new String[1];

//        typeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                RadioButton typeButton = (RadioButton) findViewById(checkedId);
//                String type = typeButton.getText().toString();
//
//                Toast.makeText(SettingActivity.this, type + "클릭", Toast.LENGTH_SHORT).show();
//            }
//        });

        myDialog.setContentView(dialogLayout);
        myDialog.show();

        // 게시글 선택 시
        ImageButton board_style = (ImageButton) findViewById(R.id.board_style);
        board_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                style[0] = "게시글";
            }
        });

        // 게시글 선택 시
        ImageButton album_style = (ImageButton) findViewById(R.id.album_style);
        board_style.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                style[0] = "앨범";
            }
        });

        // 확인 버튼 클릭 시
        Button btn_ok = (Button) dialogLayout.findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(SettingActivity.this, style[0] + " 형식으로 보기방식이 변경되었습니다.", Toast.LENGTH_SHORT).show();
                myDialog.cancel();
            }
        });

        Button btn_cancel = (Button) dialogLayout.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.cancel();
            }
        });
    }
}
