package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 收费项目
 * Created by fengs on 2016/8/22.
 */
public class SfxmDto implements Serializable{


    private static final long serialVersionUID = -4415467593236336345L;

    private Long id;
    /**
     * 项目名称
     */

    private String name;

    /**
     * 说明
     */

    private String description;




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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
