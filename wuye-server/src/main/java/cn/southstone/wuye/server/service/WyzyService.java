package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.domain.Wyzy;

/**
 * Created by fengs on 2016/8/22.
 */
public interface WyzyService {
    WyzyDto transferToDto(Wyzy wyzy);
}
