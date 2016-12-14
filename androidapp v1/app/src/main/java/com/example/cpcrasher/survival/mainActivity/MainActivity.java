package com.example.cpcrasher.survival.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cpcrasher.survival.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    static boolean basic = false;
    static boolean supp = false;
    static boolean surr = false;
    static boolean extra = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        boolean basicNeedsDone = ((MyQuiz) this.getApplication()).getQuizDone("basicNeeds");
        if(((MyQuiz) this.getApplication()).getQuizDone("basicNeeds")){
            Toast toast = Toast.makeText(getApplicationContext(),"done test",Toast.LENGTH_SHORT);
            toast.show();
        }
        //*/
        //*
        // Basic needs
        final Button basicNeeds_butt = (Button) findViewById(R.id.basicNeeds_butt);
        basicNeeds_butt.setOnClickListener(new View.OnClickListener() {
            //earthquake_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BasicNeedsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                basicNeeds_butt.setAlpha(.6f);
                basicNeeds_butt.setEnabled(false);
                //basic = true;
                startActivity(intent);
            }
        });
        /*
        if(!basicNeedsDone){
            //basicNeeds_butt.setAlpha(.5f);
            //basicNeeds_butt.setEnabled(false);
        }
        //*/


        // TSupporting needs
        final Button suppNeeds_butt = (Button) findViewById(R.id.suppNeeds_butt);
        suppNeeds_butt.setOnClickListener(new View.OnClickListener(){
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SuppNeedsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                suppNeeds_butt.setAlpha(.6f);
                suppNeeds_butt.setEnabled(false);
                //supp = true;
                startActivity(intent);

            }
        });


        // Surroundings state
        final Button surroundings_butt = (Button) findViewById(R.id.surroundings_butt);
        surroundings_butt.setOnClickListener(new View.OnClickListener() {
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SurroundingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                surroundings_butt.setAlpha(.6f);
                surroundings_butt.setEnabled(false);
                //surr = true;
                startActivity(intent);
            }
        });

        // Extra information
        final Button extra_butt = (Button) findViewById(R.id.extra_butt);
        extra_butt.setOnClickListener(new View.OnClickListener() {
            //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ExtrasActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                extra_butt.setAlpha(.6f);
                extra_butt.setEnabled(false);
                //extra = true;
                startActivity(intent);
            }
        });


    }




}
