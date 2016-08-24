package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.DyqyDto;
import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.domain.Dyqy;

import java.util.Set;

/**
 * Created by fengs on 2016/8/22.
 */
public interface DyqyService {
    DyqyDto findRoot();

    Set<WyzyDto> findChildrenWyzies(Long id);

    DyqyDto transferToDto(Dyqy dyqy);
}
