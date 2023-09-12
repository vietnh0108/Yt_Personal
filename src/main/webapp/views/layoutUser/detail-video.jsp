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
	href="/Asm_Java_Youtube/views/assets/myCss/style.css" />
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
	<jsp:include page="headerUser.jsp"></jsp:include>
	<!-- End Header -->
	<section class="mt-3">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-sm-12">
					<iframe height="430" class="w-100 mb-3"
						src="https://www.youtube.com/embed/${video.id}">
					</iframe>
					<div class="video-info mb-3">
						<div class="title">
							<h4>${video.title}</h4>
						</div>
						<div class="d-flex justify-content-between">
							<div class="video-view text-secondary">
								${video.views} <span>lượt xem</span>
							</div>
							<div class="video_like-share">
								<a href="/Asm_Java_Youtube/youtube/favorite?userid=${sessionScope.currentUser.id}&videoid=${video.id}" style="text-decoration: none">
									<button class="btn_like-share d-inline-flex" type="text">
										<span class="material-symbols-outlined mr-2"> thumb_up </span>
											<c:if test="${ favorite == null}">
												Like
											</c:if>
											<c:if test="${ favorite != null }">
												UnLike
											</c:if>
									</button>
								</a>
								
								<a href="/Asm_Java_Youtube/youtube/share?videoid=${video.id}" style="text-decoration: none">
									<button class="btn_like-share d-inline-flex" type="text">
										<span class="material-symbols-outlined mr-2"> share </span>
										Share
									</button>
								</a>
								
							</div>
						</div>
					</div>
					<div class="video-description p-3"
						style="background-color: rgb(235, 235, 235); border-radius: 15px">
						<p>${video.description}</p>
					</div>
				</div>
				<div class="col-lg-4 col-sm-12">
					<c:forEach var="video" items="${list}">
						<div class="row mb-3">
						<div class="col-7">
							<div class="video_img w-100">
								<a href="/Asm_Java_Youtube/youtube/detail-video?vid=${video.id}">
								<img
									style="border-radius: 10px" class="w-100"
									src="/Asm_Java_Youtube/views/assets/img/poster/${video.poster}"
									alt="Poster" /></a>
							</div>
						</div>

						<div class="video_title col-5 p-0">
							<h6 class="">${video.title}</h6>
							<div class="video-view text-secondary">
							${video.views} <span>lượt xem</span>
						</div>
						</div>
						
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<jsp:include page="../layoutChung/footer.jsp"></jsp:include>
	<!-- End Footer -->
	<script>
		// Tạo đối tượng XMLHttpRequest
		var xhttp = new XMLHttpRequest();

		// Định nghĩa hàm callback để xử lý kết quả trả về từ máy chủ
		xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		        // Xử lý kết quả trả về từ máy chủ ở đây
		        document.getElementById("myDiv").innerHTML = this.responseText;
		    }
		};
	
		// Gửi yêu cầu đến máy chủ
		xhttp.open("GET", "myserverurl", true);
	xhttp.send();

	</script>
</body>
</html>
