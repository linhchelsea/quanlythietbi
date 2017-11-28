<%@page import="beans.ThongTinBaoDuong"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="<%=request.getContextPath() %>/baoduong">Quản lý bảo dưỡng</a>
        </li>
        <li class="breadcrumb-item active">Chi tiết</li>
      </ol>
      <div class="col-md-12" style="margin-bottom: 10px">
      	<div class="col-md-6" style="margin-bottom: 10px">
      		<a href="<%=request.getContextPath() %>/baoduong-themthietbi" class="btn btn-primary">Thêm thiết bị bảo dưỡng</a>
      	</div>
      </div>
  		<%
  			ThongTinBaoDuong baoDuong = (ThongTinBaoDuong) request.getAttribute("baoDuong");
  		%>
      <div class="table-responsive">
            <table class="table table-bordered" width="100%" cellspacing="0">
              	<tr>
              		<td>#</td>
              		<td><%= baoDuong.getMaTTBD() %></td>
              	</tr>
              	<tr>
              		<td>Thiết bị</td>
              		<td><%= baoDuong.getObjThietBi().getTenTB() %></td>
              	</tr>
              	<tr>
              		<td>Loại thiết bị</td>
              		<td><%= baoDuong.getObjLoaiThietBi().getTenLoai() %></td>
              	</tr>
              	<tr>
              		<td>Nhân viên</td>
              		<td><%= baoDuong.getObjNguoiDung().getTenND() %></td>
              	</tr>
              	<tr>
              		<td>Tình trạng</td>
              		<td>
              			<%
                  			switch(baoDuong.getTinhTrang()){
                  				case 1:
                  					%>
                  					Đang chờ
                  					<%
                  					break;
                  				case 2:
                  					%>
                  					Đang bảo dưỡng
                  					<%
                  					break;
                  				case 3:
                  					%>
                  					Đã xong
                  					<%
                  					break;
                  			}
                  		%>
              		</td>
              	</tr>
              	<tr>
              		<td>Lý do bảo dưỡng</td>
              		<td><%= baoDuong.getLyDoBaoDuong() %></td>
              	</tr>
              	<tr>
              		<td>Ngày bắt đầu</td>
              		<td><%= baoDuong.getNgayBatDau() %></td>
              	</tr>
              	<tr>
              		<td>Ngày kết thúc</td>
              		<td><%= baoDuong.getNgayKetThuc() %></td>
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
    <%@include file="/partial/footer.jsp" %>