<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
		<li><a href="RealBuyController?method=list">已购商品</a></li>
		<li><a href="talk.jsp">聊天记录</a></li>
		<li><a href="products.jsp">商品发布</a></li>
		<li><a href="realsell.jsp">已卖商品</a></li>
		<li><a href="vindicate.jsp">信息维护</a></li>
	</ul>
</div>
<div id="rightDiv">
	<table border="2">
  	<tr>
  		<th>T_PRODUCTID</th>
  		  <th>T_BUYNUM</th>
  		<th>T_BUYUSERID</th>

  		<th>T_SELLUSERID</th>
  	</tr>
  
	  <c:forEach var="item"  items="${list}">
	  	<tr>
	  		<td>${item.pid }</td>
	  		<td>${item.buynum }</td>
	  		<td>${item.buyuserid }</td>
	  		<td>${item.selluserid }</td>
	  </c:forEach>
  
  </table>
</div>
</body>
</html>