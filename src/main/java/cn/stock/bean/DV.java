package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class DV implements Serializable {

    private static final long serialVersionUID = 8101992075983756844L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private Integer inventory_id;
    @Column
    private Integer amount;
    @Column
//    private String unit;
    private Integer unitId;
    @ManyToOne
    private Unit unit;
    @Column
    private Integer status;
//    备注
    @Column
    private String remark;
    @Column
    private Date created;
    @ManyToOne
    private User creater;
    @ManyToOne
    private User verifier;
    @ManyToOne
    private Stock stock;
//    @OneToMany(mappedBy = "dv")
//    private Set<Stock_Log> stockLogs = new HashSet<>();
//
//    public Set<Stock_Log> getStockLogs() {
//        return stockLogs;
//    }
//
//    public void setStockLogs(Set<Stock_Log> stockLogs) {
//        this.stockLogs = stockLogs;
//    }


    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public User getVerifier() {
        return verifier;
    }

    public void setVerifier(User verifier) {
        this.verifier = verifier;
    }

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
