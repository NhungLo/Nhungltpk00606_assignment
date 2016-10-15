package com.example.nhungltpk00606_assignment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdapterLopPoly  extends ArrayAdapter<LopPoly>{
   ArrayList<LopPoly> mylist;
	public AdapterLopPoly(Context context, int resource, ArrayList<LopPoly> objects) {
		super(context, resource, objects);
		mylist=objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view=convertView;
		LayoutInflater inflater=LayoutInflater.from(getContext());
		view =inflater.inflate(R.layout.itemlop, null);
		LopPoly item =mylist.get(position);
		TextView txtMa,txtTen;
		txtMa=(TextView)view.findViewById(R.id.textViewMa);
		txtTen=(TextView)view.findViewById(R.id.textViewTen);
		txtMa.setText(item.getMaLop());
		txtTen.setText(item.getTenLop());
		return view;
	}
	public void reloadadapter(ArrayList<LopPoly> newlist){
		mylist=newlist;
		notifyDataSetChanged();
	}
	

}
