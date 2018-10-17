package controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;

import models.AdminDao;
import models.AlertService;
@Controller
public class AlertController extends TextWebSocketHandler{
	@Autowired
	AdminDao adminDao;
	@Autowired
	AlertService service;
	@Autowired
	Gson gson;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		service.addSocket(session);
		
		Map <String, Object> attrs=session.getAttributes();
		// 이 기능을 사용하는 방법을 알아야한다.
		System.out.println(session.getId()+" / "+attrs);
		System.out.println(service.size());
	
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		service.removeSocket(session);
	}
	

	
}
