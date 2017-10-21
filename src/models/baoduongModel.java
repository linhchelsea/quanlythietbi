package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BaoDuong;
import library.LibraryConnectDB;

public class baoduongModel {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public baoduongModel(){
		lcdb = new LibraryConnectDB();
	}
	
	public ArrayList<BaoDuong> getList(int offset, int sodong) {		
		ArrayList<BaoDuong> result = new ArrayList<>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinBaoDuong ORDER BY MaTTBD ASC LIMIT ?,?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, sodong);
			rs = pst.executeQuery();
			while(rs.next()){
				BaoDuong baoDuongObj = new BaoDuong(rs.getInt("MaTTBD"),
													rs.getInt("MaTTBD"),
													rs.getInt("MaTTBD"),
													rs.getInt("MaTTBD"), 
													rs.getInt("MaTTBD"),
													rs.getString("LyDoBaoDuong"),
													rs.getDate("NgayBatDau"),
													rs.getDate("NgayKetThuc"));
				result.add(baoDuongObj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		int total=0;
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT COUNT(MaTTBD) total FROM ThongTinBaoDuong";
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			if(rs.next()){
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
}
