<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="../js/jquery-1.11.0.min.js"></script>
	<script src="../js/json2.js"></script>
	<script type="text/javascript" src="../js/main2.js" charset="utf-8"></script>
</head>
<body>
<h2>Hello World!</h2>
<form action="login" method="post">
	uname:
	<input type="text" name="uname" id="name">${errormap.userNameisNull}
	<br/>
	upassword:
	<input type="text" name="upassword">
	<br/>
	<input type="submit" value="submit">
</form>
============================ajax向后台传值==============================
<button id="btn">ajax传值</button>
<br/>
============================重定向=====================================
<form action="Redir">
	uname:
	<input type="text" name="name" id="name1">
	<br/>
	<button type="submit" id="testRedirparam">测试有参重定向</button>
</form>

<form action="Redir2">
	<button id="testRedir">测试无参重定向</button>
</form>

<button id="URLmatch">URL匹配</button><br/>
============================json传值===================================
<br/>
<input type="text" id="jsonstr">
<button id="sendjson">传递json</button>
<button id="json2object">传递json,转变为object</button>
<button id="getjson">接受控制层传递的json(字符串类型)</button>
<button id="getjson2">接受控制层传递的json(对象类型)</button>
============================上传文件===================================
<br/>
</body>
</html>
