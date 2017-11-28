package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import beans.ThongTinBaoDuong;
import beans.ThongTinDangKy;
import beans.ThongTinSuDung;
import library.LibraryConnectDB;

public class thongtinsudungModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public thongtinsudungModels(){
		lcdb = new LibraryConnectDB();
	}
	
	//SO LUONG THIET BI DANG SU DUNG
		public int getSoLuongDangSuDung(int maLoai, Timestamp batDau, Timestamp ketThuc) {
			int soLuong = 0;
			conn = lcdb.GetConnectMySQL();
			String query = "SELECT SUM(ThongTinDangKy.SoLuongDK) AS SOLUONG FROM ThongTinSuDung\n" + 
					"INNER JOIN ThongTinDangKy ON ThongTinSuDung.MaTTDK = ThongTinDangKy.MaTTDK\n" + 
					"WHERE ThongTinSuDung.TinhTrang <>3 \n" + 
					"AND ThongTinDangKy.MaLoaiTB = ? \n" + 
					"AND (((BatDauSuDung BETWEEN ? AND ?) OR (KetThucSuDung BETWEEN ? AND ?)) "
						+ "OR (BatDauSuDung < ? AND KetThucSuDung > ?))";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, maLoai);
				pst.setTimestamp(2, batDau);
				pst.setTimestamp(3, ketThuc);
				pst.setTimestamp(4, batDau);
				pst.setTimestamp(5, ketThuc);
				pst.setTimestamp(6, batDau);
				pst.setTimestamp(7, ketThuc);
				rs = pst.executeQuery();
				while(rs.next()){
					if (rs.getString("SOLUONG") != null) {
						soLuong = rs.getInt("SOLUONG");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return soLuong;
		}
		
		// LAY DANH SACH TTSD THEO MA NGUOI MUON
		public ArrayList<ThongTinSuDung> getListByMaND(int maND) {
			ArrayList<ThongTinSuDung> alTTSD = new ArrayList<>();
			ThongTinSuDung.Builder builder = new ThongTinSuDung.Builder();
			conn = lcdb.GetConnectMySQL();
			String query = "SELECT * FROM `ThongTinSuDung`\n" + 
					"INNER JOIN ThongTinDangKy ON ThongTinDangKy.MaTTDK = ThongTinSuDung.MaTTDK\n" + 
					"WHERE ThongTinSuDung.MaNguoiMuon = ?\n" + 
					"AND ThongTinSuDung.TinhTrang <> 3\n" + 
					"ORDER BY MaTTSD DESC";
			loaithietbiModels mLoaiTB = new loaithietbiModels();
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, maND);
				rs = pst.executeQuery();
				while (rs.next()) {
					//lay thong tin su dung
					ThongTinSuDung objTTSD = builder.setMaTTSD(rs.getInt("MaTTSD"))
							.setMaTTDK(rs.getInt("MaTTDK"))
							.setMaNguoiMuon(rs.getInt("MaNguoiMuon"))
							.setBatDauSuDung(rs.getTimestamp("BatDauSuDung"))
							.setKetThucSuDung(rs.getTimestamp("KetThucSuDung"))
							.setTinhTrang(rs.getInt("TinhTrang"))
							.build();
					
					//lay thong tin dang ky cua doi tuong TTSD
					ThongTinDangKy.Builder builderTTDK = new ThongTinDangKy.Builder();
					ThongTinDangKy objTTDK = builderTTDK.setMaLoaiTB(rs.getInt("MaLoaiTB"))
							.setSoLuongDK(rs.getInt("SoLuongDK"))
							.build();
					//lay thong tin loai thiet bi va gan vao doi tuong TTDK
					objTTDK.setObjLoaiTB(mLoaiTB.getItemByMaLoai(objTTDK.getMaLoaiTB()));
					
					//gan doi tuong TTDK vao doi tuong TTSD
					objTTSD.setObjTTDK(objTTDK);
					
					alTTSD.add(objTTSD);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return alTTSD;
		}
}
