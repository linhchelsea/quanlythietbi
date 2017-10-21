<%@page import="beans.BaoDuong"%>
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
            <table class="table table-striped" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tên thiết bị</th>
                  <th>Mã</th>
                  <th>Người/ Phòng sử dụng</th>
                  <th>Tình trạng</th>
                  <th>Thông tin</th>
                </tr>
              </thead>
              <tbody>
              <% 
              ArrayList<BaoDuong> alBaoDuong = (ArrayList<BaoDuong>) request.getAttribute("alBaoDuong");
              for(BaoDuong baoDuongObj : alBaoDuong) {%>
                <tr>
                  <td><%= baoDuongObj.getMaTTBD() %></td>
                  <td><%= baoDuongObj.getMaLoaiTB() %></td>
                  <td><%= baoDuongObj.getMaLoaiTB() %></td>
                  <td>Phòng F302</td>
                  <td><%= baoDuongObj.getTinhTrang() %></td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/baoduong-chitiet" class="btn btn-success">Chi tiết</a>
                  	<a href="<%= request.getContextPath() %>/baoduong-capnhat" class="btn btn-warning">Cập nhật tình trạng bảo dưỡng</a>
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