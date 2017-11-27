package thietBiController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoaiThietBi;
import beans.ThietBi;
import models.loaithietbiModels;
import models.thietbiModels;

/**
 * Servlet implementation class ThietBiThemController
 */
public class ThietBiThemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThietBiThemController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("type").equals("load")) {
			ArrayList<LoaiThietBi> listLoaiTB = new loaithietbiModels().getList();
			ArrayList<LoaiThietBi> sortedListLoaiTB = new ArrayList<>();
			for (LoaiThietBi loaicha : listLoaiTB) {
				if (loaicha.getMaLoaiCha() == 0) {
					sortedListLoaiTB.add(loaicha);
					for (LoaiThietBi loaicon : listLoaiTB) {
						if (loaicon.getMaLoaiCha() == loaicha.getMaLoai())
							sortedListLoaiTB.add(loaicon);
					}
				}
			}
			request.setAttribute("listLoaiTB", sortedListLoaiTB);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-them.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("type").equals("add")) {
			int maloai = Integer.valueOf(request.getParameter("loaitb"));
			Date ngaynhap = Date.valueOf(request.getParameter("ngaynhap"));
			String tentb = request.getParameter("tentb");
			ThietBi.Builder tbBuilder = new ThietBi.Builder();
			tbBuilder.setMaLoaiTB(maloai);
			tbBuilder.setNgayNhap(ngaynhap);
			tbBuilder.setTenTB(tentb);
			ThietBi thietBi = tbBuilder.build();
			thietbiModels tbModel = new thietbiModels();
			if (tbModel.themThietBi(thietBi) == 1) {
				response.sendRedirect(request.getContextPath() + "/thietbi?addmsg=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/thietbi-them?type=load&addmsg=0");
			}
		} else {
		}
	}

}
