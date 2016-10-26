package com.example.nhungltpk00606.fragment;

import com.example.nhungltpk00606_assignment.MainActivity;
import com.example.nhungltpk00606_assignment.R;
import com.example.nhungltpk00606_assignment.TrangHome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Hello_fm extends Activity{
	EditText tendn, mk;
	Button dn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_fgm);
		tendn=(EditText)findViewById(R.id.txtTendn_hello);
		mk=(EditText)findViewById(R.id.txtMk_hello);
		dn=(Button)findViewById(R.id.btnDangnhap_hello);
		dn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username="Nhungbin";
				String pass=("nhung123");
				if(tendn.getText().toString().equals(username) && mk.getText().toString().equals(pass)){
					Toast.makeText(getApplicationContext(), R.string.loginsuccess, Toast.LENGTH_LONG).show();
					Intent o=new Intent(Hello_fm.this,GioiThieu_fm.class);
					startActivity(o);
				}else{
					Toast.makeText(getApplicationContext(), R.string.loginerror, Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
