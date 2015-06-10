<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<!-- CLEditor -->
	<link rel="stylesheet" href="js/libs/CLEditor/jquery.cleditor.css">

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
	
	<script type="text/javascript">
		function IsBeyondMaxLen(str,len){
			var I=str.length;
			var t=I;
			var c;
			for(var i=0;i<1;i++){
				c=str.charCodeAt(i);
				if(c<0) c=c+65536;
				if(c>255){
					t=t+1;
				}
			}
			if(t>=Len){
				window.event.keyCode=0;
				event.srcElement.focus();
			}
		}
	</script>
	
</head>
<body class="clearfix with-menu with-shortcuts">
	<c:if test="${empty sessionScope.user }">
		<script>
			location = "login.jsp";
			alert("您尚未登陆!");	
		</script>
	</c:if>

	<header role="banner" id="title-bar">
		<h2>旅行大师-论坛-首页</h2>
	</header>
	<!-- Button to open/hide menu -->
	<a href="#" id="open-menu"><span>Menu</span></a>

	<section role="main" id="main">

		<noscript class="message black-gradient simpler">Your browser does not support JavaScript! Some features won't work as expected...</noscript>

	  <hgroup id="main-title" class="thin">
			<h1>论坛</h1>
		</hgroup>
        <div class="with-padding">
			<table class="table responsive-table" id="sorting-advanced">

				<thead>
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col" >帖子主题</th>
						<th scope="col" width="15%" class="align-center hide-on-mobile">发帖人</th>
						<th scope="col" width="10%" class="align-center hide-on-mobile-portrait">回复数</th>
						<th scope="col" width="20%" class="hide-on-tablet">发帖时间</th>
						<th scope="col" width="100" class="align-center">相关操作</th>
					</tr>
				</thead>

				

				<tbody>
				<c:forEach items="${requestScope.lstupost }" var="upost">
					<tr>
						<th scope="row" class="checkbox-cell"><input type="checkbox" name="checked[]" id="check-1" value="1"></th>
						<td>${upost.ptitle }</td>
						<td>${upost.uname }</td>
						<td>${upost.replynum }</td>
						<td>${upost.postdate }</td>
						<td class="low-padding align-center">
							<a href="ShowReplyServlet?pid=${upost.pid }">
								<button type="button" class="button compact icon-eye">
			            			点击查看
			            		</button>
							</a>
						</td>
					</tr>
					</c:forEach>
					
					
				</tbody>

			</table>
            </div>
            </section>
            
            <!-- 发表帖子 -->       
            
            <section role="main" id="main">
            <form id="singleUpload" name="singleUpload" method="post" enctype="multipart/form-data" action="/TravelMaster/AddPostServlet">
     		<div class="with-padding">
			
			
				
				<div class="block margin-bottom">
					<h3 class="block-title blue-gradient glossy" >发表帖子</h3><br/>
					<div >
					  <div style="float:left;">
					    <h3 class="thin">帖子标题:</h3>
					  </div>
					<textarea maxlength="40" name="ptitle" style="resize:none; width:60%; height:24px; align-items:center;" placeholder="在此输入主题...(40字以内)"></textarea>
					</div><br/>
					
					
					
					<div style="margin-left:0px;">
					  <div style="float:left;">
					    <h3 class="thin">帖子内容:</h3>
					  </div>
					<textarea maxlength="500" name="contents" style="resize:none; width:60%; height:160px; align-items:center;" placeholder="在此输入内容...(500字以内)"></textarea>
					</div><br/>
					</div>
					<div style="margin-top:-50px; margin-right:5px;">
						<span style="float:right;" >
						  <button type="submit" class="button blue-gradient glossy">确认发帖</button>
						</span>
						<div class="field-block button-height">
				  		<span class="input file" style="float:right;">
				  		  <span class="file-text"></span>
				  		  <span class="button compact">选择文件</span>
				  		  <input type="file" name="file-input" id="file-input" value="" class="file withClearFunctions">
				  		</span>
				  		</div>
					</div>
		</div>
	</form>
	</section>
	
	
	<!--左边栏-->
	<ul id="shortcuts" role="complementary" class="children-tooltip tooltip-right">
		<li class="at-bottom"><a href="index.jsp" class="shortcut-medias" title="返回首页">返回首页</a></li>
	</ul>
	
	
	<!--右边栏-->
	<!-- Sidebar/drop-down menu -->
	<section id="menu" role="complementary">

		<!-- This wrapper is used by several responsive layouts -->
		<div id="menu-content">

			<header> 会员 </header>

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


				<c:if test="${empty requestScope.lstHotAttractions }">
					<script>
						window.location = "ShowHotAttractionsServlet?here="+"mytravellists.jsp";
					</script>
				</c:if>

				<li class="title-menu">今日热门</li>
				<li>
					<ul class="message-menu">
						<c:forEach items="${ requestScope.lstHotAttractions}" var="hotattr">
							<li>
							<span class="message-status">
							 <a href="AddCollectionServlet?aid=${ hotattr.aid }" class="starred" title="加入收藏">Starred</a> 
							 <a href="addtravellists.jsp?aid=${ hotattr.aid }&&aname=${ hotattr.aname }" class="new-message" title="加入旅程表">New</a>
							</span> 
							<a href="AttractionServlet?aid=${hotattr.aid}" title="查看详细信息"> <strong class="blue">${ hotattr.aname }</strong>
									<br> <span>点击量:${ hotattr.sum }</span><br /> <strong>所在省份:${ hotattr.aprovince }<br />
										所在城市:${ hotattr.acity }
								</strong>
							</a></li>

						</c:forEach>

					</ul>
				</li>

			</ul>

		</div>
		<!-- End content wrapper -->

		<!-- This is optional -->
		<footer id="menu-footer">
			<p class="button-height">
				<input type="checkbox" name="auto-refresh" id="auto-refresh"
					checked="checked" class="switch float-right"> <label
					for="auto-refresh">自动刷新</label>
			</p>
		</footer>

	</section>
	
	
	<!-- Scripts -->
	<script src="js/libs/jquery-1.8.2.min.js"></script>
	<script src="js/setup.js"></script>

	<!-- Template functions -->
	<script src="js/developr.input.js"></script>
	<script src="js/developr.navigable.js"></script>
	<script src="js/developr.notify.js"></script>
	<script src="js/developr.scroll.js"></script>
	<script src="js/developr.tooltip.js"></script>
	<script src="js/developr.auto-resizing.js"></script>

	<!-- CLEditor -->
    <script src="js/libs/CLEditor/jquery.cleditor.min.js"></script>

	<script>

		// Call template init (optional, but faster if called manually)
		$.template.init();

		// CLEditor
		var editorTextarea = $('#cleditor'),
			editorWrapper = editorTextarea.parent(),
			editor = editorTextarea.cleditor({
				width:	'100%',
				height:	350
			})[0];

		// Update size when resizing
		editorWrapper.sizechange(function()
		{
			editor.refresh();
		});

	</script>

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

		// Table sort - styled
		$('#sorting-example1').tablesorter({
			headers: {
				0: { sorter: false },
				5: { sorter: false }
			}
		}).on('click', 'tbody td', function(event)
		{
			// Do not process if something else has been clicked
			if (event.target !== this)
			{
				return;
			}

			var tr = $(this).parent(),
				row = tr.next('.row-drop'),
				rows;

			// If click on a special row
			if (tr.hasClass('row-drop'))
			{
				return;
			}

			// If there is already a special row
			if (row.length > 0)
			{
				// Un-style row
				tr.children().removeClass('anthracite-gradient glossy');

				// Remove row
				row.remove();

				return;
			}

			// Remove existing special rows
			rows = tr.siblings('.row-drop');
			if (rows.length > 0)
			{
				// Un-style previous rows
				rows.prev().children().removeClass('anthracite-gradient glossy');

				// Remove rows
				rows.remove();
			}

			// Style row
			tr.children().addClass('anthracite-gradient glossy');

			// Add fake row
			$('<tr class="row-drop">'+
				'<td colspan="'+tr.children().length+'">'+
					'<div class="float-right">'+
						'<button type="submit" class="button glossy mid-margin-right">'+
							'<span class="button-icon"><span class="icon-mail"></span></span>'+
							'Send mail'+
						'</button>'+
						'<button type="submit" class="button glossy">'+
							'<span class="button-icon red-gradient"><span class="icon-cross"></span></span>'+
							'Remove'+
						'</button>'+
					'</div>'+
					'<strong>Name:</strong> John Doe<br>'+
					'<strong>Account:</strong> admin<br>'+
					'<strong>Last connect:</strong> 05-07-2011<br>'+
					'<strong>Email:</strong> john@doe.com'+
				'</td>'+
			'</tr>').insertAfter(tr);

		}).on('sortStart', function()
		{
			var rows = $(this).find('.row-drop');
			if (rows.length > 0)
			{
				// Un-style previous rows
				rows.prev().children().removeClass('anthracite-gradient glossy');

				// Remove rows
				rows.remove();
			}
		});

		// Table sort - simple
	    $('#sorting-example2').tablesorter({
			headers: {
				5: { sorter: false }
			}
		});

	</script>
</body>
</html>