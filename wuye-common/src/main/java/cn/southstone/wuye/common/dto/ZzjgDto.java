package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
public class ZzjgDto implements Serializable {


    private static final long serialVersionUID = 5876302893043264695L;
    private Long id;

    private Long parentId;
    private String name;

    private String jglb;

    private String description;

    private Set<ZzjgDto> children = new HashSet<ZzjgDto>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJglb() {
        return jglb;
    }

    public void setJglb(String jglb) {
        this.jglb = jglb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ZzjgDto> getChildren() {
        return children;
    }

    public void setChildren(Set<ZzjgDto> children) {
        this.children = children;
    }

    public void addChild(ZzjgDto zzjgDto) {
        this.getChildren().add(zzjgDto);
    }

    @Override
    public String toString() {
        return "ZzjgDto{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", jglb='" + jglb + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
