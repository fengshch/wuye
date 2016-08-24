package cn.southstone.wuye.common.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 收费标准
 * Created by fengs on 2016/8/22.
 */

public class SfbzDto implements Serializable {


    private static final long serialVersionUID = -311212006331186715L;

    private Long id;
    /**
     * 项目名称
     */

    private String name;


    private String formula;
    /**
     * 说明
     */

    private String description;



    private Long sfxmId;




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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSfxmId() {
        return sfxmId;
    }

    public void setSfxmId(Long sfxmId) {
        this.sfxmId = sfxmId;
    }


}
