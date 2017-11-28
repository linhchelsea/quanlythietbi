package quanLySuDungController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.thongtinsudungModels;

/**
 * Servlet implementation class KetThucSuDungController
 */
@WebServlet("/KetThucSuDungController")
public class KetThucSuDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KetThucSuDungController() {
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
		int maTTSD = Integer.parseInt(request.getParameter("maTTSD"));
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		
		if (mTTSD.SuaTinhTrang(3, maTTSD) == 1) {
			response.sendRedirect(request.getContextPath() + "/qlsd-capnhatsudung?msgketthuc=1");
		} else {
			response.sendRedirect(request.getContextPath() + "/qlsd-capnhatsudung?msgketthuc=0");
		}
	}

}
