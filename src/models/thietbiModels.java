package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.ThietBi;
import library.LibraryConnectDB;

public class thietbiModels {
	private LibraryConnectDB lcdb;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public thietbiModels() {
		this.lcdb = new LibraryConnectDB();
		this.conn = null;
	}

	// LAY TAT CA THIET BI
	public ArrayList<ThietBi> getList() {
		ArrayList<ThietBi> alTB = new ArrayList<ThietBi>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThietBi";
		ThietBi.Builder builder = new ThietBi.Builder();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				ThietBi thietbi = builder.setMaTB(rs.getInt("MaTB")).setTenTB(rs.getString("TenTB"))
						.setMaLoaiTB(rs.getInt("MaLoaiTB")).setNgayNhap(rs.getDate("NgayNhap")).build();
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

	// TINH SO THIET BI KHA DUNG
	public int getSoLuongKhaDung(int maLoai, Timestamp batDau, Timestamp ketThuc) {
		int soLuongKhaDung = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinDangKy WHERE MaLoaiTB = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maLoai);
			rs = pst.executeQuery();
			while (rs.next()) {

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

		return soLuongKhaDung;
	}

	// THEM MOT THIET BI MOI
	public int themThietBi(ThietBi thietBi) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "INSERT INTO `ThietBi` (`tentb`, `maloaitb`, `ngaynhap`) VALUES (?, ?, ?);";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, thietBi.getTenTB());
			pst.setInt(2, thietBi.getMaLoaiTB());
			pst.setDate(3, thietBi.getNgayNhap());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// CHINH SUA MOT THIET BI
	public int chinhSuaThietBi(ThietBi thietBi) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE `thietbi` SET `tentb`=?, `maloaitb`=?,`ngaynhap`=? WHERE matb = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, thietBi.getTenTB());
			pst.setInt(2, thietBi.getMaLoaiTB());
			pst.setDate(3, thietBi.getNgayNhap());
			pst.setInt(4, thietBi.getMaTB());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// XOA MOT THIET BI
	public int xoaThietBi(int maTB) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String sql = "DELETE FROM `thietbi` WHERE `matb` =  ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, maTB);
			pst.executeUpdate();
			result = 1;
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// LAY THEO MA THIET BI
	public ThietBi getById(int matb) {
		String sql = "SELECT * FROM thietbi WHERE matb = " + matb;
		ThietBi objItem = null;
		conn = lcdb.GetConnectMySQL();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int MaTB = rs.getInt("matb");
				String TenTB = rs.getString("tentb");
				int MaLoaiTB = rs.getInt("maloaitb");
				Date NgayNhap = rs.getDate("ngaynhap");

				ThietBi.Builder tbBuilder = new ThietBi.Builder();
				tbBuilder.setMaTB(MaTB);
				tbBuilder.setTenTB(TenTB);
				tbBuilder.setMaLoaiTB(MaLoaiTB);
				tbBuilder.setNgayNhap(NgayNhap);
				objItem = tbBuilder.build();
				System.out.println(objItem.getMaLoaiTB());
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
		return objItem;
	}

}
