<%@page import="java.util.Date"%>
<%@page import="library.LibraryFormatDateTime"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="beans.ThongTinSuDung"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    
    <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <%ArrayList<ThongTinSuDung> alTTSD = (ArrayList<ThongTinSuDung>) request.getAttribute("alTTSD"); 
      LibraryFormatDateTime lbDateTime = new LibraryFormatDateTime();%>
      <ol class="breadcrumb">
        <li class="breadcrumb-item active">
          <a href="#">Cập nhật sử dụng</a>
        </li>
      </ol>
      <div>
			<%if (request.getParameter("msgketthuc") != null && request.getParameter("msgketthuc").equals("1")) {%>
				<div class="alert alert-success">Kết thúc ca sử dụng thành công</div>
			<%} else if (request.getParameter("msgketthuc") != null && request.getParameter("msgketthuc").equals("0")) {%>
				<div class="alert alert-danger" style="color: red">Tác vụ không thành công</div>
			<%}%>
			
			<%if (request.getParameter("msgbangiao") != null && request.getParameter("msgbangiao").equals("1")) {%>
				<div class="alert alert-success">Bàn giao thiết bị thành công</div>
			<%}%>
		</div>
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
              <%
              long now = new Date().getTime();
              for (ThongTinSuDung objTTSD : alTTSD){ %>
                <tr <%if (objTTSD.getKetThucSuDung().getTime() <= now) {%>
						style="color: red;" <%}%>>
                  <td class="text-center"><%=objTTSD.getMaTTSD() %></td>
                  <td><%=objTTSD.getObjNguoiMuon().getTenND() %></td>
                  <td><%=objTTSD.getObjTTDK().getObjLoaiTB().getTenLoai() %></td>
                  <td><%=objTTSD.getObjTTDK().getObjLoaiTB().getObjLoaiCha().getTenLoai() %></td>
                  <td><%=lbDateTime.TimestamptoString(objTTSD.getBatDauSuDung()) %></td>
                  <td><%=lbDateTime.TimestamptoString(objTTSD.getKetThucSuDung()) %></td>
                  <td>
                  <%if(objTTSD.getTinhTrang() == 1){ %>
                  	Chưa giao
                  <%} else { %>
                  	Đang sử dụng
                  <%} %>
                  </td>
                  <td class="text-center">
                  	<button type="button" class="btn btn-outline-info" data-toggle="modal" data-target="#ModelChiTiet"
                  	onclick="ModalChiTiet(<%=objTTSD.getMaNguoiMuon()%>, '<%=objTTSD.getObjNguoiMuon().getTenND()%>', '<%=objTTSD.getObjNguoiMuon().getObjPhongBan().getTenPhongBan()%>', '<%=objTTSD.getObjNguoiMuon().getObjChucVu().getTenChucVu()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getTenLoai()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getObjLoaiCha().getTenLoai()%>', <%=objTTSD.getObjTTDK().getSoLuongDK()%>, '<%if (objTTSD.getTinhTrang() == 1){ %>Chưa giao<%} else {%>Đang sử dụng<%} %>', '<%=lbDateTime.TimestamptoString(objTTSD.getBatDauSuDung())%>', '<%=lbDateTime.TimestamptoString(objTTSD.getKetThucSuDung())%>', <%=objTTSD.getMaTTSD() %>);"
                  	>Chi tiết</button>
                  	<%if (objTTSD.getTinhTrang() == 1){ %>
                  		<button type="button" class="btn btn-success" data-toggle="modal" data-target="#ModelBanGiao" 
                  		onclick="ModalBanGiao(<%=objTTSD.getMaNguoiMuon()%>, '<%=objTTSD.getObjNguoiMuon().getTenND()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getTenLoai()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getObjLoaiCha().getTenLoai()%>', <%=objTTSD.getObjTTDK().getSoLuongDK()%>, <%=objTTSD.getMaTTSD() %>, <%=objTTSD.getObjTTDK().getMaLoaiTB() %>);"
                  		>Bàn giao</button>
                  	<%} else { %>
                  		<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#ModelKetThuc" 
                  		onclick="ModalKetThuc(<%=objTTSD.getMaNguoiMuon()%>, '<%=objTTSD.getObjNguoiMuon().getTenND()%>', '<%=objTTSD.getObjNguoiMuon().getObjPhongBan().getTenPhongBan()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getTenLoai()%>', '<%=objTTSD.getObjTTDK().getObjLoaiTB().getObjLoaiCha().getTenLoai()%>', <%=objTTSD.getObjTTDK().getSoLuongDK()%>, '<%=lbDateTime.TimestamptoString(objTTSD.getBatDauSuDung())%>', '<%=lbDateTime.TimestamptoString(objTTSD.getKetThucSuDung())%>', <%=objTTSD.getMaTTSD() %>);"
                  		>Kết thúc</button>
                  	<%} %>
                  </td>
                </tr>
                <%} %>
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
	          		<td style="font-weight: bold;" >Mã người dùng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-maND">1</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Họ tên:</td>
	          		<td id="modal-tenND">Phan Thanh Thuận</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Phòng ban:</td>
	          		<td id="modal-phongBan">Kế toán</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Chức vụ:</td>
	          		<td id="modal-chucVu">Trưởng phòng</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
	          	<tr>
	          		<td style="font-weight: bold;" id="modal-tenTB">Tên thiết bị:</td>
	          		<td id="modal-tenTB">Màn hình LG</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Loại thiết bị:</td>
	          		<td id="modal-loaiTB">Màn hình</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Số lượng mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-soLuong">10</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Sử dụng</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tình trạng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-tinhTrang">Chưa giao</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Bắt đầu:</td>
	          		<td id="modal-batDau" >15/10/2017 8:00 AM</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Kết thúc:</td>
	          		<td id="modal-ketThuc">15/10/2017 8:00 AM</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Danh sách thiết bị</th>
	          	<tr>
	          		<td>
	          			<table border="1" id="ajax_chitiet">
			          	
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
	          		<td id="modal-bg-maND">1</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Họ tên:</td>
	          		<td id="modal-bg-tenND">Phan Thanh Thuận</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tên thiết bị:</td>
	          		<td  id="modal-bg-tenTB">Màn hình LG</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Loại thiết bị:</td>
	          		<td  id="modal-bg-loaiTB">Màn hình</td>
	          	</tr>
	          	<tr style="display: none;">
	          		<td style="font-weight: bold;">Mã loại thiết bị:</td>
	          		<td  id="modal-bg-maLoaiTB"></td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Số lượng mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-bg-soLuong">10</td>
	          	</tr>
	          </table>
	          <hr>
	          <p style="color: green; font-weight: bold;">Danh sách thiết bị khả dụng</p>
	          <div id="ajax-bangiao">
	          
	          </div>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" id="btn-bangiao" onclick="BanGiao();">Bàn giao</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  
	  <!-- Modal ket thuc-->
	  <div class="modal fade" id="ModelKetThuc" role="dialog">
	    <div class="modal-dialog ">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">Hoàn trả thiết bị</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          <table>
	          	<th colspan="2" style="color: green;">Thông tin người mượn</th>
	          	<tr>
	          		<td style="font-weight: bold;">Mã người dùng:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-kt-maND">1</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Họ tên:</td>
	          		<td id="modal-kt-tenND">Phan Thanh Thuận</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Phòng ban:</td>
	          		<td id="modal-kt-phongBan">Kế toán</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Chi tiết thiết bị</th>
	          	<tr>
	          		<td style="font-weight: bold;">Tên thiết bị:</td>
	          		<td id="modal-kt-tenTB">Màn hình LG</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Loại thiết bị:</td>
	          		<td id="modal-kt-loaiTB">Màn hình</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Số lượng mượn:&nbsp;&nbsp;&nbsp;&nbsp;</td>
	          		<td id="modal-kt-soLuong">10</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Sử dụng</th>
	          	<tr>
	          		<td style="font-weight: bold;">Bắt đầu:</td>
	          		<td id="modal-kt-batDau">15/10/2017 8:00 AM</td>
	          	</tr>
	          	<tr>
	          		<td style="font-weight: bold;">Kết thúc:</td>
	          		<td id="modal-kt-ketThuc">15/10/2017 8:00 AM</td>
	          	</tr>
	          </table>
	          <hr>
	          <table>
	          	<th colspan="2" style="color: green;">Danh sách thiết bị</th>
	          	<tr>
	          		<td>
	          			<table border="1" id="ajax_ketthuc">
			          	
			          </table>
	          		</td>
	          	</tr>
	          </table>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-warning" id="btn-ketthuc" onclick="KetThuc()">Kết thúc</button>
	        </div>
	      </div>
	      
	    </div>
	  </div>
	  <script type="text/javascript">
	  function ModalChiTiet(maND, tenND, phongBan, chucVu, tenTB, loaiTB, soLuong, tinhTrang, batDau, ketThuc, maTTSD) {
			document.getElementById("modal-maND").innerHTML = maND;
			document.getElementById("modal-tenND").innerHTML = tenND;
			document.getElementById("modal-phongBan").innerHTML = phongBan;
			document.getElementById("modal-chucVu").innerHTML = chucVu;
			document.getElementById("modal-tenTB").innerHTML = tenTB;
			document.getElementById("modal-loaiTB").innerHTML = loaiTB;
			document.getElementById("modal-soLuong").innerHTML = soLuong;
			document.getElementById("modal-tinhTrang").innerHTML = tinhTrang;
			document.getElementById("modal-batDau").innerHTML = batDau;
			document.getElementById("modal-ketThuc").innerHTML = ketThuc;
			
			$.ajax({
	      		url: '<%=request.getContextPath()%>/cnnm-chitietsudung',
	           	type: 'POST',
	         	cache: false,
	            data: {
	            	maTTSD: maTTSD
	            },
	            success: function(data){
	            	$("#ajax_chitiet").html(data);
	          	},
	           	error: function (){
	            	//Xử lý nếu có lỗi
	                confirm('Có vấn đề xảy ra');
	            }
	     	});
		}
	  
	  function ModalKetThuc(maND, tenND, phongBan, tenTB, loaiTB, soLuong, batDau, ketThuc, maTTSD) {
			document.getElementById("modal-kt-maND").innerHTML = maND;
			document.getElementById("modal-kt-tenND").innerHTML = tenND;
			document.getElementById("modal-kt-phongBan").innerHTML = phongBan;
			document.getElementById("modal-kt-tenTB").innerHTML = tenTB;
			document.getElementById("modal-kt-loaiTB").innerHTML = loaiTB;
			document.getElementById("modal-kt-soLuong").innerHTML = soLuong;
			document.getElementById("modal-kt-batDau").innerHTML = batDau;
			document.getElementById("modal-kt-ketThuc").innerHTML = ketThuc;
			document.getElementById("btn-ketthuc").value = maTTSD;
			
			$.ajax({
	      		url: '<%=request.getContextPath()%>/cnnm-chitietsudung',
	           	type: 'POST',
	         	cache: false,
	            data: {
	            	maTTSD: maTTSD
	            },
	            success: function(data){
	            	$("#ajax_ketthuc").html(data);
	          	},
	           	error: function (){
	            	//Xử lý nếu có lỗi
	                confirm('Có vấn đề xảy ra');
	            }
	     	});
		}
	  
	  function KetThuc() {
		  var conf = confirm("Bạn muốn kết thúc ca sử dụng này?");
		  if(conf == true){
			  maTTSD = document.getElementById("btn-ketthuc").value;
			  window.location.href = '<%=request.getContextPath()%>/qlsd-ketthucsudung?maTTSD=' + maTTSD;
		  }
	}
	  
	  function ModalBanGiao(maND, tenND, tenTB, loaiTB, soLuong, maTTSD, maLoaiTB) {
			document.getElementById("modal-bg-maND").innerHTML = maND;
			document.getElementById("modal-bg-tenND").innerHTML = tenND;
			document.getElementById("modal-bg-tenTB").innerHTML = tenTB;
			document.getElementById("modal-bg-loaiTB").innerHTML = loaiTB;
			document.getElementById("modal-bg-maLoaiTB").innerHTML = maLoaiTB;
			document.getElementById("modal-bg-soLuong").innerHTML = soLuong;
			document.getElementById("btn-bangiao").value = maTTSD;
			
			$.ajax({
	      		url: '<%=request.getContextPath()%>/qlsd-thietbikhadung',
	           	type: 'POST',
	         	cache: false,
	            data: {
	            	maLoaiTB: maLoaiTB,
	            	soLuong: soLuong
	            },
	            success: function(data){
	            	$("#ajax-bangiao").html(data);
	          	},
	           	error: function (){
	            	//Xử lý nếu có lỗi
	                confirm('Có vấn đề xảy ra');
	            }
	     	});
		}
	  
	  //Tinh so thiet bi da chon
	  	function countChoose() {
		    var soThietBi = document.getElementsByClassName("thietbi");
		    var checks = 0;
		    for (i = 0; i < soThietBi.length; i++){
		        if (soThietBi[i].checked == true){
		            checks += 1;
		        }
		    }
		    return checks;
		}
		
		function daChon(id, soLuong) {
		    var feature = document.getElementById("thietbi_" + id);
		    if(feature.checked){
		        if(countChoose() > soLuong){
		            alert("Số lượng thiết bị tối đa cho mượn là " + soLuong);
		            feature.checked = false;
		        } else {
		        	document.getElementById("dachon").innerHTML = countChoose();
		        }
		    } else {
		    	document.getElementById("dachon").innerHTML = countChoose();
		    }
		}
		
		function BanGiao() {
			if (countChoose() <= 0){
				alert("Bạn chưa chọn thiết bị");
			} else {
			  var conf = confirm("Bàn giao hoàn tất?");
			  if(conf == true){
				  maTTSD = document.getElementById("btn-bangiao").value;
				  maLoaiTB = document.getElementById("modal-bg-maLoaiTB").innerHTML;
				  
				  var listId = [];
				  var soThietBi = document.getElementsByClassName("thietbi");
				  for(i=0; i < soThietBi.length; i++){
					  if (soThietBi[i].checked == true){
						listId.push(soThietBi[i].value);
				      }
				  }
				  window.location.href = '<%=request.getContextPath()%>/qlsd-bangiao?listId='+ listId.toString() + '&maTTSD=' + maTTSD + '&maLoaiTB=' + maLoaiTB;
			  }
			}
		}
	  </script>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>