<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath }/css/signin.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>


<title>관리자 - 그룹웨어</title>
<body class="text-center">
	<form class="form-signin" method="post"
		action="${pageContext.servletContext.contextPath }/setpass.do">
		<c:if test="${!empty errpass }">
<div class="alert alert-danger" role="alert">
 맞지않는 PASSWORD 입니다.
</div>
</c:if>
		<img class="mb-4" src="../../assets/brand/bootstrap-solid.svg" alt=""
			width="72" height="72">
		<h1 class="h3 mb-3 font-weight-normal">비밀번호 변경</h1>
		
		
		<label for="inputPassword" class="sr-only">pass</label> 
		<input type="password" id="inputEmail" class="form-control"
			placeholder="Nowpassword" required autofocus name="pass">
			<br/><br/>
			
			
		<label for="inputPassword" class="sr-only">pass</label> 
		<input type="password" id="inputEmail" class="form-control"
			placeholder="Setpassword" required autofocus name="pass1"> 
			
			<label for="inputPassword" class="sr-only">Password</label> 
			<input type="password" id="inputPassword" class="form-control"
			placeholder="RePassword" required name="pass2">
		<!-- <div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div> -->
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
			in</button>
		<p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
	</form>
</body>
</html>