package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * 人员信息
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="person")
public class Person extends AbstractEntity {


    private static final long serialVersionUID = -499931610568054549L;
    /**
     * 姓名
     */
    @Column(length = 255,nullable = false)
    private String name;

    /**
     * 说明
     */
    @Column(length = 255,nullable = true)
    private String description;


    /**
     * 性别
     */
    @Column(length = 1,nullable = false)
    private String xb;


    /**
     * 证件名称
     */
    @Column(length = 50,nullable = true)
    private String zjmc;

    /**
     * 证件号码
     */
    @Column(length = 50,nullable = true)
    private String zjhm;

    /**
     * 出生日期
     */
    @Temporal(TemporalType.DATE)
    private Date csrq;

    /**
     * 邮箱
     */
    @Column(length = 255,nullable = true)
    private String email;

    /**
     * 移动电话
     */
    @Column(length =50,nullable = true)
    private String yddh;

    /**
     * 固定电话
     */
    @Column(length = 50,nullable = true)
    private String gddh;


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

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getZjmc() {
        return zjmc;
    }

    public void setZjmc(String zjmc) {
        this.zjmc = zjmc;
    }

    public String getZjhm() {
        return zjhm;
    }

    public void setZjhm(String zjhm) {
        this.zjhm = zjhm;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getYddh() {
        return yddh;
    }

    public void setYddh(String yddh) {
        this.yddh = yddh;
    }

    public String getGddh() {
        return gddh;
    }

    public void setGddh(String gddh) {
        this.gddh = gddh;
    }
}
