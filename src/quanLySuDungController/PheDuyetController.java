package quanLySuDungController;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThongTinDangKy;
import beans.ThongTinDangKy.Builder;
import beans.ThongTinSuDung;
import library.LibraryFormatDateTime;
import library.ThietBiKhaDung;
import models.thietbiModels;
import models.thongtindangkyModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class PheDuyetController
 */
@WebServlet("/PheDuyetController")
public class PheDuyetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PheDuyetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		thongtindangkyModels mTTDK = new thongtindangkyModels();
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		ThietBiKhaDung khadung = new ThietBiKhaDung();
		LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();
		
		int maTTDK =Integer.parseInt(request.getParameter("maTTDK"));
		int maNguoiMuon = Integer.parseInt(request.getParameter("maNguoiMuon"));
		Timestamp dkBatDauSuDung = Timestamp.valueOf(request.getParameter("dkBatDauSuDung"));
		Timestamp dkKetThucSuDung = Timestamp.valueOf(request.getParameter("dkKetThucSuDung"));
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		int maLoaiTB = Integer.parseInt(request.getParameter("maLoaiTB"));
		
		int maNguoiPheDuyet = 2;
		
		ThongTinDangKy.Builder builderTTDK = new ThongTinDangKy.Builder();
		ThongTinDangKy objTTDK = builderTTDK.setMaTTDK(maTTDK)
				.setMaNguoiMuon(maNguoiMuon)
				.setMaLoaiTB(maLoaiTB)
				.setDKBatDauSuDung(dkBatDauSuDung)
				.setDKKetThucSuDung(dkKetThucSuDung)
				.setSoLuongDK(soLuong)
				.build();
		
		ThongTinSuDung.Builder builderTTSD = new ThongTinSuDung.Builder();
		ThongTinSuDung objTTSD = builderTTSD.setMaTTDK(maTTDK)
				.setMaNguoiMuon(maNguoiMuon)
				.setMaNguoiPheDuyet(maNguoiPheDuyet)
				.setBatDauSuDung(dkBatDauSuDung)
				.setKetThucSuDung(dkKetThucSuDung)
				.setTinhTrang(1)
				.build();
		
		int soLuongKhaDung = khadung.TinhSoLuongKhaDung(maLoaiTB, dkBatDauSuDung, dkKetThucSuDung);
		
		if(soLuongKhaDung >= soLuong) { //dang ky dat yeu cau
			mTTDK.SuaTinhTrang(2, maTTDK);
			mTTSD.ThemSuDungMoi(objTTSD);
			response.sendRedirect(request.getContextPath() + "/qlsd-pheduyetdangky?msgpheduyet=1");
		} else { //dang ky khong dat yeu cau
			response.sendRedirect(request.getContextPath() + "/qlsd-pheduyetdangky?msgpheduyet=0");
		}
	}

}
