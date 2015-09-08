<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="../resources/jquery-ui-1.11.4/jquery-ui.css">
<script src="../resources/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="../resources/jquery-ui-1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#progressbar").progressbar({
			value : 0
		});
	});
	// this sets up the progress bar
	$(document).ready(function() {
		$("#uploadprogressbar").progressBar();
	});

	// fades in the progress bar and starts polling the upload progress after 1.5seconds
	function beginUpload() {
		// uses ajax to poll the uploadprogress.php page with the id
		// deserializes the json string, and computes the percentage (integer)
		// update the jQuery progress bar
		// sets a timer for the next poll in 750ms
		$("#uploadprogressbar").fadeIn();

		var i = setInterval(function() {
			$.getJSON("demo.php?id=" + progress_key, function(data) {
				if (data == null) {
					clearInterval(i);
					location.reload(true);
					return;
				}

				var percentage = Math.floor(100 * parseInt(data.bytes_uploaded)
						/ parseInt(data.bytes_total));
				$("#uploadprogressbar").progressBar(percentage);
			});
		}, 1500);
	}
	/* function doUpload(){
	 //document.form.submit();
	 window.setInterval(function() {
	 $.getJSON("progress/status", function(data) {
	 alert(data);  
	 $("#progressbar").progressbar(data.percent);
	 });
	 }, 1500);
	 document.form.submit();
	 } */
</script>
<title>SpringMVC jQueryUI Progressbar Demo</title>
</head>
<body>
	<h2>SpringMVC jQueryUI Progressbar Demo</h2>
	<form action="${pageContext.request.contextPath}/progress/upload"
		method="POST" enctype="multipart/form-data">
		业务系统名称：<input type="text" name="appName"> <br />业务系统WAR：<input
			name="appIcon" type="file" /> <br />业务系统简介：<input type="text"
			name="appDesc"> <br /> <input value="部署" type="submit"
			onclick="doUpload()" />
	</form>
	<div id="progressbar"></div>
</body>
</html>