package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import beans.ThongTinBaoDuong;
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
		
//		public static void main(String[] args) {
//			thongtinsudungModels mThongtinsudungModels = new thongtinsudungModels();
////			System.out.println(mThongtinsudungModels.getSoLuongDangSuDung(9, new Timestamp(new Date('2017-10-17 10:20:00')), 0));
//		}
}
