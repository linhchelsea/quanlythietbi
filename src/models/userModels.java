package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import beans.NguoiDung;
import beans.NguoiDung.Builder;
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

	// lấy danh sách người dùng
	public ArrayList<NguoiDung> getList() {
		ArrayList<NguoiDung> alNguoiDung = new ArrayList<NguoiDung>();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM nguoidung";
		NguoiDung objItem;
		Builder builder = new Builder();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				builder.setMaND(rs.getInt("MaND")).setTenND(rs.getString("TenND"))
						.setTenDangNhap(rs.getString("TenDangNhap")).setMatKhau(rs.getString("MatKhau"))
						.setGioiTinh(rs.getInt("GioiTinh")).setNgaySinh(rs.getDate("NgaySinh"))
						.setDiaChi(rs.getString("DiaChi")).setChucVu(rs.getInt("ChucVu"))
						.setPhongBan(rs.getInt("PhongBan")).setPhanQuyen(rs.getInt("PhanQuyen"));
				objItem = builder.build();
				alNguoiDung.add(objItem);
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
		return alNguoiDung;
	}

	// lấy thông tin người dùng đăng nhập
	public NguoiDung getUserLogin(String tenDangNhap, String matKhau) {
		NguoiDung nguoiDung = null;
		Builder builder = new Builder();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM nguoidung WHERE TenDangNhap = ? AND MatKhau = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, tenDangNhap);
			pst.setString(2, matKhau);
			rs = pst.executeQuery();
			if (rs.next()) {
				builder.setMaND(rs.getInt("MaND")).setTenND(rs.getString("TenND"))
						.setTenDangNhap(rs.getString("TenDangNhap")).setMatKhau(rs.getString("MatKhau"))
						.setGioiTinh(rs.getInt("GioiTinh")).setNgaySinh(rs.getDate("NgaySinh"))
						.setDiaChi(rs.getString("DiaChi")).setChucVu(rs.getInt("ChucVu"))
						.setPhongBan(rs.getInt("PhongBan")).setPhanQuyen(rs.getInt("PhanQuyen"));
				nguoiDung = builder.build();
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
		return nguoiDung;
	}

	// thêm người dùng
	public int addUser(NguoiDung nguoiDung) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "INSERT INTO nguoidung(TenND,TenDangNhap,MatKhau,GioiTinh,NgaySinh,DiaChi,ChucVu,PhongBan,PhanQuyen) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, nguoiDung.getTenND());
			pst.setString(2, nguoiDung.getTenDangNhap());
			pst.setString(3, nguoiDung.getMatKhau());
			pst.setInt(4, nguoiDung.getGioiTinh());
			pst.setDate(5, nguoiDung.getNgaySinh());
			pst.setString(6, nguoiDung.getDiaChi());
			pst.setInt(7, nguoiDung.getChucVu());
			pst.setInt(8, nguoiDung.getPhongBan());
			pst.setInt(9, nguoiDung.getPhanQuyen());
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

	// lấy dữ liệu người dùng qua mã người dùng
	public NguoiDung getItembyId(int maND) {
		NguoiDung nguoiDung = new NguoiDung();
		Builder builder = new Builder();
		conn = lcdb.GetConnectMySQL();
		String query = "SELECT * FROM nguoidung WHERE MaND = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maND);
			rs = pst.executeQuery();
			if (rs.next()) {
				builder.setMaND(rs.getInt("MaND")).setTenND(rs.getString("TenND"))
						.setTenDangNhap(rs.getString("TenDangNhap")).setMatKhau(rs.getString("MatKhau"))
						.setGioiTinh(rs.getInt("GioiTinh")).setNgaySinh(rs.getDate("NgaySinh"))
						.setDiaChi(rs.getString("DiaChi")).setChucVu(rs.getInt("ChucVu"))
						.setPhongBan(rs.getInt("PhongBan")).setPhanQuyen(rs.getInt("PhanQuyen"));
				nguoiDung = builder.build();
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
		return nguoiDung;
	}

	// xóa người dùng
	public int delItem(int maND) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "DELETE FROM nguoidung WHERE MaND = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, maND);
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

	// thay đổi thông tin người dùng
	public int editUser(NguoiDung nguoiDung) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE nguoidung SET TenND=?,TenDangNhap=?, MatKhau=?, GioiTinh=?, NgaySinh=?,DiaChi=?,ChucVu=?,PhongBan=?,PhanQuyen=? WHERE IdUser = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, nguoiDung.getTenND());
			pst.setString(2, nguoiDung.getTenDangNhap());
			pst.setString(3, nguoiDung.getMatKhau());
			pst.setInt(4, nguoiDung.getGioiTinh());
			pst.setDate(5, nguoiDung.getNgaySinh());
			pst.setString(6, nguoiDung.getDiaChi());
			pst.setInt(7, nguoiDung.getChucVu());
			pst.setInt(8, nguoiDung.getPhongBan());
			pst.setInt(9, nguoiDung.getPhanQuyen());
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

	public int changePassword(int maND, String matKhauMoi) {
		int result = 0;
		conn = lcdb.GetConnectMySQL();
		String query = "UPDATE nguoidung SET MatKhau=? WHERE MaND = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, matKhauMoi);
			pst.setInt(2, maND);
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
}
