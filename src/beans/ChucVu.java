package beans;

public class ChucVu {
	private int maChucVu;
	private String tenChucVu;
	
	private ChucVu(Builder builder) {
		maChucVu = builder.maChucVu;
		tenChucVu = builder.tenChucVu;
	}
	
	public static class Builder {
		private int maChucVu;
		private String tenChucVu;
		
		public Builder() {
			
		}
		
		public ChucVu build() {
			return new ChucVu(this);
		}

		public Builder setMaChucVu(int maChucVu) {
			this.maChucVu = maChucVu;
			return this;
		}

		public Builder setTenChucVu(String tenChucVu) {
			this.tenChucVu = tenChucVu;
			return this;
		}
	}

	public int getMaChucVu() {
		return maChucVu;
	}

	public void setMaChucVu(int maChucVu) {
		this.maChucVu = maChucVu;
	}

	public String getTenChucVu() {
		return tenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}

	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}

	
}
