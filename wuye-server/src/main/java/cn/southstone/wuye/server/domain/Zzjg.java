package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *组织机构类
 * Created by fengs on 2016/8/19.
 */
@Entity
@Table(name="zzjg")
public class Zzjg extends AbstractEntity{


    private static final long serialVersionUID = 4971694630021850315L;

    /**
     * 机构名称
     */
    @Column(length=255,nullable = false)
    private String name;

    /**
     * 机构类别
     */
    @Column(length = 255,nullable = false)
    private String jglb;


    /**
     * 机构说明
     */
    @Column(length = 255,nullable = true)
    private String description;

    /**
     * 上级机构
     */
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Zzjg parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Zzjg> children = new HashSet<Zzjg>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJglb() {
        return jglb;
    }

    public void setJglb(String jglb) {
        this.jglb = jglb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Zzjg getParent() {
        return parent;
    }

    public void setParent(Zzjg parent) {
        this.parent = parent;
    }

    public Set<Zzjg> getChildren() {
        return children;
    }

    public void setChildren(Set<Zzjg> children) {
        this.children = children;
    }

    public void addChild(Zzjg child) {
        if (!getChildren().contains(child)) {
            getChildren().add(child);
            if (child.getParent() != null) {
                child.getParent().getChildren().remove(child);
            }
            child.setParent(this);

        }
    }

    @Override
    public String toString() {
        return name;
    }
}
