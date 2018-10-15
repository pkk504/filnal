package controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.AdminDao;
import models.AlertService;

@Controller
@RequestMapping("/chat")
public class Chatingcontroller {
	@Autowired
	AlertService service;
	
	@Autowired
	AdminDao adminDao;
	
	
	@GetMapping("/room.do")
	public String charRoomHandler() {
		/*Map map =new HashMap();
		map.put("mode", "dodo");
		map.put("ddd", 321);
		service.sendAll(map);*/
		return "chat";
	}
	
	
}
