package baoDuongController;

import java.io.IOException;
import java.sql.Date;

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

public class BaoDuongCapNhatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongCapNhatController() {
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
		baoduongModel bdModel = new baoduongModel();
		int MaTTBD = Integer.parseInt(request.getParameter("ttbd"));
		ThongTinBaoDuong baoDuong = bdModel.getTTBD(MaTTBD);
		if(baoDuong == null) {
			System.out.println("ahihi");
			response.sendRedirect(request.getContextPath()+"/baoduong/not-found");
			return;
		}
		if(request.getParameter("capnhat") != null) {
			Date ngayBatDau = Date.valueOf(request.getParameter("ngaybaoduong"));
			Date ngayKetThuc = Date.valueOf(request.getParameter("dukienxong"));
			if(ngayBatDau.after(ngayKetThuc)) {
				response.sendRedirect(request.getContextPath() + "/baoduong-capnhat?ttbd="+MaTTBD+"&err=bd-kt");
				return;
			}
			String lyDoBaoDuong = new String(request.getParameter("lydobaoduong").getBytes("ISO-8859-1"),"UTF-8");
			ThongTinBaoDuong.Builder bdBuilder = new ThongTinBaoDuong.Builder();
			ThongTinBaoDuong ttbd = bdBuilder
									.setMaTTBD(MaTTBD)
									.setNgayBatDau(ngayBatDau)
									.setNgayKetThuc(ngayKetThuc)
									.setLyDoBaoDuong(lyDoBaoDuong)
									.build();
			boolean capNhat = bdModel.capNhatBaoDuong(ttbd);
			String Msg = "Upadte unsuccessfully!";
			if(capNhat) {
				Msg = "Update successfully!";
			}
			response.sendRedirect(request.getContextPath()+"/baoduong-capnhat?ttbd="+MaTTBD+"&msg="+Msg);
		}else {	
			request.setAttribute("baoDuong", baoDuong);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlybaoduong//baoduong-capnhat.jsp");
			rd.forward(request, response);
		}		
	}

}
