<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>时刻找家教</title>
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

<!--donate start here-->
<div class="donate-banner">
	<div class="container">
		  <div class="donate-banner-main">
				<div class="col-md-6 donate-banner-left">
					<h3> 我要找家教 </h3>
				</div>
		<div class="clearfix"> </div>
		    </div>
	  </div>
</div>
<div class="donate">
	<div class="container">
		<div class="donate-main">
			<div class="col-md-8 donate-right">
				<div class="donate-top">
					<h3>申请信息</h3>
					<form action="tutor/fTutorAction.action" method="post" name="tutorForm">
						学员姓名：<input type="text" name="tuName" value="" /></br>
						学员性别：<input type="radio" name="tuSex" value="male" />男
						<input type="radio" name="tuSex" value="female" />女</br></br>
						学员性别：<select name="tuGrade">
							<option value="select your grade">==请选择==</option>
							<option value="1">一年级</option>
							<option value="2">二年级</option>
							<option value="3">三年级</option>
							<option value="4">四年级</option>
							<option value="5">五年级</option>
							<option value="6">六年级</option>
							<option value="7">初一</option>
							<option value="8">初二</option>
							<option value="9">初三</option>
							<option value="10">高一</option>
							<option value="11">高二</option>
							<option value="12">高三</option>
						</select></br></br>
						辅导科目：<input type="text" name="tuCourse" value="" /></br>
					 	学习情况：<input type="radio" name="tuState" value="ex" />拔尖
					 	<input type="radio" name="tuState" value="good" />优秀
					 	<input type="radio" name="tuState" value="ordi" />普通
					 	<input type="radio" name="tuState" value="bad" />不理想</br></br>
					 	辅导方式：<select name="tuMethod">
							<option value="">==请选择==</option>
							<option value="one">一对一上门</option>
							<option value="many">一对多上门</option>
							<option value="cla">小班辅导（仅限机构开班区域）</option>
						</select></br></br>
						家教时间：<input type="text" name="tuTime" value="" /></br>
						联系方式：<input type="text" name="tuTel" value="" /></br>
						 住         址：<input type="text" name="tuAddress" value="" /></br>
						对老师的要求：<input type="text" name="tuRequest" value="" /></br>
						<div class="text-sma">	
						<input type="submit"  value="提交">
					</div>
					<div class="clearfix"> </div>
					</form>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
</div>
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