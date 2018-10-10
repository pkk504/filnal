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
		return template.insert("adminadd.addadminn",map);
	}
}
