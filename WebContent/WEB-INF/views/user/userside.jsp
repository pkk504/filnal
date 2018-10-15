<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar-sticky">
	<ul class="nav flex-column">
		<li class="nav-item"><a class="nav-link active" > <span
				data-feather="home"></span>환영합니다.<br/> NAME = <b style="color: dark"><small>${user.ID }</small></b> <span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link active" href="#"> <span
				data-feather="home"></span> Dashboard <span class="sr-only">(current)</span>
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/receive.do"> <span
				data-feather="file"></span> 메일함
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/send.do"> <span
				data-feather="shopping-cart"></span> 메일작성
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/chat/room.do"> <span
				data-feather="users"></span> 채팅
		</a></li>
	</ul>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>Saved reports</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<ul class="nav flex-column mb-2">
		<li class="nav-item"><a class="nav-link" href="#"> <span
				data-feather="file-text"></span> Current month
		</a></li>
		<li class="nav-item"><a class="nav-link" href="${pageContext.servletContext.contextPath }/setpass.do"> <span
				data-feather="file-text"></span> 비밀번호변경
		</a></li>
	</ul>
	<hr/>
	<h6
		class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
		<span>Saved reports</span> <a
			class="d-flex align-items-center text-muted" href="#"> <span
			data-feather="plus-circle"></span>
		</a>
	</h6>
	<div id="alert" style="font-size: .75em">
	
	</div>
	
	<script>
		
	var ws = new WebSocket("ws://"+ location.host +"${pageContext.servletContext.contextPath}/alert.do");
		ws.onmessage = function(evt) {
			console.log(evt.data);
			var obj = JSON.parse(evt.data);
			switch(obj.mode) {
			case "login":
				
				loginAlertHandle(obj);
				break;
			case "erlogin":
				
				errLoginHandle(obj);
			case "send":
				
				sendmessageHandle(obj);
			
			
			
			}
		};
		
		
		var loginAlertHandle = function(obj) {
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【로그인】</strong><br/>" + obj.actor.NAME+"("+obj.actor.ID+ "님이 로그인을 하였습니다."+")";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
			
		}
		
		var errLoginHandle =function(obj){
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【로그아웃】</strong><br/>" + obj.actor+"(님이 다른 페이지에서 로그인을 시도하셨습니다.)";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
			document.getElementById("alert").id="";
		}
		
		var sendmessageHandle =function(obj){
			var html = "<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">";
			html += "<strong>【메시지 수신】</strong><br/>" + obj.sendid+"(님이 메시지를 보내셨습니다.)";
			html += "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">";
			html += "<span aria-hidden=\"true\">&times;</span>";
			html += "</div>";
			document.getElementById("alert").innerHTML += html;
		}
		
		
		
	</script>
</div>
