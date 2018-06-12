package cn.stock.dao;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.WV;

public interface Stock_LogDAO extends BaseDAO{
    int count();

    void addByWV(WV wv,Stock stock);

    void addByDV(DV dv,Stock stock);

    void denyByWV(WV wv,Stock stock);

    void denyByDV(DV dv,Stock stock);
}
