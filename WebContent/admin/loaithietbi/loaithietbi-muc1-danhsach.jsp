<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/partial/header.jsp"%>
<!-- Body -->

<div class="content-wrapper">
	<div class="container-fluid">
		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Thiết bị</a></li>
			<li class="breadcrumb-item active">Danh sách</li>
		</ol>
		<div class="col-md-12" style="margin-bottom: 10px ">
			<div class="col-md-3" style="margin-bottom: 10px">
				<a href="<%=request.getContextPath()%>/thietbi-them"
					class="btn btn-success">THÊM DANH MỤC</a> 
			</div>
		</div>

		<div class="table-responsive">
			<table class="table table-striped" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>#</th>
						<th>Tên danh mục</th>
						<th class="text-center" colspan="2">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>Máy chiếu</td>
						<td class="text-center"><a
							href="<%=request.getContextPath()%>/thietbi-sua"
							class="btn btn-warning">Sửa</a> <a
							href="<%=request.getContextPath()%>/thietbi-xoa"
							class="btn btn-danger">Xóa</a></td>

					</tr>
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