<%@page import="beans.LoaiThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.ThietBi"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->

<%
	ThietBi thietBi = (ThietBi) request.getAttribute("tb");
%>

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Thiết bị</a></li>
			<li class="breadcrumb-item active">Sửa thông tin thiết bị</li>
		</ol>
		<%if (request.getParameter("editmsg") != null && request.getParameter("editmsg").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Chỉnh sửa thất bại</div>
			<%}%>
		<form action="<%=request.getContextPath() %>/thietbi-sua?type=edit&id=<%=thietBi.getMaTB() %>" method="POST">
			<div class="form-group">
			
				<div class="form-row">
					<div class="col-md-6">
						<label for="ma">Mã <span style="color: red">(*)</span></label> <input
							class="form-control" disabled="disabled" type="text" name="ma" value="<%=thietBi.getMaTB()%>">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="tenThietBi">Tên thiết bị<span
							style="color: red">(*)</span></label> <input class="form-control"
							type="text" name="tentb" value="<%=thietBi.getTenTB()%>">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="loaiThietBi">Loại thiết bị <span
							style="color: red">(*)</span></label> 
							<select class="form-control"
							name="maloaitb">
							<% ArrayList<LoaiThietBi> listLoaiTB = (ArrayList<LoaiThietBi>) request.getAttribute("listLoaiTB"); 
							for (LoaiThietBi loai: listLoaiTB) {  {%>
							<option <% if (loai.getMaLoai()==thietBi.getMaLoaiTB())%> selected="selected" <% %> <%if (loai.getMaLoaiCha()==0) { %> disabled <%} %>
								value="<%=loai.getMaLoai()%>"><%=loai.getMaLoaiCha()==0? ">>>":""%><%=loai.getTenLoai() %></option>
							<%} }%>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngayNhapThietBi">Ngày nhập thiết bị</label> 
						<input
							class="form-control" type="date" name="ngaynhap" value="<%=thietBi.getNgayNhap()%>">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-2">
						<a href="<%=request.getContextPath() %>/thietbi" class="form-control btn btn-danger">HỦY</a>
					</div>
					<div class="col-md-2">
						<input class="form-control btn btn-warning" type="reset"
							name="Reset" value="NHẬP LẠI">
					</div>
					<div class="col-md-2">
						<input class="form-control btn btn-success" type="submit"
							name="Them" value="SỬA">
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Your Website 2017</small>
			</div>
		</div>

		<!-- Start footer -->
		<%@include file="/partial/footer.jsp"%>
	</footer>
</div>