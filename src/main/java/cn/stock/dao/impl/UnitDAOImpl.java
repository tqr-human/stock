package cn.stock.dao.impl;

import cn.stock.bean.Unit;
import cn.stock.dao.UnitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UnitDAOImpl extends BaseDAOImpl implements UnitDAO {
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		super.hibernateTemplate = hibernateTemplate;
	}

	public Unit findByName(Unit unit) {
		return  hibernateTemplate.findByExample(unit).get(0);
	}
	public  int count(){
		String sql = "select count(*) from Unit";
		return DataAccessUtils.intResult(hibernateTemplate.find(sql));
	}


}
