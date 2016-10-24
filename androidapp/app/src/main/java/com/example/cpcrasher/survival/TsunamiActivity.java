package com.example.cpcrasher.survival;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class TsunamiActivity extends AppCompatActivity {

    boolean emptyQuest = true;

    // Earthquake parameters
    boolean injured = false;
    boolean stuck = false;
    boolean urgentHelp = false;
    int buildingDestruction = -1;
    int survivalDays = -1;
    int waterLevel = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsunami);


        // Injured
        CheckBox injuredCheckBox = (CheckBox) findViewById(R.id.injuredCheckBoxTsu);
        injuredCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                injured = true;
            }

        });

        // Stuck
        CheckBox stuckCheckBox = (CheckBox) findViewById(R.id.stuckCheckBoxTsu);
        stuckCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                stuck = true;
            }
        });

        // Urgent Help
        CheckBox urgentHelpCheckBox = (CheckBox) findViewById(R.id.urgentHelpCheckBoxTsu);
        urgentHelpCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                urgentHelp = true;
            }
        });

        // Building Destruction
        final Spinner buildingDestructionSpin = (Spinner) findViewById(R.id.buildingDestructionSpinnerTsu);
        buildingDestructionSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                emptyQuest = false;
                buildingDestruction = buildingDestructionSpin.getSelectedItemPosition();
                //Toast toast = Toast.makeText(getApplicationContext(),String.valueOf(buildVal),Toast.LENGTH_SHORT);
                //toast.show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Survival Days
        final Spinner survivalSpin = (Spinner) findViewById(R.id.survivalDaysSpinnerTsu);
        survivalSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                emptyQuest = false;
                survivalDays = survivalSpin.getSelectedItemPosition();
                //Toast toast = Toast.makeText(getApplicationContext(),String.valueOf(buildVal),Toast.LENGTH_SHORT);
                //toast.show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Water Level
        final Spinner waterLevelSpin = (Spinner) findViewById(R.id.waterLevelSpinnerTsu);
        waterLevelSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                emptyQuest = false;
                waterLevel = waterLevelSpin.getSelectedItemPosition();
                //Toast toast = Toast.makeText(getApplicationContext(),String.valueOf(buildVal),Toast.LENGTH_SHORT);
                //toast.show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Send
        Button send_butt = (Button) findViewById(R.id.sendButtTsu);
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
        // Check if spinners are -1: if notm¡, send value.
        Toast toast = Toast.makeText(getApplicationContext(),"Data has been sent",Toast.LENGTH_SHORT);
        toast.show();
    }
}
