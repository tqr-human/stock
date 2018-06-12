package cn.stock.dao.impl;


import cn.stock.dao.DVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DVDAOImpl extends BaseDAOImpl implements DVDAO {
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        super.hibernateTemplate = hibernateTemplate;
    }
    @Override
    public int count() {
        String sql = "select count(*) from DV";
        return DataAccessUtils.intResult(hibernateTemplate.find(sql));
    }
}
