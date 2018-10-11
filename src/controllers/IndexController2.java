/*package controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import models.AdminDao;

@WebServlet("/index.do")
public class IndexController2 extends HttpServlet{

	@Autowired
	AdminDao adminDao;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session.getAttribute("auth")==null) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
			rd.forward(req, resp);
		}else{
			resp.sendRedirect(req.getContextPath()+"/employee/add.do");
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("pass"));
		String id=req.getParameter("id");
		String pass=req.getParameter("pass");
		Map map =new HashMap();
		map.put("ID", id);
		map.put("PASS", pass);
		Map li=adminDao.selectIdPass(map);
		
		System.out.println(li.get("ID"));
		
		
		if(req.getParameter("id")!=null&&req.getParameter("pass")!=null) {
		
		if(adminDao.selectIdPass(map)!=null) {
			resp.sendRedirect(req.getContextPath()+"/index.do");
		}else if(adminDao.selectIdPass(map)==null){
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
			rd.forward(req, resp);
		}
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/admin/index.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	@GetMapping("index.do")
	public String indexgetHandle(WebRequest wr) {
		
		if(wr.getAttribute("auth", wr.SCOPE_SESSION)==null) {
		return "/index.jsp";
		}else {
			return "redirect:employee/add.do";
		}
	}
	
	@PostMapping("index.do")
	public String indexpostHandle() {
		return "";
	}
	
}
*/