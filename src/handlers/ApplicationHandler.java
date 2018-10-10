package handlers;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * application Event용 Listener 2개 
 *  
 *  - ServletContextListener: init, destroy
 *  
 *  - ServletContextAttributeListener : setAttribute, removeAttribute
 *  
 *  
 *  # 모든 리스너는 등록이 필요함.(알아서 감지되지 않는다.)(web.xml 확인)
 */


public class ApplicationHandler implements ServletContextListener{
long begin;
Date i1;
@Override
public void contextInitialized(ServletContextEvent sce) {//만들어질때
	   try {
		 	Class.forName("oracle.jdbc.driver.OracleDriver");
		   } catch(Exception e) {
			e.printStackTrace();
		   }
	   Set<String> set=new LinkedHashSet<>();
				
	System.out.println("contextInitialized..");
	
	//i1= new Date(begin);
	//System.out.println(i1);
	
	/*
	 * 매개변수로 잡혀있는 ServletContextEvent를 통해서
	 * application을 접근할수 있다.
	 */
	ServletContext ctx=sce.getServletContext();
	ctx.setAttribute("newline", "\n");
	
	
	
	//JSP에서 사용되는 application 이라는 이름의 객체.

	ctx.setRequestCharacterEncoding("UTF-8"); // Listener에서만 가능
											//Servlet하위버전에는 없는 메서드
	/*ctx.setSessionTimeout(1);*/
	

}


}
