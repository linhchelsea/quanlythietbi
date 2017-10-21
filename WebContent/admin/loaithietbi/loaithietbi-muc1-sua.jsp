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
                <label for="loaiThietBi">Tên loại thiết bị</label>
                <input class="form-control" type="text" name="loaiThietBi">
              </div>
            </div>
          </div>
          
          <div class="form-group">
          <div class="form-row">
          	  <div class="col-md-2">
                <a href="" class="form-control btn btn-danger">HỦY</a>
              </div>
          	  <div class="col-md-2">
                <input class="form-control btn btn-warning" type="reset" name="Reset" value="NHẬP LẠI">
              </div>
              <div class="col-md-2">
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