package com.example.daeta19;
// 댓글 리스트뷰에 아이템을 보여줄 어댑터 클래스 입니다.

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReplyListAdapter extends BaseAdapter {

    LayoutInflater inflater = null;
    private ArrayList<ReplyItemData>m_oData = null; // 아이템데이터 클래스인 ReplyData.java
    private int nListCnt = 0;

    public ReplyListAdapter(ArrayList<ReplyItemData>_oData) { // 이것도 역시
        m_oData = _oData;
        nListCnt = m_oData.size();
    }

    @Override
    public int getCount() {
        Log.i("TAG", "getCount") ;
        return nListCnt ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            final Context context = parent.getContext();

            if (inflater == null) {
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.user_comment , parent , false) ; // 아이템 하나의 뷰 넘겨줌.
        }

        //ImageView oStoreImage = (ImageView) convertView.findViewById((R.id.StoreImage)); // user_comment.xml의 점주 프로필 이미지.
        TextView oStoreName = (TextView) convertView.findViewById(R.id.StoreName); // 점주 이름.
        TextView oCommentDate = (TextView) convertView.findViewById(R.id.CommentDate); // 등록 날짜. 일단은 텍스트뷰로 합니다.
        TextView oStoreComment = (TextView) convertView.findViewById(R.id.StoreComment) ; // 점주의 알바에 대한 평가.

        //oStoreImage.setImage(m_oData.get(position).StoreImage); 이건 다른것좀 찾아보구
        oStoreName.setText(m_oData.get(position).StoreName);
        oCommentDate.setText(m_oData.get(position).CommentDate);
        oStoreComment.setText(m_oData.get(position).StoreComment);

        return convertView;

    }
}

