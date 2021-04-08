package eadmin.edx.com.eadmin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.edaixi.platform.widget.webview.EDXWebView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EDXWebView webview = (EDXWebView) findViewById(R.id.edxWebview);
        webview.loadUrl("http://www.163.com");
    }
}
