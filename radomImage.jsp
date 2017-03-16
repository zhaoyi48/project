<%@ page language="java" import="java.util.*"  pageEncoding="utf-8"%>
<!--  Java  awt功能：包含用于创建用户界面和绘制图形图像的所有类。-->
<%@page import ="java.awt.*" %>
<%@page import ="java.awt.image.*" %>
<%@page import ="java.util.Random" %>
<%@page import ="javax.imageio.*"%>   
<html> 
<head>
<title>校验码页面</title>
<%!
Color getRandomColor(int lower,int upper){
	//创建随机数变量 java.util.Random产生随机数
	Random random=new Random();
	//防止出界 条件运算符：  ? 
	lower=(lower<0 || lower>255)?0:lower;
	upper=(upper<0 || upper>255)?0:upper;
	//生成红、黄、绿三种基本色的随机数   给定一个参数n，nextInt(n)将返回一个大于等于0小于n的随机数
	int r=lower+random.nextInt(upper-lower);
	int g=lower+random.nextInt(upper-lower);
	int b=lower+random.nextInt(upper-lower);
	return new Color(r,g,b);
}
%>
</head>
<body>
<%
//校验码图片的宽度
int width=60;
//校验码图片的高度
int height=20;
//创建缓冲图片 BufferedImage对象，指定图片的长度宽度和色彩
BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//获取缓冲图片的绘图类变量，即从图像中取得图像对象
Graphics g=image.getGraphics();
//设置前景色（设置为较亮的颜色） 
g.setColor(getRandomColor(200,255)); 
//所有的图形都是以Graphics对象来绘制的
//画方框 fillRect(x, y, width, height)
//填充一个矩形区域，x,y为起始坐标即左上角坐标，后面两个参数是矩形区域的宽和高 
g.fillRect(0, 0, width, height);
//创建随机数变量
Random random=new Random();
//产生100条具有随机位置、随机长度和随机颜色的干扰线
for(int i=0;i<100;i++){
	//设置前景色 （为灰度中等的一种随机色）
	g.setColor(getRandomColor(155,200));
	//获取随机位置
	int x1=random.nextInt(width);
	int  y1=random.nextInt(height);
	//获取随机长度
	int x2=random.nextInt(10);
	int y2=random.nextInt(10);
	//绘制直线
	//在此图形上下文的坐标系中，使用当前颜色在点（x1,y1）和（x2,y2）之间画一条线 
	g.drawLine(x1,y1,x2,y2); 
}
//设置字体
g.setFont(new Font("Times New Roman",Font.PLAIN,18));
//获取1000-9999之间的随机4位数
int randomInt=1000+random.nextInt(9000);
//转换成字符串
String randomStr=String.valueOf(randomInt);
//遍历字符串中的每一个字符
for(int i=0;i<randomStr.length();i++){
	//设置前景色（设置为较暗的颜色）
	g.setColor(getRandomColor(0, 100));
	// drawString(String str, int x, int y) 
	//参数： str - 要绘制的 string。 x - x 坐标。 y - y 坐标。  
	g.drawString(randomStr.substring(i,i+1),10*i+10,15);
}
session.setAttribute("randomStr", randomStr);
//如果我们将验证码的代码写在jsp页面中，因为jsp页面会调用JspWriter的out()方法将内容输出，
//同时我们的图片又调用了response.getOutputStream()方法因此会抛出这个异常；    
out.clear();
out=pageContext.pushBody();    
//通过ImageIO对象的write静态方法将图片输出
ImageIO.write(image,"JPG", response.getOutputStream());
//绘制的图形就可以显示在客户端的浏览器上了

%>
</body>
</html>