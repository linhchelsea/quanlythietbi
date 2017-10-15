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
        <li class="breadcrumb-item active">Danh sách</li>
      </ol>
      <div class="col-md-12" style="margin-bottom: 10px">
      	<a href="<%= request.getContextPath() %>/user-create" class="btn btn-success">THÊM NGƯỜI DÙNG</a>
      </div>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Tên đăng nhập</th>
                  <th>Tên người dùng</th>
                  <th>Ngày sinh</th>
                  <th>Chức vụ</th>
                  <th>Phòng ban</th>
                  <th class="text-center">Chi tiết</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>linhchelsea</td>
                  <td>Nguyễn Mạnh Linh</td>
                  <td>21/10/1995</td>
                  <td>SuperAdmin</td>
                  <td>Quản trị</td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-success">Chi tiết</a>
                  </td>
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