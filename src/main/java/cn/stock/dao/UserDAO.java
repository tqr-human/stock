package cn.stock.dao;

import cn.stock.bean.User;

public interface UserDAO extends BaseDAO{


     User findByName(User user);
     int count();
}
