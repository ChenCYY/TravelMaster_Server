<%@page import="com.chinasofti.travelmaster.biz.impl.CollectionBizImpl"%>
<%@page import="com.chinasofti.travelmaster.biz.ICollectionBiz"%>
<%@page import="com.chinasofti.travelmaster.po.Attractions"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chinasofti.travelmaster.po.ShowRemarks"%>
<%@page import="java.util.List"%>
<%@page import="com.chinasofti.travelmaster.dao.impl.ShowRemarksDaoImpl"%>
<%@page import="com.chinasofti.travelmaster.dao.IShowRemarksDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>

<head>
  <title>TravelMaster</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <link rel="stylesheet" type="text/css" href="style/style.css" />
  <style type="text/css">
#slideshow {
	margin:0 auto;
	width:640px;
	height:263px;
	background:transparent url(img/bg-grey.jpg) no-repeat 0 0;
	position:relative;
}
#slideshow #slidesContainer {
  margin:0 auto;
  width:560px;
  height:263px;
  overflow:auto; /* allow scrollbar */
  position:relative;
}
#slideshow #slidesContainer .slide {
  margin:0 auto;
  width:560px; /* reduce by 20 pixels of #slidesContainer to avoid horizontal scroll */
  height:263px;
}

/** 
 * Slideshow controls style rules.
 */
.control {
  display:block;
  width:39px;
  height:263px;
  text-indent:-10000px;
  position:absolute;
  cursor: pointer;
}
#leftControl {
  top:0;
  left:0;
  background:transparent url(img/bg-left.jpg) no-repeat 0 0;
}
#rightControl {
  top:0;
  right:0;
  background:transparent url(img/bg-right.jpg) no-repeat 0 0;
}

/** 
 * Style rules for Demo page
 */
* {
  margin:0;
  padding:0;
  font:normal 11px Verdana, Geneva, sans-serif;
  color:#5D5D5D;;
}

.slide h2, .slide p {
  margin:15px;
}
.slide h2 {
  font:italic 24px Georgia, "Times New Roman", Times, serif;
  color:#ccc;
  letter-spacing:-1px;
}
.slide img {
  float:right;
  margin-left:60px;
  border:0;
}
#footer {
  height:100px;
}
#footer p {
  margin:30px auto 0 auto;
  display:block;
  width:560px;
  height:40px;
}
-->
</style>
<script type="text/javascript" src="jquery-1.4.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
  var currentPosition = 0;
  var slideWidth = 606;
  var slides = $('.slide');
  var numberOfSlides = slides.length;

  // Remove scrollbar in JS
  $('#slidesContainer').css('overflow', 'hidden');

  // Wrap all .slides with #slideInner div
  slides
    .wrapAll('<div id="slideInner"></div>')
    // Float left to display horizontally, readjust .slides width
	.css({
      'float' : 'left',
      'width' : slideWidth
    });

  // Set #slideInner width equal to total width of all slides
  $('#slideInner').css('width', slideWidth * numberOfSlides);

  // Insert controls in the DOM
  $('#slideshow')
    .prepend('<span class="control" id="leftControl">Clicking moves left</span>')
    .append('<span class="control" id="rightControl">Clicking moves right</span>');

  // Hide left arrow control on first load
  manageControls(currentPosition);

  // Create event listeners for .controls clicks
  $('.control')
    .bind('click', function(){
    // Determine new position
	currentPosition = ($(this).attr('id')=='rightControl') ? currentPosition+1 : currentPosition-1;
    
	// Hide / show controls
    manageControls(currentPosition);
    // Move slideInner using margin-left
    $('#slideInner').animate({
      'marginLeft' : slideWidth*(-currentPosition)
    });
  });

  // manageControls: Hides and Shows controls depending on currentPosition
  function manageControls(position){
    // Hide left arrow if position is first slide
	if(position==0){ $('#leftControl').hide() } else{ $('#leftControl').show() }
	// Hide right arrow if position is last slide
    if(position==numberOfSlides-1){ $('#rightControl').hide() } else{ $('#rightControl').show() }
  }	
});

function showReply(id){
	// 获取页面中所有的消息回复表单行对象的集合
	var lstTr = document.getElementsByName("reply");
	// 使用循环遍历每个对象将其显示属性设置为none
	for(var i=0; i<lstTr.length; i++){
		lstTr[i].style.display = "none";
	}
	// 将需要显示的回复表单行对象进行显示
	document.getElementById(id).style.display = "";
}
function hiddenReply(id){
	document.getElementById(id).style.display = "none";
}




</script>
</head>

<body>

<c:if test="${empty sessionScope.user }">
		<script>
			location = "login.jsp";
			alert("您尚未登陆!");	
		</script>
</c:if>

  <div id="main">
    <div id="header">
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
           <h1><a><span class="logo_colour">${requestScope.attraction.aname }</span></a></h1>
			<h2>带给您最全的景点信息</h2>
        </div>
      </div>
      <!-- 标签栏内容 -->
      <div id="menubar">
        <ul id="menu">
          <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
          <li class="selected"><a href="index.jsp">首页</a></li>
          <li><a href="rankinglists.jsp">排行榜</a></li>
          <li><a href="ShowPostsServlet">论坛</a></li>
          <li><a href="mytravellists.jsp">个人中心</a></li>
        </ul>
      </div>
      
    </div>
	<div class="inner_copyright">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="æ¨¡æ¿ä¹å®¶">æ¨¡æ¿ä¹å®¶</a></div>
    <div id="site_content">
      <div id="sidebar_container">
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <!-- insert your sidebar items here -->
            <h3>相关信息</h3>
            
            <p>位置:${requestScope.attraction.aprovince }&nbsp;${requestScope.attraction.acity}&nbsp;&nbsp;&nbsp;&nbsp;
            	<!-- <a href="#">百度地图</a> -->
            </p>
            <p>点击量：&nbsp;&nbsp;&nbsp;${requestScope.clickrate }</p>
            <p>好感度：&nbsp;&nbsp;&nbsp;${requestScope.attraction.comments }</p>
            <p><a href="addtravellists.jsp?aid=${ requestScope.attraction.aid }&&aname=${ requestScope.attraction.aname }">加入旅程</a>&nbsp;&nbsp;&nbsp;
            
            <c:set var="aid" value="${requestScope.attraction.aid}" scope="request"></c:set>
			<c:set var="uid" value="${sessionScope.user.uid}" scope="request"></c:set>
 
            
            
            <%
            	ICollectionBiz collectionBiz = new CollectionBizImpl();
            	int aid = (Integer)request.getAttribute("aid");
            	int uid = (Integer)request.getAttribute("uid");
            	if(collectionBiz.isCollected(aid, uid)){%>
            	
            	已收藏
            		
            	<%}else{%>
            		 <a href="AddCollectionServlet?aid=${requestScope.attraction.aid}">加入收藏</a></p>
            	<%}
            %>
           
          
          </div>
          <div class="sidebar_base"></div>
        </div>
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <h3>周边景点</h3>
            <ul>
            <c:if test="${empty requestScope.lstAttraction}">
           		&nbsp;&nbsp;&nbsp;&nbsp;暂无
            </c:if>
            <c:if test="${!empty requestScope.lstAttraction}">
            	<c:forEach items="${requestScope.lstAttraction }" var="Attraction">
            		<li><a href="AttractionServlet?aid=${Attraction.aid}">${Attraction.aname}</a></li>
            	</c:forEach>
            </c:if>
              
            </ul>
          </div>
          <div class="sidebar_base"></div>
        </div>
        <div class="sidebar">
          <div class="sidebar_top"></div>
          <div class="sidebar_item">
            <h3>搜寻其它景点</h3>
            <form method="post" action="FindAttractionServlet" id="search_form">
              <p>
                <input class="search" type="text" name="oaname" placeholder="请输入景点名称" />
                <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="style/search.png" alt="Search" title="Search" />
              </p>
            </form>
          </div>
          <div class="sidebar_base"></div>
        </div>
      </div>
      <!-- 插入图片 -->
      
      <div style="width:684px; height:263px; position:relative;">
      	<div id="slideshow">
    <div id="slidesContainer">
    
    <c:forEach items="${requestScope.lstPic }" var="pic">
      <div class="slide">
        <p><img src="images/attractions/${pic}" alt="An" width="606" height="263" /></p>
      </div>
    </c:forEach>
    
    </div>
  </div>
      </div>
      
      	

      <!-- 正文介绍 -->
      <div id="content">
      	<h2>
        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.attraction.context}
        </h2>
      </div>
      
      
       <div style="width=500px;">
        <h2>相关评论:</h2>
        
 <%
  IShowRemarksDao showRemarksDao = new ShowRemarksDaoImpl();
  List<ShowRemarks> lstRemarks = showRemarksDao.selectByFollowidAndAid(0, aid);
  for(ShowRemarks remark:lstRemarks){%>
  
  <table width="70%" border="0">
        
  <tr>
    <td colspan="2"><%=remark.getUname() %>&nbsp;&nbsp;&nbsp;&nbsp; 发表于 <%=remark.getPublish() %></td>
    <td width="7%" colspan="-3" align="center"><a href="javascript:showReply('reply<%=remark.getRemarkid() %>');">回复</a></td>
  </tr>
  
  <tr>
    <td colspan="3" bgcolor="#FFFFCC"><%=remark.getRemarkcontext() %></td>
  </tr>
  
  <!-- 楼中楼回复 -->
  <tr id="reply<%=remark.getRemarkid() %>" name="reply" style="display:none;">
    <td colspan="3" align="right" valign="baseline">
    
    	<form name="formReply" method="post" action="SendReplyServlet">
    	
    	<input type="hidden" id="followid" name="followid" value="<%=remark.getRemarkid() %>">
    	<input type="hidden" id="attractionid" name="attractionid" value="<%=remark.getAid() %>">
    	<table>
    	<tr>
    		<td>
      			<textarea name="context" cols="90" rows="10" id="context"></textarea>
    		</td>
    	</tr>
      	<tr>
      		<td>
         	<input type="submit" name="submit2" id="submit2" value="回复">
     		&nbsp; &nbsp; 
     		<input type="button" name="submit3" id="submit3" onclick="javascript:hiddenReply('reply<%=remark.getRemarkid() %>');" value="关闭">
      		</td>
      	</tr>
      	</table>
      	</form>
    </td>
  </tr>
  
  
  <%
	  List<ShowRemarks> lstReplys = showRemarksDao.selectByFollowidAndAid(remark.getRemarkid(), aid);
	  for(ShowRemarks reply:lstReplys){%>
  <tr>
    <td width="10%">&nbsp;</td>
    <td colspan="2"><%=reply.getUname() %> 回复 <%=remark.getUname() %>&nbsp; <%=reply.getPublish() %> <%=reply.getRemarkcontext() %></td>
  </tr>
	
  <%
	 }%>
     </table>
  <%}
  %>
  
  

<table width="70%" border="0">
  <tr>
    <td height="30">发表评论：</td>
  </tr>
  <form id="formRemark" method="post" action="SendRemarkServlet">
  <input type="hidden" id="attractionid" name="attractionid" value="<%=aid %>">
  <tr>
    <td height="30">
    	<textarea name="context" cols="90" rows="10" id="textarea"></textarea>
    </td>
  </tr>
  <tr>
    <td height="30" align="right"> 
     <input type="submit" name="submit" id="submit" value="发表评论">
    </td>
  </tr>
  </form>
</table>
        
        
        
      </div>
      
      
      
    </div>
    <div id="footer">
      <p>机动的晓蜗牛 &copy; 出品 </p>
    </div>
    <p>&nbsp;</p>
  
</body>
</html>
