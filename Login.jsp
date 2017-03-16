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
	//当窗口改变大小时仍居中
	window.onresize=function Login_Div_Center(){
		var oDiv=document.getElementById("Div_Form");
		var divWidth=oDiv.offsetWidth;
		var divHeight=oDiv.offsetHeight;
		oDiv.style.left=((document.documentElement.clientWidth-divWidth)/2)+"px";
		oDiv.style.top=((document.documentElement.clientHeight-divHeight)/2)+"px";
	}
</script>
<script>
	/* 
		登录外框div框样式
	*/
	window.onload=function(){
	var oDiv=document.getElementById("Div_Form");
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
	var oTr=oTable.getElementsByTagName("tr");
	//设置列宽和行高
	for(var i=0;i<oTr.length;i++)
	{
		var oTd=oTr[i].getElementsByTagName("td");
		for(var j=0;j<oTd.length;j++)
			{
			//设置列宽
			switch(j)
			{
			case 0: oTd[j].style.width="70px";break;
			case 1: oTd[j].style.width="150px";break;
			case 2: oTd[j].style.width="100px";break;
			}
				oTd[j].style.height="30px";
			}
	}
	document.onkeydown=function(event){
	var e=event||window.event||arguments.callee.caller.arguments[0];
	if(e&&e.keyCode==13)//按下enter提交
		{
			submitTable();	
		}
}
	}
</script>
</head>
<body style="background:lightblue;background-size:cover">
	<div id="Div_Form">
		<form action="" method="post">
			<table id="login">
			<caption style="font-size:20px">请登录</caption>
				<tr>
					<td>&nbsp</td>
				</tr>
				<tr>
					<td>用户名:</td>
					<td><input type="text" name=UserName/></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="text" name=Password/></td>
				</tr>
				<tr>
					<td></td>
					<td>管理员:<input type="radio" name="User" value="admin" checked /> 卖家:<input type="radio" name="User" value="seller"/></td>
					<td>买家:<input type="radio" name="User" value="buyer"/></td>
				</tr>
				<tr>
					<td>验证码:</td>
					<td><input type="text" name="VerifyCode"/></td>
					<td><img src="radomImage.jsp" alt="验证码" style="width:70px; height:35px background:red" onclick="" style="display:block;position:absolute;right:30px;"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="登录" style="float:left"/> <input type="button" onclick="resetTable();" value="重置" style="float:right"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>
