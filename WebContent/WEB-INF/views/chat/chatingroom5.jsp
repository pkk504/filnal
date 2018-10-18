<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">GROUPWARE</h1>
	<div class="btn-toolbar mb-2 mb-md-0">
		<div class="btn-group mr-2">
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.NAME }</button>
			<button class="btn btn-sm btn-outline-secondary">${sessionScope.user.DNAME }
				${sessionScope.user.PNAME }</button>
		</div>
		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar">${sessionScope.userId }</span> 
		</button>
<!-- 		<button class="btn btn-sm btn-outline-secondary dropdown-toggle">
			<span data-feather="calendar">전체채팅</span> 
				<span data-feather="calendar">부서채팅</span> 
		</button> -->
		
<div class="btn-group" role="group">
    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      부서선택
    </button>
    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
      <a class="dropdown-item" href="${pageContext.servletContext.contextPath }/chat/room.do?param=public">전체채팅</a>
      <a class="dropdown-item" href="${pageContext.servletContext.contextPath }/chat/room.do?param=HumanResources">인사부</a>
    </div>
  </div>
	</div>
	
	
</div>


<h4>Chat Room <small id="ho">(${depart })</small></h4>
<div style="height: 520px; overflow-y: scroll; " id="chatView">
	<c:forEach var="v" items="${publicchatAll }">
		
			
			<div class="alert alert-secondary" role="alert" style="padding:3px; margin-bottom:3px;">
			${v.user.NAME } : ${v.text }  / <small><b>${v.time }</b></small>
			</div>
		
	</c:forEach>
</div>
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">CHAT</span>
  </div>
  <input type="text" class="form-control" aria-describedby="basic-addon1"
  	id="input" >
</div>
<script>
	var chatws = new WebSocket("ws://"+location.host+"${pageContext.servletContext.contextPath}/chat.do");
	
	chatws.onmessage= function(evt) {
		console.log(evt.data);
		var obj = JSON.parse(evt.data);
		switch(obj.mode) {
		case "public":
			publicHandle(obj);
			break;
		case "HumanResources" :
			HumanResourceshandle(onj);
			break;
		}
	} 
	
	
	
	var publicHandle = function(obj) {
		var txt = obj.text;
		console.log(txt);
		var html = "<div class=\"alert alert-secondary\" role=\"alert\" style=\"padding:3px; margin-bottom:3px;\">";
		html += obj.user.NAME+" : "+obj.text +"  / <small><b>"+obj.time+"</b></small>";
		html +="</div>";
		document.getElementById("chatView").innerHTML += html;
		document.getElementById("chatView").scrollTop = 
			document.getElementById("chatView").scrollHeight; 
	}
	
	var HumanResourceshandle = function(obj){
		var txt = obj.text;
		console.log(txt);
		var html = "<div class=\"alert alert-secondary\" role=\"alert\" style=\"padding:3px; margin-bottom:3px;\">";
		html += obj.user.NAME+" : "+obj.text +"  / <small><b>"+obj.time+"</b></small>";
		html +="</div>";
		document.getElementById("chatView").innerHTML += html;
		document.getElementById("chatView").scrollTop = 
			document.getElementById("chatView").scrollHeight; 
		
	}
	
	
	
	
	document.getElementById("input").onchange= function() {
		console.log(this.value);
		var msg;
		var aa="HumanResources";
		if(${depart}==aa){
			 msg = {
					"mode":"HumanResources",
					"text":this.value,
					"sendid":"${sessionScope.userId }"
				};
		}else{
		 msg = {
			"mode":"public",
			"text":this.value,
			"sendid":"${sessionScope.userId }"
		}
		}
		chatws.send(JSON.stringify(msg));
		 this.value=""; 
	};
	
	
	
	
	
	
	var modeclick=function(target){
		console.log(target.value);
		
	}
	
	
	
</script>

