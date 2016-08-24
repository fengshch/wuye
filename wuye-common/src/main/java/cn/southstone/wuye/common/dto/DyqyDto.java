package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fengs on 2016/8/22.
 */
public class DyqyDto implements Serializable {


    private static final long serialVersionUID = 3744100770537411081L;

    private Long id;


    /**
     * 区域名称
     */

    private String name;

    /**
     * 区域类别
     */

    private String qylb;

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

    private Set<DyqyDto> children = new HashSet<DyqyDto>();

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

    public String getQylb() {
        return qylb;
    }

    public void setQylb(String qylb) {
        this.qylb = qylb;
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

    public Set<DyqyDto> getChildren() {
        return children;
    }

    public void setChildren(Set<DyqyDto> children) {
        this.children = children;
    }

    public void addChild(DyqyDto child) {
        this.getChildren().add(child);
    }

    @Override
    public String toString() {
        return "name";
    }
}
