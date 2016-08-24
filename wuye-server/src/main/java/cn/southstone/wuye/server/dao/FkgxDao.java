package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Fkgx;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface FkgxDao {
    public Fkgx findById(Long id);


    public List<Fkgx> findAllFkgxes();

    public List<Fkgx> findByWyzyId(Long id);

    public List<Fkgx> findByCustomerId(Long id);



}
