package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.LoaiThietBi;
import beans.NguoiDung;
import beans.ThietBi;
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
		String query = "SELECT * FROM ThongTinBaoDuong ttbd , ThietBi tb, LoaiTB ltb"
				+ " WHERE ttbd.MaTB = tb.MaTB AND ltb.MaLoai = ttbd.MaLoaiTB ORDER BY MaTTBD DESC LIMIT ?,?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, sodong);
			rs = pst.executeQuery();
			ThongTinBaoDuong.Builder ttbdBuider = new ThongTinBaoDuong.Builder();
			ThongTinBaoDuong objTTBD = null;
			while (rs.next()) {
				ThietBi.Builder tbBuilder = new ThietBi.Builder();
				ThietBi thietBi = tbBuilder.setMaTB(rs.getInt("tb.MaTB"))
											.setTenTB(rs.getString("tb.TenTB"))
											.build();
				LoaiThietBi.Builder ltbBuilder = new LoaiThietBi.Builder();
				LoaiThietBi loaiThietBi = ltbBuilder.setMaLoai(rs.getInt("ltb.MaLoai"))
											.setTenLoai(rs.getString("ltb.TenLoai"))
											.build();
				objTTBD = ttbdBuider.setMaTTBD(rs.getInt("ttbd.MaTTBD"))
									.setObjThietBi(thietBi)
									.setObjLoaiThietBi(loaiThietBi)
									.setTinhTrang(rs.getInt("ttbd.TinhTrang"))
									.build();
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

	public ThongTinBaoDuong getTTBD(int maTTBD) {
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinBaoDuong ttbd , ThietBi tb, LoaiTB ltb,"
				+ " NguoiDung nd WHERE ttbd.MaTB = tb.MaTB AND ltb.MaLoai = ttbd.MaLoaiTB"
				+ " AND nd.MaND = ttbd.MaNV AND ttbd.MaTTBD = ? LIMIT 1";
		ThongTinBaoDuong objTTBD = null;
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maTTBD);
			rs = pst.executeQuery();
			ThongTinBaoDuong.Builder ttbdBuider = new ThongTinBaoDuong.Builder();
			if (rs.next()) {
				ThietBi.Builder tbBuilder = new ThietBi.Builder();
				ThietBi thietBi = tbBuilder.setMaTB(rs.getInt("tb.MaTB"))
											.setTenTB(rs.getString("tb.TenTB"))
											.build();
				LoaiThietBi.Builder ltbBuilder = new LoaiThietBi.Builder();
				LoaiThietBi loaiThietBi = ltbBuilder.setMaLoai(rs.getInt("ltb.MaLoai"))
											.setTenLoai(rs.getString("ltb.TenLoai"))
											.build();
				NguoiDung.Builder ndBuilder = new NguoiDung.Builder();
				NguoiDung nguoiDung = ndBuilder.setMaND(rs.getInt("nd.MaND"))
												.setTenND(rs.getString("nd.TenND"))
												.build();
				objTTBD = ttbdBuider.setMaTTBD(rs.getInt("ttbd.MaTTBD"))
									.setObjThietBi(thietBi)
									.setObjLoaiThietBi(loaiThietBi)
									.setObjNguoiDung(nguoiDung)
									.setTinhTrang(rs.getInt("ttbd.TinhTrang"))
									.setLyDoBaoDuong(rs.getString("ttbd.LyDoBaoDuong"))
									.setNgayBatDau(rs.getDate("ttbd.NgayBatDau"))
									.setNgayKetThuc(rs.getDate("ttbd.NgayKetThuc"))
									.build();
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
		return objTTBD;
	}

	public boolean DangKyBaoDuong(ThongTinBaoDuong ttbd) {
		boolean result = false;
		conn = lcdb.GetConnectMySQL();
		String query = "INSERT INTO ThongTinBaoDuong(MaNV,MaTB,MaLoaiTB,TinhTrang,LyDoBaoDuong,NgayBatDau,NgayKetThuc)"
				+ " VALUES(?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, ttbd.getMaNV());
			pst.setInt(2, ttbd.getMaTB());
			pst.setInt(3, ttbd.getMaLoaiTB());
			pst.setInt(4, ttbd.getTinhTrang());
			pst.setString(5, ttbd.getLyDoBaoDuong());
			pst.setDate(6, ttbd.getNgayBatDau());
			pst.setDate(7, ttbd.getNgayKetThuc());
			pst.executeUpdate();
			result=true;
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

	public boolean capNhatBaoDuong(ThongTinBaoDuong ttbd) {
		boolean result = false;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE ThongTinBaoDuong SET NgayBatDau = ?, NgayKetThuc = ?, LyDoBaoDuong = ? WHERE MaTTBD = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setDate(1, ttbd.getNgayBatDau());
			pst.setDate(2, ttbd.getNgayKetThuc());
			pst.setString(3, ttbd.getLyDoBaoDuong());
			pst.setInt(4, ttbd.getMaTTBD());
			pst.executeUpdate();
			result=true;
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

	public boolean huyDKBD(int ttbd) {
		boolean result = false;
		conn = lcdb.GetConnectMySQL();
		String query = "DELETE FROM ThongTinBaoDuong WHERE MaTTBD = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, ttbd);
			pst.executeUpdate();
			result=true;
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

	public boolean hoanTatBaoDuong(int ttbd) {
		boolean result = false;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE ThongTinBaoDuong SET TinhTrang = 3 WHERE MaTTBD = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, ttbd);
			pst.executeUpdate();
			result=true;
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

	public boolean tienHanhBaoDuong(int ttbd) {
		boolean result = false;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE ThongTinBaoDuong SET TinhTrang = 2 WHERE MaTTBD = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, ttbd);
			pst.executeUpdate();
			result=true;
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

	public ThongTinBaoDuong getTTBDByMaThietBi(int maTB) {
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinBaoDuong ttbd WHERE MaTB = ? LIMIT 1";
		ThongTinBaoDuong objTTBD = null;
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maTB);
			rs = pst.executeQuery();
			if (rs.next()) {
				ThongTinBaoDuong.Builder ttbdBuider = new ThongTinBaoDuong.Builder();
				objTTBD = ttbdBuider.setMaTTBD(rs.getInt("ttbd.MaTTBD"))
									.setTinhTrang(rs.getInt("ttbd.TinhTrang"))
									.build();
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
		return objTTBD;
	}
}
