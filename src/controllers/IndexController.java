package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import models.AdminDao;

@Controller
public class IndexController extends HttpServlet{

	@Autowired
	AdminDao adminDao;
	
	@GetMapping("index.do")
	public String indexgetHandl(WebRequest wr) {
		
		if(wr.getAttribute("auth", WebRequest.SCOPE_SESSION)==null) {
		return "admin/index"; 
		}else {
			return "main";
		}
		
	}
	
	@PostMapping("login.do")
	public String indexgetHandl(@RequestParam Map map,WebRequest wr) {
		Map mapp=adminDao.selectIdPass(map);
		String id=wr.getParameter("id");
		String pass=wr.getParameter("pass");
		wr.removeAttribute("user", wr.SCOPE_SESSION);
		Map qq=new HashMap();
		qq.remove("id");
		qq.remove("pass");
		qq.put("id", id);
		qq.put("pass", pass);
		
		
		if(mapp!=null) {
		/*wr.setAttribute("user", map, wr.SCOPE_SESSION);*/
		wr.setAttribute("user",qq , wr.SCOPE_SESSION);
			wr.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
			return "redirect:index.do";
		}else {
			/*return "redirect:index.do"; */
			wr.setAttribute("err", true, WebRequest.SCOPE_REQUEST);
			return "admin/index"; 
		}
	}
	
}
