<%@page import="beans.ThietBi"%>
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
        <li class="breadcrumb-item active">Đăng ký bảo dưỡng</li>
      </ol>
    <div>
    	<%
    	if( request.getParameter("err") != null &&request.getParameter("err").equals("bd-kt")){
            %>
            <div class="alert alert-danger"><p><strong>Thời gian bắt đầu và dự kiến kết thúc không hợp lệ!</strong></p></div>
            <%
        }
    	if( request.getParameter("err") != null &&request.getParameter("err").equals("ht")){
            %>
            <div class="alert alert-danger"><p><strong>Thời gian bắt đầu không thể trước ngày hiện tại	!</strong></p></div>
            <%
        }
    	ThietBi thietBi = (ThietBi) request.getAttribute("thietBi");
    	%>
         <form method="post" action="<%= request.getContextPath()%>/baoduong/dangky?maTB=<%= thietBi.getMaTB() %>">
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="mathietbi">Mã thiết bị</label>
					 	<input class="form-control" type="text" name="mathietbi" disabled="disabled" value="<%= thietBi.getMaTB() %>" required>
					</div>
					<div class="col-md-6">
						<label for="tenthietbi">Tên thiết bị</label>
					 	<input class="form-control" type="text" name="tenthietbi" disabled="disabled" value="<%= thietBi.getTenTB() %>" required>
					</div>
				</div>
			</div> 
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngaybaoduong">Chọn ngày bảo dưỡng</label>
					 	<input class="form-control" type="date" name="ngaybaoduong" required>
					</div>
					<div class="col-md-6">
						<label for="dukienxong">Dự kiến xong</label>
					 	<input class="form-control" type="date" name="dukienxong" required>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-12">
						<label for="lydobaoduong">Lý do bảo dưỡng</label>
						<textarea  class="form-control" name="lydobaoduong" required ></textarea>
					</div>
				</div>
			</div> 
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
					 	<input class="form-control btn-warning" type="reset" value="Nhập lại">
					</div>
					<div class="col-md-6 text-center">
					 	<input class="form-control btn-success" type="submit" name="submit" value="Đăng ký">
					</div>
				</div>
			</div>
         </form>
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