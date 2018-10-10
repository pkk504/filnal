package handlers;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/*
 * ServletContextAttributeListener
 * 
 * application �� C/U/D �۾��� �Ͼ�� ó���� �ϵ��� ���� �����ϴ�.
 * 
 * 
 * 
 */

public class ApplicationSupport implements ServletContextAttributeListener{
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		String name = scae.getName(); // attribute�� ���� �̸�.
		Object obj=scae.getValue(); //��ϵ� ���
		ServletContext ctx = scae.getServletContext();
		System.out.println("ServletContext.attributeAdded.."+name);
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("ServletContext.attributeReplaced..");
		String name = scae.getName();
		Object value = scae.getValue();//��ü�Ǳ��� ���� ���
		if(name.equals("latest")) {
			String old=(String)value;
			ServletContext ctx = scae.getServletContext();
			String neo = (String)ctx.getAttribute("latest");
			System.out.println("[SERVER] latest replaced.."+old+"��"+neo);
		}
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		String name = scae.getName();//������ ���
		System.out.println("ServletContext.attributeRemoved.."+name);
	
		
	}
	
	

}
