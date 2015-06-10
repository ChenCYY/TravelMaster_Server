<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<!--[if IEMobile 7]><html class="no-js iem7 oldie linen"><![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js ie7 oldie linen" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js ie8 oldie linen" lang="en"><![endif]-->
<!--[if (IE 9)&!(IEMobile)]><html class="no-js ie9 linen" lang="en"><![endif]-->
<!--[if (gt IE 9)|(gt IEMobile 7)]><!--><html class="no-js linen" lang="en"><!--<![endif]-->

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

	<!-- Additional styles -->
	<link rel="stylesheet" href="css/styles/form.css?v=1">
	<link rel="stylesheet" href="css/styles/switches.css?v=1">
	<link rel="stylesheet" href="css/styles/modal.css?v=1">
	
	<!-- jQuery Form Validation -->
	<link rel="stylesheet" href="js/libs/formValidator/developr.validationEngine.css?v=1">

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

	<!-- IE9 Pinned Sites: http://msdn.microsoft.com/en-us/library/gg131029.aspx -->
	<meta name="application-name" content="Developr Admin Skin">
	<meta name="msapplication-tooltip" content="Cross-platform admin template.">
	<meta name="msapplication-starturl" content="http://www.display-inline.fr/demo/developr">
	<!-- These custom tasks are examples, you need to edit them to show actual pages -->
	<meta name="msapplication-task" content="name=Agenda;action-uri=http://www.display-inline.fr/demo/developr/agenda.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">
	<meta name="msapplication-task" content="name=My profile;action-uri=http://www.display-inline.fr/demo/developr/profile.html;icon-uri=http://www.display-inline.fr/demo/developr/img/favicons/favicon.ico">
</head>

<body class="full-page-wizard">
	<c:if test="${empty sessionScope.user }">
		<script>
		location = "login.jsp";
		alert("您尚未登陆!");	
	</script>
	</c:if>
	
	<form method="post" action="ModifyInfoServlet" id="form1" enctype="multipart/form-data" class="block wizard same-height">

		<h3 class="block-title">个人信息修改</h3>

		<fieldset class="wizard-fieldset fields-list">

			<legend class="legend">个人基本信息修改</legend>

			<div class="field-block">
				<h4>嗨！</h4>
				<p>请在这儿修改你的基本信息吧:</p>
			</div>

			<div class="field-block button-height">
				<label for="first_name" class="label"><b>用户名</b></label>
				<input name="uname" type="text" id="uname" value="${ sessionScope.user.uname }" readonly="readonly">
		&nbsp;*不可修改！</div>
		
			<div class="field-block button-height">
				<label for="umail" class="label"><b>注册邮箱</b></label>
				<input name="umail" type="text" id="umail" value="${ sessionScope.user.uemail }" readonly="readonly">
		&nbsp;*不可修改！</div>
		
			<div class="field-block button-height">
				<label for="regdate" class="label"><b>注册时间</b></label>
				<input name="regdate" type="text" id="regdate" value="${ sessionScope.user.regdate }" readonly="readonly">
		&nbsp;*不可修改！</div>

			<div class="field-block button-height">
				<span class="label"><b>性别</b></span>
				<input type="radio" name="gender" id="gender_male" value="男" class="radio" checked> <label for="gender_male">男</label><br>
				<input type="radio" name="gender" id="gender_female" value="女" class="radio"> <label for="gender_female">女</label>
			</div>
            
            <div class="field-block button-height">
				<label for="file" class="label"><b>头像</b> (*.jpg)</label>
				<span class="input file"><span class="file-text"></span><span class="button compact">选择文件</span><input type="file" name="file-input" id="file-input" value="" class="file withClearFunctions"></span>
           </div>
           
          <div class="field-block button-height">
				<label for="signature" class="label"><b>个性签名</b></label>
                <label>
                       <textarea name="umark" id="umark" cols="45" rows="5">${ sessionScope.user.umark }</textarea>  
                 </label>		  
          </div>
          
          <div class="field-block button-height wizard-controls align-right">
				<a href="mytravellists.jsp">
				<button type="button" class="button glossy mid-margin-right">
					<span class="button-icon red-gradient"><span class="icon-cross"></span></span>
					返回
		    </button></a>

			   <button type="button" class="button glossy mid-margin-right" onclick="return openConfirm()">
					<span class="button-icon"><span class="icon-tick"></span></span>
					提交
		    </button>
		  </div>

		</fieldset>
      
	</form>

	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Scripts -->
	<script src="js/libs/jquery-1.8.2.min.js"></script>
	<script src="js/setup.js"></script>

	<!-- Template functions -->
	<script src="js/developr.input.js"></script>
	<script src="js/developr.message.js"></script>
	<script src="js/developr.notify.js"></script>
	<script src="js/developr.scroll.js"></script>
	<script src="js/developr.tooltip.js"></script>
	<script type="text/javascript" src="js/developr.wizard.js" charset="gbk"></script>
	<script type="text/javascript" src="js/developr.modal.js" charset="gbk"></script>
	

	<!-- Google code prettifier -->
	<script src="js/libs/google-code-prettify/prettify.js?v=1"></script>
	
	
	<script>
	$.template.init();

	// Demo confirm
	function openConfirm()
	{
		$.modal.confirm('确定保存个人信息吗?', function()
		{
			form1.submit();
		}, function()
		{
			$.modal.alert('呵呵  -_-||');
		});
	};

		$(document).ready(function()
		{
				// Elements
			var form = $('.wizard'),

				// If layout is centered
				centered;

			// Handle resizing (mostly for debugging)
			function handleWizardResize()
			{
				centerWizard(false);
			};

			// Register and first call
			$(window).bind('normalized-resize', handleWizardResize);

			/*
			 * Center function
			 * @param boolean animate whether or not to animate the position change
			 * @return void
			 */
			function centerWizard(animate)
			{
				form[animate ? 'animate' : 'css']({ marginTop: Math.max(0, Math.round(($.template.viewportHeight-30-form.outerHeight())/2))+'px' });
			};

			// Initial vertical adjust
			centerWizard(false);

			// Refresh position on change step
			form.on('wizardchange', function() { centerWizard(true); });

			// Validation
			if ($.validationEngine)
			{
				form.validationEngine();
			}
		});
		
		

	</script>

</body>
</html>