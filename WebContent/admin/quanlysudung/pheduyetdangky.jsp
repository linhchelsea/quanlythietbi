<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Phê duyệt đăng ký</a>
        </li>
      </ol>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">Mã ĐK</th>
                  <th>Người đăng ký</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th class="text-center">Số lượng</th>
                  <th>Thời gian đăng ký</th>
                  <th class="text-center" width="250px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">1</td>
                  <td>Phan Thanh Thuận</td>
                  <td>Màn hình LG</td>
                  <td>Màn hình</td>
                  <td class="text-center">10</td>
                  <td>15/11/2017 14:00 AM</td>
                  <td class="text-center">
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<button type="button" class="btn btn-success" >Phê duyệt</button>
          			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModelTuChoi">Từ chối</button>
                  </td>
                </tr>
                <tr>
                  <td class="text-center">2</td>
                  <td>Nguyễn Mạnh Linh</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td class="text-center">6</td>
                  <td>15/10/2017 08:00 AM</td>
                  <td class="text-center">
					<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<button type="button" class="btn btn-success">Phê duyệt</button>
          			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModelTuChoi">Từ chối</button>                  </td>
                </tr>
                <tr>
                  <td class="text-center">3</td>
                  <td>Lê Anh Đức</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td class="text-center">2</td>
                  <td>18/10/2017 14:00 AM</td>
                  <td class="text-center">
					<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<button type="button" class="btn btn-success">Phê duyệt</button>
          			<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#ModelTuChoi">Từ chối</button>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
    </div>
    
    <!-- Modal chi tiet-->
	  <div class="modal fade" id="ModelChiTiet" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Thông tin đăng ký</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <table>
	          	<th colspan="2" style="color: green;">Thông tin người mượn</th>
	          	<tr>
	          		<td style="font-weight: bold;">Mã người dùng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>1</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Họ tên:</td>
	          		<td>Phan Thanh Thuận</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Phòng ban:</td>
	          		<td>Kế toán</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Chức vụ:</td>
	          		<td>Trưởng phòng</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tên thiết bị:</td>
	          		<td>Màn hình LG</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Loại thiết bị:</td>
	          		<td>Màn hình</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Số lượng mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>10</td>
	          	</tr>
	          </table>
	          <hr>
	          <p style="color: green; font-weight: bold;">Thời gian đăng ký</p>
	          	<span>15/10/2017 8:00 AM</span>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Thời gian sử dụng</th>
	          	<tr>
	          		<td style="font-weight: bold;">Bắt đầu:</td>
	          		<td>15/10/2017 8:00 AM</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Kết thúc:</td>
	          		<td>15/10/2017 8:00 AM</td>
	          	</tr>
	          </table>
	          <hr>
	          <p style="color: green; font-weight: bold;">Mục đích sử dụng</p>
	          <p>Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. Mình thích thì mình đăng ký thôi. </p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	    </div>
	  </div>
	  
	  <!-- Modal tu choi-->
	  <div class="modal fade" id="ModelTuChoi" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Lý do từ chối</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <form>
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-12">
		                <textarea class="form-control" rows="5"></textarea>
		              </div>
		            </div>
		          </div>
		        </form>
	        </div>
	        <div class="modal-footer">
	          <button type="submit" class="btn btn-warning">Xác nhận</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	    </div>
	  </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>