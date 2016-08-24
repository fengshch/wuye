package cn.southstone.wuye.common.dto;


import java.io.Serializable;
import java.util.Date;

/**
 * 人员信息
 * Created by fengs on 2016/8/22.
 */

public class PersonDto implements Serializable{


    private static final long serialVersionUID = 968836276372255623L;
    private Long id;


    /**
     * 姓名
     */

    private String name;

    /**
     * 说明
     */

    private String description;


    /**
     * 性别
     */

    private String xb;


    /**
     * 证件名称
     */

    private String zjmc;

    /**
     * 证件号码
     */

    private String zjhm;

    /**
     * 出生日期
     */

    private Date csrq;

    /**
     * 邮箱
     */

    private String email;

    /**
     * 移动电话
     */

    private String yddh;

    /**
     * 固定电话
     */

    private String gddh;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
