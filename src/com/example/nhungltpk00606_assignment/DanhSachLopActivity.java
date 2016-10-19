package com.example.nhungltpk00606_assignment;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class DanhSachLopActivity extends Activity {
ListView lv;
ArrayList<LopPoly> dsl=null;
Dialog dialogSualop,dialogthemlop;
Button buttonThemLop;
Sqlite_database db;
AdapterLopPoly adapterLopPoly;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danh_sach_lop);
		lv=(ListView)findViewById(R.id.listViewDanhSachLop);
		 db=new Sqlite_database(this);
		buttonThemLop=(Button)findViewById(R.id.buttonThemClass);
		db.AddLopPoly(new LopPoly("lt01","lap trinh 01"));
		db.AddLopPoly(new LopPoly("lt02","lap trinh 02"));
		db.AddLopPoly(new LopPoly("lt03","lap trinh 04"));
		db.AddLopPoly(new LopPoly("lt04","lap trinh 05"));
		db.AddLopPoly(new LopPoly("lt05","lap trinh 06"));
		db.AddLopPoly(new LopPoly("lt06","lap trinh 07"));
		db.AddLopPoly(new LopPoly("lt07","lap trinh 08"));
		dsl=db.GetAllLop();
		Toast.makeText(getApplicationContext(),
		dsl.get(1).getMaLop(), Toast.LENGTH_LONG).show();
		adapterLopPoly=new AdapterLopPoly(DanhSachLopActivity.this, R.layout.itemlop,dsl);
		lv.setAdapter(adapterLopPoly);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent=new Intent(DanhSachLopActivity.this,QLSVActivity.class);
				Bundle bundle=new Bundle();
				bundle.putInt("ID_Lop", dsl.get(position).getID());
				intent.putExtra("pk", bundle);
				startActivity(intent);	
			}
		});
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {
				PopupMenu popupMenu=new PopupMenu(DanhSachLopActivity.this, view);
				popupMenu.getMenuInflater().inflate(R.menu.menu_item_lop, popupMenu.getMenu());
				popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
					if(item.getItemId()==R.id.menu_item_lop_sua)
					{
						dialogsualop(position);	
					}else
						if(item.getItemId()==R.id.menu_item_lop_xoa)
						{
							dialogxoalop(position);	
							
						}else
							{
							Toast.makeText(DanhSachLopActivity.this, "bạn đã click vô chi tiết", Toast.LENGTH_SHORT).show();
								startDSHS();
							}	
						return false;
					}
				});
				popupMenu.show();
				return false;
			}
		});
		buttonThemLop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogthemlop();
			}
		});
	}
	public void startDSHS(){		
	}
	
	public void dialogxoalop(final int vitri) {
		AlertDialog.Builder dialogxoa=new AlertDialog.Builder(DanhSachLopActivity.this);
		dialogxoa.setTitle("xóa lớp!");
		dialogxoa.setMessage("bạn có muốn xóa không?");
		dialogxoa.setPositiveButton("oke", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				db.deleteLopPoly(dsl.get(vitri));
				dsl.remove(vitri);
				adapterLopPoly.reloadadapter(dsl);
			}
		});
		dialogxoa.setNegativeButton("close",null);
		dialogxoa.show();	
	}
	public void dialogsualop(final int vitri){
		dialogSualop=new Dialog(DanhSachLopActivity.this);
		dialogSualop.setContentView(R.layout.dialogthemlop);
		dialogSualop.setTitle("sửa dữ liệu");
		final EditText editTextMa,editTextTen;
		final Button buttonClose,buttonOke,buttonXoaTrang;
		editTextMa=(EditText)dialogSualop.findViewById(R.id.editTextMalop);
		editTextTen=(EditText)dialogSualop.findViewById(R.id.editTextTensv);
		buttonClose=(Button)dialogSualop.findViewById(R.id.btnThoat);
		buttonOke=(Button)dialogSualop.findViewById(R.id.btnLuulop);
		buttonXoaTrang=(Button)dialogSualop.findViewById(R.id.btnXoatrang);
		buttonClose.setOnClickListener(new View.OnClickListener() {
		LopPoly lopPoly = db.getLop(vitri);
		//editTextMa.setText(lopPoly.getMaLop);
		//editTextTen.setText(lopPoly.getTensv);
			public void onClick(View v) {
				dialogSualop.dismiss();
				
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
				LopPoly loptam02=new LopPoly(editTextMa.getText().toString(),editTextTen.getText().toString());
				db.updateLopPoly(loptam02);
				dsl.set(vitri, loptam02);
				adapterLopPoly.reloadadapter(dsl);
				Toast.makeText(getApplicationContext(), "sửa thành công", Toast.LENGTH_LONG).show();
				dialogSualop.dismiss();
			}
		});
					dialogSualop.show();
	}
	public void dialogthemlop(){
		dialogthemlop=new Dialog(DanhSachLopActivity.this);
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
				dsl.add(loptam01);
				adapterLopPoly.reloadadapter(dsl);
				adapterLopPoly.notifyDataSetChanged();
				Toast.makeText(getApplicationContext(), "thêm thành công", Toast.LENGTH_LONG).show();
				dialogthemlop.dismiss();	
			}
		});
		dialogthemlop.show();
	}
}

	