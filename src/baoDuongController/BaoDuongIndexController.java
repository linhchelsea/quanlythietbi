package baoDuongController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.baoduongModel;

/**
 * Servlet implementation class BaoDuongIndexController
 */

public class BaoDuongIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BaoDuongIndexController() {
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
		baoduongModel mBD = new baoduongModel();
		int sodong = 20;
		int tong = mBD.getTotal();
		int sotrang = (int) Math.ceil((float)tong/sodong);
		int tranghientai = 1;
		if(request.getParameter("page")!=null){
			tranghientai = Integer.parseInt(request.getParameter("page"));
		}
		int offset = (tranghientai-1)*sodong;
		request.setAttribute("alBaoDuong", mBD.getList(offset,sodong));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/quanlybaoduong/baoduong-danhsach.jsp");
		rd.forward(request, response);
	}

}
