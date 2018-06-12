package cn.stock.dao.impl;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.WV;
import cn.stock.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StockDAOImpl extends BaseDAOImpl implements StockDAO{
    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        super.hibernateTemplate = hibernateTemplate;
    }

    public  int count(){
        String sql = "select count(*) from Stock ";
        return DataAccessUtils.intResult(hibernateTemplate.find(sql));
    }

    @Override
    public Stock findStockByName(Stock stock) {
        return hibernateTemplate.findByExample(stock).get(0);
    }

    @Override
    public Stock addByWV(WV wv) {
        Stock stock;
        try {
            stock = findStockByName(new Stock(wv.getProduct_name()));
            stock.setInventory(wv.getAmount() + stock.getInventory());
            hibernateTemplate.update(stock);
        } catch (Exception e) {
            stock = new Stock();
            stock.setMax_inventory(wv.getGoods().getMaxInventory());
            stock.setName(wv.getProduct_name());
            stock.setInventory(wv.getAmount());
            stock.setUnit(wv.getUnit());
            hibernateTemplate.save(stock);
        }
        return stock;
    }

    @Override
    public Stock decreaseByDV(DV dv) throws Exception {
        Stock stock;
        stock = findById(Stock.class, dv.getInventory_id());
        int temp = stock.getInventory()-dv.getAmount();
        if (temp >= 0) {
            stock.setInventory(temp);
            hibernateTemplate.update(stock);
        }
//        else if(temp==0)
//        {
//            hibernateTemplate.delete(stock);
//        }
        else {
            throw new Exception();
        }
        return stock;
    }
}