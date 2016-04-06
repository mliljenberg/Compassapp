package com.mliljenberg.compass;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mliljenberg on 25/03/16.
 */


public class AccelerometorActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private TextView x,y,z;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acc_layout);
        x = (TextView)findViewById(R.id.xtext);
        y = (TextView)findViewById(R.id.ytext);
        z = (TextView)findViewById(R.id.ztext);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    @Override
    protected void onPause() {
        super.onPause();

        // to stop the listener and save battery
        mSensorManager.unregisterListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();

        // for the system's orientation sensor registered listeners
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        x.setText((double)sensorEvent.values[0]+"");
        y.setText((double)sensorEvent.values[1]+"");
        z.setText((double)sensorEvent.values[2]+"");


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
