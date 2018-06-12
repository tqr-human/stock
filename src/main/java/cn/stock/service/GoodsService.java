package cn.stock.service;

import cn.stock.bean.Goods;
import cn.stock.dao.GoodsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    GoodsDAO goodsDAO;

    public List<Goods> findAll() {
        return goodsDAO.findAll(Goods.class);
    }

    public Goods findById(int id) {
        return goodsDAO.findById(Goods.class, id);
    }
    @Transactional
    public int count() {
        return goodsDAO.count();
    }

    @Transactional
    public void deleteGoods(int id) {
        goodsDAO.deleteById(Goods.class, id);
    }
    @Transactional
    public void deleteGoods(Goods goods) {
        goodsDAO.delete(goods);
    }
    @Transactional
    public void createGoods(Goods goods) {
        goodsDAO.save(goods);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
    public void updateGoods(Goods goods) {
        goodsDAO.update(goods);
    }

    public List<Goods> findByHql(String hql,Object obj) {
        return goodsDAO.findSql(hql,obj);
    }
}
