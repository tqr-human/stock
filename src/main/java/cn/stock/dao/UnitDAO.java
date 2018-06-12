package cn.stock.dao;

import cn.stock.bean.Unit;

public interface UnitDAO extends BaseDAO{


     Unit findByName(Unit unit);
     int count();
}
