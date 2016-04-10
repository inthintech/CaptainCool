package com.keyrelations.captaincool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void navigateToSelectOpponentActivity(View view){
        Intent intent = new Intent(getBaseContext(), SelectOpponentActivity.class);
        startActivity(intent);
        finish();
    }
}
