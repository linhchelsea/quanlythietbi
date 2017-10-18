<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Sử dụng thiết bị</a>
        </li>
        <li class="breadcrumb-item active">Đăng ký</li>
      </ol>
      <form action="" method="">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="ma">Mã</label>
                <input class="form-control" type="text" name="ma" disabled="disabled">
              </div>
              <div class="col-md-6">
                <label for="loai">Loại</label>
                <input class="form-control" type="text" name="loai" disabled="disabled">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="tenThietBi">Tên thiết bị</label>
                <input class="form-control" type="text" name="tenThietBi" disabled="disabled">
              </div>
              <div class="col-md-6">
                <label for="maSoSeri">Ngày đăng ký</label>
                <input class="form-control" type="date" name="ngayDangKy" disabled="disabled">
                
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="tenNguoiDung">Tên người dùng</label>
                <input class="form-control" type="text" name="tenNguoiDung" disabled="disabled">
              </div>
              <div class="col-md-6">
                <label for="phongban">Phòng/ban</label>
                <input class="form-control" type="text" name="phongban" disabled="disabled">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-2">
                <label>Số lượng khả dụng:</label>
              </div>
              <div class="col-md-4">
              	<input class="form-control" type="text" disabled="disabled" value="2">
              </div>
              <div class="col-md-2">
                <label>Số lượng đăng ký:</label>
              </div>
              <div class="col-md-4">
                <input class="form-control" type="text" name="sldk">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-2">
                <label>Tình trạng:</label>
              </div>
              <div class="col-md-10">
                <label><span style="color:red">Đang sử dụng (kết thúc ngày 30/02/2017)</span></label>
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-2">
                <label for="ngayBatDau">Ngày bắt đầu:</label>
              </div>
              <div class="col-md-4">
                <input type="date" class="form-control" name="ngayBatDau">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-2">
                <label for="ngayBatDau">Ngày kết thúc:</label>
              </div>
              <div class="col-md-4">
                <input type="date" class="form-control" name="ngayKetThuc">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-12">
                <label for="mucDichSuDung">Mục đích sử dụng:</label>
                <textarea class="form-control" name="mucDichSudung"></textarea>
              </div>
            </div>
          </div>
          <div class="form-group">
          <div class="form-row">
          	  <div class="col-md-4">
                <a href="" class="form-control btn btn-danger">HỦY</a>
              </div>
          	  <div class="col-md-4">
                <input class="form-control btn btn-warning" type="reset" name="Reset" value="NHẬP LẠI">
              </div>
              <div class="col-md-4">
                <input class="form-control btn btn-success" type="submit" name="Them" value="THÊM">
              </div>
          </div>
          </div>
        </form>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">/
          <small>Copyright © Your /Website 2017</small>
        </div>
      </div>
    
    <!-- Start footer -->
    <%@include file="/partial/footer.jsp" %>