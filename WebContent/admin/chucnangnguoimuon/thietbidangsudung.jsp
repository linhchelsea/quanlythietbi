<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="library.LibraryFormatDateTime"%>
<%@page import="beans.ThongTinSuDung"%>
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
			ArrayList<ThongTinSuDung> alTTSD = (ArrayList<ThongTinSuDung>) request.getAttribute("alTTSD");
		%>
		<ol class="breadcrumb">
			<li class="breadcrumb-item active"><a href="#">Danh sách
					thiết bị đang sử dụng</a></li>
		</ol>
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th class="text-center" width="50px">Mã SD</th>
						<th>Tên thiết bị</th>
						<th>Loại thiết bị</th>
						<th>Thời gian bắt đầu</th>
						<th>Thời gian kết thúc</th>
						<th class="text-center">Số lượng</th>
						<th class="text-center">Tình trạng</th>
						<th class="text-center" width="170px">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						long now = new Date().getTime();
					%>
					<%
						for (ThongTinSuDung objTTSD : alTTSD) {
					%>
					<tr <%if (objTTSD.getKetThucSuDung().getTime() <= now) {%>
						style="color: red;" <%}%>>
						<td class="text-center"><%=objTTSD.getMaTTSD()%></td>
						<td><%=objTTSD.getObjTTDK().getObjLoaiTB().getTenLoai()%></td>
						<td><%=objTTSD.getObjTTDK().getObjLoaiTB().getObjLoaiCha().getTenLoai()%></td>
						<td><%=lbDateTime.TimestamptoString(objTTSD.getBatDauSuDung())%></td>
						<td><%=lbDateTime.TimestamptoString(objTTSD.getKetThucSuDung())%></td>
						<td class="text-center"><%=objTTSD.getObjTTDK().getSoLuongDK()%></td>
						<td class="text-center">
							<%
								if (objTTSD.getTinhTrang() == 1) {
							%> Chưa giao <%
								} else {
							%> Đang sử
							dụng <%
								}
							%>
						</td>
						<td class="text-center">
							<button type="button" class="btn btn-outline-info"
								data-toggle="modal" data-target="#ModelChiTiet"
								onclick="ChiTiet(<%=objTTSD.getMaTTSD()%>);">Chi tiết</button>
						</td>
					</tr>
					<%
						}
					%>
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
					<h4 class="modal-title">Danh sách thiết bị sử dụng</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<table>
						<th colspan="2" style="color: green;">Danh sách thiết bị</th>
						<tr>
							<td>
								<table border="1" id="ajax_chitiet">
									
								</table>
							</td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	  function ChiTiet(maTTSD){
				$.ajax({
		      		url: '<%=request.getContextPath()%>/cnnm-chitietsudung',
		           	type: 'POST',
		         	cache: false,
		            data: {
		            	maTTSD: maTTSD
		            },
		            success: function(data){
		            	$("#ajax_chitiet").html(data);
		          	},
		           	error: function (){
		            	//Xử lý nếu có lỗi
		                confirm('Có vấn đề xảy ra');
		            }
		     	});
		}
	  </script>
	<%@include file="/partial/footer.jsp"%>