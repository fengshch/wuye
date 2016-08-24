package cn.southstone.wuye.jfx.model;

import javafx.beans.property.*;

/**
 * 房客关系类
 * Created by fengs on 2016/8/19.
 */
public class Fkgx {

    private LongProperty id;


    /**
     * 客户编号
     */

    private  StringProperty khNo;
    /**
     * 客户名称
     */

    private  StringProperty khName;

    /**
     * 是否收费
     */
    private  BooleanProperty sfsf;


    /**
     * 开始收费日期
     */

    private  StringProperty kssfrq;

    /**
     * 结束收费日期
     */
    private  StringProperty jssfrq;



    public Fkgx(long id,String KhNo,String KhName) {
        this.id = new SimpleLongProperty(id);
        this.khNo = new SimpleStringProperty(KhNo);
        this.khName = new SimpleStringProperty(KhName);
        this.sfsf = new SimpleBooleanProperty();
        this.kssfrq = new SimpleStringProperty();
        this.jssfrq = new SimpleStringProperty();
    }

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getKhNo() {
        return khNo.get();
    }

    public StringProperty khNoProperty() {
        return khNo;
    }

    public void setKhNo(String khNo) {
        this.khNo.set(khNo);
    }

    public String getKhName() {
        return khName.get();
    }

    public StringProperty khNameProperty() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName.set(khName);
    }

    public boolean isSfsf() {
        return sfsf.get();
    }

    public BooleanProperty sfsfProperty() {
        return sfsf;
    }

    public void setSfsf(boolean sfsf) {
        this.sfsf.set(sfsf);
    }

    public String getKssfrq() {
        return kssfrq.get();
    }

    public StringProperty kssfrqProperty() {
        return kssfrq;
    }

    public void setKssfrq(String kssfrq) {
        this.kssfrq.set(kssfrq);
    }

    public String getJssfrq() {
        return jssfrq.get();
    }

    public StringProperty jssfrqProperty() {
        return jssfrq;
    }

    public void setJssfrq(String jssfrq) {
        this.jssfrq.set(jssfrq);
    }
}
