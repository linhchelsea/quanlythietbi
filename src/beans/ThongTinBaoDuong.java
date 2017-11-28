package beans;

import java.sql.Date;
import java.sql.Timestamp;

import beans.ThongTinDangKy.Builder;

public class ThongTinBaoDuong {
	private int maTTBD;
	private int maNV;
	private int maTB;
	private int maLoaiTB;
	private int tinhTrang;
	private String lyDoBaoDuong;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	private NguoiDung objNguoiDung;
	private ThietBi objThietBi;
	private LoaiThietBi objLoaiThietBi;
	
	private ThongTinBaoDuong(Builder builder) {
		maTTBD = builder.maTTBD;
		maNV = builder.maNV;
		maTB = builder.maTB;
		maLoaiTB = builder.maLoaiTB;
		tinhTrang = builder.tinhTrang;
		lyDoBaoDuong = builder.lyDoBaoDuong;
		ngayBatDau = builder.ngayBatDau;
		ngayKetThuc = builder.ngayKetThuc;
		objNguoiDung = builder.objNguoiDung;
		objThietBi = builder.objThietBi;
		objLoaiThietBi = builder.objLoaiThietBi;
	}
	
	public static class Builder {
		private int maTTBD;
		private int maNV;
		private int maTB;
		private int maLoaiTB;
		private int tinhTrang;
		private String lyDoBaoDuong;
		private Date ngayBatDau;
		private Date ngayKetThuc;
		private NguoiDung objNguoiDung;
		private ThietBi objThietBi;
		private LoaiThietBi objLoaiThietBi;
		
		public Builder() {
			
		}
		
		public ThongTinBaoDuong build() {
			return new ThongTinBaoDuong(this);
		}

		public Builder setMaTTBD(int maTTBD) {
			this.maTTBD = maTTBD;
			return this;
		}

		public Builder setMaNV(int maNV) {
			this.maNV = maNV;
			return this;
		}

		public Builder setMaTB(int maTB) {
			this.maTB = maTB;
			return this;
		}

		public Builder setMaLoaiTB(int maLoaiTB) {
			this.maLoaiTB = maLoaiTB;
			return this;
		}

		public Builder setTinhTrang(int tinhTrang) {
			this.tinhTrang = tinhTrang;
			return this;
		}

		public Builder setLyDoBaoDuong(String lyDoBaoDuong) {
			this.lyDoBaoDuong = lyDoBaoDuong;
			return this;
		}

		public Builder setNgayBatDau(Date ngayBatDau) {
			this.ngayBatDau = ngayBatDau;
			return this;
		}

		public Builder setNgayKetThuc(Date ngayKetThuc) {
			this.ngayKetThuc = ngayKetThuc;
			return this;
		}

		public Builder setObjNguoiDung(NguoiDung objNguoiDung) {
			this.objNguoiDung = objNguoiDung;
			return this;
		}

		public Builder setObjThietBi(ThietBi objThietBi) {
			this.objThietBi = objThietBi;
			return this;
		}

		public Builder setObjLoaiThietBi(LoaiThietBi objLoaiThietBi) {
			this.objLoaiThietBi = objLoaiThietBi;
			return this;
		}
	}

	public int getMaTTBD() {
		return maTTBD;
	}

	public void setMaTTBD(int maTTBD) {
		this.maTTBD = maTTBD;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public int getMaTB() {
		return maTB;
	}

	public void setMaTB(int maTB) {
		this.maTB = maTB;
	}

	public int getMaLoaiTB() {
		return maLoaiTB;
	}

	public void setMaLoaiTB(int maLoaiTB) {
		this.maLoaiTB = maLoaiTB;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getLyDoBaoDuong() {
		return lyDoBaoDuong;
	}

	public void setLyDoBaoDuong(String lyDoBaoDuong) {
		this.lyDoBaoDuong = lyDoBaoDuong;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public NguoiDung getObjNguoiDung() {
		return objNguoiDung;
	}

	public void setObjNguoiDung(NguoiDung objNguoiDung) {
		this.objNguoiDung = objNguoiDung;
	}

	public ThietBi getObjThietBi() {
		return objThietBi;
	}

	public void setObjThietBi(ThietBi objThietBi) {
		this.objThietBi = objThietBi;
	}

	public LoaiThietBi getObjLoaiThietBi() {
		return objLoaiThietBi;
	}

	public void setObjLoaiThietBi(LoaiThietBi objLoaiThietBi) {
		this.objLoaiThietBi = objLoaiThietBi;
	}

	@Override
	public String toString() {
		return "ThongTinBaoDuong [maTTBD=" + maTTBD + ", maNV=" + maNV + ", maTB=" + maTB + ", maLoaiTB=" + maLoaiTB
				+ ", tinhTrang=" + tinhTrang + ", lyDoBaoDuong=" + lyDoBaoDuong + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", objNguoiDung=" + objNguoiDung + ", objThietBi=" + objThietBi
				+ ", objLoaiThietBi=" + objLoaiThietBi + "]";
	}
	
	public static void main(String[] args) {
		ThongTinBaoDuong.Builder builder = new ThongTinBaoDuong.Builder();
		ThongTinBaoDuong TTBD = builder.setMaTTBD(1)
				.setLyDoBaoDuong("aaaaaa")
				.setMaTB(2)
				.build();
				
		System.out.println(TTBD.toString());
	}
}
