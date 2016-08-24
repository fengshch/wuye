package cn.southstone.wuye.server.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 收费标准选用
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="bzxy")
public class Bzxy extends AbstractEntity {


    private static final long serialVersionUID = 7228852937543947069L;
    /**
     * 房客关系
     */
    @ManyToOne
    @JoinColumn(name="fkgx_id")
    private Fkgx fkgx;

    /**
     * 收费标准
     */
    @ManyToOne
    @JoinColumn(name="sfbz_id")
    private  Sfbz sfbz;

    public Fkgx getFkgx() {
        return fkgx;
    }

    public void setFkgx(Fkgx fkgx) {
        this.fkgx = fkgx;
    }

    public Sfbz getSfbz() {
        return sfbz;
    }

    public void setSfbz(Sfbz sfbz) {
        this.sfbz = sfbz;
    }
}
