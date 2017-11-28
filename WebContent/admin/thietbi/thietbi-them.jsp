<%@page import="beans.LoaiThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/thietbi">Thiết bị</a></li>
			<li class="breadcrumb-item active">Thêm thông tin thiết bị</li>
		</ol>
		<%if (request.getParameter("addmsg") != null && request.getParameter("addmsg").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Thêm thất bại</div> <%} %>
		<form action="<%=request.getContextPath() %>/thietbi-them?type=add" method="POST">
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="ma">Mã <span style="color: red">(Không cần nhập)</span></label> <input
							class="form-control" disabled="disabled" type="text" name="matb">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngayNhapThietBi">Ngày nhập thiết bị <span
							style="color: red">(*)</span></label> <input class="form-control"
							type="date" name="ngaynhap">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="tenThietBi">Tên thiết bị<span
							style="color: red">(*)</span></label> <input class="form-control"
							type="text" name="tentb">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="loaiThietBi">Loại thiết bị <span
							style="color: red">(*)</span></label> <select class="form-control"
							name="loaitb">
							<% ArrayList<LoaiThietBi> listLoaiTB = (ArrayList<LoaiThietBi>) request.getAttribute("listLoaiTB"); 
							for (LoaiThietBi loai: listLoaiTB) {  {%>
							<option <%if (loai.getMaLoaiCha()==0) { %> disabled <%} %>value="<%=loai.getMaLoai()%>"><%=loai.getMaLoaiCha()==0? ">>>":""%><%=loai.getTenLoai() %></option>
							<%} }%>
						</select>
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
							name="Them" value="THÊM">
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