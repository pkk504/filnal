package models;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
@Repository
public class Mongochat {

	
	@Autowired
	MongoTemplate template;
	
	public boolean chatinsert(Map map) {
		try {
			Map rst=template.insert(map,"publicchat");
		 
			return rst != null;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<Map> getpublicchat(String id){
		
		List<Map> list2=template.find(new Query(Criteria.where("id").in(id)),Map.class,"publicchat");
		return list2;
		
	}
	
	
	
	public boolean chatHumanResourcesinsert(Map map) {
		try {
			Map rst=template.insert(map,"HumanResourceschat");
		 
			return rst != null;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	

	public List<Map> getHumanResourceschat(String id){
		
		List<Map> list2=template.find(new Query(Criteria.where("id").in(id)),Map.class,"HumanResourceschat");
		return list2;
		
	}
	
}
