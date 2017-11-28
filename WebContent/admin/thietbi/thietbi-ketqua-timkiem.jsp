<%@page import="beans.ThietBi"%>
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
			<li class="breadcrumb-item active">Kết quả tìm kiếm</li>
		</ol>
		<div class="col-md-12" style="margin-bottom: 10px">
			<div class="col-md-6" style="margin-bottom: 10px">
				<a href="<%=request.getContextPath()%>/thietbi-timkiem?type=load"
					class="btn btn-warning">TÌM KIẾM</a>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-striped" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>#</th>
						<th>Tên thiết bị</th>
						<th>Tên loại</th>
						<th>Ngày nhập</th>
					</tr>
				</thead>
				<tbody>
					<%
					ArrayList<ThietBi> listThietBi = (ArrayList<ThietBi>) request.getAttribute("listTB");
					for (ThietBi tb: listThietBi) {
					%>
					<tr>
						<td><%=tb.getMaTB() %></td>
						<td><%=tb.getTenTB() %></td>
						<td><%=tb.getObjLoaiTB().getTenLoai() %></td>
						<td><%=tb.getNgayNhap() %></td>
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