
package jp.mixi.assignment.controller.beg;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Toast;
import android.util.Log;

/**
 * TODO: 課題1
 * {@link Toast#makeText(Context, CharSequence, int)} または
 * {@link Toast#makeText(Context, int, int)} を利用して、各ライフサイクルメソッドがどのような順番で
 * 実行されているかを確認してください。
 * 確認したら、assignments/fundamentals/2nd/Report.md にその順番を記述してください。
 * @author keishin.yokomaku
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Toast example", Toast.LENGTH_LONG).show();
        Log.v("Example", "onCreate was called");
    }

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}