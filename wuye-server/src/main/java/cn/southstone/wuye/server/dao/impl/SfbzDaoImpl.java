package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.SfbzDao;
import cn.southstone.wuye.server.domain.Sfbz;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
@Repository
public class SfbzDaoImpl extends AbstractDao<Long, Sfbz> implements SfbzDao {
    public Sfbz findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Sfbz> findAllSfbzs() {
        List<Sfbz> sfbzs = getSession().createQuery("from Sfbz",Sfbz.class).list();
        return sfbzs;
    }

    @SuppressWarnings("unchecked")
    public List<Sfbz> findBySfxmId(Long id) {
        List<Sfbz> sfbzs = getSession().createQuery("from Sfbz where sfxm_id=:sfxmId ")
                .setParameter("sfxmId", id).list();
        return sfbzs;
    }

}
