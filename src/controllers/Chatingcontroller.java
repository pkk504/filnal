package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import models.AdminDao;
import models.AlertService;
import models.Mongochat;

@Controller
@RequestMapping("/chat")
public class Chatingcontroller {
	@Autowired
	AlertService service;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	Mongochat mongochat;
	
	
	
	
	@GetMapping("/room.do")
	public String charRoomHandler(ModelMap map,@RequestParam Map mapp) {
		/*Map map =new HashMap();
		map.put("mode", "dodo");
		map.put("ddd", 321);
		service.sendAll(map);*/
		String id=(String)mapp.get("param");
		System.out.println(id);
		
		if(id.equals("HumanResources")) {
			List<Map> li= mongochat.getpublicchat(id);
			
			System.out.println(li);
		map.put("publicchatAll", li);
		map.put("depart", id);
		}else {
		List<Map> li= mongochat.getpublicchat("public");
		
		System.out.println(li);
	map.put("publicchatAll", li);
	map.put("depart", "public");
		}
		
		return "chat";
	}
	
	
}
