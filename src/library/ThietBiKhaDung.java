package library;

import java.sql.Timestamp;

import models.baoduongModel;
import models.loaithietbiModels;
import models.thongtinsudungModels;

public class ThietBiKhaDung {
	public ThietBiKhaDung() {};

	public int TinhSoLuongKhaDung(int maLoai, Timestamp batDau, Timestamp ketThuc) {
		int soLuongKhaDung = 0;
		
		//Tinh so luong kha dung
		//Tong so luong
		loaithietbiModels mLoaiTB = new loaithietbiModels();
		int tongSoLuong = mLoaiTB.getSoLuong(maLoai);
		//So thiet bi dang su dung
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		int soLuongDangSuDung = mTTSD.getSoLuongDangSuDung(maLoai, batDau, ketThuc);
		//so thiet bi dang bao duong
		baoduongModel mBaoDuong = new baoduongModel();
		int soLuongBaoDuong = mBaoDuong.getSoLuongDangBaoDuong(maLoai, batDau, ketThuc);
		//So luong kha dung
		soLuongKhaDung = tongSoLuong - (soLuongDangSuDung + soLuongBaoDuong);
		
		return soLuongKhaDung;
	}
}
