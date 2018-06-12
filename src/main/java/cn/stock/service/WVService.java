package cn.stock.service;

import cn.stock.bean.WV;
import cn.stock.dao.WVDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WVService {
    @Autowired
    private WVDAO wvDAO;

    public WV findByWVId(int wvId) {
        return wvDAO.findById(WV.class, wvId);
    }

    public List<WV> findAll() {
        return wvDAO.findAll(WV.class);
    }
    @Transactional
    public int count() {
        return wvDAO.count();
    }
    @Transactional
    public void deleteWV(int wvId) {
        wvDAO.deleteById(WV.class, wvId);
    }
    @Transactional
    public void deleteWV(WV wv) {
        wvDAO.delete(wv);
    }
    @Transactional
    public void createWV(WV wv) {
        wvDAO.save(wv);
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
    public void updateWV(WV wv) {
        wvDAO.update(wv);
    }

}
