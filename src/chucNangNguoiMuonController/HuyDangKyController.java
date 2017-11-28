package chucNangNguoiMuonController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.thongtindangkyModels;

/**
 * Servlet implementation class HuyDangKyController
 */
public class HuyDangKyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuyDangKyController() {
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
		int maTTDK = Integer.parseInt(request.getParameter("maTTDK"));
		
		if(mTTDK.HuyDangKy(maTTDK) == 1) { //Huy thanh cong
			response.sendRedirect(request.getContextPath() + "/cnnm-yeucaudagui?msghuy=1");
		} else { //Co loi xay ra
			response.sendRedirect(request.getContextPath() + "cnnm-yeucaudagui?msghuy=0");
		}
	}

}
