package com.tampil.pdf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class PDFActivity extends AppCompatActivity {

    WebView webView;
    private ProgressBar progressBar;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        webView = findViewById(R.id.WV);
        progressBar = findViewById(R.id.pb);
        progressBar.setVisibility(View.VISIBLE);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setWebChromeClient(new WebChromeClient());
        Intent intent = getIntent();
        final int position = intent.getIntExtra("position",0);

        //https://docs.google.com/viewerng/viewer?embedded=true&url=
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url="+MainActivity.list.get(position).getPdfUrl());
// ganti ini jika pake drive http://drive.google.com/viewerng/viewer?embedded=true&url=

    }
}
