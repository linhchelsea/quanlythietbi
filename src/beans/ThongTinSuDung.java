package beans;

import java.sql.Date;
import java.sql.Timestamp;

public class ThongTinSuDung {
	private int maTTSD;
	private int maTTDK;
	private int maNguoiMuon;
	private int maNguoiPheDuyet;
	private Timestamp batDauSuDung;
	private Timestamp ketThucSuDung;
	private int tinhTrang;
	private ThongTinDangKy objTTDK;
	private NguoiDung objNguoiMuon;
	private NguoiDung objNguoiPheDuyet;
	
	
	private ThongTinSuDung(Builder builder) {
		maTTSD = builder.maTTSD;
		maTTDK = builder.maTTDK;
		maNguoiMuon = builder.maNguoiMuon;
		maNguoiPheDuyet = builder.maNguoiPheDuyet;
		batDauSuDung = builder.batDauSuDung;
		ketThucSuDung = builder.ketThucSuDung;
		tinhTrang = builder.tinhTrang;
		objTTDK = builder.objTTDK;
		objNguoiMuon = builder.objNguoiMuon;
		objNguoiPheDuyet = builder.objNguoiPheDuyet;
	}
	
	public static class Builder {
		private int maTTSD;
		private int maTTDK;
		private int maNguoiMuon;
		private int maNguoiPheDuyet;
		private Timestamp batDauSuDung;
		private Timestamp ketThucSuDung;
		private int tinhTrang;
		private ThongTinDangKy objTTDK;
		private NguoiDung objNguoiMuon;
		private NguoiDung objNguoiPheDuyet;
		
		public Builder() {
			
		}
		
		public ThongTinSuDung build() {
			return new ThongTinSuDung(this);
		}

		public Builder setMaTTSD(int maTTSD) {
			this.maTTSD = maTTSD;
			return this;
		}

		public Builder setMaTTDK(int maTTDK) {
			this.maTTDK = maTTDK;
			return this;
		}

		public Builder setMaNguoiMuon(int maNguoiMuon) {
			this.maNguoiMuon = maNguoiMuon;
			return this;
		}

		public Builder setMaNguoiPheDuyet(int maNguoiPheDuyet) {
			this.maNguoiPheDuyet = maNguoiPheDuyet;
			return this;
		}

		public Builder setBatDauSuDung(Timestamp batDauSuDung) {
			this.batDauSuDung = batDauSuDung;
			return this;
		}

		public Builder setKetThucSuDung(Timestamp ketThucSuDung) {
			this.ketThucSuDung = ketThucSuDung;
			return this;
		}

		public Builder setTinhTrang(int tinhTrang) {
			this.tinhTrang = tinhTrang;
			return this;
		}

		public Builder setObjTTDK(ThongTinDangKy objTTDK) {
			this.objTTDK = objTTDK;
			return this;
		}

		public Builder setObjNguoiMuon(NguoiDung objNguoiMuon) {
			this.objNguoiMuon = objNguoiMuon;
			return this;
		}

		public Builder setObjNguoiPheDuyet(NguoiDung objNguoiPheDuyet) {
			this.objNguoiPheDuyet = objNguoiPheDuyet;
			return this;
		}
	}

	public int getMaTTSD() {
		return maTTSD;
	}

	public void setMaTTSD(int maTTSD) {
		this.maTTSD = maTTSD;
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

	public int getMaNguoiPheDuyet() {
		return maNguoiPheDuyet;
	}

	public void setMaNguoiPheDuyet(int maNguoiPheDuyet) {
		this.maNguoiPheDuyet = maNguoiPheDuyet;
	}

	public Timestamp getBatDauSuDung() {
		return batDauSuDung;
	}

	public void setBatDauSuDung(Timestamp batDauSuDung) {
		this.batDauSuDung = batDauSuDung;
	}

	public Timestamp getKetThucSuDung() {
		return ketThucSuDung;
	}

	public void setKetThucSuDung(Timestamp ketThucSuDung) {
		this.ketThucSuDung = ketThucSuDung;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public ThongTinDangKy getObjTTDK() {
		return objTTDK;
	}

	public void setObjTTDK(ThongTinDangKy objTTDK) {
		this.objTTDK = objTTDK;
	}

	public NguoiDung getObjNguoiMuon() {
		return objNguoiMuon;
	}

	public void setObjNguoiMuon(NguoiDung objNguoiMuon) {
		this.objNguoiMuon = objNguoiMuon;
	}

	public NguoiDung getObjNguoiPheDuyet() {
		return objNguoiPheDuyet;
	}

	public void setObjNguoiPheDuyet(NguoiDung objNguoiPheDuyet) {
		this.objNguoiPheDuyet = objNguoiPheDuyet;
	}

	@Override
	public String toString() {
		return "ThongTinSuDung [maTTSD=" + maTTSD + ", maTTDK=" + maTTDK + ", maNguoiMuon=" + maNguoiMuon
				+ ", maNguoiPheDuyet=" + maNguoiPheDuyet + ", batDauSuDung=" + batDauSuDung + ", ketThucSuDung="
				+ ketThucSuDung + ", tinhTrang=" + tinhTrang + ", objTTDK=" + objTTDK + ", objNguoiMuon=" + objNguoiMuon
				+ ", objNguoiPheDuyet=" + objNguoiPheDuyet + "]";
	}
}
