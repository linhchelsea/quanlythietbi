package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.ThietBi;
import library.LibraryConnectDB;

public class thietbiModels {
	private LibraryConnectDB lcdb;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public thietbiModels(){
		this.lcdb = new LibraryConnectDB();
		this.conn = null;
	}

	//LAY TAT CA THIET BI
	public ArrayList<ThietBi> getList() {
		ArrayList<ThietBi> alTB = new ArrayList<ThietBi>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThietBi";
		ThietBi.Builder builder = new ThietBi.Builder();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				ThietBi thietbi = builder.setMaTB(rs.getInt("MaTB")).setTenTB(rs.getString("TenTB")).setMaLoaiTB(rs.getInt("MaLoaiTB")).setNgayNhap(rs.getDate("NgayNhap")).build();
				alTB.add(thietbi);
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
		return alTB;
	}
}
