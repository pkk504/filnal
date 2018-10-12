package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import models.AdminDao;
import models.AlertService;

@Controller

public class IndexController extends HttpServlet{
	Map<String, HttpSession> sessions;
	public IndexController() {
		sessions = new HashMap<>();
	}
	
	
	
	@Autowired
	AlertService service;
	
	@Autowired
	AdminDao adminDao;
	
	@GetMapping("index.do")
	public String indexgetHandl(@SessionAttribute(required=false) String auth,WebRequest wr) {
		
		if(wr.getAttribute("auth", WebRequest.SCOPE_SESSION)==null) {
		return "admin/index"; 
		}else {
			return "main";
		}
		
	}
	
	@PostMapping("login.do")
	public String indexgetHandl(@RequestParam Map map,WebRequest wr,HttpSession session) {
		Map mapp=adminDao.selectIdPass(map);
		String id=wr.getParameter("id");
		String pass=wr.getParameter("pass");
		wr.setAttribute("userId",id , wr.SCOPE_SESSION);
		Map qq=new HashMap();
		qq.remove("id");
		qq.remove("pass");
		qq.put("id", id);
		qq.put("pass", pass);
		
		System.out.println(mapp.toString());
		
		
		if(mapp!=null) {
			Map msgg = new HashMap();
			msgg.put("mode", "erlogin");
			msgg.put("actor", id);
			
			if(sessions.containsKey(id)) {
				sessions.get(id).invalidate();
			}
			sessions.put(id,session);
			service.sendOne(msgg, id);
			
			//======================
		/*wr.setAttribute("user", map, wr.SCOPE_SESSION);*/
		wr.setAttribute("user",mapp , wr.SCOPE_SESSION);
	
		wr.setAttribute("userId",id , wr.SCOPE_SESSION);
			wr.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
			Map msg=new HashMap<>();
			msg.put("mode","login");
			msg.put("actor", mapp);
			if(!sessions.containsKey(id)) {
			service.sendAll(msg);
			}
			
			return "redirect:index.do";
		}else {
			/*return "redirect:index.do"; */
			wr.setAttribute("err", true, WebRequest.SCOPE_REQUEST);
			return "admin/index"; 
		}
	}
	
	
	@GetMapping("setpass.do")
	public String setpassset() {
		return "user/setpass";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
