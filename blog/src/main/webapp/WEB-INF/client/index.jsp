<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="client/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="client/css/ionicons.min.css" type="text/css">
<link rel="stylesheet" href="client/css/pace.css" type="text/css">
<link rel="stylesheet" href="client/css/custom.css" type="text/css">
<!-- js -->
<script src="client/js/jquery-2.1.3.min.js"></script>
<script src="client/js/bootstrap.min.js"></script>
<script src="client/js/pace.min.js"></script>
<script src="client/js/modernizr.custom.js"></script>
<title>晨曦的博客</title>
</head>
<body>
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
    								<li class="cl-effect-11"><a href="index.html" data-hover="Home">Home</a></li>
    								<li class="cl-effect-11"><a href="full-width.html" data-hover="Blog">Blog</a></li>
    								<li class="cl-effect-11"><a href="about.html" data-hover="About">About</a></li>
    								<li class="cl-effect-11"><a href="contact.html" data-hover="Contact">Contact</a></li>
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
		<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>

		<div class="content-body">
			<div class="container">
				<div class="row">
					<main class="col-md-8">
						<article class="post post-1">
							<header class="entry-header">
								<h1 class="entry-title">
									<a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
								</h1>
								<div class="entry-meta">
									<span class="post-category"><a href="#">Web Design</a></span>
			
									<span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>
			
									<span class="post-author"><a href="#">Albert Einstein</a></span>
			
									<span class="comments-link"><a href="#">4 Comments</a></span>
								</div>
							</header>
							<div class="entry-content clearfix">
								<p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
								<div class="read-more cl-effect-14">
									<a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
								</div>
							</div>
						</article>

						<article class="post post-2">
							<header class="entry-header">
								<h1 class="entry-title">
									<a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
								</h1>
								<div class="entry-meta">
									<span class="post-category"><a href="#">Web Design</a></span>
			
									<span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>
			
									<span class="post-author"><a href="#">Albert Einstein</a></span>
			
									<span class="comments-link"><a href="#">4 Comments</a></span>
								</div>
							</header>
							<div class="entry-content clearfix">
								<p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
								<div class="read-more cl-effect-14">
									<a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
								</div>
							</div>
						</article>

						<article class="post post-3">
							<header class="entry-header">
								<h1 class="entry-title">
									<a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
								</h1>
								<div class="entry-meta">
									<span class="post-category"><a href="#">Web Design</a></span>
			
									<span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>
			
									<span class="post-author"><a href="#">Albert Einstein</a></span>
			
									<span class="comments-link"><a href="#">4 Comments</a></span>
								</div>
							</header>
							<div class="entry-content clearfix">
								<p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
								<div class="read-more cl-effect-14">
									<a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
								</div>
							</div>
						</article>

						<article class="post post-4">
							<header class="entry-header">
								<h1 class="entry-title">
									<a href="single.html">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
								</h1>
								<div class="entry-meta">
									<span class="post-category"><a href="#">Web Design</a></span>
			
									<span class="post-date"><a href="#"><time class="entry-date" datetime="2012-11-09T23:15:57+00:00">February 2, 2013</time></a></span>
			
									<span class="post-author"><a href="#">Albert Einstein</a></span>
			
									<span class="comments-link"><a href="#">4 Comments</a></span>
								</div>
							</header>
							<div class="entry-content clearfix">
								<p>Responsive web design offers us a way forward, finally allowing us to design for the ebb and flow of things. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don’t look even slightly.</p>
								<div class="read-more cl-effect-14">
									<a href="#" class="more-link">Continue reading <span class="meta-nav">→</span></a>
								</div>
							</div>
						</article>
					</main>
					<aside class="col-md-4">
						<div class="widget widget-recent-posts">		
							<h3 class="widget-title">Recent Posts</h3>		
							<ul>
								<li>
									<a href="#">Adaptive Vs. Responsive Layouts And Optimal Text Readability</a>
								</li>
								<li>
									<a href="#">Web Design is 95% Typography</a>
								</li>
								<li>
									<a href="#">Paper by FiftyThree</a>
								</li>
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
								<li>
									<a href="#">Web Design</a>
								</li>
								<li>
									<a href="#">Web Development</a>
								</li>
								<li>
									<a href="#">SEO</a>
								</li>
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
						<p class="copyright">&copy; 2014 ThemeWagon.com -More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
					</div>
				</div>
			</div>
		</footer>

		<!-- Mobile Menu -->
		<div class="overlay overlay-hugeinc">
			<button type="button" class="overlay-close"><span class="ion-ios-close-empty"></span></button>
			<nav>
				<ul>
					<li><a href="index.html">Home</a></li>
					<li><a href="full-width.html">Blog</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</nav>
		</div>

		<script src="../js/script.js"></script>
</body>
</html>