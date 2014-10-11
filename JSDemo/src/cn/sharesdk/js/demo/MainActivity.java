package cn.sharesdk.js.demo;

import cn.sharesdk.js.ShareSDKUtils;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		WebView wvBody = new WebView(this);
		WebViewClient wvClient = new WebViewClient();
		wvBody.setWebViewClient(wvClient);
		wvBody.setWebChromeClient(new WebChromeClient() {
			public boolean onJsAlert(WebView view, String url, String message,
					JsResult result) {
				return super.onJsAlert(view, url, message, result);
			}
		});
		
		// you must call the following line after the webviewclient is set into the webview
		ShareSDKUtils.prepare(wvBody, wvClient);
		setContentView(wvBody);
		//wvBody.loadUrl("file:///android_asset/Sample.html");
		//wvBody.loadUrl("http://ishare.ecit-it.com/ishareapp/index.html");
		wvBody.loadUrl("http://192.168.1.100:8005/app.php");
		//wvBody.loadUrl("http://58.240.74.14:800/app.php");
	}
}
