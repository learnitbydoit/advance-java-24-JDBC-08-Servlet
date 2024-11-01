<%@page import="java.util.ArrayList"%>
<%@page import="java.beans.PropertyChangeListenerProxy"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.Format"%>
<%@page import="vn.edu.eiu.model.Sach" %>
<%@page import="javax.swing.colorchooser.AbstractColorChooserPanel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>Danh mục sách</title>
</head>
<body>
	<%
		Object oSach = request.getAttribute("dmSach");
		ArrayList<Sach> dmSach = null;
		if(oSach != null && oSach instanceof ArrayList){
			 dmSach = (ArrayList<Sach>) oSach ;	
		}
	%>

	<div class="container">
	<h1 align="center">Danh mục sách</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Mã sách</th>
				<th scope="col">Tên sách</th>
				<th scope="col">Giá bán</th>
				<th scope="col">Năm xuất bản</th>
			</tr>
		</thead>
		<tbody>
			<%
				int stt = 0;
				NumberFormat numFormat = NumberFormat.getInstance();
				for (Sach sach : dmSach) {
			 %>
			<tr>
				<th scope="row"><%=++stt%></th>
				<td><%=sach.getIdSach()%></td>
				<td><%=sach.getTenSach()%></td>
				<td align="right"><%=numFormat.format(sach.getGiaBan())%></td>
				<td><%=sach.getNamXuatBan()%></td>
			</tr>
			<%} //End foreach %>
		</tbody>	
	</table>
	</div>
</body>
</html>