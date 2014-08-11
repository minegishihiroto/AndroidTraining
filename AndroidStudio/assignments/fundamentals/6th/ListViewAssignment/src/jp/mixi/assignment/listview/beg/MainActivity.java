
package jp.mixi.assignment.listview.beg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {

    private Activity mActivity;

    private ListView mListView;

    static ArrayList<Book> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActivity = this;

        // データの作成
        list = new ArrayList<Book>();
        for (int i = 0; i < 20; i++) {
            list.add(new Book("タイトル" + i, "出版社" + i, i * 10));
        }

        // TODO:BookArrayAdapterを作成して下さい。
        // (リストアイテムのレイアウトは用意されているlist_item_book.xmlをしてください。)
        BookArrayAdapter<String> bookArrayAdapter = new BookArrayAdapter<String>(mActivity, R.layout.list_item_book ,list);
        mListView = (ListView) findViewById(R.id.BookList);

        // TODO:ListViewにBookArrayAdapterをセットしてください。
        mListView.setAdapter(bookArrayAdapter);

        // TODO:ListViewをタップしたとき、BookActivityに遷移するようにしてください。遷移するときにBookクラスのtitleを渡してください。
        // (BookActivityは用意されているものを使用してください)
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, BookActivity.class);

                LinearLayout linearLayout = (LinearLayout)((RelativeLayout) view).getChildAt(1);
                TextView textView = (TextView) linearLayout.getChildAt(0);

                intent.putExtra("BOOK_TITLE", textView.getText());
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerForContextMenu(mListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        // ContextMenuを設定
        getMenuInflater().inflate(R.menu.context_menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() != R.id.DeleteListItem && item.getItemId() != R.id.AddListItem) {
            return false;
        }

        // MenuItemからContextMenuInfoを取得し、AdapterContextMenuInfoにキャストします
        ContextMenuInfo menuInfo = item.getMenuInfo();
        AdapterContextMenuInfo adapterInfo = (AdapterContextMenuInfo) menuInfo;

        // AdapterContextMenuInfoから長押ししたリストアイテムのpositionを取得します
        int position = adapterInfo.position;

        // ListViewから長押しされたリストアイテムを取得します
        Book book = (Book) mListView.getItemAtPosition(position);
        // ListViewからセットされているAdapterを取得します
        BookArrayAdapter adapter = (BookArrayAdapter) mListView.getAdapter();

        if (item.getItemId() == R.id.DeleteListItem) {
            // TODO:Adapterを使用して長押ししたデータを削除してください

            adapter.remove(adapter.getItem(position));

        } else if (item.getItemId() == R.id.AddListItem) {
            // TODO:Adapterを使用して長押ししたデータを追加してください

            adapter.add(book);

        }
        // TODO:Adapterを使用して表示されているデータを更新してください
        adapter.notifyDataSetChanged();

        return true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterForContextMenu(mListView);
    }

}
