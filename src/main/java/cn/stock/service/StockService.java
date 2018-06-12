package cn.stock.service;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.WV;
import cn.stock.dao.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {
    @Autowired
    StockDAO stockDAO;

    public Stock findByStockId(int stockId) {
        return stockDAO.findById(Stock.class, stockId);
    }

    public Stock findStockByName(Stock stock) {
        return stockDAO.findStockByName(stock);
    }
    @Transactional
    public Stock addByWV(WV wv) {
        return stockDAO.addByWV(wv);
    }

    @Transactional
    public Stock decreaseByDV(DV dv) throws Exception {
        return stockDAO.decreaseByDV(dv);
    }

    public List<Stock> findAll() {
        return stockDAO.findAll(Stock.class);
    }

    @Transactional
    public int count() {
        return stockDAO.count();
    }

    @Transactional
    public void createStock(Stock stock) {
        stockDAO.save(stock);
    }

    @Transactional
    public void deleteStock(Stock stock) {
        stockDAO.delete(stock);
    }

    @Transactional
    public void deleteStock(int id) {
        stockDAO.deleteById(Stock.class, id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateStock(Stock stock) {
        stockDAO.update(stock);
    }
}
