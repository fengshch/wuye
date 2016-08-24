package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Bzxy;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface BzxyDao {
    public Bzxy findById(Long id);

    public List<Bzxy> findAllBzxies();

    public List<Bzxy> findBzxiesByFkgxId(Long id);

    public List<Bzxy> findBzxiesBySfbzId(Long id);

    public List<Bzxy> findBzxiesBySfxmId(Long id);

    public List<Bzxy> findBzxiesByWyzyId(Long id);


}
