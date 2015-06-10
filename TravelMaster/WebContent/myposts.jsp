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
    <link rel="stylesheet" href="css/styles/modal.css?v=1">

	<!-- DataTables -->
	<link rel="stylesheet" href="js/libs/DataTables/jquery.dataTables.css?v=1">

	<!-- JavaScript at bottom except for Modernizr -->
	<script src="js/libs/modernizr.custom.js"></script>

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
</head>

<body class="clearfix with-menu with-shortcuts">
	<c:if test="${empty sessionScope.user }">
		<script>
		location = "login.jsp";
		alert("您尚未登陆!");	
	</script>
	</c:if>
		
	<c:if test="${empty requestScope.lstHotAttractions }">
		<script>
			window.location = "ShowMyPostsServlet";
		</script>
	</c:if>


	<!-- Prompt IE 6 users to install Chrome Frame -->
	<!--[if lt IE 7]><p class="message red-gradient simpler">Your browser is <em>ancient!</em> <a href="http://browsehappy.com/">Upgrade to a different browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to experience this site.</p><![endif]-->

	<!-- Title bar -->
	<header role="banner" id="title-bar">
		<h2>旅行大师-个人中心-我的帖子
	</h2></header>

	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>

	<!-- Button to open/hide shortcuts -->
	<a href="#" id="open-shortcuts"><span class="icon-thumbs"></span></a>

	<!-- Main content -->
	<section role="main" id="main">

		<noscript class="message black-gradient simpler">Your browser does not support JavaScript! Some features won't work as expected...</noscript>

	  <hgroup id="main-title" class="thin">
			<h1>我的帖子</h1>
		</hgroup>
        <div class="with-padding">
            
            
            
            <table class="table responsive-table" id="sorting-advanced">
				<thead>
					<tr>
						<th width="15" scope="col">&nbsp;</th>
						<th align="center" scope="col">帖子主题</th>
						<th width="15%" align="center" class="align-center hide-on-mobile" scope="col">发帖时间</th>
					  <th width="10%" align="center" class="align-center hide-on-mobile-portrait" scope="col">回复数</th>
					  <th width="20%" align="center" class="hide-on-tablet" scope="col">最新回复时间</th>
					  <th width="100" align="center" class="align-right" scope="col">相关操作</th>
					</tr>
				</thead>

				
				<tbody>
				<%int count; %>
				<%count=0; %>
					<c:forEach items="${ requestScope.lstMyPosts }" var="post">
					<tr>
						
						<th><%=count+1 %></th>
						<td>${ post.ptitle }</td>
						<td>${ post.postdate }</td>
						<td>${ post.replynum }</td>
					  	<td>${ post.latestreply }</td>
                        <td class="low-padding align-center">
                        	<a href="ShowReplyServlet?pid=${post.pid }">
                        		<button type="button" class="button compact icon-eye">
			            			点击查看
			            		</button>
			            	</a>
			          
			            </td>
			          				
					</tr>
							
					<%count=count+1; %>
					
					</c:forEach>
		
					 	
				</tbody>
				
				<tfoot>
					<tr>
						<td colspan="6">
							共有<%=count %>条记录
						</td>
					</tr>
				</tfoot>
			</table>
         </div>
	</section>
	<!-- End main content -->

	<!-- Side tabs shortcuts -->
	<ul id="shortcuts" role="complementary" class="children-tooltip tooltip-right">
		<li><a href="mytravellists.jsp" class="shortcut-dashboard" title="我的旅程">我的旅程</a></li>
		<li><a href="mycollections.jsp" class="shortcut-messages" title="我的收藏">我的收藏</a></li>
	    <li class="current"><a href="myposts.jsp" class="shortcut-agenda" title="我的帖子">我的帖子</a></li>
		<li><a href="myfriends.jsp" class="shortcut-contacts" title="我的关注">我的关注</a></li>	
	    <li class="at-bottom"><a href="index.jsp" class="shortcut-medias" title="返回首页">返回首页</a></li>
	</ul>

	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary">

		<!-- This wrapper is used by several responsive layouts -->
		<div id="menu-content">

			<header>
				会员
		  </header>

			<div id="profile">
				<p>
					<img src="upload/avatar/${sessionScope.user.uavatar }" width="64" height="64"
						alt="User name" class="user-icon">你好
				</p>
				<p>
					<span class="name">${sessionScope.user.uname }</span>
				</p>
			</div>

			<!-- By default, this section is made for 4 icons, see the doc to learn how to change this, in "basic markup explained" -->
			<ul id="access" class="children-tooltip">
				<li><a href="myposts.jsp" title="我的帖子消息"><span
						class="icon-mail"></span></a></li>
				<li><a href="modifyinfo.jsp" title="修改个人信息"><span class="icon-user"></span></a></li>
				<li><a href="changepwd.jsp" title="修改密码"><span
						class="icon-gear"></span></a></li>
				<li><a href="LogoutUserServlet" title="注销"><span
						class="icon-extract"></span></a></li>
			</ul>
			<ul class="unstyled-list">   
                <li class="title-menu">我的个人信息</li>
                <li>
					<table width="70%" border="0">
						<tr>
							<td height="30" align="center" valign="bottom">用户名:</td>
							<td height="30" align="center" valign="bottom">${sessionScope.user.uname }</td>
						</tr>
						<tr>
							<td height="30" align="center" valign="bottom">用户性别:</td>
							<td height="30" align="center" valign="bottom">${sessionScope.user.usex }</td>
						</tr>
						<tr>
							<td height="30" align="center" valign="bottom">注册时间:</td>
							<td height="30" align="center" valign="bottom">${sessionScope.user.regdate }</td>
						</tr>
						<tr>
							<td height="30" align="center" valign="bottom">注册邮箱:</td>
							<td height="30" align="center" valign="bottom">${sessionScope.user.uemail }</td>
						</tr>
						<tr>
							<td height="30" align="center" valign="bottom">个性签名:</td>
							<td height="30" align="center" valign="bottom">${sessionScope.user.umark }</td>
						</tr>
					</table>

				</li>
				
                 
                
				<li class="title-menu">今日热门</li>
				<li>
					<ul class="message-menu">
						<c:forEach items="${ requestScope.lstHotAttractions}"
							var="hotattr">
							<li>
								<span class="message-status"> 
									<a href="#"	class="starred" title="加入收藏">Starred</a>
									<a href="addtravellists.jsp?aid=${ hotattr.aid }&&aname=${ hotattr.aname }" class="new-message" title="加入旅程表">New</a>
								</span> 
								<a href="AttractionServlet?aid=${hotattr.aid}" title="查看详细信息"> 
									<strong class="blue">${ hotattr.aname }</strong><br>
									<span>点击量:${ hotattr.sum }</span><br/>
									<strong>所在省份:${ hotattr.aprovince }<br/>
										所在城市:${ hotattr.acity }
									</strong>
								</a>
							</li>

						</c:forEach>

					</ul>
				</li>
		  </ul>

		</div>
		<!-- End content wrapper -->

		<!-- This is optional -->
		<footer id="menu-footer">
			<p class="button-height">
				<input type="checkbox" name="auto-refresh" id="auto-refresh" checked="checked" class="switch float-right">
				<label for="auto-refresh">自动刷新</label>
			</p>
		</footer>

	</section>
	<!-- End sidebar/drop-down menu -->

	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Scripts -->
	<script src="js/libs/jquery-1.8.2.min.js"></script>
	<script src="js/setup.js"></script>

	<!-- Template functions -->
	<script src="js/developr.input.js"></script>
    <script src="js/developr.message.js"></script>
	<script src="js/developr.navigable.js"></script>
	<script src="js/developr.notify.js"></script>
	<script src="js/developr.scroll.js"></script>
	<script src="js/developr.tooltip.js"></script>
	<script src="js/developr.table.js"></script>
    <script type="text/javascript" src="js/developr.wizard.js" charset="gbk"></script>
   	<script type="text/javascript" src="js/developr.modal.js" charset="gbk"></script>

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
 		
		 function openConfirm(id)
		{
		$.modal.confirm('确定取消关注吗? ', function()
		{
			location="RemoveRelationServlet?reid="+id;
		}, function()
		{
			$.modal.alert('呵呵  -_-||');
		});
	};

		// Table sort - DataTables
		var table = $('#sorting-advanced');
		table.dataTable({
			'aoColumnDefs': [
				{ 'bSortable': false, 'aTargets': [ 0, 5 ] }
			],
			'sPaginationType': 'full_numbers',
			'sDom': '<"dataTables_header"lfr>t<"dataTables_footer"ip>',
			'fnInitComplete': function( oSettings )
			{
				// Style length select
				table.closest('.dataTables_wrapper').find('.dataTables_length select').addClass('select blue-gradient glossy').styleSelect();
				tableStyled = true;
			}
		});
		
		

	</script>
</body>
</html>