package ru.gendalf13666.moonshiner;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class book_main extends AppCompatActivity {

    protected void onCreate(Bundle bundle) {
        int n;
        TextView bookname;
        WebView webView;
        block14 : {
            super.onCreate(bundle);
            this.setContentView(R.layout.activity_book_main);
            ActionBar actionBar = this.getSupportActionBar();
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            bookname = this.findViewById(R.id.bookname);
            String string2 = this.getIntent().getExtras().get("book").toString();
            webView = this.findViewById(R.id.webView);
            switch (string2.hashCode()) {
                default: {
                    break;
                }
                case 1421950339: {
                    if (!string2.equals("fruitwater")) break;
                    n = 1;
                    break block14;
                }
                case 1419162682: {
                    if (!string2.equals("fruittable")) break;
                    n = 3;
                    break block14;
                }
                case 189091618: {
                    if (!string2.equals("ferments")) break;
                    n = 2;
                    break block14;
                }
                case -386077403: {
                    if (!string2.equals("hoptable")) break;
                    n = 4;
                    break block14;
                }
                case -503888488: {
                    if (!string2.equals("yeasttable")) break;
                    n = 5;
                    break block14;
                }
                case -963515783: {
                    if (!string2.equals("fertman")) break;
                    n = 0;
                    break block14;
                }
            }
            n = -1;
        }
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        if (n != 4) {
                            if (n != 5) {
                                return;
                            }
                            bookname.setText("\u0422\u0430\u0431\u043b\u0438\u0446\u0430 \u0441\u0443\u0445\u0438\u0445 \u043f\u0438\u0432\u043d\u044b\u0445 \u0434\u0440\u043e\u0436\u0436\u0435\u0439");
                            webView.loadUrl("file:///android_asset/yeasttable.html");
                            return;
                        }
                        bookname.setText("\u0422\u0430\u0431\u043b\u0438\u0446\u0430 \u0441\u043e\u0440\u0442\u043e\u0432 \u0445\u043c\u0435\u043b\u044f");
                        webView.loadUrl("file:///android_asset/hoptable.html");
                        return;
                    }
                    bookname.setText("\u0421\u043e\u0434\u0435\u0440\u0436\u0430\u043d\u0438\u0435 \u0441\u0430\u0445\u0430\u0440\u0430 \u0438 \u043a\u0438\u0441\u043b\u043e\u0442");
                    webView.loadUrl("file:///android_asset/fruittable.html");
                    return;
                }
                bookname.setText("\u0424\u0435\u0440\u043c\u0435\u043d\u0442\u044b");
                webView.loadUrl("file:///android_asset/ferments_brew.html");
                return;
            }
            bookname.setText("\u0421\u043e\u0434\u0435\u0440\u0436\u0430\u043d\u0438\u0435 \u0432\u043e\u0434\u044b \u0432\u043e \u0444\u0440\u0443\u043a\u0442\u0430\u0445");
            webView.loadUrl("file:///android_asset/fruitwater.html");
            return;
        }
        bookname.setText("\u0422\u0430\u0431\u043b\u0438\u0446\u0430 \u0424\u0435\u0440\u0442\u043c\u0430\u043d\u0430");
        webView.loadUrl("file:///android_asset/fertman.html");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() !=  R.id.home) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.finish();
        return true;
    }
}

