package cn.stock.service;

import cn.stock.bean.DV;
import cn.stock.bean.Unit;
import cn.stock.dao.UnitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnitService {
    @Autowired
    UnitDAO unitDAO;

    public List<Unit> findAll() {
        return unitDAO.findAll(Unit.class);
    }

    public Unit findByName(Unit unit) {
        return unitDAO.findByName(unit);
    }

    public Unit findById(int id) {
        return unitDAO.findById(Unit.class, id);
    }
    @Transactional
    public int count() {
        return unitDAO.count();
    }

    @Transactional
    public void deleteUnit(int id) {
        unitDAO.deleteById(DV.class, id);
    }
    @Transactional
    public void deleteUnit(Unit unit) {
        unitDAO.delete(unit);
    }
    @Transactional
    public void createUnit(Unit unit) {
        unitDAO.save(unit);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
    public void updateUnit(Unit unit) {
        unitDAO.update(unit);
    }
}
