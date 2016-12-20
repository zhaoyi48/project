<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
			<td>购买数量</td>
			<td><input type="text" name="pnum" /></td>
		</tr>
		<tr>
			<td>商品费用</td>
			<td><input type="text" name="psprice" /></td>
		</tr>
		<tr>
			<td>附加费</td>
			<td><input type="text" name="extra" /></td>
		</tr>
		<tr>
			<td>优惠</td>
			<td><input type="text" name="discount" /></td>
		</tr>
		<tr>
			<td>单一合计</td>
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
</body>
</html>