package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		System.out.println("id�� "+id);
		wr.setAttribute("userId",id , wr.SCOPE_SESSION);
		Map qq=new HashMap();
		qq.remove("id");
		qq.remove("pass");
		qq.put("id", id);
		qq.put("pass", pass);
		
		
		
		
		if(mapp!=null) {
			Map msgg = new HashMap();
			msgg.put("mode", "erlogin");
			msgg.put("actor", id);
			
			Map msg=new HashMap<>();
			msg.put("mode","login");
			msg.put("actor", mapp);
			
			if(sessions.containsKey(id)) {
				sessions.get(id).invalidate();
				sessions.remove(id);
				
				
				service.sendOne(msgg, id);
			}
			sessions.put(id,session);
			service.sendAll(msg);
			
			/*service.sendOne(msgg, id);*/
			
			
			//======================
		/*wr.setAttribute("user", map, wr.SCOPE_SESSION);*/
		wr.setAttribute("user",mapp , wr.SCOPE_SESSION);
	
		wr.setAttribute("userId",id , wr.SCOPE_SESSION);
			wr.setAttribute("auth", true, WebRequest.SCOPE_SESSION);
			
			
			
			
			return "redirect:index.do";
		}else {
			/*return "redirect:index.do"; */
			
			return "admin/index"; 
		}
	}
	
	
	@GetMapping("setpass.do")
	public String setpassset() {
		return "user/setpass";
		
	}
	
	
	@PostMapping("setpass.do")
	public String postpassset(@RequestParam Map map,WebRequest wr) {
		String pass1=(String)map.get("pass1");
		String pass2=(String)map.get("pass2");
		String id= (String)wr.getAttribute("userId", wr.SCOPE_SESSION);
		Map m=new HashMap<>();
		if(pass1.equals(pass2)) {
			m.put("pass1", pass1);
			m.put("id", id);
			int r=adminDao.setPass(m);
			if(r==1) {
				return "redirect:index.do";
			}else {
				return "user/setpass";
			}
		}else {
			
			return "user/setpass";
		}
	}
	
	
	@GetMapping("send.do")
	public String sendmessage() {
		return "sendmessage";
		
	}
	
	@PostMapping("send.do")
	public String sendmessagepost(@RequestParam Map map,WebRequest wr) {
		String sender =(String)wr.getAttribute("userId", wr.SCOPE_SESSION);
		String receiveid =(String)map.get("receiveid");
		String content =(String)map.get("content");
		System.out.println("sender = "+sender);
		System.out.println("receiveid"+receiveid);
		System.out.println("content"+content);
		Map ma =new HashMap();
		ma.put("sender", sender);
		ma.put("receiveid", receiveid);
		wr.setAttribute("receiveid", receiveid, wr.SCOPE_SESSION);
		ma.put("content", content);
		try {
			Map sendme=new HashMap<>();
			sendme.put("mode", "send");
			sendme.put("sendid",sender );
			
			int i=adminDao.addaddmessage(ma);
			if(sender!=null) {
			service.sendOne(sendme,receiveid );;
			}
			return "main";
		}catch(Exception e){
			e.printStackTrace();
			wr.setAttribute("meerr", "on", wr.SCOPE_REQUEST);
			return "sendmessage";
		}
	}
		/*int i=adminDao.addaddmessage(ma);
		
		if(i==1) {
		return "main";
		}else {
			wr.setAttribute("meerr", "on", wr.SCOPE_REQUEST);
			return "sendmessage";
		}*/
		@GetMapping("receive.do")
		public String receiveAll(WebRequest wr,ModelMap map) {
			String id=(String)wr.getAttribute("userId", wr.SCOPE_SESSION);
			System.out.println(id);
			List<Map> li=adminDao.receiveAll(id);
			map.put("message", li);
			return "receiveAll";
		}
		
		/*@PostMapping("receive.do")
		public String receiveAllpost(WebRequest wr,ModelMap map) {
			String id=(String)wr.getAttribute("receiveid", wr.SCOPE_SESSION);
		List<Map> li=	adminDao.receiveAll(id);
			
			return
		}*/
		
		@GetMapping("message.do")
		public String receivemsg(@RequestParam Map map,ModelMap modelmap) {
			System.out.println(map.get("no"));
			Map aa= new HashMap<>();
			int no =Integer.parseInt(map.get("no").toString());
			
			
			System.out.println("num��"+no);
			
			Map msg =adminDao.receivemsg(no);
			
			modelmap.put("msg", msg);
			
			if(msg.get("CHOICE").toString().equals("0")) {
				adminDao.setchoice(no);
			}
				
				
			
			return "msgg";
		}
		
		@GetMapping("logout.do")
		public String logout(WebRequest wr) {
			String id= (String)wr.getAttribute("userId", wr.SCOPE_SESSION);
			/*sessions.get(id).invalidate();*/
			sessions.remove(id);
			wr.removeAttribute("auth", wr.SCOPE_SESSION);
			return "redirect:index.do";
		}
		
		
		
		
		
		
		
		
		
		
		
		}
	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

