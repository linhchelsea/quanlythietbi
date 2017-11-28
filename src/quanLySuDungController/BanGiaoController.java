package quanLySuDungController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xpath.internal.axes.ChildTestIterator;

import models.chitietTTSDModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class BanGiaoController
 */
public class BanGiaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanGiaoController() {
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
		String listId = request.getParameter("listId");
		int maTTSD = Integer.parseInt(request.getParameter("maTTSD"));
		int maLoaiTB = Integer.parseInt(request.getParameter("maLoaiTB"));
		
		String[] maTBString = listId.split(",");
		int[] maTB = new int[maTBString.length];
		for (int i=0; i< maTBString.length; i++) {
			maTB[i] = Integer.parseInt(maTBString[i]);
		}
		
		chitietTTSDModels mCTSD = new chitietTTSDModels();
		mCTSD.ThemChiTietSudung(maTTSD, maTB, maLoaiTB);
		
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		mTTSD.SuaTinhTrang(2, maTTSD);
		
		mTTSD.UpdateSoLuongMuon(maTTSD, maTB.length);
		response.sendRedirect(request.getContextPath() + "/qlsd-capnhatsudung?msgbangiao=1");
	}

}
