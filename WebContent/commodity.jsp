<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Model.search"%>
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
				<td width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="LoginController?method=logout">退出</a>
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
		</ul>
	</div>
	<div id="rightDiv">
		<table>
			<tr>
				<td>商品名</td>
				<td><input type="text" name="search"></td>
				<td><input type="button" name="button" value="查询"></td>
			</tr>
			<tr>
				<td>商品编号</td>
				<td>商品名</td>
				<td>单价</td>
				<td>现存数量</td>
				<td>卖家</td>
				<td>邮费</td>
			</tr>
			<%
			search test=new search();
			test.getProduct(request, response);
			%>
		</table>
	</div>
</body>
</html>