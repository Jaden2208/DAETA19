package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    Bundle extras = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        extras = getIntent().getExtras();

        TextView star = (TextView) findViewById(R.id.stars);
        TextView score = (TextView) findViewById(R.id.stars_point);
        TextView sex = (TextView) findViewById(R.id.sex_age);
        TextView name = (TextView) findViewById(R.id.name);

        star.setText(extras.getString("star"));
        score.setText(extras.getString("score"));
        sex.setText(extras.getString("sex") +" / " + extras.getInt("age"));
        name.setText(extras.getString("name"));
    }
}
