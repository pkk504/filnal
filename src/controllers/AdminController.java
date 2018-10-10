package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class AdminController {

	
	@RequestMapping("add.do")
	public String adminmain() {
		
	return	"adminserver";
	}
}
