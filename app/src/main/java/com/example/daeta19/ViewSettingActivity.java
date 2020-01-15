package com.example.daeta19;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ViewSettingActivity extends AppCompatActivity {

    ImageButton btn_board;
    ImageButton btn_album;
    String view_style;
    Button btn_ok;
    Button btn_cancel;
    DatabaseReference mDatabase;
    FirebaseDatabase db;

    UserSessionManager userSessionManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_setting);

        userSessionManager = new UserSessionManager(this);
        final HashMap<String, String> user = userSessionManager.getUserDetail();

        btn_board = (ImageButton) findViewById(R.id.btn_board);
        btn_album = (ImageButton) findViewById(R.id.btn_album);


        view_style = user.get("VIEW_STYLE");
        Log.d("kkkuserstyle", "" + view_style);
        if(view_style.equals("게시글")) {
            setBoardStyleOn();
//            btn_board.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
//            btn_album.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
        }
        else {
            setAlbumStyleOn();
//            btn_board.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
//            btn_album.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
        }

        btn_board.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBoardStyleOn();
//                btn_board.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
//                btn_album.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
                view_style = "게시글";

            }
        });


        btn_album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlbumStyleOn();
//                btn_board.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
//                btn_album.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                view_style = "앨범";
            }
        });

        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSessionManager.changeValue("VIEW_STYLE", view_style);
                Toast.makeText(ViewSettingActivity.this,
                        view_style + " 형식으로 보기방식이 변경되었습니다.", Toast.LENGTH_SHORT)
                        .show();


                HashMap result = new HashMap<>();
                if(view_style.equals("게시글")){
                    result.put("ViewType", 1);
                }
                else{
                    result.put("ViewType", 2);
                }

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();

                db = FirebaseDatabase.getInstance();
                mDatabase = db.getReference("users");
                mDatabase.child(uid).child("settings").setValue(result);

                finish();
            }
        });

        btn_cancel = (Button) findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    public void setBoardStyleOn(){
        btn_board.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
        btn_album.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
    }

    public void setAlbumStyleOn(){
        btn_board.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp);
        btn_album.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
    }
}
