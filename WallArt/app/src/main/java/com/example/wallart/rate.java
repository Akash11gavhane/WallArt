package com.example.wallart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        WebView w2 = findViewById(R.id.webView2);

        w2.setWebViewClient(new WebViewClient());
        w2.loadUrl("https://play.google.com/store/apps/details?id=net.zedge.android");

    }
}