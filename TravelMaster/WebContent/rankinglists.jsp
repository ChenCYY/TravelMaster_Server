<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<!--[if IEMobile 7]><html class="no-js iem7 oldie"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!--><html class="no-js" lang="en"><!--<![endif]-->

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

	<title>TravelMaster</title>
	<meta name="description" content="">
	<meta name="author" content="">

	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!-- For all browsers -->
	<link rel="stylesheet" href="css/reset.css?v=1">
	<link rel="stylesheet" href="css/style.css?v=1">
	<link rel="stylesheet" href="css/colors.css?v=1">
	<link rel="stylesheet" media="print" href="css/print.css?v=1">
	<!-- For progressively larger displays -->
	<link rel="stylesheet" media="only all and (min-width: 480px)" href="css/480.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 768px)" href="css/768.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 992px)" href="css/992.css?v=1">
	<link rel="stylesheet" media="only all and (min-width: 1200px)" href="css/1200.css?v=1">
	<!-- For Retina displays -->
	<link rel="stylesheet" media="only all and (-webkit-min-device-pixel-ratio: 1.5), only screen and (-o-min-device-pixel-ratio: 3/2), only screen and (min-device-pixel-ratio: 1.5)" href="css/2x.css?v=1">

	<!-- Webfonts -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>

	<!-- Additional styles -->
	<link rel="stylesheet" href="css/styles/form.css?v=1">
	<link rel="stylesheet" href="css/styles/switches.css?v=1">
	<link rel="stylesheet" href="css/styles/table.css?v=1">

	<!-- DataTables -->
	<link rel="stylesheet" href="js/libs/DataTables/jquery.dataTables.css?v=1">

	<!-- JavaScript at bottom except for Modernizr -->
	<script src="js/libs/modernizr.custom.js"></script>
	

  <link rel="stylesheet" href="css/jPages.css">
  <link rel="stylesheet" href="css/animate.css">
  <link rel="stylesheet" href="css/github.css">
  	
  	

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1-->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="img/favicons/apple-touch-icon.png">

	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">

	<!-- Microsoft clear type rendering -->
	<meta http-equiv="cleartype" content="on">
	
	
	
		
	<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
  	<script type="text/javascript" src="js/highlight.pack.js"></script>
  	<script type="text/javascript" src="js/tabifier.js"></script>
  	<script src="js/js.js"></script>
  	<script src="js/jPages.js"></script>
  
	
	<script>
	

	  $(function(){
		    $("div.holder").jPages({
		      containerID : "attractions",
		      first       : "第一页",
		      previous	  : "←",
		      next 		  : "→",
		      last        : "最后一页",
		      perPage : 10,
		      delay : 20
		    });
		  });
	
	
	</script>
	
	
	
	
	
	
</head>

<body class="clearfix with-menu with-shortcuts">
	
	<!-- Prompt IE 6 users to install Chrome Frame -->
	<!--[if lt IE 7]><p class="message red-gradient simpler">Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

<c:if test="${empty sessionScope.user }">
		<script>
			location = "login.jsp";
			alert("您尚未登陆!");	
		</script>
</c:if>
<c:if test="${empty requestScope.lstAttraction }">
	<script>
		window.location = "ShowAttractionServlet";
	</script>
	
</c:if>
	<!-- Title bar -->
	<header role="banner" id="title-bar">
		<h2>旅行大师-景点排行
	</h2></header>

	<!-- Button to open/hide menu -->
	<a href="login.jsp"><span>登陆</span></a>

	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>

	<!-- Main content -->
	<section role="main" id="main">

		<noscript class="message black-gradient simpler">Your browser does not support JavaScript! Some features won't work as expected...</noscript>

	  <hgroup id="main-title" class="thin">
			<h1>景点排行榜</h1>
		</hgroup>
		
        <div class="with-padding">
	  <div class="table-header button-height">
	  
	  <form method="post" action="FindAttractionServlet">
		  <div class="float-right">搜索:&nbsp;
                  <input type="text" name="oaname" id="table_search" value="" class="input mid-margin-left">
                  <button type="submit" class="button blue-gradient glossy" >Go</button>
          </div>
	 </form>
                &nbsp;
	</div>
			
			
			

			<table class="table responsive-table" id="sorting-example1">

				<thead>
					<tr>
						<th width="15" scope="col">&nbsp;</th>
						<th align="center" scope="col">景点名</th>
						<th width="15%" align="center" class="align-center hide-on-mobile" scope="col">好评度</th>
					  <th width="10%" align="center" class="align-center hide-on-mobile-portrait" scope="col">所在省份</th>
					  <th width="20%" align="center" class="hide-on-tablet" scope="col">所在城市</th>
					  <th width="80" align="center" class="align-right" scope="col">相关操作</th>
					</tr>
				</thead>

				
				<tbody id="attractions">
				<%int count; %><%count=0; %>
				<c:forEach items="${requestScope.lstAttraction }" var="Attraction">
					
					<tr>
						<td onclick="javascript:showInfo('${Attraction.aid}');"><%=count+1 %></td>
						<td onclick="javascript:showInfo('${Attraction.aid}');">${Attraction.aname}</a></td>
						<td onclick="javascript:showInfo('${Attraction.aid}');">${Attraction.comments}</td>
						<td onclick="javascript:showInfo('${Attraction.aid}');">${Attraction.aprovince}</td>
					  	<td onclick="javascript:showInfo('${Attraction.aid}');">${Attraction.acity}</td>
						<td class="low-padding align-center">
						<a href="AttractionServlet?aid=${Attraction.aid}" class="button icon-eye">
						详情
						</a>
						</td>
					</tr>
					
					<!-- 下拉菜单 -->
				<tr id="${Attraction.aid}" name="rowdrop" class="row-drop" style="display:none;">
				
				<td colspan=6>
					<img src="images/attractions/${Attraction.resourceids}" width="400" height="240">
				</td>
				</tr>
				<%count++; %>
				
					</c:forEach>
					
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="6">共<%=count %>条结果</td>
					</tr>
				</tfoot>

			</table>
            
            
            
            
			<form method="post" action="ShowAttractionServlet" class="table-footer button-height large-margin-bottom">
					
			<!-- 导航栏 -->		
			<div class="holder float-right"></div>
                
                按年筛选:
				<select name="year" class="select blue-gradient glossy mid-margin-left">
					<option value="0">全部</option>
					<option value="2014">2014年</option>
					<option value="2013">2013年</option>
					<option value="2012">2012年</option>
					<option value="2011">2011年</option>
				</select>
                按季度筛选:
                <select name="season" class="select blue-gradient glossy mid-margin-left">
					<option value="0">全部</option>
					<option value="1">春季</option>
					<option value="2">夏季</option>
					<option value="3">秋季</option>
					<option value="4">冬季</option>
				</select>
                
				<button type="submit" class="button blue-gradient glossy">Go</button>
				

			</form>
            
            
            
            
            
            
            
            </div>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<ul id="shortcuts" role="complementary" class="children-tooltip tooltip-right">
		<li class="at-bottom"><a href="index.jsp" class="shortcut-medias" title="返回首页">返回首页</a></li>
	</ul>

	<!-- JavaScript at the bottom for fast page loading -->
	
	<!-- Scripts -->
	
	<script src="js/setup.js"></script>
	
	

	<!-- Template functions -->
	<script src="js/developr.input.js"></script>
	<script src="js/developr.navigable.js"></script>
	<script src="js/developr.notify.js"></script>
	<script src="js/developr.scroll.js"></script>
	<script src="js/developr.tooltip.js"></script>
	<script src="js/developr.table.js"></script>

	<!-- Plugins -->
	<script src="js/libs/jquery.tablesorter.min.js"></script>
	<script src="js/libs/DataTables/jquery.dataTables.min.js"></script>

	<script>
	
	
	
		// Call template init (optional, but faster if called manually)
		$.template.init();
		
		function showInfo(id){
			var lstDropRow = document.getElementsByName("rowdrop");
			for(var i=0;i<lstDropRow.length;i++)
				lstDropRow[i].style.display = "none";
			document.getElementById(id).style.display = "";
		}

		// Table sort - styled
		$('#sorting-example1').tablesorter({
			headers: {
				0: { sorter: false },
				5: { sorter: false }
			}
		});

		
	</script>
</body>
</html>