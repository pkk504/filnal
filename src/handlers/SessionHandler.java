package handlers;

import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*
 * ServletContextListener/
 * 	ServletContextAttributeListener�� ServletContext�� ���õ� �̺�Ʈ ������ ���ٸ�,
 * 
 * HttpSession�� ���õ� �̺�Ʈ �����ʸ� ���캸���� �ϴµ�
 * 	-HttpSessionListener : Session�� ���������, �ı��ɶ��� �̺�Ʈ ������
 * 	-HttpSessionAttributeListener : Session�� attribute�� ��ȭ�� �Ͼ���� �̺�Ʈ ������
 * 
 */

public class SessionHandler implements HttpSessionListener{
	
	
	public void sessionCreated(HttpSessionEvent se) {
		//���ο� ������ ������ �۵�.. ������ ���� �ʴ� ������� ���� ����� �۵�
		HttpSession session=se.getSession();
		System.out.println("[Session] created.."+session.getId());
		/*session.setAttribute("auth", true);*/
		ServletContext ctx = session.getServletContext();
		
	}
	
/*	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// �̹� ������ ������� ������ ������ �۵�...
		// ��ȿ�ð��� ���ŵ��� �ʰų�, invalidate() ��Ű�� �۵��ȴ�.
		HttpSession session = se.getSession();
		session.removeAttribute("set");
		
		System.out.println("[Session] destroyed.."+session.getId());
		
		
	}*/
	
	/*public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session  = se.getSession();
		ServletContext application =session.getServletContext();//application �� �������°���.
		Set<String> set =(Set)application.getAttribute("users");
		String id = (String)session.getAttribute("loginid");
		set.remove(id);
		
		application.setAttribute("users", set);	
	}*/
	
	
	
}
