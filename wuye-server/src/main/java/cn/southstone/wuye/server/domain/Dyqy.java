package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *  地域和区域
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="dyqy")
public class Dyqy extends AbstractEntity{


    private static final long serialVersionUID = -6458670043407447452L;


    /**
     * 区域名称
     */
    @Column(length = 255,nullable = false)
    private String name;

    /**
     * 区域类别
     */
    @Column(length = 255,nullable = false)
    private String qylb;

    /**
     * 区域地址
     */
    @Column(length = 255,nullable = true)
    private String description;

    /**
     * 上级区域
     */
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Dyqy parent;

    /**
     * 包含区域
     */
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Dyqy> children = new HashSet<Dyqy>();

    /**
     * 包含物业资源
     */
    @OneToMany(mappedBy = "dyqy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Wyzy> wyzies = new HashSet<Wyzy>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQylb() {
        return qylb;
    }

    public void setQylb(String qylb) {
        this.qylb = qylb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dyqy getParent() {
        return parent;
    }

    public void setParent(Dyqy parent) {
        this.parent = parent;
    }

    public Set<Dyqy> getChildren() {
        return children;
    }

    public void setChildren(Set<Dyqy> children) {
        this.children = children;
    }

    public Set<Wyzy> getWyzies() {
        return wyzies;
    }

    public Set<Wyzy> getChildrenWyzies(){
        Set<Wyzy> wyzies = new HashSet<Wyzy>();
        wyzies = this.getWyzies();
        for (Dyqy dyqy : getChildren()) {
            wyzies.addAll(dyqy.getChildrenWyzies());
        }

        return  wyzies;
    }

    public void setWyzies(Set<Wyzy> wyzies) {
        this.wyzies = wyzies;
    }

    public void addChild(Dyqy child) {
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
        return "name";
    }
}
