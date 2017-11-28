package quanLySuDungController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThongTinDangKy;
import models.thongtindangkyModels;

/**
 * Servlet implementation class PheDuyetDangKyController
 */
public class PheDuyetDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PheDuyetDangKyController() {
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
		ArrayList<ThongTinDangKy> alTTDK = mTTDK.getList();
		request.setAttribute("alTTDK", alTTDK);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlysudung/pheduyetdangky.jsp");
		rd.forward(request, response);
	}
}
