package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.ChiTietTTSD;
import beans.ThietBi;
import beans.ThongTinBaoDuong;
import beans.ThongTinDangKy;
import library.LibraryConnectDB;

public class chitietTTSDModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;

	public chitietTTSDModels() {
		lcdb = new LibraryConnectDB();
	}

	// LAY DANH SACH THIET BI THEO MATTSD
	public ArrayList<ChiTietTTSD> getListByMaTTSD(int maTTSD) {
		ArrayList<ChiTietTTSD> alChiTietTTSD = new ArrayList<ChiTietTTSD>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM `ChiTietTTSD`\n" + 
				"INNER JOIN ThietBi ON ChiTietTTSD.MaTB = ThietBi.MaTB\n" + 
				"WHERE MaTTSD = ?";
		ChiTietTTSD.Builder builder = new ChiTietTTSD.Builder();
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maTTSD);
			rs = pst.executeQuery();
			while (rs.next()) {
				ChiTietTTSD objChiTiet = builder.setMaTTSD(maTTSD)
						.setMaTB(rs.getInt("ChiTietTTSD.MaTB"))
						.setMaLoaiTB(rs.getInt("ChiTietTTSD.MaLoaiTB"))
						.build();
				
				ThietBi.Builder builderTB = new ThietBi.Builder();
				ThietBi objThietBi = builderTB.setTenTB(rs.getString("ThietBi.TenTB")).build();
				
				objChiTiet.setObjThietBi(objThietBi);
				
				alChiTietTTSD.add(objChiTiet);
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
		return alChiTietTTSD;
	}
	
	// Ban giao - them chi tiet su dung moi
		public int ThemChiTietSudung(int maTTSD, int[] maTB, int maLoaiTB) {
			int result = 0;
			conn = lcdb.GetConnectMySQL();
			String query = "INSERT INTO `ChiTietTTSD` "
					+ "(`MaTTSD`, `MaTB`, `MaLoaiTB`) VALUES ";
			for (int i = 0; i < maTB.length; i++) {
				query += "(" + maTTSD + ", " + maTB[i] + ", " + maLoaiTB +"),";
			}
			query = query.substring(0, query.length() - 1);
			try {
				pst = conn.prepareStatement(query);
				pst.executeUpdate();
				result = 1;
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
}
