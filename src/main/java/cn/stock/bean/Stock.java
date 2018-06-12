package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "inventory")
public class Stock implements Serializable {

    private static final long serialVersionUID = -8189771033277251638L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column
    private Integer inventory;
    @Column
    private Integer max_inventory;
    @Column
    private Integer unitId;
    @ManyToOne
    private Unit unit;
    @OneToMany(mappedBy = "stock")
    private Set<WV> wvSet = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private Set<DV> dvSet = new HashSet<>();
    @OneToMany(mappedBy = "stock")
    private List<Stock_Log> stockLogs = new ArrayList<>();
    @OneToOne(mappedBy = "stock")
    private Goods goods;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
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

    public Unit getUnit() {
        return unit;
    }

    public List<Stock_Log> getStockLogs() {
        return stockLogs;
    }

    public void setStockLogs(List<Stock_Log> stockLogs) {
        this.stockLogs = stockLogs;
    }

    public Set<DV> getDvSet() {
        return dvSet;
    }

    public void setDvSet(Set<DV> dvSet) {
        this.dvSet = dvSet;
    }

    public Stock() {
    }

    public Stock(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getMax_inventory() {
        return max_inventory;
    }

    public void setMax_inventory(Integer max_inventory) {
        this.max_inventory = max_inventory;
    }

//    public String getUnit() {
//        return unit;
//    }
//
//    public void setUnit(String unit) {
//        this.unit = unit;
//    }

    public Set<WV> getWvSet() {
        return wvSet;
    }

    public void setWvSet(Set<WV> wvSet) {
        this.wvSet = wvSet;
    }
}
