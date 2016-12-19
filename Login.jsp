<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<script>
	//重置表格
	function resetTable()
	{
		document.getElementsByTagName("form")[0].reset();
	}
	//提交表格
	function submitTable()
	{
		document.getElementsByTagName("form")[0].submit();
	}
	//当窗口改变大小时
	window.onresize=function Login_Div_Center(){
		var oDiv=document.getElementById("Div_Form");
		var divWidth=oDiv.offsetWidth;
		var divHeight=oDiv.offsetHeight;
		oDiv.style.left=((document.documentElement.clientWidth-divWidth)/2)+"px";
		oDiv.style.top=((document.documentElement.clientHeight-divHeight)/2)+"px";
	}
</script>
</head>
<body style="background-image:url(img/Login_Background.jpg);background-size:cover">
	<div id="Div_Form">
		<form action="post">
			<table id="login">
			<caption style="font-size:20px">请登录</caption>
				<tr>
					<td>&nbsp</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name=UserName/></td>
					<td></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="text" name=Password/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td>管理员:<input type="radio" name="User" value="admin" checked /> 卖家:<input type="radio" name="User" value="seller"/> 买家:<input type="radio" name="User" value="buyer"/></td>
				</tr>
				<tr>
					<td>验证码:</td>
					<td><input type="text" name="VerifyCode"/></td>
					<td><img src="radomImage.jsp" alt="验证码" style="width:70px; height:35px background:red" onclick="" style="display:block;position:absolute;right:30px;"/></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="login" style="float:left"/> <input type="button" onclick="resetTable();" value="重置" style="float:right"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script>
	/* 
		登录外框DIV框样式
	*/

	load();
	function load(){
	var oDiv=document.getElementById("Div_Form");
	/* oDiv.style.width="auto";
	oDiv.style.height="auto"; */
	oDiv.style.border="5px solid #ccc";
	//上下左右居中
	oDiv.style.position="absolute";
	var oDiv=document.getElementById("Div_Form");
	var divWidth=oDiv.offsetWidth;
	var divHeight=oDiv.offsetHeight;
	oDiv.style.left=((document.documentElement.clientWidth-divWidth)/2)+"px";
	oDiv.style.top=((document.documentElement.clientHeight-divHeight)/2)+"px";
	
	/* 
		设置表单样式
		宽高
	 */
	var oTable=document.getElementsByTagName("table")[0];
	var oTr=document.getElementByTagName("tr");
	
	for(var i=0;i<oTr.length;i++)
	{
		var oTd=oTr[i].getElementsByTagName("td");
		for(var j=0;j<oTd.length;j++)
			{
				if(j==0)
					{
						oTd.style.width="100px";	
					}
				else
					{
					oTd.style.width="0px";
					}
				oTd.style.height="30px";
			}
	}
}
</script>
</html>
