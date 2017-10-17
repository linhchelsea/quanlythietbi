<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Cập nhật sử dụng</a>
        </li>
      </ol>
      <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th class="text-center">Mã TTSD</th>
                  <th>Người sử dụng</th>
                  <th>Tên thiết bị</th>
                  <th>Loại thiết bị</th>
                  <th>Bắt đầu</th>
				  <th>Kết thúc</th>
                  <th>Tình trạng</th>
                  <th class="text-center" width="160px">Chức năng</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="text-center">1</td>
                  <td>Phan Thanh Thuận</td>
                  <td>Màn hình LG</td>
                  <td>Màn hình</td>
                  <td>15/11/2017 08:00 AM</td>
                  <td>15/11/2017 14:00 AM</td>
                  <td>Chưa giao</td>
                  <td class="text-center">
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-success" data-toggle="modal" data-target="#ModelBanGiao">Bàn giao</a>
                  </td>
                </tr>
                <tr>
                  <td class="text-center">2</td>
                  <td>Nguyễn Mạnh Linh</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td>15/10/2017 08:00 AM</td>
                  <td>18/10/2017 14:00 AM</td>
                  <td>Đang sử dụng</td>
                  <td class="text-center">
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-warning">Kết thúc</a>
                  </td>
                </tr>
                <tr style="color: red;">
                  <td class="text-center">3</td>
                  <td>Lê Anh Đức</td>
                  <td>Màn hình DELL</td>
                  <td>Màn hình</td>
                  <td>15/10/2017 08:00 AM</td>
                  <td>18/10/2017 14:00 AM</td>
                  <td>Đang sử dụng</td>
                  <td class="text-center">
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet">Chi tiết</button>
          			<a href="<%= request.getContextPath() %>/user-edit" class="btn btn-warning">Kết thúc</a>
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
	          <h4 class="modal-title">Thông tin sử dụng</h4>
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
	          <table>
	          	<th colspan="2" style="color: green;">Sử dụng</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tình trạng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>Chưa giao</td>
	          	</tr>
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
	          <table>
	          	<th colspan="2" style="color: green;">Danh sách thiết bị</th>
	          	<tr>
	          		<td>1&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>2&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>3&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>4&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>5&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          	</tr>
	          	<tr>
	          		<td>6&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>10&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>15&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>11&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td>12&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  
	  <!-- Modal Ban giao-->
	  <div class="modal fade" id="ModelBanGiao" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Bàn giao thiết bị</h4>
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
	          <p style="color: green; font-weight: bold;">Danh sách thiết bị khả dụng</p>
	          <span style="font-weight: bold;">Số lượng khả dụng: </span><span>15</span>
	          <table border="1">
	          	<tr>
	          		<th class="text-center" style="padding: 0 15px;">#</th>
	          		<th class="text-center" style="padding: 0 15px;">Mã thiết bị</th>
	          		<th style="padding: 0 15px;">Chọn</th>
	          	</tr>
	          	<tr>
	          		<td class="text-center">1</td>
	          		<td class="text-center">10</td>
	          		<td class="text-center"><input type="checkbox" name="thietbi" value="10"></td>
	          	</tr>
	          	<tr>
	          		<td class="text-center">2</td>
	          		<td class="text-center">14</td>
	          		<td class="text-center"><input type="checkbox" name="thietbi" value="14"></td>
	          	</tr>
	          	<tr>
	          		<td class="text-center" style="font-weight: bold; color: red;" colspan="2">Đã chọn</td>
	          		<td class="text-center" style="font-weight: bold; color: red;">1</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success">Bàn giao</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>