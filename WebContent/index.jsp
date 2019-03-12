<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>报修平台</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
    <script type = "text/javascript" src = "js/checkCode.js">      //引入js
    </script>
    <style type="text/css">
        #code               /*设置验证码显示的样式*/
        {
            font-family:Arial;//字体
            font-style:italic;
            font-weight:bold;
            border:0;
            letter-spacing:15px;
            color:blue;
        }
    </style>
    <script type="text/javascript">
    
    var code ; //在全局定义验证码
    //产生验证码
    function createCode(){
        code = "";
        var codeLength = 4;//验证码的长度
        var checkCode = document.getElementById("code");
        var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',
            'S','T','U','V','W','X','Y','Z');//随机数
        for(var i = 0; i < codeLength; i++) {//循环操作
            var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）
            code += random[index];//根据索引取得随机数加到code上
        }
        checkCode.value = code;//把code值赋给验证码
    }
    //校验验证码
    function validate(){
        var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写
        if(inputCode.length <= 0) { //若输入的验证码长度为0
            alert("请输入验证码"); //则弹出请输入验证码
        }
        else if(inputCode != code ) { //若输入的验证码与产生的验证码不一致时
            alert("验证码输入错误@_@"); //则弹出验证码输入错误
            createCode();//刷新验证码
            document.getElementById("input").value = "";//清空文本框
        }
        else { //输入正确时
        	var form = document.getElementById("form");
            form.submit();
            /* $("#form").submit(); */
        }
    }
    </script>
    
    
</head>

<body class="gray-bg"  onload="createCode()">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>
                <h1 class="logo-name">Zz</h1>
            </div>
            
            <h3>欢迎使用 智慧校园</h3>

            <form target="_self" method="post" class="m-t" role="form" action="LoginServlet" id="form">
                <div class="form-group">
                    <input name="account" type="tel" class="form-control" placeholder="用户名" value="${user.account }" required="">
                </div>
                <div class="form-group">
                    <input name="password" type="password" class="form-control" value="${user.password }" placeholder="密码" required="">
                </div class="form-group">
                <div class="form-group">
                    <input type = "text" id = "input"  class="form-control" placeholder="验证码" /><!--输入验证码的文本框-->
                </div>
                <div class="form-group">
                    <input type = "button" id="code" class="form-control" onclick="createCode()"/>       <!--设置一个按钮，用来显示验证码，设置id值为code，以便在js中通过id值找到它，并给他点击事件，在页面加载中自动调用-->
                </div>
                <div class="form-group">
                    <font color="red">${message }</font>
                </div>
                    <input type = "button" value = "登录" onclick = "validate()" class="btn btn-primary block full-width m-b"/><!--设置一个按钮用来验证验证码是否正确，通过点击事件触发js-->
                
            <!--     <button type="submit" class="btn btn-primary block full-width m-b">登 录</button> -->


                <p class="text-muted text-center"> <a href="login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>
    <script src="/js/jquery.min.js?v=2.1.4"></script>
    <script src="/js/bootstrap.min.js?v=3.3.5"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>