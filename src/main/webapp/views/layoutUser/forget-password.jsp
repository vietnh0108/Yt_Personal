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
<link rel="stylesheet" href="/Asm_Java_Youtube/views/assets/myCss/feature1.css" />
<!-- Link icons -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
</head>
<body>
	<section>
		<div class="container">
			<div class="row">
				<form action="/Asm_Java_Youtube/youtube/forget-password" method="post"
					class="form p-4 col-4 bg-white mt-2"
					style="margin: 0 auto; border-radius: 10px">
					<div class="form-header text-center mb-4">
						<h3 class="text-uppercase text-info font-weight-bold">Forgot
							Password</h3>
					</div>
					<div class="user-box">
						<input type="text" name="id" required="" /> <label>ID (Username)</label>
					</div>
					<div class="user-box">
						<input type="email" name="email" required="" /> <label>Email
							Address</label>
					</div>
					<div class="text-center" style="width: 100%">
						<mark class="p-2 bg-transparent text-danger">${message}</mark>
					</div>

					<hr />
					<div class="form-footer w-100">
						<div class="change-page">
							<a href="/Asm_Java_Youtube/youtube/index">Home Page?</a> | <a
								href="/Asm_Java_Youtube/youtube/sign-in">Login?</a>
						</div>
						<button type="submit" class="btn-retrieve btn btn-info w-100 p-2"
							data-toggle="modal" data-target="#myModalCart">
							Retrieve</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
