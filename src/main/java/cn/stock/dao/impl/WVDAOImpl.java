package cn.stock.dao.impl;

import cn.stock.dao.WVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WVDAOImpl extends BaseDAOImpl implements WVDAO {
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        super.hibernateTemplate = hibernateTemplate;
    }
    @Override
    public int count() {
        String sql = "select count(*) from WV";
        return DataAccessUtils.intResult(hibernateTemplate.find(sql));
    }
}
