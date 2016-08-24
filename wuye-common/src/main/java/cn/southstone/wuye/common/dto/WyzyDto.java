package cn.southstone.wuye.common.dto;

import java.io.Serializable;

/**
 * 物业资源传输类
 * Created by fengs on 2016/8/19.
 */
public class WyzyDto implements Serializable {

    private Long id;


    /**
     * 物业资源编号
     */

    private String no;
    /**
     * 物业资源名称
     */

    private String name;

    /**
     * 资源类别
     */
    private String zylb;


    /**
     * 资源说明
     */

    private String description;

    /**
     * 建筑面积
     */
    private Double jzmj;

    /**
     * 收费面积
     */

    private Double sfmj;
    /**
     * 所在区域
     */

    private Long dyqyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZylb() {
        return zylb;
    }

    public void setZylb(String zylb) {
        this.zylb = zylb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getJzmj() {
        return jzmj;
    }

    public void setJzmj(Double jzmj) {
        this.jzmj = jzmj;
    }

    public Double getSfmj() {
        return sfmj;
    }

    public void setSfmj(Double sfmj) {
        this.sfmj = sfmj;
    }

    public Long getDyqyId() {
        return dyqyId;
    }

    public void setDyqyId(Long dyqyId) {
        this.dyqyId = dyqyId;
    }

    @Override
    public String toString() {
        return name;
    }
}
