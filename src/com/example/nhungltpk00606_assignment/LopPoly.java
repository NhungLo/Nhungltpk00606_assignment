package com.example.nhungltpk00606_assignment;

public class LopPoly {
public int ID;
public String MaLop;
public String TenLop;
public LopPoly(int iD, String maLop, String ten) {
	super();
	ID = iD;
	MaLop = maLop;
	TenLop = ten;
}
public LopPoly( String maLop, String ten) {
	super();
	MaLop = maLop;
	TenLop = ten;
}
public LopPoly() {
	super();
	
}
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getMaLop() {
	return MaLop;
}
public void setMaLop(String maLop) {
	MaLop = maLop;
}
public String getTenLop() {
	return TenLop;
}
public void setTenLop(String tenLop) {
	TenLop = tenLop;
}


}
