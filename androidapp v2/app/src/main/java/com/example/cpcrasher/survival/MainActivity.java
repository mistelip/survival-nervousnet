package com.example.cpcrasher.survival;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        TextView earthquake_txt = (TextView) findViewById(R.id.earthquake_txt);
        earthquake_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AccelerometerActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        //*/

        // Earthquake quest
        //TextView earthquake_txt = (TextView) findViewById(R.id.earthquake_txt);
        LinearLayout earthquake_butt = (LinearLayout) findViewById(R.id.earthquake_button);
        earthquake_butt.setOnClickListener(new View.OnClickListener() {
        //earthquake_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EarthquakeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        // Tsunami quest
        //TextView tsunami_txt = (TextView) findViewById(R.id.tsunami_txt);
        LinearLayout tsunami_butt = (LinearLayout) findViewById(R.id.tsunami_button);
        tsunami_butt.setOnClickListener(new View.OnClickListener(){
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TsunamiActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        // Terrorist attack quest
        //TextView terrorist_txt = (TextView) findViewById(R.id.terrorist_txt);
        LinearLayout terrorist_butt = (LinearLayout) findViewById(R.id.terrorist_button);
        terrorist_butt.setOnClickListener(new View.OnClickListener() {
        //tsunami_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TerroristActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}
