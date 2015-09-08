<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>业务组注册示例</title>
</head>
<body>
	<h2>业务组注册示例</h2>
	<form action="${pageContext.request.contextPath}/bsgroup/add"
		method="POST" enctype="multipart/form-data">
		业务组名称：<input type="text" name="bsgName" style="width: 286px"/> <br />业务组图标：<input
			name="bsgIcon" type="file" style="width: 290px"/> <br />业务组简介：
		<textarea name="bsgDesc" style="width: 280px; height: 80px;">业务组简介</textarea>
		<br />云服务申请：<input name="bsgServices" type="checkbox" value="cdb">云数据库
		<input name="bsgServices" type="checkbox" value="cst">云存储<input
			name="bsgServices" type="checkbox" value="csr">云服务器<input
			name="bsgServices" type="checkbox" value="cac">云账户 <br /> <br />
		<input value="注册" type="submit" />
	</form>
</body>
</html>