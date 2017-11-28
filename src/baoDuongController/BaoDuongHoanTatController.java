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

public class BaoDuongHoanTatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongHoanTatController() {
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
		int ttbd = Integer.parseInt(request.getParameter("ttbd"));
		ThongTinBaoDuong baoDuong = bdModel.getTTBD(ttbd);
		if(baoDuong == null) {
			System.out.println("ahihi");
			response.sendRedirect(request.getContextPath()+"/baoduong/not-found");
			return;
		}
		if(baoDuong.getTinhTrang() == 1) {
			System.out.println("aaaaaaaaaaaa");
			response.sendRedirect(request.getContextPath()+"/baoduong-capnhat?ttbd="+ttbd+"&err=3");
			return;
		}
		boolean hoantat = bdModel.hoanTatBaoDuong(ttbd);
		response.sendRedirect(request.getContextPath()+"/baoduong-capnhat?ttbd="+ttbd+"&hoantat=1");
		return;
	}

}
