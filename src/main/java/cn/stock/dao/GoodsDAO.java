package cn.stock.dao;

import cn.stock.bean.Goods;

import java.util.List;

public interface GoodsDAO extends BaseDAO{

     List<Goods> findSql(String sql, Object value);
     Goods findByName(Goods goods);
     int count();
}
