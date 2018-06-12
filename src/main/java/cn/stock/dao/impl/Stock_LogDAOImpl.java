package cn.stock.dao.impl;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.Stock_Log;
import cn.stock.bean.WV;
import cn.stock.dao.Stock_LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Stock_LogDAOImpl extends BaseDAOImpl implements Stock_LogDAO {
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        super.hibernateTemplate = hibernateTemplate;
    }

    public  int count(){
        String sql = "select count(*) from Stock_Log ";
        return DataAccessUtils.intResult(hibernateTemplate.find(sql));
    }

    @Override
    public void addByWV(WV wv,Stock stock) {
        Stock_Log stockLog = new Stock_Log();
        stockLog.setAmount(wv.getAmount());
        stockLog.setCreated(new Date());
        stockLog.setAction(1);
        stockLog.setCreater(wv.getCreater());
        stockLog.setVerifier(wv.getVerifier());
//        与库存记录关联后
        stockLog.setInventory_id(wv.getStock().getId());
        stockLog.setStock(stock);
        hibernateTemplate.save(stockLog);
    }

    @Override
    public void addByDV(DV dv,Stock stock) {
        Stock_Log stockLog = new Stock_Log();
        stockLog.setInventory_id(dv.getInventory_id());
        stockLog.setAction(2);
        stockLog.setCreated(new Date());
        stockLog.setAmount(dv.getAmount());
        stockLog.setCreater(dv.getCreater());
        stockLog.setVerifier(dv.getVerifier());
        stockLog.setStock(stock);
        hibernateTemplate.save(stockLog);
    }

    @Override
    public void denyByWV(WV wv,Stock stock) {
        Stock_Log stockLog = new Stock_Log();
        stockLog.setAmount(wv.getAmount());
        stockLog.setCreated(new Date());
        stockLog.setAction(3);
        stockLog.setCreater(wv.getCreater());
//        与库存记录关联后
        stockLog.setInventory_id(wv.getStock().getId());
        stockLog.setStock(stock);
        hibernateTemplate.save(stockLog);
    }

    @Override
    public void denyByDV(DV dv,Stock stock) {
        Stock_Log stockLog = new Stock_Log();
        stockLog.setInventory_id(dv.getInventory_id());
        stockLog.setAction(4);
        stockLog.setCreated(new Date());
        stockLog.setAmount(dv.getAmount());
        stockLog.setCreater(dv.getCreater());
        stockLog.setStock(stock);
        hibernateTemplate.save(stockLog);
    }

}
