package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {

	
	
	
	@RequestMapping("logout.do")
	public String logoutHandler(WebRequest wr) {
		wr.removeAttribute("auth", wr.SCOPE_SESSION);
		return "redirect:index.do";
		
	}
}
