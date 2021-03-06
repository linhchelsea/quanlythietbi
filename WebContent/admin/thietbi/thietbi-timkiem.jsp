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
			<li class="breadcrumb-item active">Tìm kiếm thông tin thiết bị</li>
		</ol>
		<form action="<%=request.getContextPath()%>/thietbi-timkiem?type=search"
			method="POST">
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="ma">Mã</label> <input class="form-control" type="text"
							name="matb">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="tenThietBi">Tên thiết bị</label> <input
							class="form-control" type="text" name="tentb">
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="loaiThietBi">Loại thiết bị <span
							style="color: red">(*)</span></label> <select class="form-control"
							name="maloaitb">
							<%
								ArrayList<LoaiThietBi> listLoaiTB = (ArrayList<LoaiThietBi>) request.getAttribute("listLoaiTB");
								for (LoaiThietBi loai : listLoaiTB) {
									{
							%>
							<option <%if (loai.getMaLoaiCha() == 0) {%> disabled <%}%>
								value="<%=loai.getMaLoai()%>"><%=loai.getMaLoaiCha() == 0 ? ">>>" : ""%><%=loai.getTenLoai()%></option>
							<%
								}
								}
							%>
						</select>
					</div>
				</div>
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngayNhap">Ngày nhập</label> <input
							class="form-control" type="date" name="ngaynhap">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-2">
						<input class="form-control btn btn-warning" type="reset"
							name="Reset" value="NHẬP LẠI">
					</div>
					<div class="col-md-2">
						<input class="form-control btn btn-success" type="submit"
							name="Them" value="Tìm kiếm">
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