package cn.southstone.wuye.jfx.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

/**
 * 收费标准
 * Created by fengs on 2016/8/22.
 */

public class Sfbz   {



    private LongProperty id;
    /**
     * 项目名称
     */

    private StringProperty name;


    private StringProperty formula;
    /**
     * 说明
     */

    private StringProperty description;



    private LongProperty sfxmId;

    public Sfbz(Long id, String name, Long sfxmId) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.formula = new SimpleStringProperty();

        this.description = new SimpleStringProperty();
        this.sfxmId = new SimpleLongProperty(sfxmId);
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

    public String getFormula() {
        return formula.get();
    }

    public StringProperty formulaProperty() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula.set(formula);
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

    public long getSfxmId() {
        return sfxmId.get();
    }

    public LongProperty sfxmIdProperty() {
        return sfxmId;
    }

    public void setSfxmId(long sfxmId) {
        this.sfxmId.set(sfxmId);
    }
}
