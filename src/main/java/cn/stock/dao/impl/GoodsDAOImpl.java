package cn.stock.dao.impl;

import cn.stock.bean.Goods;
import cn.stock.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDAOImpl extends BaseDAOImpl implements GoodsDAO {
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
		super.hibernateTemplate = hibernateTemplate;
	}

	public Goods findByName(Goods goods) {
		return  hibernateTemplate.findByExample(goods).get(0);
	}
	public  int count(){
		String sql = "select count(*) from Goods";
		return DataAccessUtils.intResult(hibernateTemplate.find(sql));
	}
	public List<Goods> findSql(String sql, Object value) {
		return (List<Goods>) hibernateTemplate.find(sql, value);
	}

}
