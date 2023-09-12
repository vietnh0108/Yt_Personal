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

<!-- Bootstrap 5 link -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />

<!-- Vendor CSS Files -->

<link
	href="/Asm_Java_Youtube/views/assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet" />
<link
	href="/Asm_Java_Youtube/views/assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet" />
<link
	href="/Asm_Java_Youtube/views/assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet" />
<link
	href="/Asm_Java_Youtube/views/assets/vendor/remixicon/remixicon.css"
	rel="stylesheet" />
<link
	href="/Asm_Java_Youtube/views/assets/vendor/swiper/swiper-bundle.min.css"
	rel="stylesheet" />
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
	href="/Asm_Java_Youtube/views/assets/myCss/style1.css" />
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
	<!-- Body -->

	<section class="home-page">
		<div class="container">
			<div class="row mb-5">
				<c:forEach var="video" items="${videos}">
					<div class="col-lg-3 col-md-4 col-sm-6 col-xs-12 box_video pl-2 pr-2 mb-5">
						<div class="video_img w-100">
							<a href="/Asm_Java_Youtube/youtube/detail-video?vid=${video.id}">
							<img
								style="border-radius: 10px" class="w-100"
								src="/Asm_Java_Youtube/views/assets/img/poster/${video.poster}"
								alt="Poster" />
							</a>
						</div>

						<div class="video_title mt-3">
							<h5 class="font-weight-bold">${video.title}</h5>
						</div>
						<div class="video-view text-secondary">
							${video.views} <span>lượt xem</span>
						</div>
						
						
					</div>
				</c:forEach>
				
			</div>
		</div>
	</section>

	<!-- Footer -->
	<jsp:include page="../layoutChung/footer.jsp"></jsp:include>
	<!-- End Footer -->

	<a href="#"
		class="back-to-top d-flex align-items-center justify-content-center"><span
		class="material-symbols-outlined"> arrow_upward </span></a>

	<!-- Bootstrap -->
	<!-- Bootstrap 5 link  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
		integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
		crossorigin="anonymous"></script>
	<!-- JS -->
	<script src="/Asm_Java_Youtube/views/assets/js/main.js"></script>

</body>
</html>
