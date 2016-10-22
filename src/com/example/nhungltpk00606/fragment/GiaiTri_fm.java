package com.example.nhungltpk00606.fragment;
import com.example.nhungltpk00606_assignment.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
@SuppressLint("NewApi")
public class GiaiTri_fm extends Activity{
	ImageView imggif;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giaitri_fgm);
		imggif=(ImageView)findViewById(R.id.imageViewanh);
		imggif.setBackgroundResource(R.drawable.anhdong);
	}
	
}
