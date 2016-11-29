package com.example.cpcrasher.survival.mainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cpcrasher.survival.R;

public class BasicNeedsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_needs);

        // Send
        Button send_butt = (Button) findViewById(R.id.sendButtBasicNeeds);
        send_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendDataToserver();
                finish();
            }
        });
    }

    public void sendDataToserver(){
        // TODO: Take quest not empty variables and values and send them to Nervousnet Servers
        // Check if spinners are -1: if notm¡, send value.
        Toast toast = Toast.makeText(getApplicationContext(),"Data has been sent",Toast.LENGTH_SHORT);
        toast.show();
        ((MyQuiz)this.getApplication()).setQuizDone("basicNeeds");
    }
}
