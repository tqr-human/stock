package cn.stock.service;

import cn.stock.bean.DV;
import cn.stock.dao.DVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DVService {
    @Autowired
    DVDAO dvDAO;

    public List<DV> findAll() {
        return dvDAO.findAll(DV.class);
    }

    public DV findByDVId(int id) {
        return dvDAO.findById(DV.class, id);
    }
    @Transactional
    public int count() {
        return dvDAO.count();
    }

    @Transactional
    public void deleteDV(int dvId) {
        dvDAO.deleteById(DV.class, dvId);
    }
    @Transactional
    public void deleteDV(DV dv) {
        dvDAO.delete(dv);
    }
    @Transactional
    public void createDV(DV dv) {
        dvDAO.save(dv);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
    public void updateDV(DV dv) {
        dvDAO.update(dv);
    }
}
