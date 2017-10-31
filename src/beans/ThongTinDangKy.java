package beans;

import java.sql.Date;
import java.sql.Timestamp;

public class ThongTinDangKy {
	private int maTTDK;
	private int maNguoiMuon;
	private int maLoaiTB;
	private Timestamp thoiGianDangKy;
	private Timestamp DKBatDauSuDung;
	private Timestamp DKKetThucSuDung;
	private int soLuongDK;
	private String mucDichSuDung;
	private int tinhTrang;
	private String thongBao;
	private LoaiThietBi objLoaiTB;
	private NguoiDung objNguoiDung;
	
	private ThongTinDangKy(Builder builder) {
		maTTDK = builder.maTTDK;
		maNguoiMuon = builder.maNguoiMuon;
		maLoaiTB = builder.maLoaiTB;
		thoiGianDangKy = builder.thoiGianDangKy;
		DKBatDauSuDung = builder.DKBatDauSuDung;
		DKKetThucSuDung = builder.DKKetThucSuDung;
		soLuongDK = builder.soLuongDK;
		mucDichSuDung = builder.mucDichSuDung;
		tinhTrang = builder.tinhTrang;
		thongBao = builder.thongBao;
		objLoaiTB = builder.objLoaiTB;
		objNguoiDung = builder.objNguoiDung;
	}
	
	public static class Builder {
		private int maTTDK;
		private int maNguoiMuon;
		private int maLoaiTB;
		private Timestamp thoiGianDangKy;
		private Timestamp DKBatDauSuDung;
		private Timestamp DKKetThucSuDung;
		private int soLuongDK;
		private String mucDichSuDung;
		private int tinhTrang;
		private String thongBao;
		private LoaiThietBi objLoaiTB;
		private NguoiDung objNguoiDung;
		
		public Builder() {
			
		}
		
		public ThongTinDangKy build() {
			return new ThongTinDangKy(this);
		}

		public Builder setMaTTDK(int maTTDK) {
			this.maTTDK = maTTDK;
			return this;
		}

		public Builder setMaNguoiMuon(int maNguoiMuon) {
			this.maNguoiMuon = maNguoiMuon;
			return this;
		}

		public Builder setMaLoaiTB(int maLoaiTB) {
			this.maLoaiTB = maLoaiTB;
			return this;
		}

		public Builder setThoiGianDangKy(Timestamp thoiGianDangKy) {
			this.thoiGianDangKy = thoiGianDangKy;
			return this;
		}

		public Builder setDKBatDauSuDung(Timestamp dKBatDauSuDung) {
			DKBatDauSuDung = dKBatDauSuDung;
			return this;
		}

		public Builder setDKKetThucSuDung(Timestamp dKKetThucSuDung) {
			DKKetThucSuDung = dKKetThucSuDung;
			return this;
		}

		public Builder setSoLuongDK(int soLuongDK) {
			this.soLuongDK = soLuongDK;
			return this;
		}

		public Builder setMucDichSuDung(String mucDichSuDung) {
			this.mucDichSuDung = mucDichSuDung;
			return this;
		}

		public Builder setTinhTrang(int tinhTrang) {
			this.tinhTrang = tinhTrang;
			return this;
		}

		public Builder setThongBao(String thongBao) {
			this.thongBao = thongBao;
			return this;
		}

		public Builder setObjLoaiTB(LoaiThietBi objLoaiTB) {
			this.objLoaiTB = objLoaiTB;
			return this;
		}

		public Builder setObjNguoiDung(NguoiDung objNguoiDung) {
			this.objNguoiDung = objNguoiDung;
			return this;
		}
	}

	public int getMaTTDK() {
		return maTTDK;
	}

	public void setMaTTDK(int maTTDK) {
		this.maTTDK = maTTDK;
	}

	public int getMaNguoiMuon() {
		return maNguoiMuon;
	}

	public void setMaNguoiMuon(int maNguoiMuon) {
		this.maNguoiMuon = maNguoiMuon;
	}

	public int getMaLoaiTB() {
		return maLoaiTB;
	}

	public void setMaLoaiTB(int maLoaiTB) {
		this.maLoaiTB = maLoaiTB;
	}

	public Timestamp getThoiGianDangKy() {
		return thoiGianDangKy;
	}

	public void setThoiGianDangKy(Timestamp thoiGianDangKy) {
		this.thoiGianDangKy = thoiGianDangKy;
	}

	public Timestamp getDKBatDauSuDung() {
		return DKBatDauSuDung;
	}

	public void setDKBatDauSuDung(Timestamp dKBatDauSuDung) {
		DKBatDauSuDung = dKBatDauSuDung;
	}

	public Timestamp getDKKetThucSuDung() {
		return DKKetThucSuDung;
	}

	public void setDKKetThucSuDung(Timestamp dKKetThucSuDung) {
		DKKetThucSuDung = dKKetThucSuDung;
	}

	public int getSoLuongDK() {
		return soLuongDK;
	}

	public void setSoLuongDK(int soLuongDK) {
		this.soLuongDK = soLuongDK;
	}

	public String getMucDichSuDung() {
		return mucDichSuDung;
	}

	public void setMucDichSuDung(String mucDichSuDung) {
		this.mucDichSuDung = mucDichSuDung;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getThongBao() {
		return thongBao;
	}

	public void setThongBao(String thongBao) {
		this.thongBao = thongBao;
	}

	public LoaiThietBi getObjLoaiTB() {
		return objLoaiTB;
	}

	public void setObjLoaiTB(LoaiThietBi objLoaiTB) {
		this.objLoaiTB = objLoaiTB;
	}

	public NguoiDung getObjNguoiDung() {
		return objNguoiDung;
	}

	public void setObjNguoiDung(NguoiDung objNguoiDung) {
		this.objNguoiDung = objNguoiDung;
	}

	@Override
	public String toString() {
		return "ThongTinDangKy [maTTDK=" + maTTDK + ", maNguoiMuon=" + maNguoiMuon + ", maLoaiTB=" + maLoaiTB
				+ ", thoiGianDangKy=" + thoiGianDangKy + ", DKBatDauSuDung=" + DKBatDauSuDung + ", DKKetThucSuDung="
				+ DKKetThucSuDung + ", soLuongDK=" + soLuongDK + ", mucDichSuDung=" + mucDichSuDung + ", tinhTrang="
				+ tinhTrang + ", thongBao=" + thongBao + ", objLoaiTB=" + objLoaiTB + ", objNguoiDung=" + objNguoiDung
				+ "]";
	}
}
