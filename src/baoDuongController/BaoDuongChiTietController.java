package baoDuongController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThongTinBaoDuong;
import models.baoduongModel;

/**
 * Servlet implementation class BaoDuongChiTietController
 */
public class BaoDuongChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongChiTietController() {
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
		int MaTTBD = Integer.parseInt(request.getParameter("ttbd"));
		baoduongModel bdModel = new baoduongModel();
		ThongTinBaoDuong baoDuong = bdModel.getTTBD(MaTTBD);
		request.setAttribute("baoDuong", baoDuong);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlybaoduong/baoduong-chitiet.jsp");
		rd.forward(request, response);
	}

}
