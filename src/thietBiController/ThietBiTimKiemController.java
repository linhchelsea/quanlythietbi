package thietBiController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
public class ThietBiTimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThietBiTimKiemController() {
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
			RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-timkiem.jsp");
			rd.forward(request, response);
		} else if (request.getParameter("type").equals("search")) {
			thietbiModels tbModel = new thietbiModels();
			
			int matb = -1;
			String tentb = null;
			int maloaitb = -1;
			Date ngaynhap =null;
			try {
				matb = Integer.parseInt(request.getParameter("matb"));
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			try {
				tentb = request.getParameter("tentb");
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {

				maloaitb = Integer.parseInt(request.getParameter("maloaitb"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				ngaynhap =Date.valueOf(request.getParameter("ngaynhap"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("DATA: "+matb+tentb+maloaitb+ngaynhap);
			ArrayList<ThietBi> listThietBi = tbModel.search(matb, tentb, maloaitb, ngaynhap);
			ArrayList<LoaiThietBi> listLoaiTB = new loaithietbiModels().getList();
			for (ThietBi tb : listThietBi) {
				for (LoaiThietBi loaiThietBi : listLoaiTB) {
					if (loaiThietBi.getMaLoai() == tb.getMaLoaiTB()) {
						tb.setObjLoaiTB(loaiThietBi);
						break;
					}
				}
			}
			request.setAttribute("listTB", listThietBi);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-ketqua-timkiem.jsp");
			rd.forward(request, response);
		} else {
		}
	}

}
