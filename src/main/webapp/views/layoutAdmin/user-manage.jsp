<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>PS20959 - Lê Huy Bảo</title>
<link rel="shortcut icon"
	href="https://bizweb.dktcdn.net/100/402/946/themes/788910/assets/favicon.png?1667214408011"
	type="image/x-icon" />
<!-- Link Jquery -->
<script src="https://code.jquery.com/jquery-latest.js"></script>
<!-- Link Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- My css -->
<link rel="stylesheet"
	href="/Asm_Java_Youtube/views/assets/myCss/manage.css" />
<!-- Link icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
	<!--  JSTL -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
</head>
<body>
	<!-- Header -->
	<jsp:include page="headerAdmin.jsp" />
	<!-- End Header -->
	<section>
		<div class="container mt-5">
			<div class="tabs">
				<div class="tab">
					<input type="radio" name="css-tabs" id="tab-1" checked
						class="tab-switch" /> <label for="tab-1"
						class="tab-label">User Edition</label>
					<div class="tab-content w-100">
						<form class="p-3 row" action="#">
							<div class="d-inline col-6">
								<div class="user-box">
									<input type="text" name="username" required="" /> <label>ID (Username)</label>
								</div>
								<div class="user-box">
									<input type="text" name="fullname" required="" /> <label>Fullname</label>
								</div>
							</div>
							<div class="d-inline col-6">
								<div class="user-box">
									<input type="password" name="password" required="" /> <label>Password</label>
								</div>
								<div class="user-box">
									<input type="text" name="email" required="" /> <label>Email
										Address</label>
								</div>
							</div>
							<hr>
							<div class="text-center" style="width: 100%">
									<mark class="p-2 bg-transparent text-danger">${message}</mark>
							</div>

							<div class="grp-btn-manage w-100 text-right">
								<button class="btn_like-share btn btn-success">Update</button>
								<button class="btn_like-share btn btn-success">Delete</button>
							</div>
						</form>
					</div>
				</div>
				<div class="tab">
					<input type="radio" name="css-tabs" id="tab-2" class="tab-switch" />
					<label for="tab-2" class="tab-label">User List</label>
					<div class="tab-content w-100">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID (Username)</th>
									<th>Password</th>
									<th>Fullname</th>
									<th>Email</th>
									<th>Role</th>
									<th>Edit?</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="user" items="${users}">
									<tr>
										<td>${user.id}</td>
										<td>${user.password}</td>
										<td>${user.fullname}</td>
										<td>${user.email}</td>
										<td>${user.admin?'Admin':'User'}</td>
										<td><a href="#">Edit</a></td>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	
	<!-- JS -->
	<script>
		// Add the following code if you want the name of the file appear on select
		$(".custom-file-input").on(
				"change",
				function() {
					var fileName = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(fileName);
				});
	</script>
</body>
</html>
