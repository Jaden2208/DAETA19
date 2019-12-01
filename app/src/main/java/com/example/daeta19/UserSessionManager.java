package com.example.daeta19;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.HashMap;

public class UserSessionManager {

    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String UID = "UID";
    public static final String VIEW_STYLE = "VIEW_STYLE";

    public UserSessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String uid, String view_style){
        editor.putBoolean(LOGIN, true);
        editor.putString(UID, uid);
        editor.putString(VIEW_STYLE, view_style);
        editor.apply();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN, false);
    }

    public void checkLogin() {
        if (!this.isLogin()) {
            Log.d("kkk", "로그인 되어있지 않음");
            gotoLoginPage();
        }
        else{
            Log.d("kkk", "로그인 되어있음");
        }
    }

    public HashMap<String, String> getUserDetail() {

        HashMap<String, String> user = new HashMap<>();
        user.put(UID, sharedPreferences.getString(UID, null));
        user.put(VIEW_STYLE, sharedPreferences.getString(VIEW_STYLE, null));

        return user;
    }

    public void changeValue(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public void logout() {

        editor.clear();
        editor.commit();
        gotoLoginPage();
    }

    public void gotoLoginPage(){
        Intent i = new Intent(context, LoginActivity.class);
        context.startActivity(i);
        ((MainActivity) context).finish();
    }

}
