<%@page import="beans.NguoiDung"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Người dùng</a>
        </li>
        <li class="breadcrumb-item active">Danh sách</li>
      </ol>
      <%if (request.getParameter("delmsg") != null && request.getParameter("delmsg").equals("1")) {%>
				<div class="alert alert-success">Xóa thành công</div>
			<%}%>
		<%if (request.getParameter("delmsg") != null && request.getParameter("delmsg").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Xóa thất bại</div> <%} %>
      <div class="col-md-12" style="margin-bottom: 10px">
      	<a href="<%= request.getContextPath() %>/user-create" class="btn btn-success">THÊM NGƯỜI DÙNG</a>
      </div>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tên đăng nhập</th>
                  <th>Tên người dùng</th>
                  <th>Ngày sinh</th>
                  <th>Chức vụ</th>
                  <th>Phòng ban</th>
                  <th class="text-center">Chi tiết</th>
                </tr>
              </thead>
              <tbody>
              <%ArrayList<NguoiDung> listND = (ArrayList<NguoiDung>) request.getAttribute("listND");
              for (NguoiDung nd: listND) {%>
                <tr>
                  <td><%=nd.getMaND() %></td>
                  <td><%=nd.getTenDangNhap() %></td>
                  <td><%=nd.getTenND() %></td>
                  <td><%=nd.getNgaySinh() %></td>
                  <%if (nd.getPhanQuyen()==1){ %><td>Người mượn</td> <%} %>
                  <% if (nd.getPhanQuyen()==2){ %><td>Nhân viên</td> <%} %>
                  <% if (nd.getPhanQuyen()==3){ %><td>Quản trị viên</td> <%} %>
                  <td><%=nd.getObjPhongBan().getTenPhongBan() %></td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/user-edit?id=<%=nd.getMaND() %>" class="btn btn-success">Sửa</a>
          			<a href="<%= request.getContextPath() %>/user-delete?id=<%=nd.getMaND() %>" class="btn btn-danger">Xóa</a>
                  </td>
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
    <%@include file="/partial/footer.jsp" %>