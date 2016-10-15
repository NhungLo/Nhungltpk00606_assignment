package com.example.nhungltpk00606_assignment;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterSV extends ArrayAdapter<SinnhVienPoly>  {
	ArrayList<SinnhVienPoly> mylist;
	public AdapterSV(Context context, int resource, ArrayList<SinnhVienPoly> objects) {
		super(context, resource, objects);
		mylist=objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
		LayoutInflater inflater=LayoutInflater.from(getContext());
		view =inflater.inflate(R.layout.item_sinhvien, null);
		SinnhVienPoly item =mylist.get(position);
		TextView txtMa,txtTen,txtMalop,txtNghanhhoc,txtGioitinh;
		txtMa=(TextView)view.findViewById(R.id.textView_item_masv);
		txtTen=(TextView)view.findViewById(R.id.textView_item_ten);
		txtNghanhhoc=(TextView)view.findViewById(R.id.textView_item_nghanhhoc);
		txtGioitinh=(TextView)view.findViewById(R.id.textView_item_gt);
		txtMalop=(TextView)view.findViewById(R.id.textView1_item_malop);
		txtMa.setText(item.getMaSV());
		txtTen.setText(item.getTenSV());
		txtGioitinh.setText(item.getStringGioiTinh());
		txtNghanhhoc.setText(item.getNghanhHoc());
		txtMalop.setText(String.valueOf(item.getMaLop()));
		return view;
	}
	public void reloadadapter(ArrayList<SinnhVienPoly> newlist){
		mylist=newlist;
		notifyDataSetChanged();
	}
	
}
