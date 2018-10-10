package handlers;
/*
 * HttpServletRequest에 관련된 EventListener..
 *  - ServletRequestListener
 *  - ServletRequestAttributeListener
 * 
 */

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestHandler implements ServletRequestListener, ServletRequestAttributeListener{
@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// 요청이 들어와서 JSP or Servlet이 작동 전
	ServletRequest req = sre.getServletRequest();
	System.out.println("[REQUEST] request occured...by"+req.getRemoteAddr());	
	//requrestURI,queryStringd을 뽑아서 출력을 시켜둘거임(DB insert)
	//들어오는 타입이 원래 예전 타입으로 뽑혀서  신규기능이 안뜸.
	HttpServletRequest request=(HttpServletRequest)req;
	String uri = request.getRequestURI();
	String query= request.getQueryString();
	System.out.println("[REQUEST] at "+uri+(query!=null? "?"+query:""));
	
	}
	
@Override
	public void requestDestroyed(ServletRequestEvent sre) {
	System.out.println("[REQUET] reponse sended..");
		// JSP or Servlet이 작동 해서 응답을 보낸 후
	
	
	}

	




//아직은 해보지 않았지만, request attribute 작업을 할 수 있다. 
//응답보내기전가지만 유지가 됨.응답보내면 사라짐.왜이런 1회성 attribue를 하는가?
//MVC설계를 하게되면 이유를 알게 됨. - 지금은 request도 attribute 가능하다는걸 보면됨 .

@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		
	
	
	}
	
	
	@Override
		public void attributeReplaced(ServletRequestAttributeEvent srae) {
	
		
		
		}
	
	
	@Override
		public void attributeRemoved(ServletRequestAttributeEvent srae) {
		
		
		
		}




	
	
}
