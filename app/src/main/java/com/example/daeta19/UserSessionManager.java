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

    private static final String LOGIN = "IS_LOGIN";
    private static final String UID = "UID";

    public UserSessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences(UID, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String uid){
        editor.putBoolean(LOGIN, true);
        editor.putString(UID, uid);
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

        return user;
    }

    public String getCurrentID() {
        return sharedPreferences.getString(UID, null);
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
