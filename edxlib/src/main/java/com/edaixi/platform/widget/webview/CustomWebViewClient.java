package com.edaixi.platform.widget.webview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * 自定义WebViewClient
 */
public class CustomWebViewClient extends WebViewClient {
    /**
     * 在 WebView 内打开链接
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }
}
