package chucNangNguoiMuonController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoaiThietBi;
import models.loaithietbiModels;

/**
 * Servlet implementation class DangKySuDungController
 */
public class DangKySuDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKySuDungController() {
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
		loaithietbiModels mLoaiTB = new loaithietbiModels();
		
		//Lay loai thiet bi
		int maLoaiTB = Integer.parseInt(request.getParameter("maLoaiTB"));
		LoaiThietBi LoaiTB = mLoaiTB.getItemByMaLoai(maLoaiTB);
		request.setAttribute("loaiTB", LoaiTB);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/chucnangnguoimuon/dangkysudung.jsp");
		rd.forward(request, response);
	}

}
