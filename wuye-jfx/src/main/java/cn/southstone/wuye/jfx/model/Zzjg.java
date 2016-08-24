package cn.southstone.wuye.jfx.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by fengs on 2016/8/19.
 */
public class Zzjg {
    private StringProperty name;
    private StringProperty jglb;

    public Zzjg(String name, String jglb) {
        this.name = new SimpleStringProperty(name);
        this.jglb = new SimpleStringProperty(jglb);
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

    public String getJglb() {
        return jglb.get();
    }

    public StringProperty jglbProperty() {
        return jglb;
    }

    public void setJglb(String jglb) {
        this.jglb.set(jglb);
    }
}
