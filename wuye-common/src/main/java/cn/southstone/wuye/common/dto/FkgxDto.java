package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 客户资源关系
 * Created by fengs on 2016/8/22.
 */

public class FkgxDto implements Serializable{


    private static final long serialVersionUID = -5544207989972210121L;

    private Long id;


    private Long zyId;

    private String zyNo;

    private String zyName;


    private Long khId;

    private String khNo;

    private String khName;




    /**
     * 是否收费
     */
    private boolean sfsf;

    /**
     * 开始计费日期
     */
    private Date ksjfrq;

    /**
     * 结束计费日期
     */
    private Date jsjfrq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getZyId() {
        return zyId;
    }

    public void setZyId(Long zyId) {
        this.zyId = zyId;
    }

    public String getZyNo() {
        return zyNo;
    }

    public void setZyNo(String zyNo) {
        this.zyNo = zyNo;
    }

    public String getZyName() {
        return zyName;
    }

    public void setZyName(String zyName) {
        this.zyName = zyName;
    }

    public Long getKhId() {
        return khId;
    }

    public void setKhId(Long khId) {
        this.khId = khId;
    }

    public String getKhNo() {
        return khNo;
    }

    public void setKhNo(String khNo) {
        this.khNo = khNo;
    }

    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName;
    }

    public boolean isSfsf() {
        return sfsf;
    }

    public void setSfsf(boolean sfsf) {
        this.sfsf = sfsf;
    }

    public Date getKsjfrq() {
        return ksjfrq;
    }

    public void setKsjfrq(Date ksjfrq) {
        this.ksjfrq = ksjfrq;
    }

    public Date getJsjfrq() {
        return jsjfrq;
    }

    public void setJsjfrq(Date jsjfrq) {
        this.jsjfrq = jsjfrq;
    }
}
