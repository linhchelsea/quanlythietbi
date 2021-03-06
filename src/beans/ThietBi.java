package beans;

import java.sql.Date;

public class ThietBi {
	private int maTB;
	private String tenTB;
	private int maLoaiTB;
	private Date ngayNhap;
	private int TinhTrang;
	private LoaiThietBi objLoaiTB;
	
	private ThietBi(Builder builder) {
		maTB = builder.maTB;
		tenTB = builder.tenTB;
		maLoaiTB = builder.maLoaiTB;
		ngayNhap = builder.ngayNhap;
		TinhTrang = builder.TinhTrang;
		objLoaiTB = builder.objLoaiTB;
	}
	
	public static class Builder {
		private int maTB;
		private String tenTB;
		private int maLoaiTB;
		private Date ngayNhap;
		private int TinhTrang;
		private LoaiThietBi objLoaiTB;
		
		public Builder() {
			
		}
		
		public ThietBi build() {
			return new ThietBi(this);
		}

		public Builder setMaTB(int maTB) {
			this.maTB = maTB;
			return this;
		}

		public Builder setTenTB(String tenTB) {
			this.tenTB = tenTB;
			return this;
		}

		public Builder setMaLoaiTB(int maLoaiTB) {
			this.maLoaiTB = maLoaiTB;
			return this;
		}

		public Builder setNgayNhap(Date ngayNhap) {
			this.ngayNhap = ngayNhap;
			return this;
		}

		public int getTinhTrang() {
			return TinhTrang;
		}

		public void setTinhTrang(int tinhTrang) {
			TinhTrang = tinhTrang;
		}
		
		public Builder setObjLoaiTB(LoaiThietBi objLoaiTB) {
			this.objLoaiTB = objLoaiTB;
			return this;
		}
		
	}

	public int getMaTB() {
		return maTB;
	}

	public void setMaTB(int maTB) {
		this.maTB = maTB;
	}

	public String getTenTB() {
		return tenTB;
	}

	public void setTenTB(String tenTB) {
		this.tenTB = tenTB;
	}

	public int getMaLoaiTB() {
		return maLoaiTB;
	}

	public void setMaLoaiTB(int maLoaiTB) {
		this.maLoaiTB = maLoaiTB;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	public int getTinhTrang() {
		return TinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	
	public LoaiThietBi getObjLoaiTB() {
		return objLoaiTB;
	}

	public void setObjLoaiTB(LoaiThietBi objLoaiTB) {
		this.objLoaiTB = objLoaiTB;
	}

	@Override
	public String toString() {
		return "ThietBi [maTB=" + maTB + ", tenTB=" + tenTB + ", maLoaiTB=" + maLoaiTB + ", ngayNhap=" + ngayNhap + "]";
	}
	
	/*public static void main(String[] args) {
		ThietBi.Builder builder = new ThietBi.Builder();
		ThietBi thietbi = builder.setMaTB(1).setTenTB("LG").build();
		
	}*/
}
