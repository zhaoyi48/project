<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="topDiv">
	<table bgcolor="skyblue" border="0px" width="100%">
		<tr>
			<td colspan="3" width="30%">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3" width="30%" align="left">注册页面</td>
		</tr>
		<tr>
			<td width="30%"></td>
			<td width="30%"></td>
			<td width="30%">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="register.jsp">新用户注册</a>
			</td>
		</tr>
	</table>
</div>
<div id="bottonDiv">
<form action="registerController?method=register" method="post">
	<table  border="0px" width="100%">
		<tr>
			<td>用户ID</td>
			<td><input type="text" name="userid"  /></td>
			<td>密码</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>用户昵称</td>
			<td><input type="text" name="username" /></td>
			<td>确认密码</td>
			<td><input type="password" name="password1" /></td>
		</tr>
		<tr>
			<td>用户昵称</td>
			<td><input type="text" name="name" /></td>
			<td>公司名</td>
			<td><input type="text" name="company" /></td>
		</tr>
		<tr>
			<td>身份证号码</td>
			<td><input type="text" name="id" /></td>
			<td>厂址</td>
			<td><input type="text" name="adress" /></td>
		</tr>
		<tr>
			<td>固定电话</td>
			<td><input type="text" name="phone" /></td>
			<td>主营</td>
			<td><input type="text" name="work" /></td>
		</tr>
		<tr>
			<td>手机</td>
			<td><input type="text" name="mphone" /></td>
			<td>卖方信度</td>
			<td><input type="text" name="credit" value="初级"/></td>
		</tr>
		<tr>
			<td>联系地址</td>
			<td><input type="text" name="adress1" /></td>
			<td>法人代表</td>
			<td><input type="text" name="rsph" /></td>
		</tr>
		<tr>
			<td>email</td>
			<td><input type="text" name="email" /></td>
			<td>法人身份证</td>
			<td><input type="text" name="rspid" /></td>
		</tr>
		<tr>
			<td>买卖标识</td>
			<td>
			<select name="access">
				<option value=”2“>买卖都有</option>
				<option value=”0“>仅买</option>
				<option value=”1“>仅卖</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>买方信度</td>
			<td><input type="text" name="bcredit"  value="初级" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="登陆" />
			</td>
		</tr>
	</table>
</form>
</div>
</body>
</html>