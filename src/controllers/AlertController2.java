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
public class AlertController2 extends TextWebSocketHandler{
	@Autowired
	AdminDao adminDao;
	@Autowired
	AlertService service;
	@Autowired
	Gson gson;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		service.addSocket(session);
		Map data= new HashMap();
		data.put("mode", "welcome");
		gson.toJson(data);
		service.sendAll(gson.toJson(data));
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		service.removeSocket(session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String paylaod=message.getPayload();
		Map map=gson.fromJson(paylaod, Map.class);
		System.out.println(map.get("ID"));
		Map mapp=new HashMap();
		mapp.put("mode", "login");
		mapp.put("ID", map.get("ID"));
		gson.toJson(mapp);
		service.sendAll(gson.toJson(mapp));
		
		
		
		
	}
	
}
