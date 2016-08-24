package cn.southstone.wuye.server.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类公共接口
 * Created by fengs on 2016/8/19.
 */
public interface CustomEntity extends Serializable {
    /**
     * @return 实体主键
     */
    Long getId();

    /**
     * @return 返回实体排序位置
     */
    Long getIndex();

    /**
     * @return 返回是否新创建实体
     */
    Boolean isNew();

    /**
     * @return 该实体的版本号
     */
    Integer getVersion();

    /**
     * @return 实体创建时间
     */
    Date getCreatedTime();

    /**
     * @return 实体修改时间
     */
    Date getLastModifiedTime();

    /**
     *
     * @return 实体是否没有锁定
     */
    Boolean isUnlocked();

    /**
     *
     * @return 实体是否过期
     */
    Boolean isUnexpired();

    /**
     * @return 实体的有效性
     */
    Boolean isAvailable();
}
