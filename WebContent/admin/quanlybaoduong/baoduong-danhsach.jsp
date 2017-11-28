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
          <a href="#">Quản lý bảo dưỡng</a>
        </li>
        <li class="breadcrumb-item active">Danh sách</li>
      </ol>
      <div class="col-md-12" style="margin-bottom: 10px">
      	<div class="col-md-6" style="margin-bottom: 10px">
      		<a href="<%=request.getContextPath() %>/baoduong-themthietbi" class="btn btn-primary">Thêm thiết bị bảo dưỡng</a>
      	</div>
      </div>
  
      <div class="table-responsive">
      <%
      if( request.getParameter("err") != null && request.getParameter("err").equals("0")){
      %>
  		<div class="alert alert-danger"><p><strong>Thiết bị này chưa được đăng ký bảo dưỡng</strong></p></div>
      <%
      }
      if( request.getParameter("huy") != null && request.getParameter("huy").equals("false")){
      %>
      	<div class="alert alert-danger"><p><strong>Hủy đăng ký không thành công!</strong></p></div>
      <%
      }
      if( request.getParameter("huy") != null && request.getParameter("huy").equals("true")){
      %>
         <div class="alert alert-success"><p><strong>Hủy đăng ký thành công!</strong></p></div>
      <%
      }
      %>
            <table class="table table-striped" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th>Tình trạng</th>
                  <th class="text-center">Thông tin</th>
                </tr>
              </thead>
              <tbody>
              <% 
              ArrayList<ThongTinBaoDuong> alBaoDuong = (ArrayList<ThongTinBaoDuong>) request.getAttribute("alBaoDuong");
              for(ThongTinBaoDuong baoDuongObj : alBaoDuong) {%>
                <tr>
                  <td><%= baoDuongObj.getMaTTBD() %></td>
                  <td><%= baoDuongObj.getObjThietBi().getTenTB() %></td>
                  <td><%= baoDuongObj.getObjLoaiThietBi().getTenLoai() %></td>
                  <td>
                  		<%
                  			switch(baoDuongObj.getTinhTrang()){
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
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/baoduong-chitiet?ttbd=<%= baoDuongObj.getMaTTBD() %>" class="btn btn-success">Chi tiết</a>
                  	<a href="<%= request.getContextPath() %>/baoduong-capnhat?ttbd=<%= baoDuongObj.getMaTTBD() %>" class="btn btn-warning">Cập nhật tình trạng bảo dưỡng</a>
                  </td>
                </tr>
              <% } %>
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
    <%@include file="/partial/footer.jsp" %>