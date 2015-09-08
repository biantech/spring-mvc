<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring4_MVC--Index</title>
</head>
<body>
	<h1>Hello Spring4 MVC</h1>
	<div>
		<a href="${pageContext.request.contextPath}/bsgroup/register">点击注册业务组</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/progress/jqueryui">jQueryUI
			Progressbar Demo</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/progress/bootstrap">Bootstrap
			Progressbar Demo</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/progress/uploadify">jQuery
			Uploadify Demo</a>
	</div>
</body>
</html>