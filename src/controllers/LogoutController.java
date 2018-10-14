/*package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.DynAnyPackage.Invalid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {

	
	
	
	@RequestMapping("logout.do")
	public String logoutHandler(WebRequest wr,HttpSession session) {
		wr.removeAttribute("auth", wr.SCOPE_SESSION);
	session.invalidate();
		
		return "redirect:index.do";
		
	}
}*/
/*@WebServlet("logout.do")
public class LogoutController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect(req.getContextPath()+"/index.do");
	}
	
	

}
*/
