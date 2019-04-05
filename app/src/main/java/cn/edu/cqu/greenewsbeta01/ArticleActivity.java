package cn.edu.cqu.greenewsbeta01;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    private TextView et1;
    WebView webView;
    public static void actionStart(Context context,String newsTitle) {
        Intent intent=new Intent(context,ArticleActivity.class);
        intent.putExtra("Posted_By",newsTitle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_article);

        et1=(TextView)findViewById(R.id.Posted_By);
        String title= getIntent().getStringExtra("Posted_By");
        et1.setText(title);

        webView= (WebView)findViewById(R.id.web_view);

        WebSettings webSettings = webView.getSettings();
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setJavaScriptEnabled(true);//支持js
        webSettings.setBuiltInZoomControls(true); // 显示放大缩小
        webSettings.setSupportZoom(true); // 可以缩放
        webView.setWebViewClient(new MyWebViewClient());
        switch(title){
            case "title1":
                webView.loadUrl("file:////android_asset/index1.html");
                break;
            case "title2":
                webView.loadUrl("file:////android_asset/index2.html");
                break;
            case "title3":
                webView.loadUrl("file:////android_asset/index3.html");
                break;
            case "title4":
                webView.loadUrl("file:////android_asset/index4.html");
                break;
            case "title5":
                webView.loadUrl("file:////android_asset/index5.html");
                break;
        }

    }
    public void onClickBack(View v){
        Intent intent =new Intent(ArticleActivity.this,DrawerHomeActivity.class);
        startActivity(intent);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小

        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

    private void imgReset() {
        webView.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                "}" +
                "})()");
    }

}
