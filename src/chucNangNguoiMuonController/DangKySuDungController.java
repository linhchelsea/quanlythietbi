package chucNangNguoiMuonController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoaiThietBi;
import beans.ThongTinDangKy;
import library.LibraryFormatDateTime;
import models.loaithietbiModels;
import models.thongtindangkyModels;

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
		LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();
		loaithietbiModels mLoaiTB = new loaithietbiModels();
		thongtindangkyModels mTTDK = new thongtindangkyModels();
		
		if(request.getParameter("type").equals("dangky")) {
			int maNguoiMuon = 4; // get tu sesson
			int maLoai = Integer.parseInt(request.getParameter("maLoaiTB"));
			Timestamp thoiGianDangKy = new Timestamp(new Date().getTime());
			Timestamp batDauSuDung = lbDateTime.DateTimeFormToTimestamp(request.getParameter("batdausudung"));
			Timestamp ketThucSuDung = lbDateTime.DateTimeFormToTimestamp(request.getParameter("ketthucsudung"));
			int soLuongDK = Integer.parseInt(request.getParameter("soluongdangky"));
			String mucDichSuDung = request.getParameter("mucdichsudung");
			
			ThongTinDangKy.Builder builder = new ThongTinDangKy.Builder();
			ThongTinDangKy objTTDK = builder.setMaNguoiMuon(maNguoiMuon)
					.setMaLoaiTB(maLoai)
					.setThoiGianDangKy(thoiGianDangKy)
					.setDKBatDauSuDung(batDauSuDung)
					.setDKKetThucSuDung(ketThucSuDung)
					.setSoLuongDK(soLuongDK)
					.setMucDichSuDung(mucDichSuDung)
					.build();
			if(mTTDK.ThemDangKy(objTTDK) == 1) {
				response.sendRedirect(request.getContextPath() + "/cnnm-danhsachthietbi");
			} else {
				response.sendRedirect(request.getContextPath() + "/cnnm-dangkysudung?type=load&maLoaiTB=" + maLoai);
			}
		} else {
			int maLoaiTB = Integer.parseInt(request.getParameter("maLoaiTB"));
			
			//Lay loai thiet bi
			LoaiThietBi LoaiTB = mLoaiTB.getItemByMaLoai(maLoaiTB);
			request.setAttribute("loaiTB", LoaiTB);
			
			//lay danh sach da dang ky
			request.setAttribute("alTTDK", mTTDK.getListByMaLoai(maLoaiTB));
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/chucnangnguoimuon/dangkysudung.jsp");
			rd.forward(request, response);
		}
	}

}
