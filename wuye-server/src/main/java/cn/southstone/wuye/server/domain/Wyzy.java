package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *物业资源类
 * Created by fengs on 2016/8/19.
 */
@Entity
@Table(name="wyzy")
public class Wyzy extends AbstractEntity{


    private static final long serialVersionUID = -2620721473321427806L;

    /**
     * 物业资源编号
     */
    @Column(length = 255,nullable = false)
    private String no;
    /**
     * 物业资源名称
     */
    @Column(length=255,nullable = false)
    private String name;

    /**
     * 资源类别
     */
    @Column(length = 255,nullable = false)
    private String zylb;


    /**
     * 资源说明
     */
    @Column(length = 255,nullable = true)
    private String description;

    /**
     *  建筑面积
     */
    @Column
    private Double jzmj;

    /**
     * 收费面积
     */
    @Column
    private Double sfmj;
    /**
     * 所在区域
     */
    @ManyToOne
    @JoinColumn(name="dyqy_id")
    private Dyqy  dyqy;

    @OneToMany(mappedBy = "wyzy",cascade = CascadeType.ALL)
    private Set<Fkgx> fkgxes = new HashSet<Fkgx>();

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZylb() {
        return zylb;
    }

    public void setZylb(String zylb) {
        this.zylb = zylb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getJzmj() {
        return jzmj;
    }

    public void setJzmj(Double jzmj) {
        this.jzmj = jzmj;
    }

    public Double getSfmj() {
        return sfmj;
    }

    public void setSfmj(Double sfmj) {
        this.sfmj = sfmj;
    }

    public Dyqy getDyqy() {
        return dyqy;
    }

    public void setDyqy(Dyqy dyqy) {
        this.dyqy = dyqy;
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

            if (fkgx.getWyzy() != null) {
                fkgx.getWyzy().getFkgxes().remove(fkgx);
            }

            fkgx.setWyzy(this);
        }
    }
    @Override
    public String toString() {
        return name;
    }
}
