package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.common.dto.QyzyDto;
import cn.southstone.wuye.server.domain.Dyqy;
import cn.southstone.wuye.server.domain.Wyzy;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
public interface QyzyService {
    QyzyDto findRoot();

    /**
     * 检索所有子项的区域和资源
     * @param id
     * @return
     */
    QyzyDto findById(Long id);

    /**
     * 检索所有子项的区域和资源
     * @param id 区域或资源ID
     * @param lb 区域或资源类别
     * @return
     */
    List<FkgxDto> findChildrenFkgxes(Long id,String lb);

    List<BzxyDto> findChildrenBzxies(Long id, String lb);

    QyzyDto transferDyqyToDto(Dyqy dyqy);

    QyzyDto transferWyzyToDto(Wyzy wyzy);
}
