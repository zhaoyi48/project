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
	</ul>
</div>
<div id="rightDiv">
	<form action="" method="post">
	<table>
		<tr>
			<td>商品编号</td>
			<td><input type="text" name="pid" /></td>
		</tr>
		<tr>
			<td>商品名</td>
			<td><input type="text" name="pname" /></td>
		</tr>
		<tr>
			<td>单价</td>
			<td><input type="text" name="pprice" /></td>
		</tr>
		<tr>
			<td>现存数量</td>
			<td><input type="text" name="pnum" /></td>
		</tr>
		<tr>
			<td>邮费</td>
			<td><input type="text" name="ship" /></td>
		</tr>
		<tr>
			<td>
			<select name="class">
				<option value="0">服装</option>
				<option value="0">仅买</option>
				<option value="0">仅卖</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>邮递费用</td>
			<td><input type="text" name="shipfee" /></td>
		</tr>
		<tr>
			<td>备注</td>
			<td><input type="text" name="all" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="确定" />
			</td>
			<td colspan="2">
				<input type="button" value="取消" />
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>