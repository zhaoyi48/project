<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div id="topDiv">
	<table bgcolor="skyblue" border="0px" width="100%">
		<tr>
			<td colspan="3" width="30%">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" width="30%" align="left">欢迎光临${pram.username}</td>
		</tr>
		<tr>
			<td width="30%"></td>
			<td width="30%"></td>
			<td width="30%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="LoginController?method=logout">退出</a>
			</td>
		</tr>
	</table>
</div>
<div id="leftDiv">
	<ul>
		<li><a href="commodity.jsp">商品一览</a></li>
		<li><a href="shopcar.jsp">购物车</a></li>
		<li><a href="realbuy.jsp">已购商品</a></li>
		<li><a href="talk.jsp">聊天记录</a></li>
		<li><a href="products.jsp">商品发布</a></li>
		<li><a href="realsell.jsp">已卖商品</a></li>
		<li><a href="vindicate.jsp">信息维护</a></li>
		<li><a href="vindicate.jsp?id=inference">个人信息</a></li>
		<li><a href="vindicate.jsp?id=password">修改密码</a></li>
		<li><a href="vindicate.jsp?id=sign">修改买卖标识</a></li>
		<li><a href="vindicate.jsp">修改商品信息</a></li>
	</ul>
</div>
<div id="rightDiv">
<%String id=request.getParameter("id");
if("password".equals(id)){%> 
	<%@include file="password.jsp"%>
<%}
else if("inference".equals(id)){%>
	<%@include file="inference.jsp"%>
<%}
else if("sign".equals(id)){%>
	<%@include file="sign.jsp"%>
<%}
%>
</div>
</body>
</html>