package com.example.daeta19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class firetest extends AppCompatActivity {

    DatabaseReference mDatabase;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firetest);



        //아이디 정의
        Button push_btn = (Button) findViewById(R.id.push_btn);
        Button toast_btn = (Button) findViewById(R.id.toast_btn);



        final EditText name_add = (EditText) findViewById(R.id.name_add);
        final EditText age_add = (EditText) findViewById(R.id.age_add);
        final EditText sex_add = (EditText) findViewById(R.id.sex_add);
        final EditText time_add = (EditText) findViewById(R.id.time_add);
        final EditText location_add = (EditText) findViewById(R.id.location_add);
        final EditText carrer_add = (EditText) findViewById(R.id.carrer_add);
        final EditText count_add = (EditText) findViewById(R.id.count_add);

        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                db = FirebaseDatabase.getInstance();
                mDatabase = db.getReference("users");
                //원하는 타겟의 정보 가져오기.
                mDatabase.child(uid).child("userinfo").child("name").addListenerForSingleValueEvent(new ValueEventListener() {
                    String name ;
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        name = dataSnapshot.getValue().toString();
                        TextView text = (TextView) findViewById(R.id.info);
                        text.setText(name);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });



            }
        });




        //온클릭리스너
        push_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edittext에 저장된 텍스트 Strig에 저장
                String get_name = name_add.getText().toString();
                String get_age = age_add.getText().toString();
                String get_sex = sex_add.getText().toString();
                String get_time = time_add.getText().toString();
                String get_location = location_add.getText().toString();
                String get_carrer = carrer_add.getText().toString();
                String get_count = count_add.getText().toString();
                int age = Integer.parseInt(get_age);

                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("name", get_name);
                result.put("age", age);
                result.put("sex", get_sex);
                result.put("count", get_count);
                result.put("star", "0");
                result.put("score", "0");
                result.put("career", get_carrer);
                result.put("location", get_location);
                result.put("time", get_time);

                //firebase 정의
                //mDatabase = FirebaseDatabase.getInstance().getReference();
                //firebase에 저장
                //mDatabase.child("article").child("dk").push().setValue(result);

                // user 토큰 가져오기
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                db = FirebaseDatabase.getInstance();
                mDatabase = db.getReference("users");
                mDatabase.child(uid).child("userinfo").setValue(result);
            }
        });


    }

}


