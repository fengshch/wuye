package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.ZzjgDao;
import cn.southstone.wuye.server.domain.Zzjg;
import org.springframework.stereotype.Repository;

/**
 * Created by fengs on 2016/8/19.
 */
@Repository
public class ZzjgDaoImpl extends AbstractDao<Long,Zzjg> implements ZzjgDao {
    public Zzjg findById(Long id) {
        return getByKey(id);
    }

}
