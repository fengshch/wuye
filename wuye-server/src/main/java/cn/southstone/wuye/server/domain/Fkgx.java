package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户资源关系
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="fkgx")
public class Fkgx extends AbstractEntity {


    private static final long serialVersionUID = -1517339271440191953L;

    /**
     * 物业资源
     */
    @ManyToOne
    @JoinColumn(name="zy_id")
    private Wyzy wyzy;

    /**
     * 客户信息
     */
    @ManyToOne
    @JoinColumn(name="kh_id")
    private  Customer customer;

    /**
     * 是否收费
     */
    @Column
    private boolean sfsf;

    /**
     * 开始计费日期
     */
    @Column
    private Date ksjfrq;


    @OneToMany(mappedBy = "fkgx", cascade = CascadeType.ALL)
    private Set<Bzxy> bzxies = new HashSet<Bzxy>();
    /**
     * 结束计费日期
     */
    @Column
    private Date jsjfrq;

    public Wyzy getWyzy() {
        return wyzy;
    }

    public void setWyzy(Wyzy wyzy) {
        this.wyzy = wyzy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isSfsf() {
        return sfsf;
    }

    public void setSfsf(boolean sfsf) {
        this.sfsf = sfsf;
    }

    public Date getKsjfrq() {
        return ksjfrq;
    }

    public void setKsjfrq(Date ksjfrq) {
        this.ksjfrq = ksjfrq;
    }

    public Date getJsjfrq() {
        return jsjfrq;
    }

    public void setJsjfrq(Date jsjfrq) {
        this.jsjfrq = jsjfrq;
    }

    public Set<Bzxy> getBzxies() {
        return bzxies;
    }

    public void setBzxies(Set<Bzxy> bzxies) {
        this.bzxies = bzxies;
    }
}
