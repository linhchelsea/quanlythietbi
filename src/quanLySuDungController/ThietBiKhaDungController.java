package quanLySuDungController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ChiTietTTSD;
import beans.ThietBi;
import models.baoduongModel;
import models.chitietTTSDModels;
import models.loaithietbiModels;
import models.thietbiModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class SoLuongKhaDungController
 */
public class ThietBiKhaDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThietBiKhaDungController() {
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
		int maLoaiTB = Integer.parseInt(request.getParameter("maLoaiTB"));
		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
		thietbiModels mThietBi = new thietbiModels();
		ArrayList<ThietBi> alThietBi = mThietBi.getListKhaDung(maLoaiTB);
		
		out.println("<span style=\"font-weight: bold;\">Số lượng khả dụng: </span><span id=\"modal-bg-khaDung\">" + alThietBi.size() +"</span>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">#</th>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">Mã thiết bị</th>");
			out.println("<th class=\"text-center\" style=\"padding: 0 15px;\">Tên thiết bị</th>");
			out.println("<th style=\"padding: 0 15px;\">Chọn</th>");
		out.println("</tr>");
		int i = 1;
		for (ThietBi objThietBi : alThietBi) {
			out.println("<tr>");
				out.println("<td class=\"text-center\">" + i + "</td>");
				out.println("<td class=\"text-center\">" + objThietBi.getMaTB() +"</td>");
				out.println("<td class=\"text-center\">" + objThietBi.getTenTB() + "</td>");
				out.print("<td class=\"text-center\"><input class=\"thietbi\" id=\"thietbi_" + i + "\" onclick=\"daChon(" +i+", " +soLuong+");\" type=\"checkbox\" name=\"thietbi\" value=\"" + objThietBi.getMaTB() + "\"></td>");
			out.println("/<tr>");
			i++;
		}
		out.println("<tr>");
	  		out.println("<td class=\"text-center\" style=\"font-weight: bold; color: red;\" colspan=\"3\">Đã chọn</td>");
	  		out.println("<td class=\"text-center\" style=\"font-weight: bold; color: red;\" id=\"dachon\">0</td>");
	  	out.println("</tr>");
	  	out.println("</table>");
	}
}
