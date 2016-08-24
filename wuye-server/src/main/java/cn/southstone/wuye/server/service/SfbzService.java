package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.SfbzDto;
import cn.southstone.wuye.server.domain.Sfbz;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
public interface SfbzService {

    public SfbzDto findById(Long id);

    public List<SfbzDto> findAllSfbzDtos();

    public List<SfbzDto> findBySfxmId(Long id);

    public SfbzDto transferToDto(Sfbz sfbz);

}
