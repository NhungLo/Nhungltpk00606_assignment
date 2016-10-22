package com.example.nhungltpk00606.fragment;

import com.example.nhungltpk00606_assignment.MainActivity;
import com.example.nhungltpk00606_assignment.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Contacts.SettingsColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
@SuppressLint("NewApi")
public class PhanBaiTap_fm extends Activity{
	ImageButton btnhw;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.phanbaitap_fgm);
	btnhw=(ImageButton)findViewById(R.id.imgbtnhw);
	btnhw.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			Intent i=new Intent(getApplicationContext(),MainActivity.class);
			startActivity(i);
		}
	});
}
	
	
}
