<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>时刻圆梦</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<!--web-fonts-->
<link href='http://fonts.useso.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<!--js-->
<script src="js/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
	</script>
<!-- //end-smoth-scrolling -->
</head>
<body>
<!--header start here-->
<div class="mother-grid">
	<div class="container">
		<div class="header">
			<div class="header-left">
				  <a href="index.jsp"> <img src="images/logo.png"> </a>
			</div>
			<span class="menu"> <img src="images/icon-1.png"></span>
			<div class="clear"> </div>
			<div class="header-right">
				  <ul class="res"> 
				  	  <li><a href="about.jsp">关于我们</a></li>
				  	   <li><a href="rule.jsp">活动规则</a></li>
				  	   <li><a href="before.jsp">往期受助</a></li>
				  	   <li><a href="apply.jsp">助学申请</a></li>
				  	   <li><a href="contact.jsp">联系我们</a></li>
				  </ul>
				  
			</div>
	<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!--header end here-->
<!--about start here-->
<div class="about">
	<div class="container">
		<div class="about-main">
			<h3>关于我们</h3>
			<div class="col-md-8 about-left">
				<p>时刻教育创办于2014年4月16日，历时七个多月已初具规模。机构主要采用一对一家教、小班教学模式。优质的服务和创新的教学模式受到了家长的肯定和孩子的支持。
核心团队来自福建师范大学在校本科生、研究生，精英的师资团队，我们秉承一切为了孩子的理念，认真负责孩子的未来。贴心健全的学习跟踪服务系统，牢牢把握孩子问题所在。独特的新媒体运营团队，竭诚提供温馨人性化的后台跟踪服务，快速调整教学内容。现阶段，团队已退出“时刻在线”微信教育服务平台，后期更将致力于推出“时刻在线”网络教育模块，因为我们坚信，明星老师加网络化才是教育培训的未来，在线教育终有一天能够颠覆传统学习。
</p>
			</div>
			<div class="col-md-4 about-right">
				<img src="images/found.jpg">
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<!--about end here-->

<!--copyrights start here-->
<div class="copyright">
	<div class="container">
		<div class="copy-right-main">
			<div class="col-md-6 copy-left">
				<p>Copyright &copy; 2014.福州第玖帮教育科技有限公司</p>
			</div>
			 <script type="text/javascript">
									$(document).ready(function() {
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
					<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='utf-8'></script></div>
</body>
</html>