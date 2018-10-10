package handlers;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * ServletContextListener/
 * 	ServletContextAttributeListener가 ServletContext에 관련된 이벤트 리스너 였다면,
 * 
 * HttpSession에 관련된 이벤트 리스너를 살펴보려고 하는데
 * 	-HttpSessionListener : Session이 만들어지고, 파괴될때의 이벤트 감지기
 * 	-HttpSessionAttributeListener : Session에 attribute의 변화가 일어날때의 이벤트 감지기
 * 
 */

public class SessionHandler implements HttpSessionListener{
	
	
	/*public void sessionCreated(HttpSessionEvent se) {
		//새로운 세션이 열릴때 작동.. 세션을 갖지 않는 사용자의 최초 연결시 작동
		HttpSession session=se.getSession();
		System.out.println("[Session] created.."+session.getId());
		session.setAttribute("auth", false);
		ServletContext ctx = session.getServletContext();
	}*/
	
/*	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 이미 기존에 만들어진 세션이 닫힐때 작동...
		// 유효시간내 갱신되지 않거나, invalidate() 시키면 작동된다.
		HttpSession session = se.getSession();
		session.removeAttribute("set");
		
		System.out.println("[Session] destroyed.."+session.getId());
		
		
	}*/
	
	/*public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session  = se.getSession();
		ServletContext application =session.getServletContext();//application 을 가져오는거임.
		Set<String> set =(Set)application.getAttribute("users");
		String id = (String)session.getAttribute("loginid");
		set.remove(id);
		
		application.setAttribute("users", set);	
	}*/
	
	
	
}
