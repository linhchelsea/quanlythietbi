<%@page import="library.LibraryFormatDateTime"%>
<%@page import="beans.ThongTinDangKy"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.LoaiThietBi"%>
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
      
			<%if (request.getParameter("msgdangky") != null && request.getParameter("msgdangky").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Đăng ký không thành công</div>
			<%}%>
      
      <%LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();
      
      LoaiThietBi loaiTB = (LoaiThietBi) request.getAttribute("loaiTB");
      ArrayList<ThongTinDangKy> alTTDK = (ArrayList<ThongTinDangKy>) request.getAttribute("alTTDK");%>
      <form method="post" action="<%=request.getContextPath() %>/cnnm-dangkysudung?type=dangky" id="dangkysudung">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-4">
                <label for="mathietbi">Mã thiết bị</label>
                <input class="form-control" type="text" name="maLoaiTB" readonly="readonly" value="<%=loaiTB.getMaLoai()%>">
              </div>
              <div class="col-md-4">
                <label for="tenthietbi">Tên thiết bị</label>
                <input class="form-control" type="text" name="tenTB" disabled="disabled" value="<%=loaiTB.getTenLoai()%>">
              </div>
              <div class="col-md-4">
                <label for="loaithietbi">Loại thiết bị</label>
                <input class="form-control" type="text" name="loaiTB" disabled="disabled" value="<%=loaiTB.getObjLoaiCha().getTenLoai()%>">
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
		                  <th class="text-center" width="50px">Mã DK</th>
		                  <th>Bắt đầu</th>
		                  <th>Kết thúc</th>
		                  <th class="text-center" width="100px">Số lượng</th>
		                </tr>
		              </thead>
		              <tbody>
		              <%for (ThongTinDangKy objTTDK : alTTDK){ %>
		                <tr>
		                  <td class="text-center"><%=objTTDK.getMaTTDK() %></td>
		                  <td><%=lbDateTime.TimestamptoString(objTTDK.getDKBatDauSuDung()) %></td>
		                  <td><%=lbDateTime.TimestamptoString(objTTDK.getDKKetThucSuDung()) %></td>
		                  <td class="text-center"><%=objTTDK.getSoLuongDK() %></td>
		                </tr>
		               <%} %>
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
                <input class="form-control" type="datetime-local" name="batdausudung" id="batdausudung">
              </div>
            </div>
          </div>
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-4">
                <label for="ketthucsudung">Thời gian kết thúc sử dụng</label>
                <input class="form-control" type="datetime-local" name="ketthucsudung" id="ketthucsudung">
              </div>
              <div class="col-md-3">
              	<label>&nbsp;</label>
                <button class="form-control btn btn-warning" type="button" name="kiemtra" onclick="kiemTra(<%=loaiTB.getMaLoai()%>)">Kiểm tra</button>
              </div>
            </div>
          </div>
        	<hr>
        <div id="ajax_dangky" style="display: none;">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-3">
                <label for="thietbikhadung">Số thiết bị có thể đăng ký</label>
                <input class="form-control" type="text" name="thietbikhadung" id="thietbikhadung" value="" disabled="disabled" style="font-weight: bold; color: red;">
              </div>
              <div class="col-md-offset-2 col-md-3">
              	<label for="soluongdangky">Số lượng đăng ký</label>
                <input class="form-control" type="number" name="soluongdangky" id="soluongdangky" value="">
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
        </div>
        </form>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <!-- AJAX SCRIPT -->
    <script type="text/javascript" charset="UTF-8">
    	function checkDateTime(batDau, ketThuc){
    		now = new Date().getTime();
			if(isNaN(batDau) || isNaN(ketThuc)){
				return "Thời gian nhập vào không đúng định dạng";
			} else if(batDau <= now){
				return "Thời gian bắt đầu sử dụng phải sau thời điểm hiện tại";
			} else if(batDau >= ketThuc){
				return "Thời gian kết thúc sử dụng phải sau thời gian bắt đầu";
			} else {
				return "";
			}
    	}
		function kiemTra(maTB){
			batDau = new Date(document.getElementById('batdausudung').value).getTime();
			ketThuc = new Date(document.getElementById('ketthucsudung').value).getTime();
			
			if (checkDateTime(batDau, ketThuc) != ""){
				alert(checkDateTime(batDau, ketThuc));
			} else {
				$.ajax({
		      		url: '<%=request.getContextPath()%>/cnnm-soluongkhadung',
		           	type: 'POST',
		         	cache: false,
		            data: {
		            	maTB: maTB,
		            	batDau: batDau,
		            	ketThuc: ketThuc
		            },
		            success: function(data){
		            	document.getElementById("thietbikhadung").value = data;
		            	document.getElementById("soluongdangky").value = 1;
		            	$("#soluongdangky").attr({
		            		   "max" : data,
		            		   "min" : 1
		            		});
		            	document.getElementById("ajax_dangky").style.display = 'block';
		          	},
		           	error: function (){
		            	//Xử lý nếu có lỗi
		                confirm('Có vấn đề xảy ra');
		            }
		     	});
			}
		}
    </script>
    <%@include file="/partial/footer.jsp" %>