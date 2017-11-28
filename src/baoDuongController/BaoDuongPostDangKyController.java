package baoDuongController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThietBi;
import beans.ThongTinBaoDuong;
import models.baoduongModel;
import models.thietbiModels;

/**
 * Servlet implementation class BaoDuongIndexController
 */

public class BaoDuongPostDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongPostDangKyController() {
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
		int maTB = Integer.parseInt(request.getParameter("maTB"));
		thietbiModels tbModel = new thietbiModels();
		ThietBi thietBi = tbModel.getThietBi(maTB);
		Date ngayBatDau = Date.valueOf(request.getParameter("ngaybaoduong"));
		Date ngayKetThuc = Date.valueOf(request.getParameter("dukienxong"));
		if(ngayBatDau.after(ngayKetThuc)) {
			response.sendRedirect(request.getContextPath() + "/baoduong-dangky?maTB="+maTB+"&err=bd-kt");
			return;
		}
		if(ngayBatDau.before(new java.util.Date())) {
			response.sendRedirect(request.getContextPath() + "/baoduong-dangky?maTB="+maTB+"&err=ht");
			return;
		}
		String lyDoBaoDuong = new String(request.getParameter("lydobaoduong").getBytes("ISO-8859-1"),"UTF-8");
		
		baoduongModel bdModel = new baoduongModel();
		ThongTinBaoDuong.Builder builder = new ThongTinBaoDuong.Builder();
		ThongTinBaoDuong ttbd = builder.setMaTB(thietBi.getMaTB())
										.setMaNV(2)//chua co session
										.setMaLoaiTB(thietBi.getMaLoaiTB())
										.setTinhTrang(1)//mac dinh
										.setLyDoBaoDuong(lyDoBaoDuong)
										.setNgayBatDau(ngayBatDau)
										.setNgayKetThuc(ngayKetThuc)
										.build();
		boolean dangKy = bdModel.DangKyBaoDuong(ttbd);
		if(dangKy) {
			response.sendRedirect(request.getContextPath() + "/baoduong?msg=success");
			return;
		}
		response.sendRedirect(request.getContextPath() + "/baoduong?msg=fail");	
	}

}
