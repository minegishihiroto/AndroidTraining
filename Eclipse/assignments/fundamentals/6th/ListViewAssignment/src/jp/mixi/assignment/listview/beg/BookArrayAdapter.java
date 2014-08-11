package jp.mixi.assignment.listview.beg;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

/**
 * Created by a12712 on 8/11/14.
 */
public class BookArrayAdapter<String> extends ArrayAdapter<String> {

    private Context _context;
    private int _textViewResourceId;
    private List<Book> _items;
    private LayoutInflater mLayoutInflater;

    public BookArrayAdapter(Context context,
                            int textViewResourceId,
                            ArrayList items) {
        super(context, textViewResourceId, items);

        _context = context;
        _textViewResourceId = textViewResourceId;
        _items = items;

        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        // ListViewに表示する分のレイアウトが生成されていない場合レイアウトを作成する
        if (convertView == null) {
            // レイアウトファイルからViewを生成する
            view = mLayoutInflater.inflate(R.layout.list_item_book, parent, false);
        } else {
            // レイアウトが存在する場合は再利用する
            view = convertView;
        }

        // リストアイテムに対応するデータを取得する
        Book item = _items.get(position);

        // 各Viewに表示する情報を設定
        TextView title = (TextView) view.findViewById(R.id.Title);
        title.setText("" + item.getTitle());
        TextView publisher = (TextView) view.findViewById(R.id.Publisher);
        publisher.setText("" + item.getPublisher());
        TextView price = (TextView) view.findViewById(R.id.Price);
        price.setText(item.getPrice() + "円");

        return view;
    }
}
