/*package controllers;

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
public class ChatSocketcontroller2 extends TextWebSocketHandler{
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	Gson gson;
	
	@Autowired
	AlertService service;
	
	List<WebSocketSession> sockets;
	
	public ChatSocketcontroller2() {
		sockets= new ArrayList<WebSocketSession>();
	}
	
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
	sockets.add(session);
	
	
		
		Map <String, Object> attrs=session.getAttributes();
		// �씠 湲곕뒫�쓣 �궗�슜�븯�뒗 諛⑸쾿�쓣 �븣�븘�빞�븳�떎.
		System.out.println(session.getId()+" z/z "+attrs);
		
	
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		
		Map mapp=new HashMap();
		List<String> li=new ArrayList<>();	
	for(int i=0; i<sockets.size();i++) {
			
			li.add((String) service.list.get(i).getAttributes().get("userId"));
			System.out.println("�샇濡쒕줉="+service.list.get(i).getAttributes().get("userId"));
			System.out.println(sockets.get(i).getAttributes().get("userId"));
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
		Map nochat =new HashMap();
		nochat.put("mode", "nochat");
		nochat.put("pass", "on");
		
		for(int i=0;i<li.size();i++) {
			if(!li.get(i).contains(sockets.get(i).getAttributes().get("userId"))) {
			String id=(String) sockets.get(i).getAttributes().get("userId");
			if(!li.get(i).contains(id)) {	
			service.sendOne(nochat,li.get(i));
			sockets.get(i).sendMessage(msg);
			}else {
			try {
			sockets.get(i).sendMessage(msg);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
		}
	}
	Map <String, Object> attrs=session.getAttributes();
	attrs.get("ID");
	String got=message.getPayload();
	Map aa=gson.fromJson(got, Map.class);
	Date time =new Date(System.currentTimeMillis());
	String time2=time.toString();
	aa.put("time", time2);
	String txt=gson.toJson(aa);
	TextMessage msg = new TextMessage(txt);
	System.out.println("爰꾨Ⅴ瑜�"+aa.get("text"));
	for(int i=0;i<sockets.size();i++) {
		try {
		sockets.get(i).sendMessage(msg);
	
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
	
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sockets.remove(session);
	}
	
	
}*/