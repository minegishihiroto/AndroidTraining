Assignment Report for 2.2
------

以下に、課題の回答を記入してください。

Activity と Fragment
======

### Activity

3. ライフサイクルのコールバックメソッドの呼び出し順

各ライフサイクルをOverrideして、Logを出力した結果は以下のようになった(MainActivity.javaを参照)
08-10 03:00:46.519    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onPause was called
08-10 03:00:47.019    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onStop was called
08-10 03:00:47.019    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onDestroy was called
08-10 03:00:47.869    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onCreate was called
08-10 03:00:47.869    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onStart was called
08-10 03:00:47.879    1804-1804/jp.mixi.assignment.controller.beg V/Example﹕ onResume was called


