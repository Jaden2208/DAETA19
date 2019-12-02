package com.example.daeta19;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private ListView m_oCommentListView = null;

    @Override
    protected void onCreate(Bundle savedInstandeState) {

        super.onCreate(savedInstandeState);
        setContentView(R.layout.activity_comment_main);

        //데이터 100개 생성--------------------------------------
        String[] CommentDate = {"2019-01-01","2019-02-01","2019-03-01","2019-04-01","2019-05-01",
                "2019-06-01","2019-07-01","2019-08-01","2019-09-01","2019-10-01"} ;

        int nDatCnt = 0;

        ArrayList<ReplyItemData> oCommentData = new ArrayList<>() ;
        for (int i=0 ; i<100 ; ++i) {
            ReplyItemData oItem = new ReplyItemData() ;
            //oItem.StoreImage = 이미지는 어떻게 받아올지 보기.
            oItem.StoreName = "점주" + (i+1) ;
            oItem.CommentDate = CommentDate[nDatCnt++] ;
            oItem.StoreComment = "성실해요" + (i+1) ;
            oCommentData.add((oItem)) ; //바로 위에서 설정해준값들이 포문이 끝날때마다 아이템에 업데이트해줌.
            if (nDatCnt >= CommentDate.length)nDatCnt = 0;
        }

        //ListView와 Adapter 생성 및 연결하기.---------------------ㄱ
        m_oCommentListView = (ListView)findViewById(R.id.CommentListView) ; // activity_comment_main.xml의 리스트뷰 속성 아이디를 연결.
        ReplyListAdapter oAdapter = new ReplyListAdapter(oCommentData);
        m_oCommentListView.setAdapter(oAdapter);

    }
}
