package beans;

public class PhongBan {
	private int maPhongBan;
	private String tenPhongBan;
	
	private PhongBan(Builder builder) {
		maPhongBan = builder.maPhongBan;
		tenPhongBan = builder.tenPhongBan;
	}
	
	public static class Builder {
		private int maPhongBan;
		private String tenPhongBan;
		
		public Builder() {
			
		}
		
		public PhongBan build() {
			return new PhongBan(this);
		}

		public Builder setMaPhongBan(int maPhongBan) {
			this.maPhongBan = maPhongBan;
			return this;
		}

		public Builder setTenPhongBan(String tenPhongBan) {
			this.tenPhongBan = tenPhongBan;
			return this;
		}
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + "]";
	}
}
