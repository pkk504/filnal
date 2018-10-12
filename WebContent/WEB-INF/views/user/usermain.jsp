<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">Dashboard</h1>
            <div class="btn-toolbar mb-2 mb-md-6">
              <div class="btn-group mr-2">
                <button class="btn btn-sm btn-outline-secondary">Share</button>
                <button class="btn btn-sm btn-outline-secondary">Export</button>
              </div>
              <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                <span data-feather="calendar"></span>
                This week
              </button>
            </div>
          </div>

          <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

         꺄르르
         <ul id="abc">
         
         
         </ul>
        </main>
      </div>
    </div>
    
       <script >
	console.log(location.host);
	
	var ws = new WebSocket("ws://"+ location.host +"${pageContext.servletContext.contextPath}/alert.do");
	var obj="";
	var html="";
	var data="";
	ws.onmessage =function(evt){ //매개변수성정하면
			//받은 메세지에 관련된 객체를 넘겨주면서 콜이 일어나고,
			/* console.log(evt);
			console.log(evt.data);//서버측에서 전송시킨 메세지 내용 */
			console.log(evt.data);
			 obj=JSON.parse(evt.data);
			console.log(obj.mode);
			var aa="";
			data={"ID" : "${user.id}"};
		 	switch(obj.mode){
			case  "welcome" : ws.send(JSON.stringify(data)); 
				break;
			/*  case  "login" : window.alert(obj.ID+" 님이 접속하셨습니다.") */
			case "login" :html+="<li>"+obj.ACTOR+"님이 접속하셨습니다.</li>";
				document.getElementById("abc").innerHTML=html;
								
			 break; 
			} 
			
		}
	
/* 	var dataSend= function(){
		var data={"mode":1,"textt" : "웹소켓으로 데이터 전송"}; 
		 ws.send(JSON.stringify(data)); 
	 	
	
	
	
	
	} */
	</script>