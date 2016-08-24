package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.server.domain.Fkgx;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface FkgxService {
    FkgxDto findById(Long id);

    List<FkgxDto> listAllFkgxes();

    List<FkgxDto> findFkgxesByWyzyId(Long id);

    List<FkgxDto> findFkgxesByCustomerId(Long id);

    List<FkgxDto> findFkgxesByDyqyId(Long id);

    FkgxDto transferToDto(Fkgx fkgx);
}
