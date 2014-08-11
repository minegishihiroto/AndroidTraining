package com.example.a12712.bmicalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.a12712.bmicalculator.R;

public class ResultActivity extends Activity {

    private int height = 0;
    private int weight = 0;
    private int bmi = 0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_result);
        TextView bmiValue = (TextView) findViewById(R.id.label_bmi_value);
        TextView status = (TextView) findViewById(R.id.label_status);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            height = extras.getInt("HEIGHT");
            weight = extras.getInt("WEIGHT");
            bmi = 10000 * weight / height / height;
            bmiValue.setText(String.valueOf(bmi));
            if (bmi > 24)
                status.setText(R.string.label_too_fat);
            else if (bmi < 18)
                status.setText(R.string.label_too_slim);
            else
                status.setText(R.string.label_standard);
        }
    }
}
