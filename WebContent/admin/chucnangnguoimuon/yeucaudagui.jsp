<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Danh sách yêu cầu đã gửi</a>
        </li>
      </ol>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center" width="50px">Mã ĐK</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th>Thời gian đăng ký</th>
                  <th class="text-center">Số lượng</th>
                  <th class="text-center">Tình trạng</th>
                  <th class="text-center" width="100px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">1</td>
                  <td>Màn hình LG</td>
                  <td>Màn hình</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td class="text-center">10</td>
                  <td class="text-center">Chưa duyệt</td>
                  <td class="text-center">
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-danger">Huỷ đăng ký</a>
                  </td>
                </tr>
                <tr>
                  <td class="text-center">2</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td class="text-center">7</td>
                  <td class="text-center">Từ chối</td>
                  <td class="text-center">
          			<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    
    <!-- Modal chi tiet-->
	  <div class="modal fade" id="ModelChiTiet" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Nguyên nhân từ chối</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <p>Mình thích thì mình từ chối thôi</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
    <%@include file="/partial/footer.jsp" %>