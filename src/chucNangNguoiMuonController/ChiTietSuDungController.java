package chucNangNguoiMuonController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ChiTietTTSD;
import models.baoduongModel;
import models.chitietTTSDModels;
import models.loaithietbiModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class SoLuongKhaDungController
 */
public class ChiTietSuDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietSuDungController() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		int maTTSD = Integer.parseInt(request.getParameter("maTTSD"));
		
		chitietTTSDModels mChiTietTTSD = new chitietTTSDModels();
		ArrayList<ChiTietTTSD> alChiTietTTSD = mChiTietTTSD.getListByMaTTSD(maTTSD);
		
		out.println("<tr>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">#</th>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">Mã thiết bị</th>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">Tên thiết bị</th>");
		out.println("</tr>");
		int i = 1;
		for (ChiTietTTSD objChiTiet : alChiTietTTSD) {
			out.println("<tr>");
				out.println("<td class=\"text-center\">" + i + "</td>");
				out.println("<td class=\"text-center\">" + objChiTiet.getMaTB() +"</td>");
				out.println("<td class=\"text-center\">" + objChiTiet.getObjThietBi().getTenTB() + "</td>");
			out.println("/<tr>");
			i++;
		}
	}
}
