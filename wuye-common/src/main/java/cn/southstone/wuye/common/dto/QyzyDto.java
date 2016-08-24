package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 区域资源传输类
 * Created by fengs on 2016/8/22.
 */
public class QyzyDto implements Serializable {


    private static final long serialVersionUID = -1457467638835946744L;


    private Long id;


    /**
     * 名称
     */

    private String name;

    /**
     * 区域类别
     */

    private String lb;

    /**
     * 区域地址
     */

    private String description;

    /**
     * 上级区域
     */

    private Long parentId;

    /**
     * 包含区域
     */

    private Set<QyzyDto> children = new HashSet<QyzyDto>();

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

    public String getLb() {
        return lb;
    }

    public void setLb(String lb) {
        this.lb = lb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Set<QyzyDto> getChildren() {
        return children;
    }

    public void setChildren(Set<QyzyDto> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "name";
    }
}
