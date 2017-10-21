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
        <li class="breadcrumb-item active">Cập nhật bảo dưỡng</li>
      </ol>
      
    <div>
         <form method="post" action="">
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="mathietbi">Mã thiết bị</label>
					 	<input class="form-control" type="text" name="mathietbi" disabled="disabled">
					</div>
					<div class="col-md-6">
						<label for="tenthietbi">Tên thiết bị</label>
					 	<input class="form-control" type="text" name="tenthietbi" disabled="disabled">
					</div>
				</div>
			</div> 
         	<div class="form-group">
				<div class="form-row">
					<div class="col-md-6">
						<label for="ngaybaoduong">Chọn ngày bảo dưỡng</label>
					 	<input class="form-control" type="date" name="ngaybaoduong">
					</div>
					<div class="col-md-6">
						<label for="dukienxong">Dự kiến xong</label>
					 	<input class="form-control" type="date" name="dukienxong">
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-12">
						<label for="lydobaoduong">Lý do bảo dưỡng</label>
						<textarea  class="form-control" name="lydobaoduong" ></textarea>
					</div>
				</div>
			</div> 
			<div class="form-group">
				<div class="form-row">
					<div class="col-md-4">
					 	<input class="form-control btn-success" type="submit" name="capnhat" value="Cập nhật">
					</div>
					<div class="col-md-4 text-center">
					 	<a href="" class="form-control btn-warning">Hủy đăng ký bảo dưỡng</a>
					</div>
					<div class="col-md-4 text-center">
						<a href="" class="form-control btn-danger">Xóa khỏi danh sách</a>
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