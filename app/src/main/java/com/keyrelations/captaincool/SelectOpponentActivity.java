package com.keyrelations.captaincool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

public class SelectOpponentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_opponent);
    }

    public void navigateToMatchStartActivity(View view){
        Random r = new Random();
        int i1 = r.nextInt(2);
        Intent intent = new Intent(getBaseContext(), MatchStartActivity.class);
        intent.putExtra("matchToss", String.valueOf(i1));
        startActivity(intent);
        finish();
        //Log.d("DEBUGLOG",String.valueOf(i1));
    }

    public void navigateToPlayerOpponentActivity(View view){
        Intent intent = new Intent(getBaseContext(), SelectOpponentActivity.class);
        startActivity(intent);
        finish();
    }
}
