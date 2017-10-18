<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Thiết bị</a>
        </li>
        <li class="breadcrumb-item active">Tìm kiếm thông tin thiết bị</li>
      </ol>
      <form action="<%= request.getContextPath() %>/thietbi-ketquatimkiem" method="">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="ma">Mã</label>
                <input class="form-control" type="text" name="ma">
              </div>
              <div class="col-md-6">
                <label for="tenNguoiNhap">Tên người nhập</label>
                <input class="form-control" type="text" name="tenNguoiNhap">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="tenThietBi">Tên thiết bị</label>
                <input class="form-control" type="text" name="tenThietBi">
              </div>
              <div class="col-md-6">
                <label for="maSoSeri">Mã số Seri</label>
                <input class="form-control" type="text" name="maSoSeri">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="loaiThietBi">Loại thiết bị</label>
                <input class="form-control" type="text" name="loaiThietBi">
              </div>
              <div class="col-md-6 col-lg-offset-6">
                <label for="cmnd">CMND</label>
                <input class="form-control" type="text" name="cmnd">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="thoiGianTu">Thời gian sử dụng từ</label>
                <input class="form-control" type="date" name="thoiGianTu">
              </div>
              <div class="col-md-6">
                <label for="thoiGianDen">Đến</label>
                <input class="form-control" type="date" name="thoiGianDen">
              </div>
            </div>
          </div>
          <div class="form-group">
          	<div class="col-md-4">
                <a href="javascript:void(0)" class="btn btn-default" onclick="BatTat()"><i class="fa fa-square-o" aria-hidden="true"></i>Ẩn tìm kiếm thời gian</a>
              </div>
          </div>
          <div class="form-group">
          <div class="form-row">
          	  <div class="col-md-6">
                <input class="form-control btn btn-warning" type="reset" name="Reset" value="NHẬP LẠI">
              </div>
              <div class="col-md-6">
              	
                <input class="form-control btn btn-success" type="submit" name="Them" value="Tìm kiếm">
              </div>
          </div>
          </div>
        </form>
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