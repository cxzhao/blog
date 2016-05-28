<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <base href="<%=basePath%>" />
		<title>Black &amp; White</title>
		<meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">

	    <!-- css -->
		<link rel="stylesheet" href="client/css/bootstrap.min.css">
		<link rel="stylesheet" href="client/css/ionicons.min.css">
		<link rel="stylesheet" href="client/css/pace.css">
	    <link rel="stylesheet" href="client/css/custom.css">

	    <!-- js -->
	    <script src="client/js/jquery-2.1.3.min.js"></script>
	    <script src="client/js/bootstrap.min.js"></script>
	    <script src="client/js/pace.min.js"></script>
	    <script src="client/js/modernizr.custom.js"></script>
	</head>

	<body id="single">
		<div class="container">	
			<header id="site-header">
				<div class="row">
					<div class="col-md-4 col-sm-5 col-xs-8">
						<div class="logo">
							<h1><a href="index.html"><b>Black</b> &amp; White</a></h1>
						</div>
					</div><!-- col-md-4 -->
					<div class="col-md-8 col-sm-7 col-xs-4">
						<nav class="main-nav" role="navigation">
							<div class="navbar-header">
  								<button type="button" id="trigger-overlay" class="navbar-toggle">
    								<span class="ion-navicon"></span>
  								</button>
							</div>

							<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
  								<ul class="nav navbar-nav navbar-right">
    								<c:forEach var="type" items="${types }">
    								<li class="cl-effect-11"><a href="type/queryByType?type=${type.type }" data-hover="${type.type }">${type.type }</a></li>
    							</c:forEach>
  								</ul>
							</div><!-- /.navbar-collapse -->
						</nav>
						<div id="header-search-box">
							<a id="search-menu" href="#"><span id="search-icon" class="ion-ios-search-strong"></span></a>
							<div id="search-form" class="search-form">
								<form role="search" method="get" id="searchform" action="#">
									<input type="search" placeholder="Search" required>
									<button type="submit"><span class="ion-ios-search-strong"></span></button>
								</form>				
							</div>
						</div>
					</div><!-- col-md-8 -->
				</div>
			</header>
		</div>

		<div class="content-body">
			<div class="container">
				<div class="row">
					<main class="col-md-8">
					
						<article class="post post-1">
							<header class="entry-header">
								<h1 class="entry-title">${article.title}</h1>
								<div class="entry-meta">
									<span class="post-category"><a href="#">${article.type}</a></span>
			
									<span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">${article.date}</time></a></span>
			
									<span class="post-author"><a href="#">chenxi zhao</a></span>
			
									<span class="comments-link"><a href="#">4 Comments</a></span>
								</div>
							</header>
							<div class="entry-content clearfix">
								${article.content }
							</div>
						</article>
					</main>
					<aside class="col-md-4">
						<div class="widget widget-recent-posts">		
							<h3 class="widget-title">Recent Posts</h3>		
							<ul>
								<c:forEach var="rencentArticle" items="${rencents }">						
						     	<li>
									<a href="article/articleDetail?id=${rencentArticle.id }">${rencentArticle.title }</a>
								</li>															
							</c:forEach>
							</ul>
						</div>
						
						<div class="widget widget-recent-posts">		
							<h3 class="widget-title">Hot Article</h3>		
							<ul>
							
							<c:forEach var="rank" items="${rank }">		
						     	<li>
									<a href="article/articleDetail?id=${rank.id }">${rank.title }</a>
								</li>															
							</c:forEach>
								
							</ul>
						</div>
						
						<div class="widget widget-archives">		
							<h3 class="widget-title">Archives</h3>		
							<ul>
								<li>
									<a href="#">November 2014</a>
								</li>
								<li>
									<a href="#">September 2014</a>
								</li>
								<li>
									<a href="#">January 2013</a>
								</li>
							</ul>
						</div>

						<div class="widget widget-category">		
							<h3 class="widget-title">Category</h3>		
							<ul>
								
								
								<c:forEach var="type" items="${types }">
    							<li>
									<a href="type/queryByType?type=${type.type }">${type.type }</a>
								</li>
    							</c:forEach>
    							
							</ul>
						</div>
					</aside>
				</div>
			</div>
		</div>
		<footer id="site-footer">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<p class="copyright">&copy; 2014 ThemeWagon.com</p>
					</div>
				</div>
			</div>
		</footer>

		<!-- Mobile Menu -->
		<div class="overlay overlay-hugeinc">
			<button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
			<nav>
				<ul>
					<c:forEach var="type" items="${types }">
    						<li class="cl-effect-11"><a href="type/queryByType?type=${type.type }" data-hover="Home">${type.type }</a></li>
    				</c:forEach>
				</ul>
			</nav>
		</div>

		<script src="client/js/script.js"></script>

	</body>
</html>
