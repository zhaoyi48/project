<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="LoginController?method=sign" method="post">
<table>
	<tr>
		<td>用户ID</td>
		<td></td>
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
		<td colspan="2">
			<input type="submit" value="确认" />
		</td>
	</tr>
</table>
</form>
</body>
</html>