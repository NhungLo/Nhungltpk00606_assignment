package com.example.nhungltpk00606.fragment;
import com.example.nhungltpk00606_assignment.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
@SuppressLint("NewApi")
public class GiaiTri_fm extends Activity{
	private ImageView progress;
	 
    private Button nutBam;
 
    private AnimationDrawable frameAnimation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.giaitri_fgm);
		 nutBam = (Button) findViewById(R.id.button);
		 
	        nutBam.setText("Click to see...");
	 
	 
	 
	        progress = (ImageView) findViewById(R.id.im);
	 
	        if (progress != null) {
	 
	            progress.setVisibility(View.VISIBLE);
	 
	            frameAnimation = (AnimationDrawable) progress.getDrawable();
	 
	            frameAnimation.setCallback(progress);
	 
	            frameAnimation.setVisible(true, true);
	 
	        }
	 
	 
	 
	        nutBam.setOnClickListener(new View.OnClickListener() {
	 
	            @Override
	 
	            public void onClick(View v) {
	 
	                if (!frameAnimation.isRunning()) {
	 
	                    frameAnimation.start();
	 
	                    nutBam.setText("Stop :)))");
	 
	                    Log.v("---", "frameAnimation.start()");
	 
	                } else {
	 
	                    frameAnimation.stop();
	 
	                    nutBam.setText("Click to see...");
	 
	                    Log.v("---", "frameAnimation.stop()");
	 
	                }
	 
	            }
	 
	        });
	 
	    }
	 
	}
	 
