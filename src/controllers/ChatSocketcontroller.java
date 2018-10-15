package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
public class ChatSocketcontroller extends TextWebSocketHandler{
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	Gson gson;
	
	@Autowired
	AlertService service;
	
	List<WebSocketSession> sockets;
	
	public ChatSocketcontroller() {
		sockets= new ArrayList<WebSocketSession>();
	}
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	sockets.add(session);
	
	
		
	/*	Map <String, Object> attrs=session.getAttributes();
		// 이 기능을 사용하는 방법을 알아야한다.
		System.out.println(session.getId()+" z/z "+attrs);*/
		
	
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		
		for(int i=0; i<service.list.size();i++) {
			
			Map mapp=new HashMap();
			service.list.get(i).getAttributes().get("user");
			for(int ii=0;ii<sockets.size();ii++) {
				sockets.get(ii).getAttributes().get("userId");
				System.out.println(sockets.get(ii).getAttributes().get("userId"));
			}
			System.out.println("호로록="+service.list.get(i).getAttributes().get("userId"));
		
		}
		
		String got=message.getPayload();
		Map aa=gson.fromJson(got, Map.class);
		Date time =new Date(System.currentTimeMillis());
		String gettime=time.toString();
		System.out.println(gettime);
		aa.put("time",gettime);
		System.out.println(aa.toString());
		String toto=gson.toJson(aa);
		TextMessage msg=new TextMessage(toto);
		
		
		for(int i=0;i<sockets.size();i++) {
			try {
			sockets.get(i).sendMessage(msg);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	/*Map <String, Object> attrs=session.getAttributes();
	attrs.get("ID");
	String got=message.getPayload();
	Map aa=gson.fromJson(got, Map.class);
	Date time =new Date(System.currentTimeMillis());
	String time2=time.toString();
	aa.put("time", time2);
	String txt=gson.toJson(aa);
	TextMessage msg = new TextMessage(txt);
	System.out.println("꺄르르"+aa.get("text"));
	for(int i=0;i<sockets.size();i++) {
		try {
		sockets.get(i).sendMessage(msg);
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	*/
	
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}
	
	
}
