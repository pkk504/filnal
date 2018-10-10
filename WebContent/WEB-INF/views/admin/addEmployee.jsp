<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>사원등록</h2>
<form method="post" action="${pageContext.servletContext.contextPath }/employee/add.do">
	<div class="form-group">
		<label>Example label</label> <input name="name"
			type="text" class="form-control" placeholder="Example input">
	</div>
	<div class="form-group">
		<label>Another label</label>
		<div class="row">
			<div class="col">
				<select class="form-control" name="did" >
			<c:forEach var="department" items="${depart }">
					<option value="${department.DID }">${department.DNAME }</option>
				
				</c:forEach>
				</select>
			</div>
			<div class="col">
				<select class="form-control" name="pid">
				<c:forEach var="positioning" items="${position }">
					<option value="${positioning.PID }">${positioning.PNAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label>Another label</label> <input
			type="date" class="form-control" placeholder="Another input" name="joindate">
	</div>
	<div class="form-group">
		<button type="submit"  class="form-control btn btn-outline-primary">사원등록</button>
	</div>
</form>