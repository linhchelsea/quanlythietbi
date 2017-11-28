<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="beans.ThietBi"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->
<%
	ThietBi thietBi = (ThietBi) request.getAttribute("tb");
	String tenloaiTB = (String) request.getAttribute("tenloai");
	%>

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="<%=request.getContextPath()%>/thietbi">Thiết bị</a></li>
			<li class="breadcrumb-item active">Chi tiết</li>
		</ol>
		<div class="table-responsive">
			<table class="table table-bordered" width="100%" cellspacing="0">
				<tr>
					<td>Mã</td>
					<td><span style="color: red"><%=thietBi.getMaTB() %></span></td>
				</tr>
				<tr>
					<td>Tên thiết bị</td>
					<td><span style="color: blue"><%=thietBi.getTenTB() %></span></td>
				</tr>
				<tr>
					<td>Loại thiết bị</td>
					<td><span style="color: red"><%=tenloaiTB %></span></td>
				</tr>
				<tr>
					<td>Ngày nhập</td>
					<td><span style="color: red"><%=thietBi.getNgayNhap().toString() %></span></td>
				</tr>
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