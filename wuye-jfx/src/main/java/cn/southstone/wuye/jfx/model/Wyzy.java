package cn.southstone.wuye.jfx.model;

import javafx.beans.property.*;

import java.io.Serializable;

/**
 * 物业资源类
 * Created by fengs on 2016/8/19.
 */
public class Wyzy {

    private LongProperty id;


    /**
     * 物业资源编号
     */

    private  StringProperty no;
    /**
     * 物业资源名称
     */

    private  StringProperty name;

    /**
     * 资源类别
     */
    private  StringProperty zylb;


    /**
     * 资源说明
     */

    private  StringProperty description;

    /**
     * 建筑面积
     */
    private  DoubleProperty jzmj;

    /**
     * 收费面积
     */

    private DoubleProperty sfmj;
    /**
     * 所在区域
     */

    private  LongProperty dyqyId;

    public Wyzy(long id, String no, String name, String zylb) {
        this.id = new SimpleLongProperty(id);
        this.no = new SimpleStringProperty(no);
        this.name = new SimpleStringProperty(name);
        this.zylb = new SimpleStringProperty(zylb);
        this.description = new SimpleStringProperty();
        this.jzmj = new SimpleDoubleProperty();
        this.sfmj = new SimpleDoubleProperty();
        this.dyqyId = new SimpleLongProperty();
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

    public String getNo() {
        return no.get();
    }

    public StringProperty noProperty() {
        return no;
    }

    public void setNo(String no) {
        this.no.set(no);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getZylb() {
        return zylb.get();
    }

    public StringProperty zylbProperty() {
        return zylb;
    }

    public void setZylb(String zylb) {
        this.zylb.set(zylb);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public double getJzmj() {
        return jzmj.get();
    }

    public DoubleProperty jzmjProperty() {
        return jzmj;
    }

    public void setJzmj(double jzmj) {
        this.jzmj.set(jzmj);
    }

    public double getSfmj() {
        return sfmj.get();
    }

    public DoubleProperty sfmjProperty() {
        return sfmj;
    }

    public void setSfmj(double sfmj) {
        this.sfmj.set(sfmj);
    }

    public long getDyqyId() {
        return dyqyId.get();
    }

    public LongProperty dyqyIdProperty() {
        return dyqyId;
    }

    public void setDyqyId(long dyqyId) {
        this.dyqyId.set(dyqyId);
    }
}
