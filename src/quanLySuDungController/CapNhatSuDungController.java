package quanLySuDungController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThongTinSuDung;
import models.thongtinsudungModels;

/**
 * Servlet implementation class C
 */
@WebServlet("/C")
public class CapNhatSuDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatSuDungController() {
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
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		ArrayList<ThongTinSuDung> alTTSD = mTTSD.getList();
		request.setAttribute("alTTSD", alTTSD);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlysudung/capnhatsudung.jsp");
		rd.forward(request, response);
	}
}
