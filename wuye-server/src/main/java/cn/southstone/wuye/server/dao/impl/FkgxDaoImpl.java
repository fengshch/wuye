package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.FkgxDao;
import cn.southstone.wuye.server.domain.Fkgx;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
@Repository
public class FkgxDaoImpl extends AbstractDao<Long,Fkgx> implements FkgxDao {
    public Fkgx findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Fkgx> findAllFkgxes() {
        List<Fkgx> fkgxes=getSession().createQuery("from Fkgx").list();

        return fkgxes;
    }

    @SuppressWarnings("unchecked")
    public List<Fkgx> findByWyzyId(Long id) {
        List<Fkgx> fkgxes=getSession().createQuery("select  fkgx from Fkgx fkgx where zy_id=:zy_id")
                .setParameter("zy_id",id).list();

        return fkgxes;
    }

    @SuppressWarnings("unchecked")
    public List<Fkgx> findByCustomerId(Long id) {
        List<Fkgx> fkgxes= getSession().createQuery("select  fkgx from Fkgx fkgx where kh_id=:kh_id")
                .setParameter("kh_id",id).list();

        return fkgxes;
    }




}
