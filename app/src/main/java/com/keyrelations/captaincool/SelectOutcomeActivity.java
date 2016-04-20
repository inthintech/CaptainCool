package com.keyrelations.captaincool;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Debug;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class SelectOutcomeActivity extends Activity implements View.OnClickListener {



    public void navigateToMatchInProgressActivity(View v){

        if(count>59) {
            Log.d("DEBUGLOG", "Dot_OPP " + dot_opp);
            Log.d("DEBUGLOG", "one_OPP " + one_opp);
            Log.d("DEBUGLOG", "two_OPP " + two_opp);
            Log.d("DEBUGLOG", "three_OPP " + three_opp);
            Log.d("DEBUGLOG", "four_OPP " + four_opp);
            Log.d("DEBUGLOG", "six_OPP " + six_opp);
            Log.d("DEBUGLOG", "nb_OPP " + nb_opp);
            Log.d("DEBUGLOG", "wk_OPP " + wk_opp);

            Log.d("DEBUGLOG", "Dot_PLA " + dot);
            Log.d("DEBUGLOG", "one_PLA " + one);
            Log.d("DEBUGLOG", "two_PLA " + two);
            Log.d("DEBUGLOG", "three_PLA " + three);
            Log.d("DEBUGLOG", "four_PLA " + four);
            Log.d("DEBUGLOG", "six_PLA " + six);
            Log.d("DEBUGLOG", "nb_PLA " + nb);
            Log.d("DEBUGLOG", "wk_PLA " + wk);
        }
        Intent intent = new Intent(getBaseContext(), MatchInProgressActivity.class);
        startActivity(intent);
        finish();
    }

    public void setOpponentOutcome(){

        Integer oppOptions[] = {
                0,
                1,
                2,
                3,
                4,
                5,
                6,
                7,
                8,
                9,
                10,
                11,
                12,
                13,
                14,
                15,
                16,
                17,
                18,
                19,
                20,
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28,
                29,
                30,
                31,
                32,
                33,
                34,
                35,
                36,
                37,
                38,
                39,
                40,
                41,
                42,
                43,
                44,
                45,
                46,
                47,
                48,
                49,
                50,
                51,
                52,
                53,
                54,
                55,
                56,
                57,
                58,
                59,
                60,
                61,
                62,
                63,
                64,
                65,
                66,
                67,
                68,
                69,
                70,
                71,
                72,
                73,
                74,
                75,
                76,
                77,
                78,
                79
        };

        Collections.shuffle(Arrays.asList(oppOptions));

        for(int j=0;j<60;j++) {
            switch (outcomes[oppOptions[j]]) {
                case "0":
                    dot_opp++;
                    break;
                case "1":
                    one_opp++;
                    break;
                case "2":
                    two_opp++;
                    break;
                case "3":
                    three_opp++;
                    break;
                case "4":
                    four_opp++;
                    break;
                case "6":
                    six_opp++;
                    break;
                case "NB":
                    nb_opp++;
                    break;
                case "WK":
                    wk_opp++;
                    break;

            }
        }


    }

    @Override
    public void onClick(View v) {

        if(count<60) {

            // default method for handling onClick Events..

            Button btn = (Button) findViewById(v.getId());
            btn.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.outcome_btn_bg_didabled_color));


            Integer btnNo;
            String str = v.getResources().getResourceName(v.getId());
            //Log.d("DEBUGLOG",String.valueOf(str.length()));

        /*
        if(str.length()==44){

            //btnNo = Integer.valueOf(str.substring(10,10));
            Log.d("DEBUGLOG",str.substring(10));
        }
        else{

            //btnNo = Integer.valueOf(str.substring(10, 11));
            Log.d("DEBUGLOG",str.substring(10));
        }
        //Log.d("DEBUGLOG",String.valueOf(btn));
        */

            btnNo = Integer.valueOf(str.substring(42));
            Log.d("DEBUGLOG", String.valueOf(btnNo));

            switch (outcomes[btnNo - 1]) {
                case "0":
                    dot++;
                    break;
                case "1":
                    one++;
                    break;
                case "2":
                    two++;
                    break;
                case "3":
                    three++;
                    break;
                case "4":
                    four++;
                    break;
                case "6":
                    six++;
                    break;
                case "NB":
                    nb++;
                    break;
                case "WK":
                    wk++;
                    break;

            }

            btn.setEnabled(false);
            count++;
            updateOutcomeCount();
        }
        else{
            Toast.makeText(getBaseContext(), getResources().getString(R.string.end_of_outcomes), Toast.LENGTH_SHORT).show();
        }
    }

    public void updateOutcomeCount(){
        outcome1Cnt.setText("x"+String.valueOf(dot));
        outcome2Cnt.setText("x"+String.valueOf(one));
        outcome3Cnt.setText("x"+String.valueOf(two));
        outcome4Cnt.setText("x"+String.valueOf(three));
        outcome5Cnt.setText("x"+String.valueOf(four));
        outcome6Cnt.setText("x"+String.valueOf(six));
        outcome7Cnt.setText("x"+String.valueOf(nb));
        outcome8Cnt.setText("x"+String.valueOf(wk));
    }

    String[] outcomes = {
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "0",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "2",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "3",
            "4",
            "4",
            "4",
            "4",
            "4",
            "4",
            "4",
            "4",
            "4",
            "4",
            "6",
            "6",
            "6",
            "6",
            "6",
            "6",
            "6",
            "6",
            "6",
            "6",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "NB",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK",
            "WK"
    };

    Integer dot = 0;
    Integer one = 0;
    Integer two = 0;
    Integer three = 0;
    Integer four = 0;
    Integer six = 0;
    Integer nb = 0;
    Integer wk = 0;

    Integer dot_opp = 0;
    Integer one_opp = 0;
    Integer two_opp = 0;
    Integer three_opp = 0;
    Integer four_opp = 0;
    Integer six_opp = 0;
    Integer nb_opp = 0;
    Integer wk_opp = 0;

    TextView outcome1Cnt;
    TextView outcome2Cnt;
    TextView outcome3Cnt;
    TextView outcome4Cnt;
    TextView outcome5Cnt;
    TextView outcome6Cnt;
    TextView outcome7Cnt;
    TextView outcome8Cnt;

    Integer count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_outcome);
        /*
        for(int i=0;i<outcomes.length;i++){
            Log.d("DEBUGLOG",outcomes[i]);
        }*/
        Collections.shuffle(Arrays.asList(outcomes));
        setOpponentOutcome();
        /*
        for(int i=0;i<outcomes.length;i++){
            Log.d("DEBUGLOG",outcomes[i]);
        }*/
        Log.d("DEBUGLOG",String.valueOf(outcomes.length));
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fontawesome-webfont.ttf");

        outcome1Cnt = (TextView) findViewById(R.id.textViewOutcome1countIndicator);
        outcome2Cnt = (TextView) findViewById(R.id.textViewOutcome2countIndicator);
        outcome3Cnt = (TextView) findViewById(R.id.textViewOutcome3countIndicator);
        outcome4Cnt = (TextView) findViewById(R.id.textViewOutcome4countIndicator);
        outcome5Cnt = (TextView) findViewById(R.id.textViewOutcome5countIndicator);
        outcome6Cnt = (TextView) findViewById(R.id.textViewOutcome6countIndicator);
        outcome7Cnt = (TextView) findViewById(R.id.textViewOutcome7countIndicator);
        outcome8Cnt = (TextView) findViewById(R.id.textViewOutcome8countIndicator);

        Button btnOutcome1 = (Button) findViewById(R.id.btnOutcome1);
        btnOutcome1.setTypeface(font);
        btnOutcome1.setOnClickListener(this);
        Button btnOutcome2 = (Button) findViewById(R.id.btnOutcome2);
        btnOutcome2.setTypeface(font);
        btnOutcome2.setOnClickListener(this);
        Button btnOutcome3 = (Button) findViewById(R.id.btnOutcome3);
        btnOutcome3.setTypeface(font);
        btnOutcome3.setOnClickListener(this);
        Button btnOutcome4 = (Button) findViewById(R.id.btnOutcome4);
        btnOutcome4.setTypeface(font);
        btnOutcome4.setOnClickListener(this);
        Button btnOutcome5 = (Button) findViewById(R.id.btnOutcome5);
        btnOutcome5.setTypeface(font);
        btnOutcome5.setOnClickListener(this);
        Button btnOutcome6 = (Button) findViewById(R.id.btnOutcome6);
        btnOutcome6.setTypeface(font);
        btnOutcome6.setOnClickListener(this);
        Button btnOutcome7 = (Button) findViewById(R.id.btnOutcome7);
        btnOutcome7.setTypeface(font);
        btnOutcome7.setOnClickListener(this);
        Button btnOutcome8 = (Button) findViewById(R.id.btnOutcome8);
        btnOutcome8.setTypeface(font);
        btnOutcome8.setOnClickListener(this);
        Button btnOutcome9 = (Button) findViewById(R.id.btnOutcome9);
        btnOutcome9.setTypeface(font);
        btnOutcome9.setOnClickListener(this);
        Button btnOutcome10 = (Button) findViewById(R.id.btnOutcome10);
        btnOutcome10.setTypeface(font);
        btnOutcome10.setOnClickListener(this);
        Button btnOutcome11 = (Button) findViewById(R.id.btnOutcome11);
        btnOutcome11.setTypeface(font);
        btnOutcome11.setOnClickListener(this);
        Button btnOutcome12 = (Button) findViewById(R.id.btnOutcome12);
        btnOutcome12.setTypeface(font);
        btnOutcome12.setOnClickListener(this);
        Button btnOutcome13 = (Button) findViewById(R.id.btnOutcome13);
        btnOutcome13.setTypeface(font);
        btnOutcome13.setOnClickListener(this);
        Button btnOutcome14 = (Button) findViewById(R.id.btnOutcome14);
        btnOutcome14.setTypeface(font);
        btnOutcome14.setOnClickListener(this);
        Button btnOutcome15 = (Button) findViewById(R.id.btnOutcome15);
        btnOutcome15.setTypeface(font);
        btnOutcome15.setOnClickListener(this);
        Button btnOutcome16 = (Button) findViewById(R.id.btnOutcome16);
        btnOutcome16.setTypeface(font);
        btnOutcome16.setOnClickListener(this);
        Button btnOutcome17 = (Button) findViewById(R.id.btnOutcome17);
        btnOutcome17.setTypeface(font);
        btnOutcome17.setOnClickListener(this);
        Button btnOutcome18 = (Button) findViewById(R.id.btnOutcome18);
        btnOutcome18.setTypeface(font);
        btnOutcome18.setOnClickListener(this);
        Button btnOutcome19 = (Button) findViewById(R.id.btnOutcome19);
        btnOutcome19.setTypeface(font);
        btnOutcome19.setOnClickListener(this);
        Button btnOutcome20 = (Button) findViewById(R.id.btnOutcome20);
        btnOutcome20.setTypeface(font);
        btnOutcome20.setOnClickListener(this);
        Button btnOutcome21 = (Button) findViewById(R.id.btnOutcome21);
        btnOutcome21.setTypeface(font);
        btnOutcome21.setOnClickListener(this);
        Button btnOutcome22 = (Button) findViewById(R.id.btnOutcome22);
        btnOutcome22.setTypeface(font);
        btnOutcome22.setOnClickListener(this);
        Button btnOutcome23 = (Button) findViewById(R.id.btnOutcome23);
        btnOutcome23.setTypeface(font);
        btnOutcome23.setOnClickListener(this);
        Button btnOutcome24 = (Button) findViewById(R.id.btnOutcome24);
        btnOutcome24.setTypeface(font);
        btnOutcome24.setOnClickListener(this);
        Button btnOutcome25 = (Button) findViewById(R.id.btnOutcome25);
        btnOutcome25.setTypeface(font);
        btnOutcome25.setOnClickListener(this);
        Button btnOutcome26 = (Button) findViewById(R.id.btnOutcome26);
        btnOutcome26.setTypeface(font);
        btnOutcome26.setOnClickListener(this);
        Button btnOutcome27 = (Button) findViewById(R.id.btnOutcome27);
        btnOutcome27.setTypeface(font);
        btnOutcome27.setOnClickListener(this);
        Button btnOutcome28 = (Button) findViewById(R.id.btnOutcome28);
        btnOutcome28.setTypeface(font);
        btnOutcome28.setOnClickListener(this);
        Button btnOutcome29 = (Button) findViewById(R.id.btnOutcome29);
        btnOutcome29.setTypeface(font);
        btnOutcome29.setOnClickListener(this);
        Button btnOutcome30 = (Button) findViewById(R.id.btnOutcome30);
        btnOutcome30.setTypeface(font);
        btnOutcome30.setOnClickListener(this);
        Button btnOutcome31 = (Button) findViewById(R.id.btnOutcome31);
        btnOutcome31.setTypeface(font);
        btnOutcome31.setOnClickListener(this);
        Button btnOutcome32 = (Button) findViewById(R.id.btnOutcome32);
        btnOutcome32.setTypeface(font);
        btnOutcome32.setOnClickListener(this);
        Button btnOutcome33 = (Button) findViewById(R.id.btnOutcome33);
        btnOutcome33.setTypeface(font);
        btnOutcome33.setOnClickListener(this);
        Button btnOutcome34 = (Button) findViewById(R.id.btnOutcome34);
        btnOutcome34.setTypeface(font);
        btnOutcome34.setOnClickListener(this);
        Button btnOutcome35 = (Button) findViewById(R.id.btnOutcome35);
        btnOutcome35.setTypeface(font);
        btnOutcome35.setOnClickListener(this);
        Button btnOutcome36 = (Button) findViewById(R.id.btnOutcome36);
        btnOutcome36.setTypeface(font);
        btnOutcome36.setOnClickListener(this);
        Button btnOutcome37 = (Button) findViewById(R.id.btnOutcome37);
        btnOutcome37.setTypeface(font);
        btnOutcome37.setOnClickListener(this);
        Button btnOutcome38 = (Button) findViewById(R.id.btnOutcome38);
        btnOutcome38.setTypeface(font);
        btnOutcome38.setOnClickListener(this);
        Button btnOutcome39 = (Button) findViewById(R.id.btnOutcome39);
        btnOutcome39.setTypeface(font);
        btnOutcome39.setOnClickListener(this);
        Button btnOutcome40 = (Button) findViewById(R.id.btnOutcome40);
        btnOutcome40.setTypeface(font);
        btnOutcome40.setOnClickListener(this);
        Button btnOutcome41 = (Button) findViewById(R.id.btnOutcome41);
        btnOutcome41.setTypeface(font);
        btnOutcome41.setOnClickListener(this);
        Button btnOutcome42 = (Button) findViewById(R.id.btnOutcome42);
        btnOutcome42.setTypeface(font);
        btnOutcome42.setOnClickListener(this);
        Button btnOutcome43 = (Button) findViewById(R.id.btnOutcome43);
        btnOutcome43.setTypeface(font);
        btnOutcome43.setOnClickListener(this);
        Button btnOutcome44 = (Button) findViewById(R.id.btnOutcome44);
        btnOutcome44.setTypeface(font);
        btnOutcome44.setOnClickListener(this);
        Button btnOutcome45 = (Button) findViewById(R.id.btnOutcome45);
        btnOutcome45.setTypeface(font);
        btnOutcome45.setOnClickListener(this);
        Button btnOutcome46 = (Button) findViewById(R.id.btnOutcome46);
        btnOutcome46.setTypeface(font);
        btnOutcome46.setOnClickListener(this);
        Button btnOutcome47 = (Button) findViewById(R.id.btnOutcome47);
        btnOutcome47.setTypeface(font);
        btnOutcome47.setOnClickListener(this);
        Button btnOutcome48 = (Button) findViewById(R.id.btnOutcome48);
        btnOutcome48.setTypeface(font);
        btnOutcome48.setOnClickListener(this);
        Button btnOutcome49 = (Button) findViewById(R.id.btnOutcome49);
        btnOutcome49.setTypeface(font);
        btnOutcome49.setOnClickListener(this);
        Button btnOutcome50 = (Button) findViewById(R.id.btnOutcome50);
        btnOutcome50.setTypeface(font);
        btnOutcome50.setOnClickListener(this);
        Button btnOutcome51 = (Button) findViewById(R.id.btnOutcome51);
        btnOutcome51.setTypeface(font);
        btnOutcome51.setOnClickListener(this);
        Button btnOutcome52 = (Button) findViewById(R.id.btnOutcome52);
        btnOutcome52.setTypeface(font);
        btnOutcome52.setOnClickListener(this);
        Button btnOutcome53 = (Button) findViewById(R.id.btnOutcome53);
        btnOutcome53.setTypeface(font);
        btnOutcome53.setOnClickListener(this);
        Button btnOutcome54 = (Button) findViewById(R.id.btnOutcome54);
        btnOutcome54.setTypeface(font);
        btnOutcome54.setOnClickListener(this);
        Button btnOutcome55 = (Button) findViewById(R.id.btnOutcome55);
        btnOutcome55.setTypeface(font);
        btnOutcome55.setOnClickListener(this);
        Button btnOutcome56 = (Button) findViewById(R.id.btnOutcome56);
        btnOutcome56.setTypeface(font);
        btnOutcome56.setOnClickListener(this);
        Button btnOutcome57 = (Button) findViewById(R.id.btnOutcome57);
        btnOutcome57.setTypeface(font);
        btnOutcome57.setOnClickListener(this);
        Button btnOutcome58 = (Button) findViewById(R.id.btnOutcome58);
        btnOutcome58.setTypeface(font);
        btnOutcome58.setOnClickListener(this);
        Button btnOutcome59 = (Button) findViewById(R.id.btnOutcome59);
        btnOutcome59.setTypeface(font);
        btnOutcome59.setOnClickListener(this);
        Button btnOutcome60 = (Button) findViewById(R.id.btnOutcome60);
        btnOutcome60.setTypeface(font);
        btnOutcome60.setOnClickListener(this);
        Button btnOutcome61 = (Button) findViewById(R.id.btnOutcome61);
        btnOutcome61.setTypeface(font);
        btnOutcome61.setOnClickListener(this);
        Button btnOutcome62 = (Button) findViewById(R.id.btnOutcome62);
        btnOutcome62.setTypeface(font);
        btnOutcome62.setOnClickListener(this);
        Button btnOutcome63 = (Button) findViewById(R.id.btnOutcome63);
        btnOutcome63.setTypeface(font);
        btnOutcome63.setOnClickListener(this);
        Button btnOutcome64 = (Button) findViewById(R.id.btnOutcome64);
        btnOutcome64.setTypeface(font);
        btnOutcome64.setOnClickListener(this);
        Button btnOutcome65 = (Button) findViewById(R.id.btnOutcome65);
        btnOutcome65.setTypeface(font);
        btnOutcome65.setOnClickListener(this);
        Button btnOutcome66 = (Button) findViewById(R.id.btnOutcome66);
        btnOutcome66.setTypeface(font);
        btnOutcome66.setOnClickListener(this);
        Button btnOutcome67 = (Button) findViewById(R.id.btnOutcome67);
        btnOutcome67.setTypeface(font);
        btnOutcome67.setOnClickListener(this);
        Button btnOutcome68 = (Button) findViewById(R.id.btnOutcome68);
        btnOutcome68.setTypeface(font);
        btnOutcome68.setOnClickListener(this);
        Button btnOutcome69 = (Button) findViewById(R.id.btnOutcome69);
        btnOutcome69.setTypeface(font);
        btnOutcome69.setOnClickListener(this);
        Button btnOutcome70 = (Button) findViewById(R.id.btnOutcome70);
        btnOutcome70.setTypeface(font);
        btnOutcome70.setOnClickListener(this);
        Button btnOutcome71 = (Button) findViewById(R.id.btnOutcome71);
        btnOutcome71.setTypeface(font);
        btnOutcome71.setOnClickListener(this);
        Button btnOutcome72 = (Button) findViewById(R.id.btnOutcome72);
        btnOutcome72.setTypeface(font);
        btnOutcome72.setOnClickListener(this);
        Button btnOutcome73 = (Button) findViewById(R.id.btnOutcome73);
        btnOutcome73.setTypeface(font);
        btnOutcome73.setOnClickListener(this);
        Button btnOutcome74 = (Button) findViewById(R.id.btnOutcome74);
        btnOutcome74.setTypeface(font);
        btnOutcome74.setOnClickListener(this);
        Button btnOutcome75 = (Button) findViewById(R.id.btnOutcome75);
        btnOutcome75.setTypeface(font);
        btnOutcome75.setOnClickListener(this);
        Button btnOutcome76 = (Button) findViewById(R.id.btnOutcome76);
        btnOutcome76.setTypeface(font);
        btnOutcome76.setOnClickListener(this);
        Button btnOutcome77 = (Button) findViewById(R.id.btnOutcome77);
        btnOutcome77.setTypeface(font);
        btnOutcome77.setOnClickListener(this);
        Button btnOutcome78 = (Button) findViewById(R.id.btnOutcome78);
        btnOutcome78.setTypeface(font);
        btnOutcome78.setOnClickListener(this);
        Button btnOutcome79 = (Button) findViewById(R.id.btnOutcome79);
        btnOutcome79.setTypeface(font);
        btnOutcome79.setOnClickListener(this);
        Button btnOutcome80 = (Button) findViewById(R.id.btnOutcome80);
        btnOutcome80.setTypeface(font);
        btnOutcome80.setOnClickListener(this);
    }
}
