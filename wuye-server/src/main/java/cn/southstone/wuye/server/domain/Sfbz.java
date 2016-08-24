package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 收费标准
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="sfbz")
public class Sfbz extends AbstractEntity {


    private static final long serialVersionUID = -8162179073782695041L;
    /**
     * 项目名称
     */
    @Column(length = 255,nullable = false)
    private String name;

    @Column(length = 255,nullable = true)
    private String formula;
    /**
     * 说明
     */
    @Column(length = 255,nullable = true)
    private String description;


    @ManyToOne
    @JoinColumn(name="sfxm_id")
    private Sfxm sfxm;


    @OneToMany(mappedBy = "sfbz", cascade = CascadeType.ALL)
    private Set<Bzxy> bzxies = new HashSet<Bzxy>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Sfxm getSfxm() {
        return sfxm;
    }

    public void setSfxm(Sfxm sfxm) {
        this.sfxm = sfxm;
    }

    public Set<Bzxy> getBzxies() {
        return bzxies;
    }

    public void setBzxies(Set<Bzxy> bzxies) {
        this.bzxies = bzxies;
    }
}
