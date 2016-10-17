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


        CheckBox injuredCheckBox = (CheckBox) findViewById(R.id.injuredCheckBoxEarth);
        injuredCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
            }

        });

        Button send_butt = (Button) findViewById(R.id.sendButtEarth);
        send_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emptyQuest){
                    Toast toast = Toast.makeText(getApplicationContext(),"You need to fill the quest!",Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    sendDataToserver();
                    finish();
                }

            }
        });
    }

    public void sendDataToserver(){
        // TODO: Take quest not empty variables and values and send them to Nervousnet Servers
    }
}
