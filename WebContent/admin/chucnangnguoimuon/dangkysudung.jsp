<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Đăng ký sử dụng</a>
        </li>
      </ol>
      <form>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-4">
                <label for="mathietbi">Mã thiết bị</label>
                <input class="form-control" type="text" name="mathietbi" disabled="disabled" value="1">
              </div>
              <div class="col-md-4">
                <label for="tenthietbi">Tên thiết bị</label>
                <input class="form-control" type="text" name="tenthietbi" disabled="disabled" value="Màn hình LG">
              </div>
              <div class="col-md-4">
                <label for="loaithietbi">Loại thiết bị</label>
                <input class="form-control" type="text" name="loaithietbi" disabled="disabled" value="Màn hình">
              </div>
            </div>
          </div>
          <hr >
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-7">
                <label for="thietbikhadung" style="color: red; font-weight: bold;">Các đăng ký trước đó:</label>
                <table class="table table-bordered">
                	<thead>
		                <tr>
		                  <th class="text-center" width="50px">#</th>
		                  <th>Bắt đầu</th>
		                  <th>Kết thúc</th>
		                  <th class="text-center" width="100px">Số lượng</th>
		                </tr>
		              </thead>
		              <tbody>
		                <tr>
		                  <td class="text-center">1</td>
		                  <td>12/09/2017 11:30AM</td>
		                  <td>12/09/2017 01:30PM</td>
		                  <td class="text-center">5</td>
		                </tr>
		              </tbody>
                </table>
              </div>
            </div>
          </div>
          <hr >
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-4">
                <label for="batdausudung">Thời gian bắt đầu sử dụng</label>
                <input class="form-control" type="datetime-local" name="batdausudung">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-4">
                <label for="ketthucsudung">Thời gian kết thúc sử dụng</label>
                <input class="form-control" type="datetime-local" name="ketthucsudung">
              </div>
              <div class="col-md-3">
              	<label>&nbsp;</label>
                <input class="form-control btn btn-warning" type="button" name="kiemtra" value="Kiểm tra">
              </div>
            </div>
          </div>
        	<hr>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-3">
                <label for="thietbikhadung">Số thiết bị có thể đăng ký</label>
                <input class="form-control" type="text" name="thietbikhadung" value="5" disabled="disabled">
              </div>
              <div class="col-md-offset-2 col-md-3">
              	<label for="soluongdangky">Số lượng đăng ký</label>
                <input class="form-control" type="number" name="soluongdangky" min="1" max="5">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="Mucdichsudung">Mục đích sử dụng</label>
                <textarea rows="5" cols="80" name="mucdichsudung"></textarea>
              </div>
          </div>
          <div class="form-group">
          <div class="form-row">
              <div class="col-md-2">
                <input class="form-control btn btn-success" type="submit" name="dangky" value="Đăng ký">
              </div>
          </div>
          </div>
        </form>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>