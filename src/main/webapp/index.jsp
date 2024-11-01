<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhập thông tin sách</title>
</head>
<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
		crossorigin="anonymous">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	
	<style>
		.rq{
			color: red;
		}
	</style>
	<script type="text/javascript">
	function my_submit() {
		//Bắt lỗi
		error ="";
		idSach = document.getElementById("idSach").value;
		tenSach = document.getElementById("tenSach").value;
		giaBan = document.getElementById("giaBan").value;
		namXuatBan = document.getElementById("namXuatBan").value;
		if(idSach.length == 0){
			error ="Mã sản phẩm không được bỏ trống!";
		}
		//Thông báo lỗi bằng popup
		if(error.length > 0){
			alert(error);
			return;
		}
		if(tenSach.length == 0){
			err_tenSach = document.getElementById("err_tenSach");
			err_tenSach.innerHTML = "<span class='rq'>Tên sản phẩm không được bỏ trống </span>";
			return;
		}
		//Thông báo lỗi giá nhập bằng text/html
		if(giaBan <= 0 || giaBan.length == 0){
			err_giaBan = document.getElementById("err_giaBan");
			err_giaBan.innerHTML = "<span class='rq'>Giá bán lớn hơn 0</span>";
			return;
		}
		//Thông báo lỗi giá bán
		err_namXuatBan = document.getElementById("err_namXuatBan");
		if(namXuatBan < 2000){
			err_namXuatBan.innerHTML = "<span class='rq'>Năm XB phải từ năm 2000 về sau.</span>";
			return;
		}
		//Submit form
		my_form = document.getElementById("my_form");
		my_form.submit();		
	}
	</script>
	
<body>
	<%
		String idSach = (String) request.getAttribute("idSach");
		String err_idSach = (String) request.getAttribute("err_idSach");	
		err_idSach = (err_idSach == null || err_idSach.equals("null"))?"":err_idSach;
	%>
	<h2 align="center"><B>NHẬP THÔNG TIN SÁCH</B></h2> <br>
	<div class="container mt-3">
		<form class="row g-3 needs-validation" action="save-sach" id="my_form">
			<div class="row">
				<div class="col-6">
					<label for="idSach" class="form-label">Mã sách<span class="rq"> * </span></label> 
					<input type="text" class="form-control"	id="idSach" name="idSach" value="<%=idSach %>" required>
					<div><span class ="rq"><%=err_idSach %></span></div>
				</div>
				<div class="col-6">
					<label for="tenSach" class="form-label">Tên sách<span class="rq"> * </span></label> 
					<input type="text" class="form-control"	id="tenSach" name="tenSach" value="" required>	
					<div id="err_tenSach"></div>
				</div>
			</div>			
			<div class="row">		
				<div class="col-6">
					<label for="giaBan" class="form-label">Giá bán<span class="rq"> * </span></label> 
					<input type="number" step="0.01" class="form-control"id="giaBan" name="giaBan" value=""required>
					<div id="err_giaBan"></div>					
				</div>
				<div class="col-6">
					<label for="namXuatBan" class="form-label">Năm xuất bản<span class="rq"> * </span></label> 
					<input type="number" class="form-control" id="namXuatBan" name="namXuatBan" value="" required>
					<div id="err_namXuatBan"></div>					
				</div>	
			</div>
			<div class="row">
				
			
			</div>				
			<div>
				<button class="btn btn-primary mt-3" type="button" onclick="my_submit()">Lưu sách</button>
			</div>
		</form>
	</div>

</body>
</html>