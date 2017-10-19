<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Danh sách thiết bị đang sử dụng</a>
        </li>
      </ol>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center" width="50px">Mã SD</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th>Thời gian bắt đầu</th>
                  <th>Thời gian kết thúc</th>
                  <th class="text-center">Số lượng</th>
                  <th class="text-center">Tình trạng</th>
                  <th class="text-center" width="170px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">1</td>
                  <td>Màn hình LG</td>
                  <td>Màn hình</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td class="text-center">10</td>
                  <td class="text-center">Chưa giao</td>
                  <td class="text-center">
          			<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
                  </td>
                </tr>
                <tr>
                  <td class="text-center">2</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td>08/11/2017 8:00 AM</td>	
                  <td class="text-center">7</td>
                  <td class="text-center">Đang sử dụng</td>
                  <td class="text-center">
          			<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
                  </td>
                </tr>
                <tr style="color: red;">
                  <td class="text-center">3</td>
                  <td>Máy chiếu Fuji</td>
                  <td>Máy chiếu</td>
                  <td>08/11/2017 8:00 AM</td>
                  <td>08/11/2017 8:00 AM</td>	
                  <td class="text-center">1</td>
                  <td class="text-center">Đang sử dụng</td>
                  <td class="text-center">
          			<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModelThongBao">Thông báo</a>
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
	          <h4 class="modal-title">Danh sách thiết bị sử dụng</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <table>
	          	<th colspan="2" style="color: green;">Danh sách thiết bị</th>
	          	<tr>
	          		<td>
	          			<table border="1">
			          	<tr>
			          		<th class="text-center" style="padding: 0 15px;">#</th>
			          		<th class="text-center" style="padding: 0 15px;">Mã thiết bị</th>
			          		<th class="text-center" style="padding: 0 15px;">Tên thiết bị</th>
			          	</tr>
			          	<tr>
			          		<td class="text-center">1</td>
			          		<td class="text-center">10</td>
			          		<td class="text-center">LG - v02</td>
			          	</tr>
			          	<tr>
			          		<td class="text-center">2</td>
			          		<td class="text-center">14</td>
			          		<td class="text-center">LG - v02</td>
			          	</tr>
			          </table>
	          		</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  <!-- Modal thong bao-->
	  <div class="modal fade" id="ModelThongBao" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Thông báo từ quản trị viên</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <p>Mình thích thì mình thông báo thôi</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
    <%@include file="/partial/footer.jsp" %>