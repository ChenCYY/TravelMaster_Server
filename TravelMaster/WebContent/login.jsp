﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
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
	

	<!-- Login pages styles -->
	<link rel="stylesheet" media="screen" href="css/login.css?v=1">

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
<body>
	<!-- JavaScript at the bottom for fast page loading -->

	<!-- Scripts -->
	<script src="js/libs/jquery-1.8.2.min.js"></script>
	<script src="js/setup.js"></script>

	<!-- Template functions -->
	<script src="js/developr.input.js"></script>
	<script src="js/developr.message.js"></script>
	<script src="js/developr.notify.js"></script>
	<script src="js/developr.tooltip.js"></script>
	
	<script src="js/developr.modal.js"></script>
	<script src="js/developr.navigable.js"></script>
	<script src="js/developr.scroll.js"></script>
	<script src="js/developr.progress-slider.js"></script>
	<script src="js/developr.tabs.js"></script>
	
	
	<div id="container">

		<hgroup id="login-title" class="large-margin-bottom">
			<h1 class="login-title-image">TravelMaster</h1>
			<h5>&copy; 机动的晓蜗牛</h5>
		</hgroup>
		
		<div id="form-wrapper">

			<div id="form-block" class="scratch-metal">
				<div id="form-viewport">

					<form method="get" action="LoginUserServlet" id="form-login" class="input-wrapper blue-gradient glossy" title="登录">
						<ul class="inputs black-input large">
							<!-- The autocomplete="off" attributes is the only way to prevent webkit browsers from filling the inputs with yellow -->
							<li><span class="icon-user mid-margin-right"></span><input type="text" name="login" id="login" value="" class="input-unstyled" placeholder="请输入登录名" autocomplete="off"></li>
							<li><span class="icon-lock mid-margin-right"></span><input type="password" name="pass" id="pass" value="" class="input-unstyled" placeholder="请输入密码" autocomplete="off"></li>
						</ul>

						<p class="button-height">
							<button type="submit" class="button glossy float-right" id="login">登录</button>
							<span id="checkUserNameMsg"></span>
							<input type="checkbox" name="remind" id="remind" value="1" checked="checked" class="switch tiny mid-margin-right with-tooltip" title="自动登录">
							<label for="remind">记住我</label>
						</p>
					</form>

					<form method="post" action="" id="form-password" class="input-wrapper orange-gradient glossy" title="忘记密码?">

						<p class="message">
							如果您忘记密码，请填写您的登录名和注册邮箱，我们会将密码以邮件的形式发送至您的邮箱：
							<span class="block-arrow"><span></span></span>
						</p>

						<ul class="inputs black-input large">
                            <li><span class="icon-user mid-margin-right"></span><input type="text" name="login-pass" id="login-pass" value="" class="input-unstyled" placeholder="请输入登录名" autocomplete="off"></li>
							<li><span class="icon-mail mid-margin-right"></span><input type="email" name="mail-pass" id="mail-pass" value="" class="input-unstyled" placeholder="请输入电子邮箱" autocomplete="off"></li>
						</ul>

						<button type="submit" class="button glossy full-width" id="send-password">发送密码</button>

					</form>

					<form method="post" action="RegisterUserServlet" id="form-register" class="input-wrapper green-gradient glossy" title="注册">

						<p class="message">
							新用户？请先注册吧：
							<span class="block-arrow"><span></span></span>
						</p>

						<ul class="inputs black-input large">
							<li><span class="icon-user mid-margin-right"></span><input type="text" name="login" id="login-register" value="" class="input-unstyled" placeholder="请输入登录名" autocomplete="off"></li>
							<li><span class="icon-lock mid-margin-right"></span><input type="password" name="pass" id="pass-register" value="" class="input-unstyled" placeholder="请输入密码" autocomplete="off"></li>
                            <li><span class="icon-lock mid-margin-right"></span><input type="password" name="repass" id="repass-register" value="" class="input-unstyled" placeholder="请再次输入密码" autocomplete="off"></li>
							<li><span class="icon-card mid-margin-right"></span>
                              <label>性别
                                <select name="gender" size="1" id="gender-register">
                                  <option value="男" selected>男</option>
                                  <option value="女">女</option>
                                </select>
                              </label>
                            </li>
							<li><span class="icon-mail mid-margin-right"></span><input type="email" name="mail" id="mail-register" value="" class="input-unstyled" placeholder="请输入电子邮箱" autocomplete="off"></li>
						</ul>

						<button type="submit" class="button glossy full-width" id="send-register">注册</button>

					</form>

				</div>

			</div>
			
			<a href="index.jsp"><button type="submit" class="button glossy full-width" id="goback" >返回首页</button></a>
		
		</div>
		

	</div>


	<script>

		/*
		 * How do I hook my login script to these?
		 * --------------------------------------
		 *
		 * These scripts are meant to be non-obtrusive: if the user has disabled javascript or if an error occurs, the forms
		 * works fine without ajax.
		 *
		 * The only part you need to edit are the scripts between the EDIT THIS SECTION tags, which do inputs validation and
		 * send data to server. For instance, you may keep the validation and add an AJAX call to the server with the user
		 * input, then redirect to the dashboard or display an error depending on server return.
		 *
		 * Or if you don't trust AJAX calls, just remove the event.preventDefault() part and let the form be submitted.
		 */

		$(document).ready(function()
		{
			/*
			 * JS login effect
			 * This script will enable effects for the login page
			 */
				// Elements
			var doc = $('html').addClass('js-login'),
				container = $('#container'),
				formWrapper = $('#form-wrapper'),
				formBlock = $('#form-block'),
				formViewport = $('#form-viewport'),
				forms = formViewport.children('form'),

				// Doors
				topDoor = $('<div id="top-door" class="form-door"><div></div></div>').appendTo(formViewport),
				botDoor = $('<div id="bot-door" class="form-door"><div></div></div>').appendTo(formViewport),
				doors = topDoor.add(botDoor),

				// Switch
				formSwitch = $('<div id="form-switch"><span class="button-group"></span></div>').appendTo(formBlock).children(),

				// Current form
				hash = (document.location.hash.length > 1) ? document.location.hash.substring(1) : false,

				// If layout is centered
				centered,

				// Store current form
				currentForm,

				// Animation interval
				animInt,

				// Work vars
				maxHeight = false,
				blocHeight;

			/******* EDIT THIS SECTION *******/

			/*
			 * Login
			 * These functions will handle the login process through AJAX
			 */
			$('#form-login').submit(function(event)
			{
				// Values
				var login = $.trim($('#login').val()),
					pass = $.trim($('#pass').val());

				formWrapper.clearMessages();
				// Check inputs
				if (login.length === 0)
				{
					// Display message
					displayError('登录名不能为空！');
					return false;
				}
				else if (pass.length === 0)
				{
					// Remove empty login message if displayed
					formWrapper.clearMessages('登录名不能为空！');

					// Display message
					displayError('密码不能为空！');
					return false;
				}
				else
				{
					// Remove previous messages
					formWrapper.clearMessages();

					// Show progress
					displayLoading('登录中……');

					
					// Stop normal behavior
					event.preventDefault();
					//loginValidate();
					
					 //This is where you may do your AJAX call, for instance:
					 $.ajax("LoginUserServlet", {
					 		data: {
					 			login:	login,
					  			pass:	pass
					  		},
					  		success: function(data)
					  		{
					  			if (data == "ok")
					  			{
					 				document.location.href = 'index.jsp';
					  			}
					  			else if(data == "failed")
					  			{
					  				formWrapper.clearMessages();
					  				displayError('用户名或密码错误,请重试! ');
					  			}
					  			else if(data == "logged")
					  			{
					  				formWrapper.clearMessages();
					  				displayError('该用户已经登陆 ! ');
					  			}
					  		},
					  		error: function()
					  		{
					  			formWrapper.clearMessages();
					 			displayError('服务器连接失败, 请重试! ');
					  		}
					  });
					 
					 
					// Simulate server-side check
					setTimeout(function() {
						//document.location.href = './'
					}, 2000);
				}
			});

			/*
			 * Password recovery
			 */
			$('#form-password').submit(function(event)
			{
				// Values
				var login = $.trim($('#login-pass').val()),
				    mail = $.trim($('#mail-pass').val());
				

				formWrapper.clearMessages();
				// Check inputs
				if (login.length === 0)
				{
					displayError('登录名不能为空！');
					return false;
				}
				else if (mail.length === 0)
				{
					// Display message
					displayError('电子邮箱不能为空！');
					return false;
				}
				else if (!/^[a-z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/.test(mail))
				{
					displayError('电子邮箱格式不正确！');
					return false;
				}
				else
				{
					// Remove previous messages
					formWrapper.clearMessages();

					// Show progress
					displayLoading('发送中……');

					// Stop normal behavior
					//event.preventDefault();

					/*
					 * This is where you may do your AJAX call
					 */

					// Simulate server-side check
					setTimeout(function() {
						document.location.href = 'login.jsp'
					}, 2000);
				}
			});

			/*
			 * Register
			 */
			$('#form-register').submit(function(event)
			{
				// Values
				var login = $.trim($('#login-register').val()),
					mail = $.trim($('#mail-register').val()),
					pass = $.trim($('#pass-register').val()),
					gender = $.trim($('#gender-register').val()),
					repass = $.trim($('#repass-register').val());

				// Remove previous messages
				formWrapper.clearMessages();

				// Check inputs
				if (login.length === 0)
				{
					// Display message
					displayError('登录名不能为空！');
					return false;
				}
				else if (pass.length === 0)
				{
					// Display message
					displayError('密码不能为空！');
					return false;
				}
				else if (repass !== pass )
				{
					// Display message
					displayError('两次密码不匹配，请重新输入！');
					return false;
				}
				else if (mail.length === 0)
				{
					// Display message
					displayError('电子邮箱不能为空！');
					return false;
				}
				else if (!/^[a-z0-9!#$%&'*+\/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+\/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/.test(mail))
				{
					// Display message
					displayError('电子邮箱格式不正确！');
					return false;
				}
				else
				{
					
					// Stop normal behavior
					event.preventDefault();
					
					// This is where you may do your AJAX call
					 $.ajax("RegisterUserServlet", {
					 		data: {
					 			login:	login,
					  			pass:	pass,
					  			gender: gender,
					  			mail: mail
					  		},
					  		success: function(data)
					  		{
					  			if (data == "1")
					  			{
					  				openLoadingModal();
					  			}
					  			else if(data == "-1")
					  			{
					  				formWrapper.clearMessages();
					  				displayError('服务器连接失败! ');
					  			}
					  			else if(data == "-2")
					  			{
					  				formWrapper.clearMessages();
					  				displayError('注册邮箱不可用! ');
					  			}
					  			else if(data == "-3")
					  			{
					  				formWrapper.clearMessages();
					  				displayError('用户名已存在! ');
					  			}
					  		},
					  		error: function()
					  		{
					  			formWrapper.clearMessages();
					 			displayError('服务器连接失败, 请重试! ');
					  		}
					  });

					// Simulate server-side check
					//setTimeout(function() {
						//document.location.href = './'
					//}, 2000);
				}
			});

			/******* END OF EDIT SECTION *******/

			/*
			 * Animated login
			 */

			// Prepare forms
			forms.each(function(i)
			{
				var form = $(this),
					height = form.outerHeight(),
					active = (hash === false && i === 0) || (hash === this.id),
					color = this.className.match(/[a-z]+-gradient/) ? ' '+(/([a-z]+)-gradient/.exec(this.className)[1])+'-active' : '';

				// Store size
				form.data('height', height);

				// Min-height for mobile layout
				if (maxHeight === false || height > maxHeight)
				{
					maxHeight = height;
				}

				// Button in the switch
				form.data('button', $('<a href="#'+this.id+'" class="button anthracite-gradient'+color+(active ? ' active' : '')+'">'+this.title+'</a>')
									.appendTo(formSwitch)
									.data('form', form));

				// Remove title to prevent tooltip from showing - thanks efreed :)
				this.title = '';

				// If active
				if (active)
				{
					// Store
					currentForm = form;

					// Height of viewport
					formViewport.height(height);
				}
				else
				{
					// Hide for now
					form.hide();
				}
			});

			// Main bloc height (without form height)
			blocHeight = formBlock.height()-currentForm.data('height');

			// Handle resizing (mostly for debugging)
			function handleLoginResize()
			{
				// Detect mode
				centered = (container.css('position') === 'absolute');

				// Set min-height for mobile layout
				if (!centered)
				{
					formWrapper.css('min-height', (blocHeight+maxHeight+20)+'px');
					container.css('margin-top', '');
				}
				else
				{
					formWrapper.css('min-height', '');
					if (parseInt(container.css('margin-top'), 10) === 0)
					{
						centerForm(currentForm, false);
					}
				}
			};

			// Register and first call
			$(window).bind('normalized-resize', handleLoginResize);
			handleLoginResize();

			// Switch behavior
			formSwitch.on('click', 'a', function(event)
			{
				var link = $(this),
					form = link.data('form'),
					previousForm = currentForm;

				event.preventDefault();
				if (link.hasClass('active'))
				{
					return;
				}

				// Refresh forms sizes
				forms.each(function(i)
				{
					var form = $(this),
						hidden = form.is(':hidden'),
						height = form.show().outerHeight();

					// Store size
					form.data('height', height);

					// If not active
					if (hidden)
					{
						// Hide for now
						form.hide();
					}
				});

				// Clear messages
				formWrapper.clearMessages();

				// If an animation is already running
				if (animInt)
				{
					clearTimeout(animInt);
				}
				formViewport.stop(true);

				// Update active button
				currentForm.data('button').removeClass('active');
				link.addClass('active');

				// Set as current
				currentForm = form;

				// if CSS transitions are available
				if (doc.hasClass('csstransitions'))
				{
					// Close doors - step 1
					doors.removeClass('door-closed').addClass('door-down');
					animInt = setTimeout(function()
					{
						// Close doors, step 2
						doors.addClass('door-closed');
						animInt = setTimeout(function()
						{
							// Hide previous form
							previousForm.hide();

							// Show target form
							form.show();

							// Center layout
							centerForm(form, true);

							// Height of viewport
							formViewport.animate({
								height: form.data('height')+'px'
							}, function()
							{
								// Open doors, step 1
								doors.removeClass('door-closed');
								animInt = setTimeout(function()
								{
									// Open doors - step 2
									doors.removeClass('door-down');
								}, 300);
							});
						}, 300);
					}, 300);
				}
				else
				{
					// Close doors
					topDoor.animate({ top: '0%' }, 300);
					botDoor.animate({ top: '50%' }, 300, function()
					{
						// Hide previous form
						previousForm.hide();

						// Show target form
						form.show();

						// Center layout
						centerForm(form, true);

						// Height of viewport
						formViewport.animate({
							height: form.data('height')+'px'
						}, {

							/* IE7 is a bit buggy, we must force redraw */
							step: function(now, fx)
							{
								topDoor.hide().show();
								botDoor.hide().show();
								formSwitch.hide().show();
							},

							complete: function()
							{
								// Open doors
								topDoor.animate({ top: '-50%' }, 300);
								botDoor.animate({ top: '105%' }, 300);
								formSwitch.hide().show();
							}
						});
					});
				}
			});

			// Initial vertical adjust
			centerForm(currentForm, false);

			/*
			 * Center function
			 * @param jQuery form the form element whose height will be used
			 * @param boolean animate whether or not to animate the position change
			 * @param string|element|array any jQuery selector, DOM element or set of DOM elements which should be ignored
			 * @return void
			 */
			function centerForm(form, animate, ignore)
			{
				// If layout is centered
				if (centered)
				{
					var siblings = formWrapper.siblings().not('.closing'),
						finalSize = blocHeight+form.data('height');

					// Ignored elements
					if (ignore)
					{
						siblings = siblings.not(ignore);
					}

					// Get other elements height
					siblings.each(function(i)
					{
						finalSize += $(this).outerHeight(true);
					});

					// Setup
					container[animate ? 'animate' : 'css']({ marginTop: -Math.round(finalSize/2)+'px' });
				}
			};

			/**
			 * Function to display error messages
			 * @param string message the error to display
			 */
			function displayError(message)
			{
				// Show message
				var message = formWrapper.message(message, {
					append: false,
					arrow: 'bottom',
					classes: ['red-gradient','align-center'],
					animate: false					// We'll do animation later, we need to know the message height first
				});

				// Vertical centering (where we need the message height)
				centerForm(currentForm, true, 'fast');

				// Watch for closing and show with effect
				message.bind('endfade', function(event)
				{
					// This will be called once the message has faded away and is removed
					centerForm(currentForm, true, message.get(0));

				}).hide().slideDown('fast');
			};

			/**
			 * Function to display loading messages
			 * @param string message the message to display
			 */
			function displayLoading(message)
			{
				// Show message
				var message = formWrapper.message('<strong>'+message+'</strong>', {
					append: false,
					arrow: 'bottom',
					classes: ['blue-gradient', 'align-center'],
					stripes: true,
					darkStripes: false,
					closable: false,
					animate: false					// We'll do animation later, we need to know the message height first
				});

				// Vertical centering (where we need the message height)
				centerForm(currentForm, true, 'fast');

				// Watch for closing and show with effect
				message.bind('endfade', function(event)
				{
					// This will be called once the message has faded away and is removed
					centerForm(currentForm, true, message.get(0));

				}).hide().slideDown('fast');
			};
		});
		
		
		
		// Demo loading modal
		function openLoadingModal()
		{
			var timeout;

			$.modal({
				contentAlign: 'center',
				width: 240,
				title: '注册中...',
				content: '<div style="line-height: 25px; padding: 0 0 10px"><span id="modal-status">正在连接服务器 ...</span><br><span id="modal-progress">0%</span></div>',
				buttons: {},
				scrolling: false,
				actions: {
					'Cancel': {
						color:	'red',
						click:	function(win) { win.closeModal(); }
					}
				},
				onOpen: function()
				{
						// Progress bar
					var progress = $('#modal-progress').progress(100, {
							size: 200,
							style: 'large',
							barClasses: ['anthracite-gradient', 'glossy'],
							stripes: true,
							darkStripes: false,
							showValue: false
						}),

						// Loading state
						loaded = 0,

						// Window
						win = $(this),

						// Status text
						status = $('#modal-status'),

						// Function to simulate loading
						simulateLoading = function()
						{
							loaded+=2;
							progress.setProgressValue(loaded+'%', true);
							if (loaded > 100)
							{
								progress.hideProgressStripes().changeProgressBarColor('green-gradient');
								status.text('正在跳转至登陆界面... ');
								/*win.getModalContentBlock().message('Content loaded!', {
									classes: ['green-gradient', 'align-center'],
									arrow: 'bottom'
								});*/
								setTimeout(function() { win.closeModal(); }, 1500);
							}
							else
							{
								if (loaded < 65)
								{
									status.text('注册中...');
								}
								else if (loaded < 100 && loaded > 65)
								{
									status.text('注册成功! ');
								}
								timeout = setTimeout(simulateLoading, 50);
							}
						};

					// Start
					timeout = setTimeout(simulateLoading, 2000);
				},
				onClose: function()
				{
					// Stop simulated loading if needed
					clearTimeout(timeout);
					document.location.href = 'login.jsp';
				}
			});
		};


	</script>

</body>
</html>