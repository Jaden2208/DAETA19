package com.example.daeta19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    UserSessionManager userSessionManager;
    private AlertDialog dialog;

    private static final int MY_REQUEST_CODE = 1919;
    List<AuthUI.IdpConfig> providers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userSessionManager = new UserSessionManager(this);

        // Init provider
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(), // Email Builder
                new AuthUI.IdpConfig.FacebookBuilder().build(), // Phone Builder
                new AuthUI.IdpConfig.GoogleBuilder().build() // Google Builder
        );

        showSignInOptions();
    }

    private void showSignInOptions() {
        startActivityForResult(
                AuthUI.getInstance().createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .setLogo(R.drawable.ic_launcher_foreground)
                        .setTheme(R.style.MyTheme)
                        .build(), MY_REQUEST_CODE
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (resultCode == RESULT_OK) {
                // Get User
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                Log.d("kkkisEmailVerified?", String.valueOf(user.isEmailVerified()));

                if (user != null) {
                    if ("firebase" .equals(user.getProviderData().get(0).getProviderId())) {
                        if (!user.isEmailVerified()) {
                            user.sendEmailVerification()
                                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            /* Check Success */
                                            if (task.isSuccessful()) {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                                dialog = builder.setMessage("본인 확인을 위한 이메일을\n[" + user.getEmail() + "] 로 보냈습니다.")
                                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                showSignInOptions();
                                                            }
                                                        })
                                                        .create();
                                                dialog.show();

                                            } else {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                                dialog = builder.setMessage("아직 본인 확인이 되지 않았습니다. 이메일을 확인해주세요.")
                                                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                                            @Override
                                                            public void onClick(DialogInterface dialog, int which) {
                                                                showSignInOptions();
                                                            }
                                                        })
                                                        .create();
                                                dialog.show();
                                            }
                                        }
                                    });
                        } else {
                            userSessionManager.createSession(user.getUid());
                            Log.d("kkk", userSessionManager.getUserDetail().get("UID"));

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                }

            } else {
                Toast.makeText(this, "" + response.getError().getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
