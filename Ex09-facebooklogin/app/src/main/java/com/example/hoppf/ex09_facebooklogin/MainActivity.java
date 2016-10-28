package com.example.hoppf.ex09_facebooklogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        final CallbackManager callbackManager = CallbackManager.Factory.create();

        // this example wont work properly because you need a valid facebook id
        // currently @strings/app_fbid is set to an invalid dummy number

        setContentView(R.layout.activity_main);

        LoginButton fb_loginbutton = (LoginButton) findViewById(R.id.fb_loginbutton);

        fb_loginbutton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }
}
