package cn.southstone.wuye.jfx.model;

import javafx.beans.property.*;

/**
 * Created by fengs on 2016/8/19.
 */
public class Dyqy {
    private LongProperty id;
    private StringProperty name;
    private StringProperty qylb;

    public Dyqy(Long id,String name, String qylb) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.qylb = new SimpleStringProperty(qylb);
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

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getQylb() {
        return qylb.get();
    }

    public StringProperty qylbProperty() {
        return qylb;
    }

    public void setQylb(String qylb) {
        this.qylb.set(qylb);
    }
}
