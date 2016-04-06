package com.mliljenberg.compass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mliljenberg on 25/03/16.
 */
public class MainActivity extends Activity {
    private Button compass,acc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.real_main);
        compass = (Button)findViewById(R.id.compass_button);
        acc = (Button) findViewById(R.id.acc_button);
        compass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CompassActivity.class);
                startActivity(i);
            }
        });

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),AccelerometorActivity.class);
                startActivity(i);
            }
        });

    }

    }
