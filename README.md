### 自定义Webview
##### 网页加载进度条

##### 代码引用
```java
import com.edaixi.platform.widget.webview.EDXWebView;

public class MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EDXWebView webview = (EDXWebView) findViewById(R.id.edxWebview);
        webview.loadUrl("http://www.163.com");
    }
}
```

##### 布局文件引用
```xml
<com.edaixi.lib.widget.webview.EDXWebView
        android:id="@+id/edxWebview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
```

