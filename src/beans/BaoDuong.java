package beans;

import java.sql.Date;
import java.sql.Timestamp;

public class BaoDuong {
	private int maTTBD;
	private int maNV;
	private int maTB;
	private int maLoaiTB;
	private int tinhTrang;
	private String lyDoBaoDuong;
	private Date ngayBatDau;
	private Date ngayKetThuc;
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
	public BaoDuong() {

	}
	public BaoDuong(int maTTBD, int maNV, int maTB, int maLoaiTB, int tinhTrang, String lyDoBaoDuong, Date ngayBatDau,
			Date ngayKetThuc) {
		this.maTTBD = maTTBD;
		this.maNV = maNV;
		this.maTB = maTB;
		this.maLoaiTB = maLoaiTB;
		this.tinhTrang = tinhTrang;
		this.lyDoBaoDuong = lyDoBaoDuong;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	
	
}
