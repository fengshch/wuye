package cn.southstone.wuye.common.dto;

import java.io.Serializable;

/**
 * 客户信息
 * Created by fengs on 2016/8/22.
 */
public class CustomerDto implements Serializable{

    private static final long serialVersionUID = -8196638652675438211L;

    private Long id;

    private String name;
    /**
     * 客户编号
     */
    private String no;

    /**
     * 发票抬头
     */
    private String fptt;

    /**
     * 开户银行
     */
    private String khyh;

    /**
     * 银行账号
     */
    private String yhzh;

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
}
