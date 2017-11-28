package chucNangNguoiMuonController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThongTinDangKy;
import beans.ThongTinSuDung;
import models.loaithietbiModels;
import models.thietbiModels;
import models.thongtindangkyModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class DanhSachThietBiController
 */
public class ThietBiDangSuDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThietBiDangSuDungController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		int maND = 5;
		
		//Lay danh sach TTSD
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		ArrayList<ThongTinSuDung> alTTSD = mTTSD.getListByMaND(maND);
		
		request.setAttribute("alTTSD", alTTSD);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chucnangnguoimuon/thietbidangsudung.jsp");
		rd.forward(request, response);
	}
}
