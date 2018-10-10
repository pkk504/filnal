package models;

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
}
