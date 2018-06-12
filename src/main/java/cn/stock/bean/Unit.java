package cn.stock.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table

public class Unit implements Serializable {
    private static final long serialVersionUID = -7933971587862656230L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @OneToMany(mappedBy = "unit")
    private Set<Goods> goods = new HashSet<>();
    @OneToMany(mappedBy = "unit")
    private Set<WV> wvs = new HashSet<>();
    @OneToMany(mappedBy = "unit")
    private Set<Stock> stocks = new HashSet<>();

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public Set<WV> getWvs() {
        return wvs;
    }

    public void setWvs(Set<WV> wvs) {
        this.wvs = wvs;
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

    public Set<Goods> getGoods() {
        return goods;
    }

    public void setGoods(Set<Goods> goods) {
        this.goods = goods;
    }
}
