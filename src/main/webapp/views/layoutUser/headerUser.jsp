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
    <link rel="stylesheet" href="/Asm_Java_Youtube/views/assets/myCss/style1.css" />
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
    <header class="header bg-white mb-3">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-md-4 center-logo">
            <div class="logo">
              <a href="/Asm_Java_Youtube/youtube/video" class="logo-wrapper">
                <img
                  class="w-100 h-100 img-fluid"
                  src="/Asm_Java_Youtube/views/assets/img/logo.png"
                  alt="Logo"
                />
              </a>
            </div>
          </div>
          <div class="col-lg-5 d-flex flex-row">
            <nav class="navbar navbar-expand-lg navbar-light bg-white p-0">
              <button
                class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
              >
                <i class="fas fa-bars"></i>
                Menu
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  <li class="nav_li nav-item">
                    <a href="/Asm_Java_Youtube/youtube/favorite-video" class="nav-link">My Favorites</a>
                  </li>
                  <c:choose>
                  	<c:when test="${not empty sessionScope.currentUser}">
                  		<li class="nav_li nav-item dropdown">
		                    <a
		                      href="/Asm_Java_Youtube/youtube/edit-profile"
		                      class="nav-link"
		                      id="navbarDropdown"
		                      role="button"
		                      data-toggle="dropdown"
		                      >Welcome, ${sessionScope.currentUser.fullname}<i class="fas fa-angle-down ml-1"></i
		                    ></a>
		                    <ul
		                      class="list_product dropdown-menu"
		                      aria-labelledby="navbarDropdown"
		                    >
		                      
		                      
		                      <li class="drop_li">
		                        <a href="/Asm_Java_Youtube/youtube/edit-profile" class="drop_item dropdown-item"
		                          >Edit Profile</a
		                        >
		                      </li>
		                      <li class="drop_li dropdown-divider"></li>
		                      <li class="drop_li">
		                        <a href="/Asm_Java_Youtube/youtube/change-password" class="drop_item dropdown-item"
		                          >Change Password</a
		                        >
		                      </li>
		                      <li class="drop_li dropdown-divider"></li>
		                      <li class="drop_li">
		                        <a href="/Asm_Java_Youtube/youtube/sign-out" class="drop_item dropdown-item">Log out</a>
		                      </li>
		                    </ul>
		                  </li>
                  	</c:when>
                  	<c:otherwise>
                  		<li class="nav_li nav-item">
                    		<a href="#" class="nav-link">Welcome you</a>
                  		</li>
                  	</c:otherwise>
                  </c:choose>
                  
                </ul>
              </div>
            </nav>
          </div>
          <div
            class="col-lg-3 col-md-3 d-flex flex-column justify-content-center"
          >
            <div class="wrapper">
           		<form action="/Asm_Java_Youtube/youtube/search">
           		<div class="search-box">
                	<input
	                  type="text"
	                  placeholder="Search title..."
	                  class="input-search"
	                  name="searchTitle"
	                  value="${titleValue}"
	                />
	               	 <div class="btn-search">
	                	  <i class="fa fa-search" aria-hidden="true"></i>
	               	 </div>
                
              </div>
              </form>
              
            </div>
          </div>
        </div>
      </div>
    </header>
    
    <!-- JS -->
    <script>
      //Search
      $(".btn-search").click(function () {
        $(".input-search").toggleClass("active").focus;
        $(this).toggleClass("animate");
        
      });

      //Paginaition
      $(function () {
        var button = $(".button");

        function switchToNext() {
          var _this = $(this);

          if (_this.hasClass("active")) return false;
          else {
            $(".button.active").removeClass("active");
            _this.addClass("active");
          }
        }

        button.on("click", switchToNext);
      });
    </script>
  </body>
</html>
