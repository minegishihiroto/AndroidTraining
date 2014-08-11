package com.example.a12712.bmicalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class BMICalculatorActivity extends Activity {

    private EditText textHeight;
    private EditText textWeight;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Log.v("Example", "onCreate was called");
        setContentView(R.layout.activity_bmicalculator);
        textHeight = (EditText) findViewById(R.id.text_height);
        textWeight = (EditText) findViewById(R.id.text_weight);
        android.widget.Button button = (android.widget.Button) findViewById(R.id.button_calculate);
        android.widget.Button buttonShowNextActivity = (android.widget.Button) findViewById(R.id.button_show_next_activity);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.label_bmi_description);
        builder.setPositiveButton(R.string.button_close_dialog, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                setResult(RESULT_OK);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText textHeight = (EditText) findViewById(R.id.text_height);
                EditText textWeight = (EditText) findViewById(R.id.text_weight);
                int height = Integer.parseInt(textHeight.getText().toString());
                int weight = Integer.parseInt(textWeight.getText().toString());
                int bmi = 10000 * weight / height / height;
                builder.setMessage(String.valueOf(bmi));
                builder.create();
                builder.show();
            }
        });

        buttonShowNextActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                android.content.Intent intent = new android.content.Intent(BMICalculatorActivity.this, ResultActivity.class);
                intent.putExtra("HEIGHT", Integer.parseInt(textHeight.getText().toString()));
                intent.putExtra("WEIGHT", Integer.parseInt(textWeight.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }

    // 各メソッドをオーバーライド
    @Override
    protected void onStart() {
        super.onStart();
        Log.v("Example", "onStart was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("Example", "onRestart was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("Example", "onResume was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("Example", "onPause was called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("Example", "onStop was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("Example", "onDestroy was called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bmicalculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.v("Example", "onConfigurationChanged was called");
    }

}
