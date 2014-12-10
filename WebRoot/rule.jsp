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
<!-- <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> -->
<meta http-equiv="Content-type" name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width">
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
<!--/header end here-->

<!--contant banner start here-->
<div class="contant-banner">
	<div class="container">
		<div class="contant-banner-main">
			<h3>活动规则</h3>
			<p>时刻教育机构感恩回馈，免费辅导公益圆梦。时刻在线公众号每增加100个关注量，将增加1个名额的助学机会。用户可以自荐也可以推荐周围需要助学的朋友，将资料填写上传，通过审核后将有机会到线下机构进行免费补习。</p>
			<p>该活动最终解释权归福州第玖帮教育科技有限公司所有。</p>
		</div>
	</div>
</div>
<!--/contant banner end here-->

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