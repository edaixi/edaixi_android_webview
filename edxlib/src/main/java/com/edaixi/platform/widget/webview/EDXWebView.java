package com.edaixi.platform.widget.webview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.edaixi.platform.R;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

/**
 * Created by Chongwen on 15/12/10.
 * <p/>
 * 自定义：
 * 1.进度条
 * 2.alert
 */
public class EDXWebView extends BridgeWebView {
    private Context mContex;
    private ProgressBar webviewProgressbar;

    public EDXWebView(Context context) {
        super(context);
    }

    public EDXWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContex = context;

        webviewProgressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        webviewProgressbar.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 12, 0, 0));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webviewProgressbar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_horizontal_holo_light,mContex.getTheme()));
        } else {
            webviewProgressbar.setProgressDrawable(getResources().getDrawable(R.drawable.progress_horizontal_holo_light));
        }

        addView(webviewProgressbar);

        WebSettings webSettings = getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUserAgentString("xiaoe_app_android");
        webSettings.setGeolocationEnabled(true);
        webSettings.setGeolocationDatabasePath(Environment.getExternalStorageDirectory().getPath());


        setWebChromeClient(new EDXWebChromeClient());
    }

    @Override
    public void loadUrl(String jsUrl, CallBackFunction returnCallback) {

        super.loadUrl(jsUrl, returnCallback);
    }

    @Override
    public void loadUrl(String url) {

        super.loadUrl(url);
    }

    public class EDXWebChromeClient extends WebChromeClient {

        /**
         * 进度条
         *
         * @param view
         * @param newProgress
         */
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                webviewProgressbar.setVisibility(View.INVISIBLE);
            } else {
                webviewProgressbar.setVisibility(View.VISIBLE);
                webviewProgressbar.setProgress(newProgress);
            }
        }

        @Override
        public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
            AlertDialog.Builder b2 = new AlertDialog.Builder(mContex)
                    .setTitle("对话框")
                    .setMessage(message)
                    .setPositiveButton("确定",
                            new AlertDialog.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    result.confirm();
                                }
                            });

            b2.setCancelable(false);
            b2.create();
            b2.show();
            return true;
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            callback.invoke(origin,true,true);

            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
    }

}
