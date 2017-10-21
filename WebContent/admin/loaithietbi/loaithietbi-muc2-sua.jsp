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
        <li class="breadcrumb-item active">Sửa thông tin thiết bị</li>
      </ol>
      <form action="" method="">
           <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="maSoSeri">Mã</label>
                <input class="form-control" type="text" name="ma" disabled ="disabled">
              </div>
               <div class="col-md-6">
                <label for="tenThietBi">Tên thiết bị<span style="color:red">(*)</span></label>
                <input class="form-control" type="text" name="tenThietBi">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="soLuong">Số lượng</label>
                <input class="form-control" type="number" name="soLuong">
              </div>
              <div class="col-md-6">
                <label for="loaiThietBi">Loại thiết bị</label>
              	<select class="form-control" name="loaiThietBi">
              	<option>Màn hình</option>
              	<option>Máy chiếu</option>
              	</select>
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
        <div class="text-center">
          <small>Copyright © Your Website 2017</small>
        </div>
      </div>
    
    <!-- Start footer -->
    <%@include file="/partial/footer.jsp" %>