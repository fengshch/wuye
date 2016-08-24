package cn.southstone.wuye.server.domain;

import javax.persistence.*;

/**
 * 机构客户
 * Created by fengs on 2016/8/22.
 */
@Entity
@DiscriminatorValue("jg")
public class JgCustomer extends Customer{

    private static final long serialVersionUID = 5971495960070613653L;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="jg_id")
    private Zzjg zzjg;


    public Zzjg getZzjg() {
        return zzjg;
    }

    public void setZzjg(Zzjg zzjg) {
        this.zzjg = zzjg;
    }
}
