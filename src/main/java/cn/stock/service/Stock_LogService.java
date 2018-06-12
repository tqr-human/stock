package cn.stock.service;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.Stock_Log;
import cn.stock.bean.WV;
import cn.stock.dao.Stock_LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Stock_LogService {
    @Autowired
    Stock_LogDAO stockLogDAO;

    public List<Stock_Log> findAll() {
        return stockLogDAO.findAll(Stock_Log.class);
    }

    @Transactional
    public void addByWV(WV wv,Stock stock) {
        stockLogDAO.addByWV(wv, stock);
    }

    @Transactional
    public void addByDV(DV dv,Stock stock) {
        stockLogDAO.addByDV(dv,stock);
    }

    @Transactional
    public int count() {
        return stockLogDAO.count();
    }

    @Transactional
    public void createStockLog(Stock_Log stockLog) {
        stockLogDAO.save(stockLog);
    }

    @Transactional
    public void denyByWV(WV wv,Stock stock) {
        stockLogDAO.denyByWV(wv,stock);
    }

    @Transactional
    public void denyByDV(DV dv,Stock stock) {
        stockLogDAO.denyByDV(dv,stock);
    }
}
