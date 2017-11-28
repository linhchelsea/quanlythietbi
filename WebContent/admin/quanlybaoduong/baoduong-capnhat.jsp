<%@page import="beans.ThongTinBaoDuong"%>
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
        <li class="breadcrumb-item active">Cập nhật bảo dưỡng</li>
      </ol>
      
    <div>
    	<%
    	if( request.getParameter("err") != null &&request.getParameter("err").equals("bd-kt")){
            %>
            <div class="alert alert-danger"><p><strong>Thời gian bắt đầu và dự kiến kết thúc không hợp lệ!</strong></p></div>
            <%
        }
        if( request.getParameter("err") != null &&request.getParameter("err").equals("1")){
        %>
        <div class="alert alert-danger"><p><strong>Thiết bị này đang được bảo dưỡng hoặc đã bảo dưỡng xong</strong></p></div>
        <%
        }
    	if( request.getParameter("err") != null &&request.getParameter("err").equals("3")){
            %>
            <div class="alert alert-danger"><p><strong>Thiết bị này đang ở trạng thái chờ bảo dưỡng</strong></p></div>
            <%
            }
    	if( request.getParameter("hoantat") != null &&request.getParameter("hoantat").equals("1")){
        %>
            <div class="alert alert-success"><p><strong>Thiết bị này đã bảo dưỡng xong</strong></p></div>
        <%
        }
    	if( request.getParameter("tienhanh") != null &&request.getParameter("tienhanh").equals("1")){
            %>
                <div class="alert alert-success"><p><strong>Thiết bị này đã được bàn giao cho bộ phận kỹ thuật</strong></p></div>
            <%
        }
    	ThongTinBaoDuong baoDuong = (ThongTinBaoDuong) request.getAttribute("baoDuong");
    	%>
         <form method="post" action="<%= request.getContextPath()%>/baoduong-capnhat?ttbd=<%=baoDuong.getMaTTBD()%>">
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="mathietbi">Mã thiết bị</label>
					 	<input class="form-control" type="text" name="mathietbi" disabled="disabled" value="<%= baoDuong.getObjThietBi().getMaTB() %>">
					</div>
					<div class="col-md-6">
						<label for="tenthietbi">Tên thiết bị</label>
					 	<input class="form-control" type="text" name="tenthietbi" disabled="disabled" value="<%= baoDuong.getObjThietBi().getTenTB() %>">
					</div>
				</div>
			</div> 
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngaybaoduong">Chọn ngày bảo dưỡng</label>
					 	<input class="form-control" type="date" name="ngaybaoduong" value="<%= baoDuong.getNgayBatDau() %>">
					</div>
					<div class="col-md-6">
						<label for="dukienxong">Dự kiến xong</label>
					 	<input class="form-control" type="date" name="dukienxong" value="<%= baoDuong.getNgayKetThuc() %>">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-12">
						<label for="lydobaoduong">Lý do bảo dưỡng</label>
						<textarea  class="form-control" name="lydobaoduong"><%= baoDuong.getLyDoBaoDuong() %></textarea>
					</div>
				</div>
			</div> 
			<div class="form-group">
				<div class="form-row">
					<% if(baoDuong.getTinhTrang() == 1){%>
					<div class="col-md-6 text-center">
						<a href="<%= request.getContextPath() %>/baoduong/huydangky?ttbd=<%=baoDuong.getMaTTBD()%>" class="form-control btn-warning">Hủy đăng ký bảo dưỡng</a>
					</div>
					<div class="col-md-6 text-center">
						<a href="<%= request.getContextPath() %>/baoduong/tienhanh?ttbd=<%=baoDuong.getMaTTBD()%>" class="form-control btn-primary">Tiến hành sửa chữa</a>
					</div>
					<%}
					if(baoDuong.getTinhTrang() == 2){%>
					<div class="col-md-6">
					 	<input class="form-control btn btn-success" type="submit" name="capnhat" value="Cập nhật">
					</div>
					<div class="col-md-6 text-center">
						<a href="<%= request.getContextPath() %>/baoduong/hoantat?ttbd=<%=baoDuong.getMaTTBD()%>" class="form-control btn-danger">Hoàn tất bảo dưỡng</a>
					</div>
					<%} %>
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