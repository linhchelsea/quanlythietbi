<%@page import="beans.LoaiThietBi"%>
<%@page import="beans.ThietBi"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/partial/header.jsp" %>
    <!-- Body -->
    <%ArrayList<LoaiThietBi> alLoaiThietBi = (ArrayList<LoaiThietBi>) request.getAttribute("alLoaiThietBi"); %>
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
              <%ArrayList<LoaiThietBi> alLoaiCha = new ArrayList<LoaiThietBi>(); %>
              <%for (LoaiThietBi item : alLoaiThietBi){ %>
	              <%if(item.getMaLoaiCha() != 0){ %>
		                <tr>
		                  <td class="text-center"><%=item.getMaLoai() %></td>
		                  <td><%=item.getTenLoai() %></td>
		                  <%for (LoaiThietBi loaiCha : alLoaiCha){ 
		                  	if (loaiCha.getMaLoai() == item.getMaLoaiCha()){%>
		                  		<td><%=loaiCha.getTenLoai() %></td>
		                  	<%break; } %>
		                  <%} %>
		                  <td class="text-center">
		          			<a href="<%= request.getContextPath() %>/cnnm-dangkysudung?type=load&maLoaiTB=<%=item.getMaLoai()%>" class="btn btn-success">Đăng ký</a>
		                  </td>
		                </tr>
	                <%} else {
	                	alLoaiCha.add(item);	
	                }%>
                <%} %>
              </tbody>
            </table>
          </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <%@include file="/partial/footer.jsp" %>