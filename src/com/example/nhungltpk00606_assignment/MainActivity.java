package com.example.nhungltpk00606_assignment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
Button buttonDanhSachLop;
Button buttonQlsv;
Button buttonThemlop;
Dialog dialogThem, dialogSualop;
Sqlite_database db= new Sqlite_database(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		buttonDanhSachLop=(Button)findViewById(R.id.buttonXemdsl);
		buttonQlsv=(Button)findViewById(R.id.buttonQuanlysinhvien);
		buttonThemlop=(Button)findViewById(R.id.buttonThemlop);
		buttonThemlop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogthemlop();
			}
		});
		buttonQlsv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,QLSVActivity.class);
				startActivity(intent);
			}
		});
		buttonDanhSachLop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),DanhSachLopActivity.class);
				startActivity(intent);
			}
		});
	}
	Dialog dialogthemlop;
	public void dialogthemlop(){
		dialogthemlop=new Dialog(MainActivity.this);
		dialogthemlop.setContentView(R.layout.dialogthemlop);
		dialogthemlop.setTitle("Thêm lớp");
		final EditText editTextMa,editTextTen;
		final Button buttonClose,buttonOke,buttonXoaTrang;
		editTextMa=(EditText)dialogthemlop.findViewById(R.id.editTextMalop);
		editTextTen=(EditText)dialogthemlop.findViewById(R.id.editTextTensv);
		buttonClose=(Button)dialogthemlop.findViewById(R.id.btnThoat);
		buttonOke=(Button)dialogthemlop.findViewById(R.id.btnLuulop);
		buttonXoaTrang=(Button)dialogthemlop.findViewById(R.id.btnXoatrang);
		buttonClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogthemlop.dismiss();
			}
		});
		buttonXoaTrang.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
						editTextMa.setText("");
						editTextTen.setText("");	
						}
					});
		buttonOke.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 LopPoly loptam01= new LopPoly(editTextMa.getText().toString(),editTextTen.getText().toString());
				db.AddLopPoly(loptam01);
				Toast.makeText(getApplicationContext(), "thêm thành công", Toast.LENGTH_LONG).show();
				dialogthemlop.dismiss();	
			}
		});
		dialogthemlop.show();
	}	
	
}
