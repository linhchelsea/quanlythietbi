package baoDuongController;

import java.io.IOException;
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

public class BaoDuongDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongDangKyController() {
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
		ThietBi thiebi = tbModel.getThietBi(maTB);
		if(thiebi == null) {
			response.sendRedirect(request.getContextPath()+"/baoduong/not-found");
			return;
		}
		//Kiem tra thiet bi nay da bao duong xong chua
		baoduongModel bdModel = new baoduongModel();
		ThongTinBaoDuong ttbd = bdModel.getTTBDByMaThietBi(maTB);
		if(ttbd != null && ttbd.getTinhTrang() != 3 ) {
			response.sendRedirect(request.getContextPath()+"/baoduong-themthietbi?dangky=0");
			return;
		}
		ThietBi thietBi = tbModel.getThietBi(maTB);
		request.setAttribute("thietBi", thietBi);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlybaoduong/baoduong-dangky.jsp");
		rd.forward(request, response);
	}

}
