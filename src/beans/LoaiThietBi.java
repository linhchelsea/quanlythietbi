package beans;

public class LoaiThietBi {
	private int maLoai;
	private String tenLoai;
	private int maLoaiCha;
	private int soLuong;
	private LoaiThietBi objLoaiCha;
	
	private LoaiThietBi(Builder builder) {
		maLoai = builder.maLoai;
		tenLoai = builder.tenLoai;
		maLoaiCha = builder.maLoaiCha;
		soLuong = builder.soLuong;
		objLoaiCha = builder.objLoaiCha;
	}
	
	public static class Builder {
		private int maLoai;
		private String tenLoai;
		private int maLoaiCha;
		private int soLuong;
		private LoaiThietBi objLoaiCha;
		
		public Builder() {
			
		}
		
		public LoaiThietBi build() {
			return new LoaiThietBi(this);
		}

		public Builder setMaLoai(int maLoai) {
			this.maLoai = maLoai;
			return this;
		}

		public Builder setTenLoai(String tenLoai) {
			this.tenLoai = tenLoai;
			return this;
		}

		public Builder setMaLoaiCha(int maLoaiCha) {
			this.maLoaiCha = maLoaiCha;
			return this;
		}

		public Builder setSoLuong(int soLuong) {
			this.soLuong = soLuong;
			return this;
		}
		
		public Builder setLoaiCha(LoaiThietBi objLoaiCha) {
			this.objLoaiCha = objLoaiCha;
			return this;
		}
	}
	
	

	public int getMaLoai() {
		return maLoai;
	}



	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}



	public String getTenLoai() {
		return tenLoai;
	}



	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}



	public int getMaLoaiCha() {
		return maLoaiCha;
	}



	public void setMaLoaiCha(int maLoaiCha) {
		this.maLoaiCha = maLoaiCha;
	}



	public int getSoLuong() {
		return soLuong;
	}



	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}



	public LoaiThietBi getObjLoaiCha() {
		return objLoaiCha;
	}



	public void setObjLoaiCha(LoaiThietBi objLoaiCha) {
		this.objLoaiCha = objLoaiCha;
	}



	@Override
	public String toString() {
		return "LoaiThietBi [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", maLoaiCha=" + maLoaiCha + ", soLuong="
				+ soLuong + ", objLoaiCha=" + objLoaiCha + "]";
	}
	



	/*public static void main(String[] args) {
		LoaiThietBi.Builder builder = new LoaiThietBi.Builder();
		LoaiThietBi thietbi = builder.setMaLoai(1).setTenLoai("LG").build();
		System.out.println(thietbi.toString());
		
	}*/
}
