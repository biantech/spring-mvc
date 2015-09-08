<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../resources/uploadify-3.2.1/uploadify.css">
<script type="text/javascript"
	src="../resources/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script type="text/javascript"
	src="../resources/uploadify-3.2.1/jquery.uploadify.min.js"></script>
<script>
	$(document).ready(function() {
		$("#file_upload").uploadify({
			'buttonText' : '请选择',
			'height' : 30,
			'swf' : '../resources/uploadify-3.2.1/uploadify.swf',
			'uploader' : '${pageContext.request.contextPath}/progress/upload',
			'width' : 120,
			'auto' : false,
			'fileObjName' : 'uploadFile',
			'onUploadSuccess' : function(file, data, response) {
				alert(file.name + ' 上传成功！ ');
			}
		});
	});
</script>
<title>SpringMVC Uploadify Demo</title>
</head>
<body>
	<h2>SpringMVC Uploadify Demo</h2>
	<input type="file" name="fileName" id="file_upload" />
	<a href="javascript:$('#file_upload').uploadify('upload', '*')">上传文件</a>
	|
	<a href="javascript:$('#file_upload').uploadify('stop')">停止上传!</a>
</body>
</html>