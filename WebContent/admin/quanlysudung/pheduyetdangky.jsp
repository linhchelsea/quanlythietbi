<%@page import="library.LibraryFormatDateTime"%>
<%@page import="beans.ThongTinDangKy"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<%
			LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();
			ArrayList<ThongTinDangKy> alTTDK = (ArrayList<ThongTinDangKy>) request.getAttribute("alTTDK");
		%>

		<ol class="breadcrumb">
			<li class="breadcrumb-item active"><a href="#">Phê duyệt
					đăng ký</a></li>
		</ol>
		
		<div>
			<%if (request.getParameter("msgpheduyet") != null && request.getParameter("msgpheduyet").equals("1")) {%>
				<div class="alert alert-success">Phê duyệt đăng ký thành công</div>
			<%} else if (request.getParameter("msgpheduyet") != null && request.getParameter("msgpheduyet").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Tác vụ không thành công</div>
			<%}%>
			
			<%if (request.getParameter("msgtuchoi") != null && request.getParameter("msgtuchoi").equals("1")) {%>
				<div class="alert alert-success">Đăng ký đã được từ chối</div>
			<%} else if (request.getParameter("msgtuchoi") != null && request.getParameter("msgtuchoi").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Tác vụ không thành công</div>
			<%}%>
		</div>
		
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th class="text-center">Mã ĐK</th>
						<th>Người đăng ký</th>
						<th>Tên thiết bị</th>
						<th>Loại thiết bị</th>
						<th class="text-center">Số lượng</th>
						<th>Thời gian đăng ký</th>
						<th class="text-center" width="270px">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (ThongTinDangKy objTTDK : alTTDK) {
					%>
					<tr>
						<td class="text-center"><%=objTTDK.getMaTTDK()%></td>
						<td>Phan Thanh Thuận</td>
						<td><%=objTTDK.getObjLoaiTB().getTenLoai()%></td>
						<td><%=objTTDK.getObjLoaiTB().getObjLoaiCha().getTenLoai()%></td>
						<td class="text-center"><%=objTTDK.getSoLuongDK()%></td>
						<td><%=lbDateTime.TimestamptoString(objTTDK.getThoiGianDangKy())%></td>
						<td class="text-center">
							<button type="button" class="btn btn-outline-info"
								data-toggle="modal" data-target="#ModelChiTiet"
								onclick="ChiTiet(<%=objTTDK.getMaNguoiMuon()%>, '<%=objTTDK.getObjNguoiDung().getTenND()%>', '<%=objTTDK.getObjNguoiDung().getObjPhongBan().getTenPhongBan()%>', '<%=objTTDK.getObjNguoiDung().getObjChucVu().getTenChucVu()%>', '<%=objTTDK.getObjLoaiTB().getTenLoai()%>', '<%=objTTDK.getObjLoaiTB().getObjLoaiCha().getTenLoai()%>', <%=objTTDK.getSoLuongDK()%>, '<%=lbDateTime.TimestamptoString(objTTDK.getThoiGianDangKy())%>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKBatDauSuDung())%>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKKetThucSuDung())%>', '<%=objTTDK.getMucDichSuDung()%>');">Chi
								tiết</button>
							<button type="button" class="btn btn-success" data-toggle="modal" data-target="#ModelConfirm" onclick="getTTDKTrung(<%=objTTDK.getMaLoaiTB()%>, <%=objTTDK.getDKBatDauSuDung().getTime()%>, <%=objTTDK.getDKKetThucSuDung().getTime()%>);">Phê duyệt</button>
							<button type="button" class="btn btn-danger" data-toggle="modal"
								data-target="#ModelTuChoi" onclick="TuChoi(<%=objTTDK.getMaTTDK()%>)">Từ chối</button>
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

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
						<th colspan="2" style="color: green;">Thông tin người mượn</th>
						<tr>
							<td style="font-weight: bold;">Mã người
								dùng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="modal-maND"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Họ tên:</td>
							<td id="modal-tenND"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Phòng ban:</td>
							<td id="modal-phongBan"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Chức vụ:</td>
							<td id="modal-chucVu"></td>
						</tr>
					</table>
					<hr>
					<table>
						<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
						<tr>
							<td style="font-weight: bold;">Tên thiết bị:</td>
							<td id="modal-tenTB"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Loại thiết bị:</td>
							<td id="modal-loaiTB"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Số lượng
								mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td id="modal-soLuong"></td>
						</tr>
					</table>
					<hr>
					<p style="color: green; font-weight: bold;">Thời gian đăng ký</p>
					<span id="modal-dangKy"></span>
					<hr>
					<table>
						<th colspan="2" style="color: green;">Thời gian sử dụng</th>
						<tr>
							<td style="font-weight: bold;">Bắt đầu:</td>
							<td id="modal-batDau"></td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Kết thúc:</td>
							<td id="modal-ketThuc"></td>
						</tr>
					</table>
					<hr>
					<p style="color: green; font-weight: bold;">Mục đích sử dụng</p>
					<p id="modal-mucDich"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal tu choi-->
	<div class="modal fade" id="ModelTuChoi" role="dialog">
		<div class="modal-dialog ">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Lý do từ chối</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form method="post" action="<%=request.getContextPath()%>/qlsd-tuchoi" id="form-tuchoi">
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<input type="hidden" name="maTTDK" value="" id="modal-maTTDK">
									<textarea class="form-control" rows="5" name="thongBao"></textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" form="form-tuchoi" class="btn btn-warning">Xác nhận</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal confirm phe duyet-->
	<div class="modal fade" id="ModelConfirm" role="dialog">
		<div class="modal-dialog ">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Xác nhận phê duyệt</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<p>Sau khi bạn phê duyệt đăng ký này, các đăng ký khác trùng ngày với đăng ký này mà không đảm bảo số lượng khả dụng sẽ bị <span style="color: red; font-weight: bold;">"Từ Chối"</span>.</p>
					<form>
						<div class="form-group">
							<div class="form-row">
								<div class="col-md-12">
									<table class="table table-bordered">
					                	<thead>
							                <tr>
							                  <th class="text-center" width="50px">Mã DK</th>
							                  <th>Bắt đầu</th>
							                  <th>Kết thúc</th>
							                  <th class="text-center" width="100px">Xem chi tiết</th>
							                </tr>
							              </thead>
							              <tbody>
							              <%for (ThongTinDangKy objTTDK : alTTDK){ %>
							                <tr>
							                  <td class="text-center"><%=objTTDK.getMaTTDK() %></td>
							                  <td><%=lbDateTime.TimestamptoString(objTTDK.getDKBatDauSuDung()) %></td>
							                  <td><%=lbDateTime.TimestamptoString(objTTDK.getDKKetThucSuDung()) %></td>
							                  <td class="text-center"><button type="button" class="btn btn-outline-info"
								data-toggle="modal" data-target="#ModelChiTiet"
								onclick="ChiTiet(<%=objTTDK.getMaNguoiMuon()%>, '<%=objTTDK.getObjNguoiDung().getTenND()%>', '<%=objTTDK.getObjNguoiDung().getObjPhongBan().getTenPhongBan()%>', '<%=objTTDK.getObjNguoiDung().getObjChucVu().getTenChucVu()%>', '<%=objTTDK.getObjLoaiTB().getTenLoai()%>', '<%=objTTDK.getObjLoaiTB().getObjLoaiCha().getTenLoai()%>', <%=objTTDK.getSoLuongDK()%>, '<%=lbDateTime.TimestamptoString(objTTDK.getThoiGianDangKy())%>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKBatDauSuDung())%>', '<%=lbDateTime.TimestamptoString(objTTDK.getDKKetThucSuDung())%>', '<%=objTTDK.getMucDichSuDung()%>');">Chi
								tiết</button></td>
							                </tr>
							               <%} %>
							              </tbody>
                </table>									
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-warning">Xác nhận</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		function getTTDKTrung(maLoai, batDau, ketThuc){
			$.ajax({
	      		url: '<%=request.getContextPath()%>/qlsd-danhsachtrung',
	           	type: 'POST',
	         	cache: false,
	            data: {
	            	maLoai: maLoai,
	            	batDau: batDau,
	            	ketThuc: ketThuc
	            },
	            success: function(data){
	            	alert("sdfds");
	          	},
	           	error: function (){
	            	//Xử lý nếu có lỗi
	                confirm('Có vấn đề xảy ra');
	            }
	     	});
		}
	
		function ChiTiet(maND, tenND, phongBan, chucVu, tenTB, loaiTB, soLuong, dangKy, batDau, ketThuc, mucDich) {
			document.getElementById("modal-maND").innerHTML = maND;
			document.getElementById("modal-tenND").innerHTML = tenND;
			document.getElementById("modal-phongBan").innerHTML = phongBan;
			document.getElementById("modal-chucVu").innerHTML = chucVu;
			document.getElementById("modal-tenTB").innerHTML = tenTB;
			document.getElementById("modal-loaiTB").innerHTML = loaiTB;
			document.getElementById("modal-soLuong").innerHTML = soLuong;
			document.getElementById("modal-dangKy").innerHTML = dangKy;
			document.getElementById("modal-batDau").innerHTML = batDau;
			document.getElementById("modal-ketThuc").innerHTML = ketThuc;
			document.getElementById("modal-mucDich").innerHTML = mucDich;
		}
		
		function TuChoi(maTTDK) {
			document.getElementById("modal-maTTDK").value = maTTDK;
		}
		
		  function PheDuyet(maTTDK, maNguoiMuon, dkBatDauSuDung, dkKetThucSuDung, soLuong, maLoaiTB){
			  var conf = confirm("Bạn muốn phê duyệt đăng ký này?");
			  if(conf == true){
				  window.location.href = '<%=request.getContextPath()%>/qlsd-pheduyet?maTTDK=' + maTTDK + '&maNguoiMuon=' + maNguoiMuon + '&dkBatDauSuDung=' + dkBatDauSuDung + '&dkKetThucSuDung=' + dkKetThucSuDung + '&soLuong=' + soLuong + '&maLoaiTB=' + maLoaiTB;
			  }
			}
	</script>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<%@include file="/partial/footer.jsp"%>