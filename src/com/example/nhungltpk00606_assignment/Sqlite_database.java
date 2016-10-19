package com.example.nhungltpk00606_assignment;

import java.sql.Statement;
import java.util.ArrayList;

import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlite_database extends SQLiteOpenHelper{
 public static final String DATA_Name="QLSV";
 public static final int DATA_Version=1;
 public static final String Table_Lop="Lop";
 public static final String Table_SinhVien="SinhVien";
 public static final String Lop_ID="ID";
 public static final String Lop_MaLop="MaLop";
 public static final String Lop_TenLop="TenLop";
 
	//SV PART// 
 public static final String SV_ID="ID";
 public static final String SV_MA="MaSV";
 public static final String SV_TEN="TenSV";
 public static final String SV_GT="GioiTinh";
 public static final String SV_MaLop="Malop";
 public static final String SV_NGANHHOC="NghanhHoc";

 
	public Sqlite_database(Context context) {
		super(context, DATA_Name, null, DATA_Version);	
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String Create_Table_Lop="Create table "+Table_Lop +"( "+
								Lop_ID+" INTEGER PRIMARY KEY ,"+Lop_MaLop+
								" TEXT,"+Lop_TenLop+" TEXT)";	
		//SV PART// 
		
		String Create_Table_SV="Create table "+Table_SinhVien +"( "+
				SV_ID+" INTEGER PRIMARY KEY ,"+SV_MA+
				" TEXT,"+SV_TEN+" TEXT ,"+SV_GT+ " TEXT ,"+SV_NGANHHOC+" TEXT," +SV_MaLop+ " INTEGER)";
		db.execSQL(Create_Table_Lop);
		db.execSQL(Create_Table_SV);
	}
	
	public void AddLopPoly(LopPoly lop){
	SQLiteDatabase db=this.getWritableDatabase();
	ContentValues values=new ContentValues();
	values.put(Lop_MaLop, lop.getMaLop());
	values.put(Lop_TenLop, lop.getTenLop());	
	db.insert(Table_Lop, null, values);
	db.close();
	}
	
	public void AddSV(SinnhVienPoly sv){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(SV_MaLop, sv.getMaLop());
		values.put(SV_NGANHHOC, sv.getNghanhHoc());
		values.put(SV_GT, sv.getStringGioiTinh());
		values.put(SV_MA, sv.getMaSV());
		values.put(SV_TEN, sv.getTenSV());	
		db.insert(Table_SinhVien, null, values);
		db.close();
		}
	
	public void updateLopPoly(LopPoly lop){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(Lop_MaLop, lop.getMaLop());
		values.put(Lop_TenLop, lop.getTenLop());	
		db.update(Table_Lop, values, Lop_ID+" =?", new  String[]{String.valueOf(lop.getID())});
		db.close();
	}
	
	public void updateSV(SinnhVienPoly sv){
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put(SV_MaLop, sv.getMaLop());
		values.put(SV_NGANHHOC, sv.getNghanhHoc());
		values.put(SV_GT, sv.getGioiTinh());
		values.put(SV_MA, sv.getMaSV());
		values.put(SV_TEN, sv.getTenSV());	
		db.update(Table_SinhVien, values, SV_ID+" =?", new  String[]{String.valueOf(sv.getID())});
		db.close();	
	}
	public ArrayList<LopPoly> GetAllLop(){
		ArrayList<LopPoly> dsl=new ArrayList<LopPoly>();
		String Get_All_Lop="SELECT * FROM "+Table_Lop;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_Lop, null);
		if(cursor.moveToFirst()){
			do{
				LopPoly lop=new LopPoly();
				lop.setID(cursor.getInt(0));
				lop.setMaLop(cursor.getString(cursor.getColumnIndex(Lop_MaLop)));
				lop.setTenLop(cursor.getString(cursor.getColumnIndex(Lop_TenLop)));
				dsl.add(lop);		
			}while(cursor.moveToNext());
		}	
		return dsl;
	}
	public LopPoly getLop(int id){
		LopPoly lop=new LopPoly();
		String Get_All_Lop="SELECT * FROM "+Table_Lop+"where"+Lop_ID+"="+String.valueOf(id);
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_Lop, null);
		if(cursor.moveToFirst()){
			do{
				
				lop.setID(cursor.getInt(0));
				lop.setMaLop(cursor.getString(cursor.getColumnIndex(Lop_MaLop)));
				lop.setTenLop(cursor.getString(cursor.getColumnIndex(Lop_TenLop)));
					
			}while(cursor.moveToNext());
		}	
		return lop;
	}
	public ArrayList<String> GetAllTenLop(){
		ArrayList<String> dsl=new ArrayList<String>();
		String Get_All_Lop="SELECT * FROM "+Table_Lop;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_Lop, null);
		if(cursor.moveToFirst()){
			do{
				dsl.add(cursor.getString(cursor.getColumnIndex(Lop_TenLop)));		
			}while(cursor.moveToNext());
		}	
		return dsl;
	}
	public ArrayList GetAllMaLop(){
		ArrayList dsl=new ArrayList();
		String Get_All_Lop="SELECT * FROM "+Table_Lop;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_Lop, null);
		if(cursor.moveToFirst()){
			do{
				dsl.add(cursor.getInt(cursor.getColumnIndex(Lop_ID)));		
			}while(cursor.moveToNext());
		}	
		return dsl;
	}
//MAD//
	public ArrayList<SinnhVienPoly> GetAllSV(){
		ArrayList<SinnhVienPoly> dsSV=new ArrayList<SinnhVienPoly>();
		String Get_All_SV="SELECT * FROM "+Table_SinhVien;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_SV, null);
		if(cursor.moveToFirst()){
			do{
				SinnhVienPoly sv=new SinnhVienPoly();
				sv.setID(cursor.getInt(0));
				sv.setMaSV(cursor.getString(cursor.getColumnIndex(SV_MA)));
				sv.setTenSV(cursor.getString(cursor.getColumnIndex(SV_TEN)));
				if(cursor.getString(cursor.getColumnIndex(SV_GT)).equals("Nam"))
				sv.setGioiTinh(true);
				else
				sv.setGioiTinh(false);
				sv.setNghanhHoc(cursor.getString(cursor.getColumnIndex(SV_NGANHHOC)));
				sv.setMaLop(cursor.getInt(cursor.getColumnIndex(SV_MaLop)));
				dsSV.add(sv);
				
			}while(cursor.moveToNext());
		}	
		return dsSV;
	}
	
	public ArrayList<SinnhVienPoly> GetAllSVTheoLop(int MaLop){
		ArrayList<SinnhVienPoly> dsSV=new ArrayList<SinnhVienPoly>();
		String Get_All_SV="SELECT * FROM "+Table_SinhVien+ " where "+SV_MaLop+" ="+MaLop;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_SV, null);
		if(cursor.moveToFirst()){
			do{
				SinnhVienPoly sv=new SinnhVienPoly();
				sv.setID(cursor.getInt(0));
				sv.setMaSV(cursor.getString(cursor.getColumnIndex(SV_MA)));
				sv.setTenSV(cursor.getString(cursor.getColumnIndex(SV_TEN)));
				if(cursor.getString(cursor.getColumnIndex(SV_GT)).equals("Nam"))
				sv.setGioiTinh(true);
				else
				sv.setGioiTinh(false);
				sv.setNghanhHoc(cursor.getString(cursor.getColumnIndex(SV_NGANHHOC)));
				sv.setMaLop(cursor.getInt(cursor.getColumnIndex(SV_MaLop)));
				dsSV.add(sv);
				
			}while(cursor.moveToNext());
		}	
		return dsSV;
	}
	
	public int getcountsv(){
	int count=0;
		String Get_All_SV="SELECT * FROM "+Table_SinhVien;
		SQLiteDatabase db=this.getWritableDatabase();
		Cursor cursor=db.rawQuery(Get_All_SV, null);
		count=cursor.getCount();
		return count;
	}
	public void deleteLopPoly(LopPoly lop){
		SQLiteDatabase db=this.getWritableDatabase();
		String cautruyvan=Lop_ID+" =?";
		db.delete(Table_Lop, cautruyvan, new  String[]{String.valueOf(lop.getID())});
		db.close();
	}
	public void deleteSinnhVienPoly(SinnhVienPoly sv){
		SQLiteDatabase db=this.getWritableDatabase();
		String cautruyvan=SV_ID+" =?";
		db.delete(Table_SinhVien, cautruyvan, new  String[]{String.valueOf(sv.getID())});
		db.close();
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	db.execSQL("Drop if exists " +Table_Lop );
	db.execSQL("Drop if exists " +Table_SinhVien);
	}

	
	
}
