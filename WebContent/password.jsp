<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController?method=password" method="post">
	<table>
		<tr>
			<td>旧密码</td>
			<td><input type="password" name="oldpassword" /></td>
		</tr>
		<tr>
			<td>新密码</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>确认密码</td>
			<td><input type="password" name="checkpassword" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="确认" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>