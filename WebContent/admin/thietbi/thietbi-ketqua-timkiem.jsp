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
        <li class="breadcrumb-item active">Kết quả tìm kiếm</li>
      </ol>
      <div class="col-md-12" style="margin-bottom: 10px">
      	<div class="col-md-6" style="margin-bottom: 10px">
      		<a href="<%=request.getContextPath() %>/thietbi-timkiem" class="btn btn-warning">TÌM KIẾM</a>
      	</div>
      </div>
  
      <div class="table-responsive">
            <table class="table table-striped" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tên thiết bị</th>
                  <th>Tên người nhập</th>
                  <th>Thời gian bắt đầu sử dụng</th>
                  <th>Thời gian kết thúc sử dụng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Máy chiếu</td>
                  <td>Alexandre Cutonhuphich</td>
                  <td>30/02/2017</td>
                  <td>31/10/2017</td>
                </tr>
              </tbody>
            </table>
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