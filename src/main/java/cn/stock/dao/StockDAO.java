package cn.stock.dao;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.WV;

public interface StockDAO extends BaseDAO {
    int count();

    Stock findStockByName(Stock stock);

    Stock addByWV(WV wv);

    Stock decreaseByDV(DV dv) throws Exception;
}
