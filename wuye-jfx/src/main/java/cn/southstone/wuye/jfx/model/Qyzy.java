package cn.southstone.wuye.jfx.model;

import cn.southstone.wuye.common.dto.QyzyDto;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * 区域资源传输类
 * Created by fengs on 2016/8/22.
 */
public class Qyzy  {





    private LongProperty id;


    /**
     * 名称
     */

    private StringProperty name;

    /**
     * 区域类别
     */

    private StringProperty lb;

    /**
     * 区域地址
     */

    private StringProperty description;

    /**
     * 上级区域
     */

    private LongProperty parentId;

    /**
     * 包含区域
     */

    private Set<QyzyDto> children = new HashSet<QyzyDto>();

    public Qyzy(Long id, String name, String lb) {
        this.id = new SimpleLongProperty(id);
        this.name = new SimpleStringProperty(name);
        this.lb = new SimpleStringProperty(lb);
        this.description = new SimpleStringProperty();
        this.parentId = new SimpleLongProperty();
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

    public String getLb() {
        return lb.get();
    }

    public StringProperty lbProperty() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb.set(lb);
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

    public long getParentId() {
        return parentId.get();
    }

    public LongProperty parentIdProperty() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId.set(parentId);
    }

    public Set<QyzyDto> getChildren() {
        return children;
    }

    public void setChildren(Set<QyzyDto> children) {
        this.children = children;
    }
}
