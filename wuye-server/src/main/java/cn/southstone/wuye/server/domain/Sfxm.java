package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 收费项目
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="sfxm")
public class Sfxm extends AbstractEntity {


    private static final long serialVersionUID = -3699438840152379226L;
    /**
     * 项目名称
     */
    @Column(length = 255,nullable = false)
    private String name;

    /**
     * 说明
     */
    @Column(length = 255,nullable = true)
    private String description;


    @OneToMany(mappedBy = "sfxm", cascade = CascadeType.ALL)
    private Set<Sfbz> sfbzs = new HashSet<Sfbz>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Sfbz> getSfbzs() {
        return sfbzs;
    }

    public void setSfbzs(Set<Sfbz> sfbzs) {
        this.sfbzs = sfbzs;
    }

    public void addSfbz(Sfbz sfbz) {
        if (!getSfbzs().contains(sfbz)) {
            getSfbzs().add(sfbz);

            if (sfbz.getSfxm() != null) {
                sfbz.getSfxm().getSfbzs().remove(sfbz);
            }

            sfbz.setSfxm(this);

        }
    }
}
