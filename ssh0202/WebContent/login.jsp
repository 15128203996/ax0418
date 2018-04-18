<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery.js"></script>
<script type="text/javascript">
   $(function(){
	   $("#kaptchaImage").click(function(){
		   $(this).attr('src','Kaptcha.jpg?'+Math.floor(Math.random()*100));
	   })
	   $("#btn").click(function(){
		   $. post("loginuser.action",
				   {"user.username":$("#username").val(),
			        "user.password":$("#password").val(),
			        "code":$("#code").val()
				   },
				   function(data){
			          console.log(data);
		   })
	   })
   })
</script>
</head>
<body>
    <form action="loginuser.action" method="post">
       <p>用户名：<input type="text" id="username"></p>
       <p>用户密码：<input type="password" id="password"></p>
       <p>验证码：<input type="text" id="code"><img src="Kaptcha.jpg" id="kaptchaImage">换一张</p>
       <p><input type="button" value="登录" id="btn"></p>
    </form>
</body>
</html>