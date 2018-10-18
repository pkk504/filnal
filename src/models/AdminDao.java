package models;

import java.util.*;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AdminDao {

	@Autowired
	SqlSessionFactory factory;
	
	
	
	@Autowired
	SqlSessionTemplate template;
	
	
	
	public List<Map> admindepart(){
		return template.selectList("adminadd.admindepart");
	}
	
	public List<Map> adminposition(){
		return template.selectList("adminadd.adminposition");
	}
	
	public int Idseq() {
		return template.selectOne("adminadd.getSequenceVal");
		
	}
	
	public int addadmin(Map map) {
		int r =template.insert("adminadd.addadminn",map);
		if(r==1) {
			return r;
		}else {
			return -1;
		}
	}
	
	public Map selectIdPass(Map map) {
		if(template.selectOne("adminadd.selectIdPass",map)!=null) {
			return template.selectOne("adminadd.selectIdPass",map);
		}else {
			return null;
		}
	}
	
	public int setPass(Map map) {
		return template.update("adminadd.setPass",map);
	}
	
	public int addaddmessage(Map map) {
		int r =template.insert("adminadd.addmessage",map);
		if(r==1) {
			return r;
		}else {
			return -1;
		}
	}
	
	public List<Map> receiveAll(String param){
		return template.selectList("adminadd.receiveAll",param);
	}
	
	public Map receivemsg(int num) {
		return template.selectOne("adminadd.receivemsg",num);
		
	}
	
	public int setchoice (int no) {
		return template.update("adminadd.setchoice",no);
	}
	
	public Map getAllEmployee(String id) {
		
		return template.selectOne("adminadd.getAllEmployee",id);
	}
	
	public List<Map> getdepartAll(int num){
		return template.selectList("adminadd.getdepartAll",num);
	}
	
	
}
