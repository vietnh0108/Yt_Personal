<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>PS20959 - Lê Huy Bảo</title>
    <link
      rel="shortcut icon"
      href="https://bizweb.dktcdn.net/100/402/946/themes/788910/assets/favicon.png?1667214408011"
      type="image/x-icon"
    />
    <!-- Link Jquery -->
    <script src="https://code.jquery.com/jquery-latest.js"></script>
    <!-- Link Bootstrap -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
      integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
      crossorigin="anonymous"
    />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- My css -->
    <link rel="stylesheet" href="/Asm_Java_Youtube/views/assets/myCss/admin.css" />
    <!-- Link icons -->
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
      integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0"
    />
    <!--  JSTL -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
  </head>
  <body>
    <!-- Header -->
    <header class="header bg-white">
      <div class="container">
        <nav class="navbar navbar-expand-md bg-white navbar-light">
          <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6 col-6 center-logo">
            <div class="logo">
              <a href="/Asm_Java_Youtube/youtube/admin" class="logo-wrapper">
                <img
                  class="w-100 h-100 img-fluid"
                  src="/Assignment_Java/views/assets/img/logo2.png"
                  alt="Logo"
                />
              </a>
            </div>
          </div>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#collapsibleNavbar"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div
            class="collapse navbar-collapse justify-content-end"
            id="collapsibleNavbar"
          >
            <ul class="navbar-nav">
              <li class="nav_li">
                <a class="nav-link" href="/Asm_Java_Youtube/youtube/admin">Home</a>
              </li>
              <li class="nav_li">
                <a class="nav-link" href="/Asm_Java_Youtube/youtube/video-manage">videos</a>
              </li>
              <li class="nav_li">
                <a class="nav-link" href="/Asm_Java_Youtube/youtube/user-manage">users</a>
              </li>
              <li class="nav_li">
                <a class="nav-link" href="/Asm_Java_Youtube/youtube/report-manage">reports</a>
              </li>
              <li class="nav_li">
                <a class="nav-link" href="/Asm_Java_Youtube/youtube/sign-out">Log out</a>
              </li>
              <c:choose>
                  	<c:when test="${not empty sessionScope.currentUser}">
                  		<li class="nav_li dropdown">
		             	   <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="/Asm_Java_Youtube/youtube/edit-profile">Welcome, ${sessionScope.currentUser.fullname}</a> 
              			 </li>
					    <div class="dropdown-menu">
					      <a class="dropdown-item" href="/Asm_Java_Youtube/youtube/edit-profile">Edit Profile</a>
					      <a class="dropdown-item" href="/Asm_Java_Youtube/youtube/change-password">Change Password</a>
					      <a class="dropdown-item" href="/Asm_Java_Youtube/youtube/sign-out">Log off</a>
					    </div>
				    </c:when>
                  	<c:otherwise>
                  		<li class="nav_li dropdown">
                   			<a href="#" class="nav-link">Welcome you</a>
                  	 	</li>	
                  	</c:otherwise>
                </c:choose>	
              
            </ul>
          </div>
        </nav>
      </div>
    </header>
  </body>
</html>
