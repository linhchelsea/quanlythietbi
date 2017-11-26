package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import beans.ChucVu;
import beans.LoaiThietBi;
import beans.NguoiDung;
import beans.PhongBan;
import beans.ThongTinBaoDuong;
import beans.ThongTinDangKy;
import beans.ThongTinSuDung;
import library.LibraryConnectDB;

public class thongtinsudungModels {
	private Connection conn;
	private LibraryConnectDB lcdb;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public thongtinsudungModels(){
		lcdb = new LibraryConnectDB();
	}
	
	// LAY DANH SACH TTSD
			public ArrayList<ThongTinSuDung> getList() {
				ArrayList<ThongTinSuDung> alTTSD = new ArrayList<>();
				ThongTinSuDung.Builder builder = new ThongTinSuDung.Builder();
				conn = lcdb.GetConnectMySQL();
				String query = "SELECT * FROM `ThongTinSuDung`\n" + 
						"INNER JOIN ThongTinDangKy ON ThongTinDangKy.MaTTDK = ThongTinSuDung.MaTTDK \n" + 
						"INNER JOIN NguoiDung ON NguoiDung.MaND = ThongTinSuDung.MaNguoiMuon\n" + 
						"INNER JOIN LoaiTB ON LoaiTB.MaLoai = ThongTinDangKy.MaLoaiTB\n" + 
						"INNER JOIN PhongBan on PhongBan = MaPhongBan\n" + 
						"INNER JOIN ChucVu on ChucVu = MaChucVu\n" +
						"WHERE ThongTinSuDung.TinhTrang <> 3\n" + 
						"ORDER BY MaTTSD DESC";
				ThongTinDangKy.Builder builderTTDK = new ThongTinDangKy.Builder();
				NguoiDung.Builder builderND = new NguoiDung.Builder();
				PhongBan.Builder builderPhongBan = new PhongBan.Builder();
				ChucVu.Builder builderChucVu = new ChucVu.Builder();
				LoaiThietBi.Builder builderLoaiTB = new LoaiThietBi.Builder();
				
				loaithietbiModels mLoaiTB = new loaithietbiModels();
				
				try {
					pst = conn.prepareStatement(query);
					rs = pst.executeQuery();
					while (rs.next()) {
						//lay thong tin su dung
						ThongTinSuDung objTTSD = builder.setMaTTSD(rs.getInt("MaTTSD"))
								.setMaTTDK(rs.getInt("MaTTDK"))
								.setMaNguoiMuon(rs.getInt("MaNguoiMuon"))
								.setMaNguoiMuon(rs.getInt("MaNguoiPheDuyet"))
								.setBatDauSuDung(rs.getTimestamp("BatDauSuDung"))
								.setKetThucSuDung(rs.getTimestamp("KetThucSuDung"))
								.setTinhTrang(rs.getInt("TinhTrang"))
								.build();
						
						//lay thong tin dang ky cua doi tuong TTSD
						ThongTinDangKy objTTDK = builderTTDK.setMaLoaiTB(rs.getInt("MaLoaiTB"))
								.setSoLuongDK(rs.getInt("SoLuongDK"))
								.build();
						objTTDK.setObjLoaiTB(mLoaiTB.getItemByMaLoai(objTTDK.getMaLoaiTB()));
						
						//lay thong tin nguoi muon
						NguoiDung objND = builderND.setMaND(rs.getInt("MaND"))
								.setTenND(rs.getString("TenND"))
								.build();
						
						//Lay thong tin phong ban
						PhongBan objPhongBan = builderPhongBan.setTenPhongBan(rs.getString("TenPhongBan")).build();
						//Lay thong tin chuc vu
						ChucVu objChucVu = builderChucVu.setTenChucVu(rs.getString("TenChucVu")).build();
						
						//gan vao objND
						objND.setObjChucVu(objChucVu);
						objND.setObjPhongBan(objPhongBan);
						
						//gan doi tuong TTSD
						objTTSD.setObjTTDK(objTTDK);
						objTTSD.setObjNguoiMuon(objND);
						
						alTTSD.add(objTTSD);
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
				return alTTSD;
			}
	
	//SO LUONG THIET BI DANG SU DUNG
		public int getSoLuongDangSuDung(int maLoai, Timestamp batDau, Timestamp ketThuc) {
			int soLuong = 0;
			conn = lcdb.GetConnectMySQL();
			String query = "SELECT SUM(ThongTinDangKy.SoLuongDK) AS SOLUONG FROM ThongTinSuDung\n" + 
					"INNER JOIN ThongTinDangKy ON ThongTinSuDung.MaTTDK = ThongTinDangKy.MaTTDK\n" + 
					"WHERE ThongTinSuDung.TinhTrang <>3 \n" + 
					"AND ThongTinDangKy.MaLoaiTB = ? \n" + 
					"AND (((BatDauSuDung BETWEEN ? AND ?) OR (KetThucSuDung BETWEEN ? AND ?)) "
						+ "OR (BatDauSuDung < ? AND KetThucSuDung > ?))";
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
				while(rs.next()){
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
			return soLuong;
		}
		
		// LAY DANH SACH TTSD THEO MA NGUOI MUON
		public ArrayList<ThongTinSuDung> getListByMaND(int maND) {
			ArrayList<ThongTinSuDung> alTTSD = new ArrayList<>();
			ThongTinSuDung.Builder builder = new ThongTinSuDung.Builder();
			conn = lcdb.GetConnectMySQL();
			String query = "SELECT * FROM `ThongTinSuDung`\n" + 
					"INNER JOIN ThongTinDangKy ON ThongTinDangKy.MaTTDK = ThongTinSuDung.MaTTDK\n" + 
					"WHERE ThongTinSuDung.MaNguoiMuon = ?\n" + 
					"AND ThongTinSuDung.TinhTrang <> 3\n" + 
					"ORDER BY MaTTSD DESC";
			loaithietbiModels mLoaiTB = new loaithietbiModels();
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, maND);
				rs = pst.executeQuery();
				while (rs.next()) {
					//lay thong tin su dung
					ThongTinSuDung objTTSD = builder.setMaTTSD(rs.getInt("MaTTSD"))
							.setMaTTDK(rs.getInt("MaTTDK"))
							.setMaNguoiMuon(rs.getInt("MaNguoiMuon"))
							.setBatDauSuDung(rs.getTimestamp("BatDauSuDung"))
							.setKetThucSuDung(rs.getTimestamp("KetThucSuDung"))
							.setTinhTrang(rs.getInt("TinhTrang"))
							.build();
					
					//lay thong tin dang ky cua doi tuong TTSD
					ThongTinDangKy.Builder builderTTDK = new ThongTinDangKy.Builder();
					ThongTinDangKy objTTDK = builderTTDK.setMaLoaiTB(rs.getInt("MaLoaiTB"))
							.setSoLuongDK(rs.getInt("SoLuongDK"))
							.build();
					//lay thong tin loai thiet bi va gan vao doi tuong TTDK
					objTTDK.setObjLoaiTB(mLoaiTB.getItemByMaLoai(objTTDK.getMaLoaiTB()));
					
					//gan doi tuong TTDK vao doi tuong TTSD
					objTTSD.setObjTTDK(objTTDK);
					
					alTTSD.add(objTTSD);
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
			return alTTSD;
		}
		
		// THEM SU DUNG MOI
		public int ThemSuDungMoi(ThongTinSuDung objTTSD) {
			int result = 0;
			conn = lcdb.GetConnectMySQL();
			String query = "INSERT INTO `ThongTinSuDung` (`MaTTDK`, `MaNguoiMuon`, `MaNguoiPheDuyet`, `BatDauSuDung`, `KetThucSuDung`, `TinhTrang`) VALUES (?, ?, ?, ?, ?, 1);";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, objTTSD.getMaTTDK());
				pst.setInt(2, objTTSD.getMaNguoiMuon());
				pst.setInt(3, objTTSD.getMaNguoiPheDuyet());
				pst.setTimestamp(4, objTTSD.getBatDauSuDung());
				pst.setTimestamp(5, objTTSD.getKetThucSuDung());
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
