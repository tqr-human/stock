package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 入库单->WV
 */
@Entity
@Table
public class WV implements Serializable {


    private static final long serialVersionUID = -1332876333839190940L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String product_name;
    @Column
    private Integer amount;
//    @Column
//    private String unit;
    @Column
    private Integer status;
    @Column
    private Date created;
    @ManyToOne
    private Stock stock;
    @ManyToOne
    private User creater;
    @ManyToOne
    private User verifier;
    @ManyToOne
    private Unit unit;
    @Column
    private Integer unitId;
    @ManyToOne
    private Goods goods;
    @Column
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Unit getUnit() {
        return unit;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    //    @OneToMany(mappedBy = "wv")
//    private Set<Stock_Log> stockLogs = new HashSet<>();
//
//    public Set<Stock_Log> getStockLogs() {
//        return stockLogs;
//    }
//
//    public void setStockLogs(Set<Stock_Log> stockLogs) {
//        this.stockLogs = stockLogs;
//    }

    public User getVerifier() {
        return verifier;
    }

    public void setVerifier(User verifier) {
        this.verifier = verifier;
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

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
