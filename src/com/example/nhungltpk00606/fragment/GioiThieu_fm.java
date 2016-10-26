package com.example.nhungltpk00606.fragment;

import com.example.nhungltpk00606_assignment.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
@SuppressLint("NewApi")
public class GioiThieu_fm extends TabActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gioithieu_fgm);
		TabHost tabhost=getTabHost();
		TabSpec GioiThieu_tab1=tabhost.newTabSpec("first");
		TabSpec GioiThieu_tab2=tabhost.newTabSpec("second");
		GioiThieu_tab1.setIndicator("Giới thiệu");
		GioiThieu_tab1.setContent(new Intent(this,GioiThieu_fm_tab1.class));
		GioiThieu_tab2.setIndicator("Liên hệ");
		GioiThieu_tab2.setContent(new Intent(this,GioiThieu_fm_tab2.class));
		tabhost.addTab(GioiThieu_tab1);
		tabhost.addTab(GioiThieu_tab2);
		
	}
}
