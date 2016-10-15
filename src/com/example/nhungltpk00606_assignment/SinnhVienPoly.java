package com.example.nhungltpk00606_assignment;

public class SinnhVienPoly {
int ID;
String MaSV;
String TenSV;
String NghanhHoc;
Boolean GioiTinh;
int MaLop;
public SinnhVienPoly() {
	super();
	// TODO Auto-generated constructor stub
}
public SinnhVienPoly(int iD, String maSV, String tenSV, String nghanhHoc, Boolean gioiTinh, int maLop) {
	super();
	ID = iD;
	MaSV = maSV;
	TenSV = tenSV;
	NghanhHoc = nghanhHoc;
	GioiTinh = gioiTinh;
	MaLop = maLop;
}

public SinnhVienPoly( String maSV, String tenSV, String nghanhHoc, Boolean gioiTinh, int maLop) {
	super();
	MaSV = maSV;
	TenSV = tenSV;
	NghanhHoc = nghanhHoc;
	GioiTinh = gioiTinh;
	MaLop = maLop;
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getMaSV() {
	return MaSV;
}
public void setMaSV(String maSV) {
	MaSV = maSV;
}
public String getTenSV() {
	return TenSV;
}
public void setTenSV(String tenSV) {
	TenSV = tenSV;
}
public String getNghanhHoc() {
	return NghanhHoc;
}
public void setNghanhHoc(String nghanhHoc) {
	NghanhHoc = nghanhHoc;
}
public Boolean getGioiTinh() {
	return GioiTinh;
}
public String getStringGioiTinh(){
	if(GioiTinh)
		return "Nam";
	else
		return "Nữ";
	
}
public void setGioiTinh(Boolean gioiTinh) {
	GioiTinh = gioiTinh;
}
public int getMaLop() {
	return MaLop;
}
public void setMaLop(int maLop) {
	MaLop = maLop;
}




}
