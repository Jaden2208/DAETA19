package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostHireActivity extends AppCompatActivity {

    private Button btn_hire_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_hire);

        btn_hire_report = (Button) findViewById(R.id.btn_hire_report);
        btn_hire_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostHireActivity.this, PostHireReportActivity.class);
                startActivity(intent);
            }
        });
    }

}
