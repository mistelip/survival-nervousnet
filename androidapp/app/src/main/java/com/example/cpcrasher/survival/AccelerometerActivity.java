package com.example.cpcrasher.survival;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import ch.ethz.coss.nervousnet.lib.ErrorReading;
import ch.ethz.coss.nervousnet.lib.LibConstants;
import ch.ethz.coss.nervousnet.lib.LightReading;
import ch.ethz.coss.nervousnet.lib.LocationReading;
import ch.ethz.coss.nervousnet.lib.NervousnetServiceConnectionListener;
import ch.ethz.coss.nervousnet.lib.NervousnetServiceController;
import ch.ethz.coss.nervousnet.lib.SensorReading;


public class AccelerometerActivity extends Activity implements NervousnetServiceConnectionListener{
    NervousnetServiceController nervousnetServiceController;

    Runnable m_statusChecker;
    Handler m_handler = new Handler();
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        txtResult = (TextView) findViewById(R.id.txtResult);

         nervousnetServiceController = new NervousnetServiceController(AccelerometerActivity.this, this);
        nervousnetServiceController.connect();



    }

    private void update() throws RemoteException {

            SensorReading gpsReading = nervousnetServiceController.getLatestReading(LibConstants.SENSOR_LOCATION);

            if (gpsReading != null) {
                if (gpsReading instanceof LocationReading) {
                    txtResult.setText(((LocationReading) gpsReading).getLatnLong() + "");
                } else if (gpsReading instanceof ErrorReading) {
                    txtResult.setText("error dataa");

                }
            } else {
                txtResult.setText("null reading");
            }


        TextView txtLux = (TextView) findViewById(R.id.txtLight);
        SensorReading lReading  = null;
        try {
            lReading = nervousnetServiceController.getLatestReading(LibConstants.SENSOR_LIGHT);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        if (lReading != null) {
            if (lReading instanceof LightReading) {
                Log.d("LightmeterActivity", "LightReading found");
                txtLux.setText("" + ((LightReading) lReading).getLuxValue());
            } else if (lReading instanceof ErrorReading) {
                Log.d("LightmeterActivity", "ErrorReading found");
                txtLux.setText("Error Code: " + ((ErrorReading) lReading).getErrorCode() + ", " + ((ErrorReading) lReading).getErrorString());

            }
        } else {
            txtLux.setText("Light object is null");
        }
    }

    @Override
    public void onServiceConnected() {
        startRepeatingTask();

    }

    @Override
    public void onServiceDisconnected() {

    }

    @Override
    public void onServiceConnectionFailed(ErrorReading errorReading) {
        Toast.makeText(this, "Error Reading " + errorReading.getErrorString(), Toast.LENGTH_LONG).show();
    }

    void startRepeatingTask() {
        m_statusChecker = new Runnable() {
            @Override
            public void run() {

                Log.d("LightmeterActivity", "before updating");

                try {
                    update();
                } catch (RemoteException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                m_handler.postDelayed(m_statusChecker, 100);
            }
        };

        m_statusChecker.run();
    }

    void stopRepeatingTask() {
        m_handler.removeCallbacks(m_statusChecker);
    }
}