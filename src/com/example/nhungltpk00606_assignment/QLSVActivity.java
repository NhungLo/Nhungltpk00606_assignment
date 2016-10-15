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
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class QLSVActivity extends Activity {
Button btnThemsv;
Dialog dialogthemsinhvien, dialogSuasv;
ListView lv;
ArrayList<SinnhVienPoly> dsSV=new ArrayList<SinnhVienPoly>();
AdapterSV adapterSinhVien;
Sqlite_database db;
Bundle bundle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qlsv);
		btnThemsv=(Button)findViewById(R.id.btnThemsinhvien);
		btnThemsv.setOnClickListener(new View.OnClickListener() {
		
			@Override
			public void onClick(View v) {
				dialogthemSV();}
		});
		lv=(ListView)findViewById(R.id.listViewDsachsv);
		Intent intent=getIntent();
		 bundle=intent.getBundleExtra("pk");
	
	Toast.makeText(QLSVActivity.this, "lớp "+bundle.getInt("ID_Lop"), Toast.LENGTH_LONG).show();
		  db=new Sqlite_database(this);
		try {
			db.AddSV(new SinnhVienPoly("01", "hoàng ddd", "laptrinh", true, 1));
			  db.AddSV(new SinnhVienPoly("02", "châu  ddd", "laptrinh", true, 1));
			  db.AddSV(new SinnhVienPoly("03", "ngọc  ddd", "laptrinh", true, 1));
			  db.AddSV(new SinnhVienPoly("04", "ánh  ddd", "laptrinh", true, 1));
			  dsSV=db.GetAllSVTheoLop(bundle.getInt("ID_Lop"));
			  adapterSinhVien=new AdapterSV(QLSVActivity.this, R.layout.item_sinhvien, dsSV);
			  lv.setAdapter(adapterSinhVien);	
		} catch (Exception e) {
			Toast.makeText(QLSVActivity.this,e.getMessage().toString(), Toast.LENGTH_LONG).show();	
		}	 
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
				PopupMenu popupMenu=new PopupMenu(QLSVActivity.this, view);
				popupMenu.getMenuInflater().inflate(R.menu.menu_item_sv, popupMenu.getMenu());
				popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
					if(item.getItemId()==R.id.menu_item_sv_sua)
					{
						dialogsuaSinhvien(position);	
					}else
						if(item.getItemId()==R.id.menu_item_sv_xoa)
						{
							dialogxoaSV(position);		
						}
						return false;
					}
					private void startDSHS() {
						// TODO Auto-generated method stub	
					}
				});
				popupMenu.show();
				return false;
			} 
		});
	}
	
	public void dialogxoaSV(final int vitri) {
		AlertDialog.Builder dialogxoa=new AlertDialog.Builder(QLSVActivity.this);
		dialogxoa.setTitle("xóa SV!");
		dialogxoa.setMessage("bạn có muốn xóa không?");
		dialogxoa.setPositiveButton("oke", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				db.deleteSinnhVienPoly(dsSV.get(vitri));
				dsSV.remove(vitri);
				adapterSinhVien.reloadadapter(dsSV);
			}
		});
		dialogxoa.setNegativeButton("close",null);
		dialogxoa.show();
	}
	public void dialogsuaSinhvien(final int vitri){
		dialogSuasv=new Dialog(QLSVActivity.this);
		dialogSuasv.setContentView(R.layout.dialogthemsv);
		dialogSuasv.setTitle("sửa SV");
		final EditText editTextMa,editTextTen;
		final RadioButton RadioButtonNam,RadioButtonNu;
		final Spinner spinnerNghanhHoc,spinnerMaLop;
		final Button buttonClose,buttonOke,buttonXoaTrang;
		editTextMa=(EditText)dialogSuasv.findViewById(R.id.editTextMasinhvien);
		editTextTen=(EditText)dialogSuasv.findViewById(R.id.editTextTensv);
		spinnerMaLop=(Spinner)dialogSuasv.findViewById(R.id.spinnerMaLop);
		spinnerNghanhHoc=(Spinner)dialogSuasv.findViewById(R.id.spinnerNghanhHoc);
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("lập trình");
		ar.add("ứng dụng");
		ar.add("kế toán");
		ar.add("đồ họa");
		ar.add("DU LỊCH");
		try {
			ArrayList<String> listTenLop=db.GetAllTenLop();
			ArrayAdapter<String> adapterLop=new ArrayAdapter<String>(QLSVActivity.this,android.R.layout.simple_expandable_list_item_1,listTenLop);
			spinnerMaLop.setAdapter(adapterLop);
		} catch (Exception e) {
			Toast.makeText(QLSVActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
		}
		ArrayList arMaLop01=db.GetAllMaLop();
		int idlop=bundle.getInt("ID_Lop");
		int vitricuaspinner= arMaLop01.indexOf(idlop);
		spinnerMaLop.setSelection(vitricuaspinner);
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(QLSVActivity.this,android.R.layout.simple_expandable_list_item_1,ar);
		spinnerNghanhHoc.setAdapter(adapter);
		RadioButtonNam=(RadioButton)dialogSuasv.findViewById(R.id.radioNam);
		RadioButtonNu=(RadioButton)dialogSuasv.findViewById(R.id.radioNu);
		buttonClose=(Button)dialogSuasv.findViewById(R.id.btnClose_thoat);
		buttonOke=(Button)dialogSuasv.findViewById(R.id.btnClose_ok);
		buttonXoaTrang=(Button)dialogSuasv.findViewById(R.id.btnClose_xoatrang);
		buttonClose.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				dialogSuasv.dismiss();
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
				ArrayList arMaLop=db.GetAllMaLop();
				int vitriten=spinnerMaLop.getSelectedItemPosition();
				int malop=(Integer)arMaLop.get(vitriten);
				Toast.makeText(QLSVActivity.this, "vi tri chọn"+vitriten+" vị trí trong mảng"+vitri, Toast.LENGTH_LONG).show();
				SinnhVienPoly sv=new SinnhVienPoly(editTextMa.getText().toString()
						,editTextTen.getText().toString(),spinnerNghanhHoc.getSelectedItem().toString()
						,RadioButtonNam.isChecked(),malop);
				
				if(malop==bundle.getInt("ID_Lop")){
					db.updateSV(sv);
					dsSV.set(vitri, sv);
				}else{
					db.deleteSinnhVienPoly(sv);
					db.AddSV(sv);
					dsSV.remove(vitri);
				}
				adapterSinhVien.reloadadapter(dsSV);
				Toast.makeText(getApplicationContext(), "sửa thành công", Toast.LENGTH_LONG).show();
				dialogSuasv.dismiss();
			}
		});
		dialogSuasv.show();
	}
	public void dialogthemSV(){
		dialogthemsinhvien=new Dialog(QLSVActivity.this);
		dialogthemsinhvien.setContentView(R.layout.dialogthemsv);
		dialogthemsinhvien.setTitle("Thêm SV");
		final EditText editTextMa,editTextTen,editTextLop;
		final Button buttonClose,buttonOke,buttonXoaTrang;
		final RadioButton RadioButtonNam,RadioButtonNu;
		final Spinner spinnerNghanhHoc,spinnerMaLop;
		editTextMa=(EditText)dialogthemsinhvien.findViewById(R.id.editTextMasinhvien);
		editTextTen=(EditText)dialogthemsinhvien.findViewById(R.id.editTextTensv);
		spinnerMaLop=(Spinner)dialogthemsinhvien.findViewById(R.id.spinnerMaLop);
		ArrayList<String> listTenLop=db.GetAllTenLop();
		ArrayList arMaLop01=db.GetAllMaLop();
		spinnerNghanhHoc=(Spinner)dialogthemsinhvien.findViewById(R.id.spinnerNghanhHoc);
		ArrayAdapter<String> adapterLop=new ArrayAdapter<String>(QLSVActivity.this,android.R.layout.simple_expandable_list_item_1,listTenLop);
		spinnerMaLop.setAdapter(adapterLop);
		int idlop=bundle.getInt("ID_Lop");
		int vitricuaspinner= arMaLop01.indexOf(idlop);
		spinnerMaLop.setSelection(vitricuaspinner);
		spinnerMaLop.setEnabled(false);
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("lập trình");
		ar.add("ứng dụng");
		ar.add("kế toán");
		ar.add("đồ họa");
		ar.add("DU LỊCH");
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(QLSVActivity.this,android.R.layout.simple_expandable_list_item_1,ar);
		spinnerNghanhHoc.setAdapter(adapter);
		RadioButtonNam=(RadioButton)dialogthemsinhvien.findViewById(R.id.radioNam);
		RadioButtonNu=(RadioButton)dialogthemsinhvien.findViewById(R.id.radioNu);
		buttonClose=(Button)dialogthemsinhvien.findViewById(R.id.btnClose_thoat);
		buttonOke=(Button)dialogthemsinhvien.findViewById(R.id.btnClose_ok);
		buttonXoaTrang=(Button)dialogthemsinhvien.findViewById(R.id.btnClose_xoatrang);
		buttonClose.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialogthemsinhvien.dismiss();
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
				try {
				
					ArrayList arMaLop=db.GetAllMaLop();
					int vitriten=spinnerMaLop.getSelectedItemPosition();
					int malop=(Integer)arMaLop.get(vitriten);
				SinnhVienPoly loptam01= new SinnhVienPoly(editTextMa.getText().toString()
						,editTextTen.getText().toString(),spinnerNghanhHoc.getSelectedItem().toString()
						,RadioButtonNam.isChecked(),malop);
				db.AddSV(loptam01);
					dsSV.add(loptam01);
		adapterSinhVien.reloadadapter(dsSV);
				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "lỗi" +e.getMessage().toString(), Toast.LENGTH_LONG).show();
				}
				Toast.makeText(getApplicationContext(), "thêm thành công", Toast.LENGTH_LONG).show();
				dialogthemsinhvien.dismiss();	
			}
		});
		dialogthemsinhvien.show();
	}
}
