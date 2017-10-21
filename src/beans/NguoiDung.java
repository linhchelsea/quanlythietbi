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
	private ChucVu objChucVu;
	private PhongBan objPhongBan;
	
	private NguoiDung(Builder builder) {
		maND = builder.maND;
		tenND = builder.tenND;
		tenDangNhap = builder.tenDangNhap;
		matKhau = builder.matKhau;
		gioiTinh = builder.gioiTinh;
		ngaySinh = builder.ngaySinh;
		diaChi = builder.diaChi;
		chucVu = builder.chucVu;
		phongBan = builder.phongBan;
		phanQuyen = builder.phanQuyen;
		objChucVu = builder.objChucVu;
		objPhongBan = builder.objPhongBan;
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
		private ChucVu objChucVu;
		private PhongBan objPhongBan;
		
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

		public Builder setObjChucVu(ChucVu objChucVu) {
			this.objChucVu = objChucVu;
			return this;
		}

		public Builder setObjPhongBan(PhongBan objPhongBan) {
			this.objPhongBan = objPhongBan;
			return this;
		}
	}

	public int getMaND() {
		return maND;
	}

	public void setMaND(int maND) {
		this.maND = maND;
	}

	public String getTenND() {
		return tenND;
	}

	public void setTenND(String tenND) {
		this.tenND = tenND;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getChucVu() {
		return chucVu;
	}

	public void setChucVu(int chucVu) {
		this.chucVu = chucVu;
	}

	public int getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(int phongBan) {
		this.phongBan = phongBan;
	}

	public int getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	public ChucVu getObjChucVu() {
		return objChucVu;
	}

	public void setObjChucVu(ChucVu objChucVu) {
		this.objChucVu = objChucVu;
	}

	public PhongBan getObjPhongBan() {
		return objPhongBan;
	}

	public void setObjPhongBan(PhongBan objPhongBan) {
		this.objPhongBan = objPhongBan;
	}

	@Override
	public String toString() {
		return "NguoiDung [maND=" + maND + ", tenND=" + tenND + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
				+ ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", chucVu=" + chucVu
				+ ", phongBan=" + phongBan + ", phanQuyen=" + phanQuyen + ", objChucVu=" + objChucVu + ", objPhongBan="
				+ objPhongBan + "]";
	}
}
