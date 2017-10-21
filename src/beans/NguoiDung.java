package beans;

import java.sql.Date;

public class NguoiDung {
	private int maND;
	private String tenND;
	private String tenDangNhap;
	private String matKhau;
	private int gioiTinh;
	private Date ngaySinh;
	private String diaChi;
	private int chucVu;
	private int phongBan;
	private int phanQuyen;

	public NguoiDung() {
		super();
	}

	public NguoiDung(Builder builder) {
		this.maND = builder.maND;
		this.tenND = builder.tenND;
		this.tenDangNhap = builder.tenDangNhap;
		this.matKhau = builder.matKhau;
		this.gioiTinh = builder.gioiTinh;
		this.ngaySinh = builder.ngaySinh;
		this.diaChi = builder.diaChi;
		this.chucVu = builder.chucVu;
		this.phongBan = builder.phongBan;
		this.phanQuyen = builder.phanQuyen;
	}

	public static class Builder {
		private int maND;
		private String tenND;
		private String tenDangNhap;
		private String matKhau;
		private int gioiTinh;
		private Date ngaySinh;
		private String diaChi;
		private int chucVu;
		private int phongBan;
		private int phanQuyen;

		public Builder() {

		}

		public NguoiDung build() {
			return new NguoiDung(this);
		}

		public Builder setMaND(int maND) {
			this.maND = maND;
			return this;
		}

		public Builder setTenND(String tenND) {
			this.tenND = tenND;
			return this;
		}

		public Builder setTenDangNhap(String tenDangNhap) {
			this.tenDangNhap = tenDangNhap;
			return this;
		}

		public Builder setMatKhau(String matKhau) {
			this.matKhau = matKhau;
			return this;
		}

		public Builder setGioiTinh(int gioiTinh) {
			this.gioiTinh = gioiTinh;
			return this;
		}

		public Builder setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
			return this;
		}

		public Builder setDiaChi(String diaChi) {
			this.diaChi = diaChi;
			return this;
		}

		public Builder setChucVu(int chucVu) {
			this.chucVu = chucVu;
			return this;
		}

		public Builder setPhongBan(int phongBan) {
			this.phongBan = phongBan;
			return this;
		}

		public Builder setPhanQuyen(int phanQuyen) {
			this.phanQuyen = phanQuyen;
			return this;
		}
	}

	public int getMaND() {
		return maND;
	}

	public String getTenND() {
		return tenND;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public int getChucVu() {
		return chucVu;
	}

	public int getPhongBan() {
		return phongBan;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}
}
