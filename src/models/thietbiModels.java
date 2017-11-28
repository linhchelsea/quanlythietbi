package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.ThietBi;
import beans.ThongTinDangKy;
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
	
	// LAY DANH SACH THIET BI KHA DUNG
			public ArrayList<ThietBi> getListKhaDung(int maLoaiTB) {
				ArrayList<ThietBi> alThietBi = new ArrayList<ThietBi>();
				conn = lcdb.GetConnectMySQL();
				String query = "SELECT * FROM ThietBi \n" + 
						"WHERE ThietBi.MaLoaiTB = ? AND ThietBi.MaTB NOT IN \n" + 
						"	(SELECT ChiTietTTSD.MaTB FROM ChiTietTTSD \n" + 
						" 	INNER JOIN ThongTinSuDung on ThongTinSuDung.MaTTSD = ChiTietTTSD.MaTTSD\n" + 
						" 	WHERE ThongTinSuDung.TinhTrang = 2)\n" + 
						"AND ThietBi.MaTB NOT IN \n" + 
						"	(SELECT ThongTinBaoDuong.MaTB FROM ThongTinBaoDuong \n" + 
						"     INNER JOIN ThietBi ON ThongTinBaoDuong.MaTB = ThietBi.MaTB\n" + 
						"     WHERE ThongTinBaoDuong.TinhTrang <> 3 AND ThongTinBaoDuong.MaLoaiTB = ?)";
				ThietBi.Builder builder = new ThietBi.Builder();
				try {
					pst = conn.prepareStatement(query);
					pst.setInt(1, maLoaiTB);
					pst.setInt(2, maLoaiTB);
					rs = pst.executeQuery();
					while (rs.next()) {
						ThietBi objThietBi = builder.setMaTB(rs.getInt("ThietBi.MaTB"))
								.setMaLoaiTB(rs.getInt("ThietBi.MaLoaiTB"))
								.setTenTB(rs.getString("TenTB"))
								.build();
						
						alThietBi.add(objThietBi);
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
				return alThietBi;
			}
}
