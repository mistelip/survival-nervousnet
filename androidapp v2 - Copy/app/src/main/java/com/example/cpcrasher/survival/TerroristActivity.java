package com.example.cpcrasher.survival;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class TerroristActivity extends AppCompatActivity {

    boolean emptyQuest = false;

    // Earthquake parameters
    boolean injured = false;
    boolean stuck = false;
    boolean urgentHelp = false;
    boolean potentialDanger = false;
    int buildingDestruction = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terrorist);

        // Injured
        CheckBox injuredCheckBox = (CheckBox) findViewById(R.id.injuredCheckBoxTerr);
        injuredCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                injured = true;
            }

        });

        // Stuck
        CheckBox stuckCheckBox = (CheckBox) findViewById(R.id.stuckCheckBoxTerr);
        stuckCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                stuck = true;
            }
        });

        // Urgent Help
        CheckBox urgentHelpCheckBox = (CheckBox) findViewById(R.id.urgentHelpCheckBoxTerr);
        urgentHelpCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                urgentHelp = true;
            }
        });

        // Potential Danger
        CheckBox potentialDangerCheckBox = (CheckBox) findViewById(R.id.potentialDangerCheckBoxTerr);
        potentialDangerCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyQuest = false;
                urgentHelp = true;
            }
        });

        // Building Destruction
        final Spinner buildingDestructionSpin = (Spinner) findViewById(R.id.buildingDestructionSpinnerTerr);
        buildingDestructionSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                buildingDestruction = buildingDestructionSpin.getSelectedItemPosition();
                //Toast toast = Toast.makeText(getApplicationContext(),String.valueOf(buildVal),Toast.LENGTH_SHORT);
                //toast.show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Button send_butt = (Button) findViewById(R.id.sendButtTerr);
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
