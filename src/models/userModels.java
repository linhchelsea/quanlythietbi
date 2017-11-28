package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.NguoiDung;
import beans.ThietBi;
import library.LibraryConnectDB;

public class userModels {
	private LibraryConnectDB lcdb;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public userModels() {
		this.lcdb = new LibraryConnectDB();
		this.conn = null;
	}

	// LAY TAT CA NGUOI DUNG
	public ArrayList<NguoiDung> getList() {
		ArrayList<NguoiDung> alND = new ArrayList<NguoiDung>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM nguoidung";
		NguoiDung.Builder builder = new NguoiDung.Builder();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				NguoiDung nguoidung = builder.setMaND(rs.getInt("mand"))
						.setChucVu(rs.getInt("chucvu"))
						.setDiaChi(rs.getString("diachi"))
						.setGioiTinh(rs.getInt("gioitinh"))
						.setMatKhau(rs.getString("matkhau"))
						.setNgaySinh(rs.getDate("ngaysinh"))
						.setPhanQuyen(rs.getInt("phanquyen"))
						.setPhongBan(rs.getInt("phongban"))
						.setTenDangNhap(rs.getString("tendangnhap"))
						.setTenND(rs.getString("tennd"))
						.build();
				alND.add(nguoidung);
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
		return alND;
	}

	// XOA MOT THIET BI
	public int deleteById(int mand) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String sql = "DELETE FROM `nguoidung` WHERE `mand` =  ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, mand);
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

	//LAY THEO MA NGUOI DUNG
	public NguoiDung getById(int mand) {
		String sql = "SELECT * FROM NGUOIDUNG WHERE MAND = " + mand;
		NguoiDung objItem = null;
		conn = lcdb.GetConnectMySQL();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {

				objItem = new NguoiDung.Builder()
						.setMaND(rs.getInt("mand"))
						.setChucVu(rs.getInt("chucvu"))
						.setDiaChi(rs.getString("diachi"))
						.setGioiTinh(rs.getInt("gioitinh"))
						.setMatKhau(rs.getString("matkhau"))
						.setNgaySinh(rs.getDate("ngaysinh"))
						.setPhanQuyen(rs.getInt("phanquyen"))
						.setPhongBan(rs.getInt("phongban"))
						.setTenDangNhap(rs.getString("tendangnhap"))
						.setTenND(rs.getString("tennd"))
						.build();
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
