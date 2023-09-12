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
	<section>
		<div class="container mt-5">
			<div class="tabs">
				<div class="tab">
					<input type="radio" name="css-tabs" id="tab-1" checked
						class="tab-switch" /> <label for="tab-1"
						class="tab-label">Video Edition</label>
					<div class="tab-content w-100">
						<form class="p-3 row" action="/Asm_Java_Youtube/youtube/video-manage" method="post">
							<div class="col-5">
								<img class="img-fluid"
									src="/Asm_Java_Youtube/views/assets/img/poster/${video.poster}"
									alt="poster" id="previewImage"/>
									
							</div>
							<div class="col-7">
								<div class="user-box">
									<input type="text" name="id" required="" value="${video.id}"/> <label>ID
										Video</label>
								</div>
								<div class="user-box">
									<input type="text" name="title" required="" value="${video.title}" /> <label>Title
										Video</label>
								</div>
								<div class="user-box">
									<input type="text" name="views" required="" value="${video.views}" disabled/>
								</div>
								<div class="custom-file mb-3">
									<input type="file" class="custom-file-input" id="customFile"
										name="poster" value="${video.poster}"/> <label
										class="custom-file-label" for="customFile" >${video.poster==null?'Choose File':video.poster}</label>
								</div>

								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" class="custom-control-input"
										id="customRadio1" name="active" value="true"
										${video.active?'checked':''}  /> <label
										class="custom-control-label" for="customRadio1">Active</label>
								</div>
								<div class="custom-control custom-radio custom-control-inline">
									<input type="radio" class="custom-control-input"
										id="customRadio2" name="active" value="false"
										${video.active?'':'checked'} /> <label
										class="custom-control-label" for="customRadio2">Inactive</label>
								</div>
							</div>
							<div class="form-group w-100 mt-3">
								<textarea class="form-control w-100 text-dark" rows="3" name="description"
									placeholder="Description..." >${video.description}</textarea>
									
								<div class="text-center" style="width: 100%">
									<mark class="p-2 bg-transparent text-danger">${message}</mark>
								</div>	
								<hr />
							</div>
							<div class="grp-btn-manage w-100 text-right">
								<button class="btn_like-create btn btn-success" formaction="/Asm_Java_Youtube/youtube/video-manage/create">Create</button>
								
								<button class="btn_like-share btn btn-success" formaction="/Asm_Java_Youtube/youtube/video-manage/update">Update</button>
								<button class="btn_like-share btn btn-success" formaction="/Asm_Java_Youtube/youtube/video-manage/delete">Delete</button>
								<a class="btn_like-share btn btn-success" href="/Asm_Java_Youtube/youtube/video-manage">Reset</a>
							</div>
						</form>
					</div>
				</div>
				<div class="tab">
					<input type="radio" name="css-tabs" id="tab-2" class="tab-switch" />
					<label for="tab-2" class="tab-label">Video List</label>
					<div class="tab-content w-100">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>ID_Video</th>
									<th>Title</th>
									<th>Views</th>
									<th>Status</th>
									<th>Edit?</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="video" items="${videos}">
									<tr>
										<td>${video.id}</td>
										<td>${video.title}</td>
										<td>${video.views}</td>
										<td>${video.active?'Active':'Inactive'}</td>
										<td><a href="/Asm_Java_Youtube/youtube/video-manage/edit/${video.id}">Edit</a></td>
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
					var poster = $(this).val().split("\\").pop();
					$(this).siblings(".custom-file-label").addClass("selected")
							.html(poster);
				});
		
		//show hình ảnh khi chọn file
		const inputImage = document.querySelector('#customFile');
		const previewImage = document.querySelector('#previewImage');
		
		inputImage.addEventListener('change', function() {
		  const file = this.files[0];
		  if (file) {
		    const reader = new FileReader();
		    reader.addEventListener('load', function() {
		      previewImage.setAttribute('src', this.result);
		    });
		    reader.readAsDataURL(file);
		  }
		});
	</script>
</body>
</html>
