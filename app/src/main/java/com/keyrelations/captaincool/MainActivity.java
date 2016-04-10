package com.keyrelations.captaincool;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    //initialise a call back manager to handle the callback from login button
    CallbackManager callbackManager = CallbackManager.Factory.create();

    String url;
    RequestQueue queue;
    JsonArrayRequest jsArrRequest;
    SharedPreferences cred;
    SharedPreferences.Editor editor;

    public void navigateToHomeActivity(){
        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        queue = VolleySingleton.getInstance(this).getRequestQueue();

        cred = getPreferences(MODE_PRIVATE);
        editor = cred.edit();

        //initialise the facebook sdk
        FacebookSdk.sdkInitialize(getApplicationContext(), new FacebookSdk.InitializeCallback() {
            @Override
            public void onInitialized() {
                // if access token already exist and valid
                if (AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired()) {
                    //Log.d("ACCESS TOKEN",String.valueOf(AccessToken.getCurrentAccessToken().getToken()));
                    //navigateToHomeActivity();
                    //login();
                    if(cred.getInt("userRegistered", 0)==1){
                        navigateToHomeActivity();
                    }
                    else{
                        LoginManager.getInstance().logOut();
                    }
                }
            }
        });

        setContentView(R.layout.activity_main);



        //create a login button instance
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);

        //save the needed permissions in an array
        List<String> permissionNeeds = Arrays.asList("public_profile","user_friends");

        //set the needed permissions from array
        if(loginButton!=null) {
            loginButton.setReadPermissions(permissionNeeds);
        }

        // Callback registration
        if(loginButton!=null) {
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // Code for login success
                    //navigateToHomeActivity();
                    //Log.d("ACCESS TOKEN", String.valueOf(AccessToken.getCurrentAccessToken().getToken()));
                    login();
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.facebook_login_failed), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }


    public void login(){

        Log.d("DEBUGLOG","Facebook login done. Logging in from server");
        //Log.d("DEBUGLOG","Access Token "+AccessToken.getCurrentAccessToken().getToken());
        url = "http://api.keyrelations.in/cc/userRegistration/"+AccessToken.getCurrentAccessToken().getToken();
        Log.d("DEBUGLOG",url);
        //define the json request
        jsArrRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        editor.putInt("userRegistered", 1);
                        // Commit the edits!
                        editor.commit();
                        Log.d("DEBUGLOG","Got response from server");
                        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("DEBUGLOG","Login failed for the user");
                Toast.makeText(getBaseContext(), getResources().getString(R.string.server_response_error), Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsArrRequest);

    }

}
