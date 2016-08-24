package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.SfxmDao;
import cn.southstone.wuye.server.domain.Sfxm;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
@Repository
public class SfxmDaoImpl extends AbstractDao<Long, Sfxm> implements SfxmDao {
    public Sfxm findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Sfxm> findAllSfxms() {
        List<Sfxm> sfxms = getSession().createQuery("From Sfxm").list();
        return sfxms;
    }


}
