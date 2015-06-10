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
	
	<link rel="stylesheet" href="css/styles/progress-slider.css?v=1">
	<link rel="stylesheet" href="css/styles/table.css?v=1">
	

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

	<form method="post" action="ChangePwdServlet" id="form-changepwd" class="block wizard same-height">

		<h3 class="block-title">密码修改</h3>

		<fieldset class="wizard-fieldset fields-list">

			<legend class="legend">密码修改</legend>
            
            <div class="field-block">
				<h4>嗨！</h4>
				<p>请按以下步骤修改密码:</p>
			</div>
                        
            <div class="field-block button-height">
				<label for="first_name" class="label"><b>用户名</b></label>
				<input name="login" type="text" id="login" value="${ sessionScope.user.uname }" readonly="readonly">
		&nbsp;*不可修改！</div>

			<div class="field-block button-height">
				<label for="password1" class="label"><b>原密码</b></label>
				<input type="password" name="oldpass" id="oldpass" value="" class="input validate[required]">
            </div>
             
             <div class="field-block button-height">
				<label for="password2" class="label"><b>新密码</b></label>
				<input type="password" name="pass" id="pass" value="">
             </div>
             
             <div class="field-block button-height">
				<label for="password3" class="label"><b>确认新密码</b></label>
				<input type="password" name="repass" id="repass" value="">
             </div>
             
              <div class="field-block button-height wizard-controls align-right">

				<a href="mytravellists.jsp">
				<button type="button" class="button glossy mid-margin-right">
					<span class="button-icon red-gradient"><span class="icon-cross"></span></span>
					返回
		   		</button></a>

			   <button type="submit" class="button glossy mid-margin-right">
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

	<script src="js/developr.navigable.js"></script>
	<script src="js/developr.progress-slider.js"></script>
	<script src="js/developr.tabs.js"></script>


	<!-- jQuery Form Validation -->
	<script src="js/libs/formValidator/jquery.validationEngine.js?v=1"></script>
	<script src="js/libs/formValidator/languages/jquery.validationEngine-en.js?v=1"></script>

	<script>
	
	    $.template.init();
	    

		$('#form-changepwd').submit(function(event) {
			// Values
			var login = $.trim($('#login').val()),
				oldpass = $.trim($('#oldpass').val()),
				pass = $.trim($('#pass').val()),
				repass = $.trim($('#repass').val());

			// Remove previous messages
			//formWrapper.clearMessages();

			// Check inputs
			if (oldpass.length === 0) {
				// Display message
				openAlert('请输入原密码！');
				return false;
			} else if (pass.length === 0) {
				// Display message
				openAlert('请输入新密码！ ');
				return false;
			} else if (repass !== pass) {
				// Display message
				openAlert('两次密码不匹配，请重新输入！');
				return false;
			} else {
				
				alert('确定修改密码吗? ');
				// Stop normal behavior
				event.preventDefault();

				// This is where you may do your AJAX call
				$.ajax("ChangePwdServlet", {
					 		data: {
					 			login:		login,
					  			oldpass:	oldpass,
					  			pass: 		pass
					  		},
					  		success: function(data)
					  		{
					  			if (data == "1")
					  			{
					  				openAlert("密码修改成功！ ");
					  				window.location = "mytravellists.jsp";
					  			}
					  			else if(data == "-1")
					  			{
					  				openAlert("输入的原密码错误！  ");
					  			}
					  			else if(data == "-2")
					  			{
					  				openAlert("密码修改失败！  ");
					  			}
					  		},
					  		error: function()
					  		{
					 			openAlert('服务器连接失败, 请重试! ');
					  		}
					  });
				
				// Simulate server-side check
				//setTimeout(function() {
				//document.location.href = './'
				//}, 2000);
			}
		});

		function openConfirm() {
			$.modal.confirm('确定修改密码吗? ', function() {
				
			}, function() {
				$.modal.alert('呵呵  -_-||');
				
			});
		};

		// Demo alert
		function openAlert(message)
		{
			$.modal.alert(message);
		};

		
		
		// Code display
		prettyPrint();

		$(document)
				.ready(
						function() {
							// Elements
							var form = $('.wizard'),

							// If layout is centered
							centered;

							// Handle resizing (mostly for debugging)
							function handleWizardResize() {
								centerWizard(false);
							}
							;

							// Register and first call
							$(window).bind('normalized-resize',
									handleWizardResize);

							/*
							 * Center function
							 * @param boolean animate whether or not to animate the position change
							 * @return void
							 */
							function centerWizard(animate) {
								form[animate ? 'animate' : 'css']
										({
											marginTop : Math
													.max(
															0,
															Math
																	.round(($.template.viewportHeight - 30 - form
																			.outerHeight()) / 2))
													+ 'px'
										});
							}
							;

							// Initial vertical adjust
							centerWizard(false);

							// Refresh position on change step
							form.on('wizardchange', function() {
								centerWizard(true);
							});

							// Validation
							if ($.validationEngine) {
								form.validationEngine();
							}
						});
		

	</script>

</body>
</html>