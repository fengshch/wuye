package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Sfbz;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface SfbzDao {
    public Sfbz findById(Long id);

    public List<Sfbz> findAllSfbzs();

    public List<Sfbz> findBySfxmId(Long id);

}
