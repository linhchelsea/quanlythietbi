<%@page import="library.LibraryFormatDateTime"%>
<%@page import="beans.ThongTinDangKy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <%LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();
      ArrayList<ThongTinDangKy> alTTDK = (ArrayList<ThongTinDangKy>) request.getAttribute("alTTDK"); %>
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Danh sách yêu cầu đã gửi</a>
        </li>
      </ol>
	 	<div>
			<%if (request.getParameter("msghuy") != null && request.getParameter("msghuy").equals("1")) {%>
				<div class="alert alert-success">Hủy đăng ký thành công</div>
			<%} else if (request.getParameter("msghuy") != null && request.getParameter("msghuy").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Hủy không thành công</div>
			<%}%>
		</div>
		<div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center" width="50px">Mã ĐK</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th width="140px">Thời gian đăng ký</th>
                  <th class="text-center">Số lượng</th>
                  <th class="text-center">Tình trạng</th>
                  <th width="190px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
              <%for(ThongTinDangKy objTTDK : alTTDK){ %>
                <tr>
                  <td class="text-center"><%=objTTDK.getMaTTDK() %></td>
                  <td><%=objTTDK.getObjLoaiTB().getTenLoai() %></td>
                  <td><%=objTTDK.getObjLoaiTB().getObjLoaiCha().getTenLoai() %></td>
                  <td><%=lbDateTime.TimestamptoString(objTTDK.getThoiGianDangKy()) %></td>
                  <td class="text-center"><%=objTTDK.getSoLuongDK() %></td>
                  <td class="text-center">
                  	<%if(objTTDK.getTinhTrang() == 1){ %>
                  		Chưa duyệt
                  	<%} else { %>
                  		Từ chối
                  	<%} %>
                  </td>
                  <td>
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet" onclick="ChiTiet(<%=objTTDK.getMaTTDK() %>, <%=objTTDK.getTinhTrang() %>, '<%=objTTDK.getObjLoaiTB().getTenLoai() %>', '<%=objTTDK.getObjLoaiTB().getObjLoaiCha().getTenLoai() %>', <%=objTTDK.getSoLuongDK() %>, '<%=lbDateTime.TimestamptoString(objTTDK.getThoiGianDangKy()) %>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKBatDauSuDung()) %>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKKetThucSuDung()) %>', '<%= objTTDK.getMucDichSuDung()%>');">Chi tiết</button>
                  	<%if(objTTDK.getTinhTrang() == 1){ %>
                  		<button type="submit" class="btn btn-warning" onclick="HuyDangKy(<%=objTTDK.getMaTTDK()%>)">Hủy đăng ký</button>
                  	<%} else { %>
                  		<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModelThongBao" onclick="ThongBao('<%= objTTDK.getThongBao()%>');">Thông báo</button>
                  	<%} %>
                  </td>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    
    <!-- Modal chi tiet-->
	  <div class="modal fade" id="ModelChiTiet" role="dialog">
	    <div class="modal-dialog ">
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Thông tin đăng ký</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	        <table>
	          	<tr>
	          		<td style="font-weight: bold;">Mã đăng ký:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-maDK">1</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Tình trạng</td>
	          		<td style="color: red;" id="modal-tinhTrang">Chưa duyệt</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tên thiết bị:</td>
	          		<td id="modal-tenTB">Màn hình LG</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Loại thiết bị:</td>
	          		<td id="modal-loaiTB">Màn hình</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Số lượng mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-soLuong">10</td>
	          	</tr>
	          </table>
	          <hr>
	          <p style="color: green; font-weight: bold;">Thời gian đăng ký</p>
	          	<span id="modal-thoiGianDK">15/10/2017 8:00 AM</span>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Thời gian sử dụng</th>
	          	<tr>
	          		<td style="font-weight: bold;">Bắt đầu:</td>
	          		<td id="modal-batDau">15/10/2017 8:00 AM</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Kết thúc:</td>
	          		<td id="modal-ketThuc">15/10/2017 8:00 AM</td>
	          	</tr>
	          </table>
	          <hr>
	          <p style="color: green; font-weight: bold;">Mục đích sử dụng</p>
	          <p id="modal-mucDich">Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. </p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	    </div>
	  </div>
    
    <!-- Modal thong bao-->
	  <div class="modal fade" id="ModelThongBao" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Nguyên nhân từ chối</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <p id="modal-thongBao">Mình thích thì mình từ chối thôi</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	<script>
		function ChiTiet(maDK, tinhTrang, tenTB, loaiTB, soLuong, thoiGianDK, batDau, ketThuc, mucDich) {
			document.getElementById("modal-maDK").innerHTML = maDK;
			
			if(tinhTrang == 1){
				document.getElementById("modal-tinhTrang").innerHTML = "Chưa duyệt";
			} else {
				document.getElementById("modal-tinhTrang").innerHTML = "Từ chối";
			}
			
			document.getElementById("modal-tenTB").innerHTML = tenTB;
			document.getElementById("modal-loaiTB").innerHTML = loaiTB;
			document.getElementById("modal-soLuong").innerHTML = soLuong;
			document.getElementById("modal-thoiGianDK").innerHTML = thoiGianDK;
			document.getElementById("modal-batDau").innerHTML = batDau;
			document.getElementById("modal-ketThuc").innerHTML = ketThuc;
			document.getElementById("modal-mucDich").innerHTML = mucDich;
		}
		
		function ThongBao(thongBao) {
			document.getElementById("modal-thongBao").innerHTML = thongBao;
		}
		
		function HuyDangKy(maTTDK){
			var c = confirm("Bạn muốn hủy đăng ký này?");
			if (c == true){
				window.location.href = '<%=request.getContextPath()%>/cnnm-huydangky?maTTDK=' + maTTDK;
			}
		}
	</script>
    <%@include file="/partial/footer.jsp" %>