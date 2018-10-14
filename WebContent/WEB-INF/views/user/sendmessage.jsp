<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%if(session.getAttribute("meerr")!=null){ %>
<div class="alert alert-danger" role="alert">
   보내기가 실패하였습니다.
   
</div>
<%} %>
<form action="${pageContext.servletContext.contextPath }/send.do"  method="post" >
  <div class="form-group">
    <label for="exampleFormControlInput1">Receive ID</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="receive ID" name ="receiveid"required autofocus>
  </div>

  <!-- <div class="form-group">
    <label for="exampleFormControlSelect2">Example multiple select</label>
    <select multiple class="form-control" id="exampleFormControlSelect2">
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
  </div> -->
  <div class="form-group">
    <label for="exampleFormControlTextarea1">보낼내용</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="content"required autofocus></textarea>
  </div>
  <button type="submit"class="btn btn-primary">보내기</button>
</form>