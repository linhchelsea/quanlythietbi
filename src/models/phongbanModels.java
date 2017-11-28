package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.NguoiDung;
import beans.PhongBan;
import beans.ThongTinBaoDuong;
import library.LibraryConnectDB;

public class phongbanModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	
	public phongbanModels(){
		lcdb = new LibraryConnectDB();
	}
	
	// LAY TAT CA NGUOI DUNG
		public ArrayList<PhongBan> getList() {
			ArrayList<PhongBan> alPB = new ArrayList<PhongBan>();
			conn = lcdb.GetConnectMySQL();
			String query = "SELECT * FROM phongban";
			PhongBan.Builder builder = new PhongBan.Builder();
			try {
				st = conn.createStatement();
				rs = st.executeQuery(query);
				while (rs.next()) {
					PhongBan pban = builder.setMaPhongBan(rs.getInt("maphongban"))
							.setTenPhongBan(rs.getString("tenphongban"))
							.build();
					alPB.add(pban);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return alPB;
		}
}
