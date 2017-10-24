package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import beans.LoaiThietBi;
import beans.ThongTinBaoDuong;
import beans.ThongTinDangKy;
import library.LibraryConnectDB;

public class thongtindangkyModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;

	public thongtindangkyModels() {
		lcdb = new LibraryConnectDB();
	}

	// LAY DANH SACH TTDK THEO MA LOAI TB
	public ArrayList<ThongTinDangKy> getListByMaLoai(int maLoai) {
		ArrayList<ThongTinDangKy> alTTDK = new ArrayList<>();
		ThongTinDangKy.Builder builder = new ThongTinDangKy.Builder();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM ThongTinDangKy WHERE MaLoaiTB = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maLoai);
			rs = pst.executeQuery();
			while (rs.next()) {
				ThongTinDangKy objItem = builder.setMaTTDK(rs.getInt("MaTTDK"))
						.setDKBatDauSuDung(rs.getTimestamp("DKBatDauSuDung"))
						.setDKKetThucSuDung(rs.getTimestamp("DKKetThucSuDung")).setSoLuongDK(rs.getInt("SoLuongDK"))
						.build();
				alTTDK.add(objItem);
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
		return alTTDK;
	}

	// Them dang ky moi
	public int ThemDangKy(ThongTinDangKy objTTDK) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "INSERT INTO `ThongTinDangKy` (`MaNguoiMuon`, `MaLoaiTB`, `ThoiGianDangKy`, `DKBatDauSuDung`, `DKKetThucSuDung`, `SoLuongDK`, `MucDichSuDung`, `TinhTrang`, `ThongBao`) VALUES (?, ?, ?, ?, ?, ?, ?, 1, '');";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, objTTDK.getMaNguoiMuon());
			pst.setInt(2, objTTDK.getMaLoaiTB());
			pst.setTimestamp(3, objTTDK.getThoiGianDangKy());
			pst.setTimestamp(4, objTTDK.getDKBatDauSuDung());
			pst.setTimestamp(5, objTTDK.getDKKetThucSuDung());
			pst.setInt(6, objTTDK.getSoLuongDK());
			pst.setString(7, objTTDK.getMucDichSuDung());
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

	// LAY DANH SACH TTDK THEO MA NGUOI MUON
	public ArrayList<ThongTinDangKy> getListByMaND(int maND) {
		ArrayList<ThongTinDangKy> alTTDK = new ArrayList<>();
		ThongTinDangKy.Builder builder = new ThongTinDangKy.Builder();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM `ThongTinDangKy` " + "WHERE MaNguoiMuon = ? " + "AND TinhTrang <>2 "
				+ "ORDER BY MaTTDK DESC";
		loaithietbiModels mLoaiTB = new loaithietbiModels();
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maND);
			rs = pst.executeQuery();
			while (rs.next()) {
				ThongTinDangKy objItem = builder.setMaTTDK(rs.getInt("MaTTDK")).setMaLoaiTB(rs.getInt("MaLoaiTB"))
						.setMaNguoiMuon(rs.getInt("MaNguoiMuon"))
						.setThoiGianDangKy(rs.getTimestamp("ThoiGianDangKy"))
						.setDKBatDauSuDung(rs.getTimestamp("DKBatDauSuDung"))
						.setDKKetThucSuDung(rs.getTimestamp("DKKetThucSuDung")).setSoLuongDK(rs.getInt("SoLuongDK"))
						.setMucDichSuDung(rs.getString("MucDichSuDung")).setTinhTrang(rs.getInt("TinhTrang"))
						.setThongBao(rs.getString("ThongBao")).build();
				objItem.setObjLoaiTB(mLoaiTB.getItemByMaLoai(objItem.getMaLoaiTB()));
				alTTDK.add(objItem);
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
		return alTTDK;
	}

	public int HuyDangKy(int maTTDK) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "DELETE FROM ThongTinDangKy WHERE maTTDK = ? AND TinhTrang = 1 LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maTTDK);
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
