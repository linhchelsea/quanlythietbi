package thietBiController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class ThietBiChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThietBiChiTietController() {
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
		
		//Tìm thiết bị
		int id = Integer.parseInt(request.getParameter("id"));
		thietbiModels tbModels = new thietbiModels();
		ThietBi thietbi = tbModels.getById(id);
		//Tìm tên loại thiết bị
		String tenLoaiTB = "";
		loaithietbiModels loaithietbiModels = new loaithietbiModels();
		ArrayList<LoaiThietBi> listLoaiTB = loaithietbiModels.getList();
		for (LoaiThietBi loaiThietBi : listLoaiTB) {
			if (loaiThietBi.getMaLoai()==thietbi.getMaLoaiTB()) {
				tenLoaiTB = loaiThietBi.getTenLoai();
				break;
			}
		}
		
		request.setAttribute("tb", thietbi);
		request.setAttribute("tenloai", tenLoaiTB);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/thietbi/thietbi-chitiet.jsp");
		rd.forward(request, response);
	}

}
