<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<div style="width: 960px;">
		<div>
			<h1>Tiles Template™</h1>
		</div>
		<div>
			<tiles:insertAttribute name="page1" />
		</div>
		<div style="min-height: 70%;">
			<tiles:insertAttribute name="page2" />
		</div>
		
		</div>
	</div>

</body>
</html>