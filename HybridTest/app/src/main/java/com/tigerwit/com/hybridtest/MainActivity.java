package com.tigerwit.com.hybridtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView =(WebView)findViewById(R.id.my_webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.requestFocus();
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void hello(String name) {
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
            }
        }, "obj");
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
        webView.loadUrl("file:///android_asset/www/hello.html");
    }
}
