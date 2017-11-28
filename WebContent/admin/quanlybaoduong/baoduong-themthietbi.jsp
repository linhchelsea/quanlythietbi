<%@page import="beans.ThietBi"%>
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
          <a href="<%=request.getContextPath() %>/baoduong">Quản lý bảo dưỡng</a>
        </li>
        <li class="breadcrumb-item active">Thêm thiết bị bảo dưỡng</li>
      </ol>
  		<%
  		if( request.getParameter("dangky") != null &&request.getParameter("dangky").equals("0")){
            %>
                <div class="alert alert-danger"><p><strong>Thiết bị này hiện tại đang được bảo dưỡng</strong></p></div>
            <%
        }
  		ArrayList<ThietBi> alThietBi = (ArrayList<ThietBi>) request.getAttribute("alThietBi");
  		%>
      <div class="table-responsive">
            <table class="table table-striped" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Mã</th>
                  <th>Tên thiết bị</th>
                  <th>Tình trạng</th>
                  <th class="text-center">Thông tin</th>
                </tr>
              </thead>
              <tbody>
              <%
              	for(ThietBi thietBi : alThietBi){
              %>
                <tr>
                  <td><%= thietBi.getMaTB() %></td>
                  <td><%= thietBi.getTenTB() %></td>
                  <td>Đang sử dụng</td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/baoduong-chitiet?maTB=<%= thietBi.getMaTB() %>" class="btn btn-success">Chi tiết</a>
          			<a href="<%= request.getContextPath() %>/baoduong-dangky?maTB=<%= thietBi.getMaTB() %>" class="btn btn-warning">Đăng ký bảo dưỡng</a>
                  </td>
                </tr>
                <%} %>
              </tbody>
            </table>
          </div>
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