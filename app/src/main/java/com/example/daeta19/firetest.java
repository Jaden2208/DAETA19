package com.example.daeta19;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    UserSessionManager userSessionManager;

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


        FirebaseDatabase.getInstance().getReference().addValueEventListener(new ValueEventListener() {
            TextView infos = (TextView) findViewById(R.id.info);
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                infos.setText(value.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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


                //hashmap 만들기
                HashMap result = new HashMap<>();
                result.put("name", get_name);
                result.put("age", get_age);
                result.put("sex", get_sex);

                //firebase 정의
                //mDatabase = FirebaseDatabase.getInstance().getReference();
                //firebase에 저장
                //mDatabase.child("article").child("dk").push().setValue(result);

                // user 토큰 가져오기
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                db = FirebaseDatabase.getInstance();
                mDatabase = db.getReference("users");
                mDatabase.child(uid).setValue(result);
            }
        });
    }

}


