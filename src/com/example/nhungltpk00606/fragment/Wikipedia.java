package com.example.nhungltpk00606.fragment;

import com.example.nhungltpk00606_assignment.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class Wikipedia extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wikipedia);
		String doc="https://vi.wikipedia.org/wiki/Vi%E1%BB%87t_Nam";
		WebView wv =(WebView)findViewById(R.id.webViewwiki);
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setAllowFileAccess(true);
		wv.getSettings().setLoadsImagesAutomatically(true);
		
		wv.loadUrl(doc);
		
	}
}
