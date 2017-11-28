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
import models.loaithietbiModels;
import models.thietbiModels;
import models.thongtindangkyModels;

/**
 * Servlet implementation class DanhSachThietBiController
 */
public class YeuCauDaGuiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YeuCauDaGuiController() {
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
		
		int maND = 4;
		
		//Lay danh sach TTDK
		thongtindangkyModels mTTDK = new thongtindangkyModels();
		ArrayList<ThongTinDangKy> alTTDK = mTTDK.getListByMaND(maND);
		
		request.setAttribute("alTTDK", alTTDK);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chucnangnguoimuon/yeucaudagui.jsp");
		rd.forward(request, response);
	}
}
