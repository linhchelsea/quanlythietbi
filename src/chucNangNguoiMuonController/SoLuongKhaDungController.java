package chucNangNguoiMuonController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.baoduongModel;
import models.loaithietbiModels;
import models.thongtinsudungModels;

/**
 * Servlet implementation class SoLuongKhaDungController
 */
public class SoLuongKhaDungController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SoLuongKhaDungController() {
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
		PrintWriter out = response.getWriter();
		int maLoai = Integer.parseInt(request.getParameter("maTB"));
		Long batDau = Long.parseLong(request.getParameter("batDau"));
		Long ketThuc = Long.parseLong(request.getParameter("ketThuc"));
		int soLuongKhaDung = 0;
		
		//Tinh so luong kha dung
		//Tong so luong
		loaithietbiModels mLoaiTB = new loaithietbiModels();
		int tongSoLuong = mLoaiTB.getSoLuong(maLoai);
		//So thiet bi dang su dung
		thongtinsudungModels mTTSD = new thongtinsudungModels();
		int soLuongDangSuDung = mTTSD.getSoLuongDangSuDung(maLoai, new Timestamp(batDau), new Timestamp(ketThuc));
		//so thiet bi dang bao duong
		baoduongModel mBaoDuong = new baoduongModel();
		int soLuongBaoDuong = mBaoDuong.getSoLuongDangBaoDuong(maLoai, new Timestamp(batDau), new Timestamp(ketThuc));
		//So luong kha dung
		soLuongKhaDung = tongSoLuong - (soLuongDangSuDung + soLuongBaoDuong);
		
		//tra ve so luong kha dung
		out.print(soLuongKhaDung);
		request.setAttribute("soLuongKhaDung", soLuongKhaDung);
	}

}