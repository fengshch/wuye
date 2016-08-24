package cn.southstone.wuye.jfx.model;

import javafx.beans.property.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 收费标准选用
 * Created by fengs on 2016/8/22.
 */
public class Bzxy {


    private LongProperty id;

    private LongProperty fkgxId;

    private LongProperty sfbzId;


    private StringProperty khNo;

    private StringProperty khName;

    private StringProperty sfxmName;

    private StringProperty sfbzName;

    private StringProperty formula;

    private BooleanProperty sfsf;

    private StringProperty kssfrq;

    private StringProperty jssfrq;

    public Bzxy(Long id, Long fkgxId, Long sfbzId) {
        this.id = new SimpleLongProperty(id);
        this.fkgxId = new SimpleLongProperty(fkgxId);
        this.sfbzId = new SimpleLongProperty(sfbzId);

        this.khNo = new SimpleStringProperty();
        this.khName = new SimpleStringProperty();
        this.sfxmName = new SimpleStringProperty();
        this.sfbzName = new SimpleStringProperty();
        this.formula = new SimpleStringProperty();
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

    public long getFkgxId() {
        return fkgxId.get();
    }

    public LongProperty fkgxIdProperty() {
        return fkgxId;
    }

    public void setFkgxId(long fkgxId) {
        this.fkgxId.set(fkgxId);
    }

    public long getSfbzId() {
        return sfbzId.get();
    }

    public LongProperty sfbzIdProperty() {
        return sfbzId;
    }

    public void setSfbzId(long sfbzId) {
        this.sfbzId.set(sfbzId);
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

    public String getSfxmName() {
        return sfxmName.get();
    }

    public StringProperty sfxmNameProperty() {
        return sfxmName;
    }

    public void setSfxmName(String sfxmName) {
        this.sfxmName.set(sfxmName);
    }

    public String getSfbzName() {
        return sfbzName.get();
    }

    public StringProperty sfbzNameProperty() {
        return sfbzName;
    }

    public void setSfbzName(String sfbzName) {
        this.sfbzName.set(sfbzName);
    }

    public String getFormula() {
        return formula.get();
    }

    public StringProperty formulaProperty() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula.set(formula);
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
