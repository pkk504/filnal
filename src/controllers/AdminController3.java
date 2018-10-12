/*package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import models.AdminDao;

@Controller
@RequestMapping("/employee")
public class AdminController3 {
	@Autowired
	AdminDao adminDao;
	
	@GetMapping("add.do")
	public String adminmain(ModelMap modelmap,WebRequest wr) {
		List<Map> li =adminDao.admindepart();
		
		for(int i=0; i<li.size();i++) {
			Map map= li.get(i);
			System.out.println(map.get("DID"));
		}
		modelmap.put("depart", li);
		List<Map> lii=adminDao.adminposition();
		modelmap.put("position", lii);
		if(wr.getAttribute("er", WebRequest.SCOPE_REQUEST)!=null) {
			wr.setAttribute("err", "on", wr.SCOPE_REQUEST);
		}
		System.out.println(wr.getAttribute("er", WebRequest.SCOPE_REQUEST));
		
		
	return	"adminserver";
	}
	
	
	@PostMapping("add.do")
	public String adminmainadd(WebRequest wr ,@RequestParam Map map) {
		int no= adminDao.Idseq();
		System.out.println(no);
		
		Map aa= new HashMap();
		String id="em"+no;
		String pass="1111";
		String name=wr.getParameter("naming");
		int did=	Integer.parseInt(wr.getParameter("departname"));
		int pid= Integer.parseInt(wr.getParameter("positionname"));
		
		System.out.println("id = "+id);
		System.out.println("pass = "+pass);
		System.out.println("name = "+map.get("name"));
		System.out.println("did = "+map.get("did"));
		System.out.println("pip = "+map.get("pid"));
		System.out.println("date"+map.get("joindate"));
		
		map.put("id", id);
		
		aa.put("id", id);
		aa.put("pass", pass);
		aa.put("name", name);
		aa.put("did",did);
		aa.put("pid", pid);
		aa.put("joindate", map.get("datetime"));
		
		
		try {
			int i =adminDao.addadmin(map);
			if(i==1) 
				return "success";
			
			
		}catch(Exception e) {
			e.printStackTrace();
			

		}
		wr.setAttribute("er", "zz", wr.SCOPE_REQUEST);
		return "redirect:add.do";
		
	
		
		if(i==1) {
			return "success";
		}else {
			return "fail";
		}
		
		}else {
			return "fail";
		}
		
		
	
	
		
	
}
}
*/