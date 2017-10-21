<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Danh sách thiết bị</a>
        </li>
      </ol>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center" width="50px">#</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th class="text-center" width="100px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">1</td>
                  <td>Màn hình LG</td>
                  <td>Màn hình</td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-success">Đăng ký</a>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>