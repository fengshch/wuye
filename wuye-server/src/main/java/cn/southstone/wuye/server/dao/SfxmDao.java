package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Sfxm;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface SfxmDao {
    public Sfxm findById(Long id);

    public List<Sfxm> findAllSfxms();

}
