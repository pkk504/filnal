<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <h1 class="h2">메일함</h1>
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
          <div>
          <c:forEach var="c" items="${message }">
         <c:choose>
         	<c:when test="${c.CHOICE==0 }">
         		<a href="${pageContext.servletContext.contextPath }/message.do?no=${c.NO}"><b style="color: blue">보낸사람 : ${c.SENDER} / 내용 : ${c.CONTENT } / 받은 날짜 : ${c.SENDDATE }</b><br/></a>
         	</c:when>
         	
         	<c:otherwise>
         	<a href="${pageContext.servletContext.contextPath }/message.do?no=${c.NO}"><b style="color: dark">보낸사람 : ${c.SENDER} / 내용 : ${c.CONTENT } / 받은 날짜 : ${c.SENDDATE }</b><br/></a>
         	</c:otherwise>
         
         </c:choose>
          </c:forEach>
          </div> 
			
			
          <canvas class="my-4 w-100" id="myChart" width="900" height="380">
          
          </canvas>

      
         
         
         
         </ul>
        </main>
      </div>
    </div>