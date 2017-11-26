package thietBiController;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ThietBi;
import models.thietbiModels;

/**
 * Servlet implementation class ThietBiThemController
 */
public class ThietBiSuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThietBiSuaController() {
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
		thietbiModels thModels = new thietbiModels();
		
		System.out.println("entered thietbisua controller"+request.getParameter("type"));
		
		if (request.getParameter("type").equals("load")) {
			System.out.println("loaded");
			int id = Integer.parseInt(request.getParameter("id"));
			ThietBi thietBi = thModels.getById(id);
			request.setAttribute("tb", thietBi);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-sua.jsp");
			rd.forward(request, response);
		}	
		else if (request.getParameter("type").equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String tentb = request.getParameter("tentb");
			int maloaitb = Integer.parseInt(request.getParameter("maloaitb"));
			Date date = Date.valueOf(request.getParameter("ngaynhap"));
			ThietBi.Builder tbBuilder = new ThietBi.Builder();
			tbBuilder.setTenTB(tentb);
			tbBuilder.setMaTB(id);
			tbBuilder.setMaLoaiTB(maloaitb);
			tbBuilder.setNgayNhap(date);
			if (thModels.chinhSuaThietBi(tbBuilder.build())==1) {
				response.sendRedirect(request.getContextPath()+"/thietbi?editmsg=1");
			}
			else {
				response.sendRedirect(request.getContextPath()+"/thietbi?editmsg=0");
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-sua.jsp");
			rd.forward(request, response);
		}
	}

}
