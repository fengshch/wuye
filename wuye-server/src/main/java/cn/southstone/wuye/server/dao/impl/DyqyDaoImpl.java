package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.DyqyDao;
import cn.southstone.wuye.server.domain.Dyqy;
import cn.southstone.wuye.server.domain.Wyzy;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by fengs on 2016/8/22.
 */
@Repository
public class DyqyDaoImpl extends AbstractDao<Long,Dyqy> implements DyqyDao {
    public Dyqy findById(Long id) {
        return getByKey(id);
    }

    public Set<Wyzy> findChildrenWyzies(Long id) {
        Dyqy dyqy = getByKey(id);

        return dyqy.getChildrenWyzies();
    }
}
