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
        <li class="breadcrumb-item active">Thông tin tài khoản</li>
      </ol>
      <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="tendangnhap">Tên đăng nhập</label>
                <input class="form-control" type="text" name="tendangnhap" disabled="disabled">
              </div>
              <div class="col-md-6">
                <label for="tennguoidung">Tên người dùng (Họ và tên)</label>
                <input class="form-control" type="text" name="tennguoidung">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="MatKhau">Mật khẩu</label>
                <input class="form-control" type="password" name="MatKhau">
              </div>
              <div class="col-md-6">
                <label for="XacNhanMatKhau">Xác nhận mật khẩu</label>
                <input class="form-control" type="password" name="XacNhanMatKhau">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="GioiTinh">Giới tính</label>
                <select class="form-control" name="GioiTinh">
                	<option value="1">Nam</option>
                	<option value="2">Nữ</option>
                </select>
              </div>
              <div class="col-md-6">
                <label for="NgaySinh">Ngày sinh</label>
                <input class="form-control" type="date" name="NgaySinh">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="ChucVu">Chức vụ</label>
                <select class="form-control" name="ChucVu">
                	<option value="1">Admin</option>
                	<option value="2">Nhân viên</option>
                </select>
              </div>
              <div class="col-md-6">
                <label for="PhongBan">Phòng ban</label>
                <select class="form-control" name="PhongBan">
                	<option value="1">Phòng 1</option>
                	<option value="2">Phòng 2</option>
                </select>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">      
           		<div class="col-md-6">
                <label for="PhanQuyen">Phân quyền</label>
                <select class="form-control" name="PhanQuyen" disabled="disabled">
                	<option value="1">Người mượn</option>
                	<option value="2">Nhân Viên</option>
                	<option value="3">Quản trị Viên</option>
                </select>
              </div>
              <div class="col-md-6">
                <label for="DiaChi">Địa chỉ</label>
                <input class="form-control" type="text" name="DiaChi">
              </div>
            </div>
          </div>
          <div class="form-group">
          <div class="form-row">
              <div class="col-md-6">
                <input class="form-control btn btn-success" type="submit" name="CapNhat" value="CẬP NHẬT">
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