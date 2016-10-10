package com.example.cpcrasher.survival;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.Toast;

public class EarthquakeActivity extends AppCompatActivity {

    boolean emptyQuest = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);


        CheckBox test = (CheckBox) findViewById(R.id.checkBox);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
            }
        });

        Button send_butt = (Button) findViewById(R.id.send_earth_butt);
        send_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EarthquakeActivity.this, MainActivity.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                if(emptyQuest){
                    Toast toast = Toast.makeText(getApplicationContext(),"You need to fill the quest!",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    startActivity(intent);
                }

            }
        });
    }
}
