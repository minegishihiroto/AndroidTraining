
package jp.mixi.assignment.listview.beg;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BookActivity extends Activity {

    @SuppressWarnings("unused")
    private static final String TAG = BookActivity.class.getSimpleName();

    private String bookTitle = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book);

        // TODO:MainActiviyから送られてきたtitleを表示してください。
        TextView title = (TextView) findViewById(R.id.BookTitle);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            bookTitle = extras.getString("BOOK_TITLE");
        }
        title.setText(bookTitle);

    }
}
