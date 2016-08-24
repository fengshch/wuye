package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 收费标准选用
 * Created by fengs on 2016/8/22.
 */
public class BzxyDto implements Serializable{


    private static final long serialVersionUID = -634669378270117843L;

    private Long id;

    private Long fkgxId;

    private Long sfbzId;


    private String  khNo;

    private String khName;

    private String sfxmName;

    private String sfbzName;

    private String formula;

    private Boolean sfsf;

    private Date kssfrq;

    private Date jssfrq;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkgxId() {
        return fkgxId;
    }

    public void setFkgxId(Long fkgxId) {
        this.fkgxId = fkgxId;
    }

    public Long getSfbzId() {
        return sfbzId;
    }

    public void setSfbzId(Long sfbzId) {
        this.sfbzId = sfbzId;
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

    public String getSfxmName() {
        return sfxmName;
    }

    public void setSfxmName(String sfxmName) {
        this.sfxmName = sfxmName;
    }

    public String getSfbzName() {
        return sfbzName;
    }

    public void setSfbzName(String sfbzName) {
        this.sfbzName = sfbzName;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Boolean getSfsf() {
        return sfsf;
    }

    public void setSfsf(Boolean sfsf) {
        this.sfsf = sfsf;
    }

    public Date getKssfrq() {
        return kssfrq;
    }

    public void setKssfrq(Date kssfrq) {
        this.kssfrq = kssfrq;
    }

    public Date getJssfrq() {
        return jssfrq;
    }

    public void setJssfrq(Date jssfrq) {
        this.jssfrq = jssfrq;
    }
}
