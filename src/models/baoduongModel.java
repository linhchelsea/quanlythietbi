package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.ThongTinBaoDuong;
import library.LibraryConnectDB;

public class baoduongModel {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;

	public baoduongModel() {
		lcdb = new LibraryConnectDB();
	}

	public ArrayList<ThongTinBaoDuong> getList(int offset, int sodong) {
		ArrayList<ThongTinBaoDuong> result = new ArrayList<>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinBaoDuong ORDER BY MaTTBD ASC LIMIT ?,?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, sodong);
			rs = pst.executeQuery();
			ThongTinBaoDuong.Builder buider = new ThongTinBaoDuong.Builder();
			ThongTinBaoDuong objTTBD = null;
			while (rs.next()) {
				objTTBD = buider.setMaLoaiTB(rs.getInt("MaTTBD")).build();
				result.add(objTTBD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int getTotal() {
		int total = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT COUNT(MaTTBD) total FROM ThongTinBaoDuong";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			if (rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return total;
	}

	// SO LUONG THIET BI DANG BAO DUONG
	public int getSoLuongDangBaoDuong(int maLoai, Timestamp batDau, Timestamp ketThuc) {
		int soLuong = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT COUNT(MaTTBD) AS SOLUONG FROM `ThongTinBaoDuong`\n" + 
				"WHERE TinhTrang <> 3\n" + 
				"AND MaLoaiTB = ?\n" + 
				"AND (((NgayBatDau BETWEEN ? AND ?) OR (NgayKetThuc BETWEEN ? AND ?)) "
				+ "OR (NgayBatDau < ? AND NgayKetThuc > ?))";
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
			while (rs.next()) {
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
		System.out.println("soluong: " + soLuong);
		return soLuong;
	}
}
