package userController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.NguoiDung;
import beans.PhongBan;
import models.phongbanModels;
import models.userModels;

/**
 * Servlet implementation class IndexController
 */
public class UserIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserIndexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		userModels mUserModels = new userModels();
		phongbanModels mPhongbanModels =new phongbanModels();
		ArrayList<PhongBan> mPhongBans = mPhongbanModels.getList();
		ArrayList<NguoiDung> mNguoiDungs = mUserModels.getList();
		for (NguoiDung nguoiDung : mNguoiDungs) {
			for (PhongBan phongBan: mPhongBans) {
				if (nguoiDung.getPhongBan()==phongBan.getMaPhongBan()) {
					nguoiDung.setObjPhongBan(phongBan);
				}
			}
		}
		request.setAttribute("listND", mNguoiDungs);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/user-index.jsp");
		rd.forward(request, response);
	}

}
