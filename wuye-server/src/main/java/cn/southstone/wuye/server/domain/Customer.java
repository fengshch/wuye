package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 客户信息
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="customer")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "khlb", discriminatorType = DiscriminatorType.STRING, length = 20)
public class Customer extends AbstractEntity {

    private static final long serialVersionUID = 3487504884783387703L;


    /**
     * 客户编号
     */
    @Column(length = 100, nullable = true, unique = true)
    private String no;

    /**
     * 发票抬头
     */
    @Column(length = 255)
    private String fptt;

    /**
     * 开户银行
     */
    @Column(length = 255)
    private String khyh;

    /**
     * 银行账号
     */
    @Column(length = 50)
    private String yhzh;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Fkgx> fkgxes = new HashSet<Fkgx>();

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getFptt() {
        return fptt;
    }

    public void setFptt(String fptt) {
        this.fptt = fptt;
    }

    public String getKhyh() {
        return khyh;
    }

    public void setKhyh(String khyh) {
        this.khyh = khyh;
    }

    public String getYhzh() {
        return yhzh;
    }

    public void setYhzh(String yhzh) {
        this.yhzh = yhzh;
    }

    public Set<Fkgx> getFkgxes() {
        return fkgxes;
    }

    public void setFkgxes(Set<Fkgx> fkgxes) {
        this.fkgxes = fkgxes;
    }

    public void addFkgx(Fkgx fkgx) {
        if (!getFkgxes().contains(fkgx)) {
            getFkgxes().add(fkgx);

            if (fkgx.getCustomer() != null) {
                fkgx.getCustomer().getFkgxes().remove(fkgx);
            }

            fkgx.setCustomer(this);
        }
    }
}
