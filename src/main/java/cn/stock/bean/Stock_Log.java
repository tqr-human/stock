package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "inventory_log")
public class Stock_Log implements Serializable {

    private static final long serialVersionUID = -4217006281223717462L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer inventory_id;
    //    动作 1 入库  2   出库
    @Column
    private Integer action;
    @Column
    private Integer amount;
    @Column
    private Date created;
//    @ManyToOne
//    private WV wv;
//    @ManyToOne
//    private DV dv;
    @ManyToOne
    private User creater;
    @ManyToOne
    private User verifier;
    @ManyToOne
    private Stock stock;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public User getCreater() {
        return creater;
    }

    public void setCreater(User creater) {
        this.creater = creater;
    }

    public User getVerifier() {
        return verifier;
    }

    public void setVerifier(User verifier) {
        this.verifier = verifier;
    }

//    public WV getWv() {
//        return wv;
//    }
//
//    public void setWv(WV wv) {
//        this.wv = wv;
//    }
//
//    public DV getDv() {
//        return dv;
//    }
//
//    public void setDv(DV dv) {
//        this.dv = dv;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Integer inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
