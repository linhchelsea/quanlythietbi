<%@page import="beans.LoaiThietBi"%>
<%@page import="beans.ThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->
<%
	ArrayList<ThietBi> alThietBi = (ArrayList<ThietBi>) request.getAttribute("alThietBi");
%>

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Thiết bị</a></li>
			<li class="breadcrumb-item active">Danh sách</li>
		</ol>
		<div class="col-md-12" style="margin-bottom: 10px">
			<div class="col-md-6" style="margin-bottom: 10px">
				<a href="<%=request.getContextPath()%>/thietbi-them"
					class="btn btn-success">THÊM THIẾT BỊ</a> <a
					href="<%=request.getContextPath()%>/thietbi-timkiem"
					class="btn btn-primary"><i class="fa fa-search"
					aria-hidden="true"></i>TÌM KIẾM</a>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-striped" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>#</th>
						<th>Tên thiết bị</th>
						<th>Loại thiết bị</th>
						<th class="text-center">Ngày nhập</th>
						<th class="text-center" colspan="3">Chi tiết</th>
					</tr>
				</thead>
				<tbody>
				<% for(ThietBi item: alThietBi) { %>
					<tr>
						<td><%=item.getMaTB() %></td>
						<td><%=item.getTenTB() %></td>
						<td><%=item.getMaLoaiTB() %></td>
						<td class="text-center"><%=item.getNgayNhap() %></td>
						<td class="text-center"><a
							href="<%=request.getContextPath()%>/thietbi-sua?type=load&id=<%=item.getMaTB() %>"
							class="btn btn-warning">Sửa</a> <a
							href="<%=request.getContextPath()%>/thietbi-xoa"
							class="btn btn-danger">Xóa</a> <a
							href="<%=request.getContextPath()%>/thietbi-chitiet"
							class="btn btn-success">Chi tiết</a>
					</tr>
					<%} %>
				</tbody>
			</table>
		</div>
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