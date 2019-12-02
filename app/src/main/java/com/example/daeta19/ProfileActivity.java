package com.example.daeta19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    Bundle extras = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        extras = getIntent().getExtras();

        ImageButton button =(ImageButton) findViewById(R.id.report_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ReportActivity.class);
                intent.putExtra("name",extras.getString("name"));
                intent.putExtra("star",extras.getString("star"));
                intent.putExtra("score",extras.getString("score"));
                intent.putExtra("sex",extras.getString("sex"));
                intent.putExtra("age",extras.getInt("age"));
                startActivity(intent);
            }
        });

        TextView star = (TextView) findViewById(R.id.stars);
        TextView score = (TextView) findViewById(R.id.stars_point);
        TextView sex = (TextView) findViewById(R.id.sex_age);
        TextView career = (TextView) findViewById(R.id.career);
        TextView location = (TextView) findViewById(R.id.area);
        TextView time = (TextView) findViewById(R.id.workable_time);
        TextView name = (TextView) findViewById(R.id.name);
        TextView count = (TextView) findViewById(R.id.experience);

        star.setText(extras.getString("star"));
        score.setText(extras.getString("score"));
        sex.setText(extras.getString("sex") +" / " + extras.getInt("age"));
        career.setText(extras.getString("career"));
        location.setText(extras.getString("location"));
        time.setText(extras.getString("time"));
        name.setText(extras.getString("name"));
        count.setText(extras.getInt("count") + " 회");
    }
}
