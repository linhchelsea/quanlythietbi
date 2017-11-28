package beans;

public class ChiTietTTSD {
	private int maTTSD;
	private int maTB;
	private int maLoaiTB;
	private ThongTinSuDung objTTSD;
	private ThietBi objThietBi;
	
	private ChiTietTTSD(Builder builder) {
		maTTSD = builder.maTTSD;
		maTB = builder.maTB;
		maLoaiTB = builder.maLoaiTB;
		objTTSD = builder.objTTSD;
		objThietBi = builder.objThietBi;
	}
	
	public static class Builder {
		private int maTTSD;
		private int maTB;
		private int maLoaiTB;
		private ThongTinSuDung objTTSD;
		private ThietBi objThietBi;
		
		public Builder() {
			
		}
		
		public ChiTietTTSD build() {
			return new ChiTietTTSD(this);
		}

		public Builder setMaTTSD(int maTTSD) {
			this.maTTSD = maTTSD;
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

		public Builder setObjTTSD(ThongTinSuDung objTTSD) {
			this.objTTSD = objTTSD;
			return this;
		}

		public Builder setObjThietBi(ThietBi objThietBi) {
			this.objThietBi = objThietBi;
			return this;
		}
	}

	public int getMaTTSD() {
		return maTTSD;
	}

	public void setMaTTSD(int maTTSD) {
		this.maTTSD = maTTSD;
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

	public ThongTinSuDung getObjTTSD() {
		return objTTSD;
	}

	public void setObjTTSD(ThongTinSuDung objTTSD) {
		this.objTTSD = objTTSD;
	}

	public ThietBi getObjThietBi() {
		return objThietBi;
	}

	public void setObjThietBi(ThietBi objThietBi) {
		this.objThietBi = objThietBi;
	}

	@Override
	public String toString() {
		return "ChiTietTTSD [maTTSD=" + maTTSD + ", maTB=" + maTB + ", maLoaiTB=" + maLoaiTB + ", objTTSD=" + objTTSD
				+ ", objThietBi=" + objThietBi + "]";
	}
}
