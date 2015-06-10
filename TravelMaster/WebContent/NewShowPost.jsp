<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.chinasofti.travelmaster.biz.IPostsBiz"%>
<%@page import="com.chinasofti.travelmaster.biz.IUsersBiz"%>
<%@page import="com.chinasofti.travelmaster.biz.IRelationsBiz"%>
<%@page import="com.chinasofti.travelmaster.biz.impl.PostsBizImpl"%>
<%@page import="com.chinasofti.travelmaster.biz.impl.UsersBizImpl"%>
<%@page import="com.chinasofti.travelmaster.biz.impl.RelationsBizImpl"%>
<%@page import="com.chinasofti.travelmaster.po.Posts"%>
<%@page import="com.chinasofti.travelmaster.po.Users"%>
<%@page import="com.chinasofti.travelmaster.po.Relations"%>
<%@page import="com.chinasofti.travelmaster.po.upost"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TravelMaster</title>
<script language="javascript">
	function showReply(id) {
		// 获取页面中所有的消息回复表单行对象的集合
		var lstTr = document.getElementsByName("reply");
		// 使用循环遍历每个对象将其显示属性设置为none
		for (var i = 0; i < lstTr.length; i++) {
			lstTr[i].style.display = "none";
		}
		// 将需要显示的回复表单行对象进行显示
		document.getElementById(id).style.display = "";
	}
	function hiddenReply(id) {
		document.getElementById(id).style.display = "none";
	}
</script>
</head>
<body>
<div style="text-align:right;"><a href="ShowPostsServlet">返回论坛首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="index.jsp">返回首页</a></div>
<br/><br/><br/><br/><br/>
<table width="850px" border="1" align="center" >
	<tr>
		<td><font size="16px" >${requestScope.upost.ptitle }</font></td>
		
	</tr>
</table>
<!-- 一楼 -->
	<table width="850" border="1" align="center" >
		<tr>
			<td width="182" rowspan="2" align="center"><img name="" src="upload/avatar/${ requestScope.upost.uavatar }" width="100"
				height="100" alt="" padding-top="20">
			  <p>${requestScope.upost.uname }</p>
			  
			  
			  <%
			    HttpSession hehehehe=request.getSession();
				Users he=(Users)hehehehe.getAttribute("user");
				upost u = (upost)request.getAttribute("upost");
			  
      			if(request.getAttribute("mark").equals("已关注")){%>
      				<p>${requestScope.mark }</p></td>
      			<%}else if(u.getUname().equals(he.getUname())){%>
      				
      			<%}
      			else{%>
      				<p><a href="/TravelMaster/AddRelationServlet?uname=${requestScope.upost.uname }">${requestScope.mark }</a></p></td>
      			<%}
      		  %>
			  
			  <!-- <p><a href="/TravelMaster/AddRelationServlet?uname=${requestScope.upost.uname }">${requestScope.mark }</a></p></td> -->
			
			<td width="650" height="110" valign="top"><textarea name="textarea" cols="100" rows="4" readonly id="textarea" style="border:0; resize: none;">${requestScope.upost.contents }</textarea>			  
			<img name="" src="upload/${requestScope.upost.resources }" width="500" height="200" alt="未上传图片" padding-top="20"></td>
		</tr>
		<tr>
			<td width="650" align="right">发表于:${requestScope.upost.postdate }</td>
		</tr>
</table>
	<hr size=1px width=850px color=#000000>

	<!-- 一楼结束 -->
	
	<!-- 二楼开始 -->
	
	<%
	@SuppressWarnings("unchecked")
	List<upost> lstupost=(List<upost>)request.getAttribute("lstupost");
	upost hi=(upost)request.getAttribute("upost");
  	for(int i=0;i<lstupost.size();i++){
  	  String mark="关注";
	  upost temp=lstupost.get(i);
	  IUsersBiz userbiz=new UsersBizImpl();
	  Users me=new Users();
	  me.setUname(temp.getUname());
	  me=userbiz.selectByName(me);
	  
	 
		
		Relations relation=new Relations();
		IRelationsBiz relationsBiz=new RelationsBizImpl();
		relation.setUid(he.getUid());
		relation.setUserid(me.getUid());
		if(relationsBiz.isAdded(relation)){
			mark="已关注";
		}
	%>
	<table width="850px" border="1" align="center">
     <tr>
    <td width="19%" rowspan="2" align="center"><p><img name="" src="upload/avatar/<%=temp.getUavatar() %>" width="100" height="100" alt=""></p>
      <p>&nbsp;</p>
      <p><%=temp.getUname() %></p>
      <%
      	if(mark.equals("已关注")){%>
      		<p><%=mark %></p></td>
      	<%}else if(temp.getUname().equals(he.getUname())){%>
      		
      	<%}
      	else{%>
      		<p><a href="/TravelMaster/AddRelationServlet?uname=<%=temp.getUname() %>"><%=mark %></a></p></td>
      	<%}
      %>
      
    <td width="81%">
      <textarea name="textarea3" cols="100" rows="4" readonly id="textarea3" style="border:0; resize:none;"><%=temp.getContents() %></textarea>
    
      <img name="" src="upload/<%=temp.getResources()%>" width="500" height="200" alt="未上传图片" padding-top="20">
      </td>
  </tr>
     <tr>
       <td width="81%" align="right">发表于&nbsp; <%=temp.getPostdate() %>&nbsp;<a href="javascript:showReply('reply<%=temp.getPid()%>');">回复 </a></td>
     </tr>
  
  
  <!-- 回复编辑框 -->
     <tr id="reply<%=temp.getPid()%>" name="reply" style="display:none;">
       <td height="30" colspan="2" align="left">
       <form name="form1" method="post" action="/TravelMaster/AddReplyServlet">
       <input type="hidden" id="pfollowid" name="pid" value="<%=temp.getPid()%>"/>
       <input type="hidden" id="pfollowid" name="mainid" value="<%=hi.getPid() %>"/>
         <table width="100%" border="1">
           <tr>
             <td width="18%" rowspan="2">&nbsp;</td>
             <td width="82%" height="30"><label for="textarea4"></label>
               <textarea name="contents" id="textarea4" cols="100" rows="5" style="border:0; resize:none;"></textarea></td>
           </tr>
           <tr>
             <td height="30"><input type="submit" name="submit" id="submit" value="回复">
               <input type="button" name="submit2" id="submit2" onclick="javascript:hiddenReply('reply<%=temp.getPid()%>');" value="关闭"></td>
           </tr>
         </table>
       </form></td>
       </tr>
     <% IPostsBiz postBiz=new PostsBizImpl();
		IUsersBiz userBiz=new UsersBizImpl();
		List<upost> lstupost1=new ArrayList<upost>();
		List<Posts> lstPosts=postBiz.selectReply(temp.getPid());
		if(lstPosts.size()!=0){
		for(int j=0;j<lstPosts.size();j++){
					Users temp2=userBiz.selectById(lstPosts.get(j).getUid());
					upost tem=new upost();
					tem.setPid(lstPosts.get(j).getPid());
					tem.setReplynum(lstPosts.get(j).getReplynum());
					tem.setPostdate(lstPosts.get(j).getPostdate());
					tem.setContents(lstPosts.get(j).getContents());
					tem.setUname(temp2.getUname());
					tem.setUavatar(temp2.getUavatar());
					lstupost1.add(tem);
					System.out.println("dddddddddddddddddddddddd:"+lstPosts.get(j).toString());
				}
				for(int j=0;j<lstupost1.size();j++)
				{
				%>
     <tr height="20">
     
     <td height="20"></td>
     
     
    <td colspan="2" align="left" valign="top">       <%=lstupost1.get(j).getUname()%> 回复<%=hi.getUname() %>：
      &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;发表于：<%=lstupost1.get(j).getPostdate() %>
      <textarea name="textarea2" cols="100" rows="1" readonly id="textarea2" style=" resize:none;"><%=lstupost1.get(j).getContents() %></textarea></td>	   
    </tr>
    <%} }%>
</table>
<hr size=1px width=850px color=#000000>
   <%} %>
<p>&nbsp;</p>
<!-- 二楼结束 -->

<!-- 底部回复框 -->
<form id="singleUpload" name="singleUpload" method="post" enctype="multipart/form-data" action="/TravelMaster/AddPostServlet?pfollowid=${requestScope.upost.uid }">
	<div style="text-align:center;">
		<div style="margin-left:-750px;">
			<h3 class="thin">发表回复:</h3>
		</div>
		<textarea maxlength="500" name="contents" style="resize: none; width: 63%; height: 160px; align-items: center;"
			placeholder="在此输入内容...(500字以内)"></textarea><br/>
			
		<div margin-left="750px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label for="fileField"></label>
        <input type="file" name="fileField" id="fileField">
        
		
		<input  type="submit" name="submit" value="发表回复"/>
		
		</div>
	</div>
	<input type="hidden" id="pfollowid" name="pfollowid" value=${requestScope.upost.uid }/>
</form>
</body>
</html>