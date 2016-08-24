package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.SfxmDto;
import cn.southstone.wuye.server.domain.Sfxm;

import java.util.List;

/**
 * Created by fengs on 2016/8/22.
 */
public interface SfxmService {

    public SfxmDto findById(Long id);

    public List<SfxmDto> findAllSfxmDtos();

    public SfxmDto transferToDto(Sfxm sfxm);
}
