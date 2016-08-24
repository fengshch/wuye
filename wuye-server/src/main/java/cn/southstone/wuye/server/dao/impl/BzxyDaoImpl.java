package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.BzxyDao;
import cn.southstone.wuye.server.domain.Bzxy;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
@Repository
public class BzxyDaoImpl extends AbstractDao<Long, Bzxy> implements BzxyDao {
    public Bzxy findById(Long id) {
        return getByKey(id);
    }

    public List<Bzxy> findAllBzxies() {
        List<Bzxy> bzxies = getSession().createQuery("from Bzxy", Bzxy.class).list();
        return bzxies;
    }

    public List<Bzxy> findBzxiesByFkgxId(Long id) {

        List<Bzxy> bzxies = getSession().createQuery("from Bzxy where fkgx_id=:fkgx_id", Bzxy.class)
                .setParameter("fkgx_id",id).list();
        return bzxies;
    }

    public List<Bzxy> findBzxiesBySfbzId(Long id) {
        List<Bzxy> bzxies = getSession().createQuery("from Bzxy where sfbz_id=:sfbz_id", Bzxy.class)
                .setParameter("sfbz_id",id).list();
        return bzxies;
    }

    public List<Bzxy> findBzxiesBySfxmId(Long id) {
        List<Bzxy> bzxies = getSession()
                .createQuery("select bzxy from Bzxy bzxy inner join Sfbz sfbz on bzxy.sfbz.id=sfbz.id where sfbz.sfxm.id=:sfxm_id", Bzxy.class)
                .setParameter("sfxm_id",id).list();
        return bzxies;
    }

    public List<Bzxy> findBzxiesByWyzyId(Long id) {
        List<Bzxy> bzxies = getSession()
                .createQuery("select bzxy from Bzxy bzxy inner join Fkgx fkgx on bzxy.fkgx.id=fkgx.id where fkgx.wyzy.id=:wyzyId", Bzxy.class)
                .setParameter("wyzyId",id).list();
        return bzxies;
    }


}
