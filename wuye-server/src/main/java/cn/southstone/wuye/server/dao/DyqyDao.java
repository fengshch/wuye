package cn.southstone.wuye.server.dao;

import cn.southstone.wuye.server.domain.Dyqy;
import cn.southstone.wuye.server.domain.Wyzy;

import java.util.Set;


/**
 * Created by fengs on 2016/8/22.
 */
public interface DyqyDao {
    public Dyqy findById(Long id);

    public Set<Wyzy> findChildrenWyzies(Long id);
}
