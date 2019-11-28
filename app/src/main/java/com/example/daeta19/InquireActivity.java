package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class InquireActivity extends AppCompatActivity {

    private ImageButton btn_back;
    private Button btn_send;
    private Button btn_call_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inquire);

        btn_back = (ImageButton) findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(InquireActivity.this, "해당 내용이 문의되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(InquireActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        btn_call_admin=(Button)findViewById(R.id.btn_call_admin);
        btn_call_admin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(Build.VERSION.SDK_INT==Build.VERSION_CODES.M){
                    int permissionResult=checkSelfPermission(Manifest.permission.CALL_PHONE);
                    if(permissionResult== PackageManager.PERMISSION_DENIED){
                        if(shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)){
                            AlertDialog.Builder dialog=new AlertDialog.Builder(InquireActivity.this);
                            dialog.setTitle("권한이 필요합니다.")
                                    .setMessage("이 기능을 사용하기 위해서는 단말기의 전화걸기 권한이 필요합니다. 계속 하시겠습니까?")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                                            }
                                        }
                                    })
                                    .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(InquireActivity.this,"기능을 취소했습니다.",Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .create()
                                    .show();
                        }
                        else{
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1000);
                        }
                    }
                    else{
                        Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:201-9101-4155"));
                        startActivity(intent);
                    }
                }
                else{
                    Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:201-9101-4155"));
                    startActivity(intent);
                }
            }
        });
    }
}
