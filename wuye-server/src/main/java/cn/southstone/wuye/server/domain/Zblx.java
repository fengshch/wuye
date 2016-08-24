package cn.southstone.wuye.server.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 走表类型
 * Created by fengs on 2016/8/22.
 */
@Entity
@Table(name="zblx")
public class Zblx extends AbstractEntity {


    private static final long serialVersionUID = 8548732387504441361L;
    /**
     * 项目名称
     */
    @Column(length = 255,nullable = false)
    private String name;

    /**
     * 说明
     */
    @Column(length = 255,nullable = true)
    private String description;


    /**
     * 表倍率
     */
    private Integer bbl;


    /**
     * 最大值
     */
    private Long zbjs;

}
