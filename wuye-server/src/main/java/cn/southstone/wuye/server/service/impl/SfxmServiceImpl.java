package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.SfbzDto;
import cn.southstone.wuye.common.dto.SfxmDto;
import cn.southstone.wuye.server.dao.SfxmDao;
import cn.southstone.wuye.server.domain.Sfbz;
import cn.southstone.wuye.server.domain.Sfxm;
import cn.southstone.wuye.server.service.SfbzService;
import cn.southstone.wuye.server.service.SfxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("sfxmService")
@Transactional
public class SfxmServiceImpl implements SfxmService {
    @Autowired
    SfxmDao sfxmDao;

    @Autowired
    SfbzService sfbzService;

    public SfxmDto findById(Long id) {
        return transferToDto(sfxmDao.findById(id));
    }

    public SfxmDto transferToDto(Sfxm sfxm) {
        SfxmDto sfxmDto= new SfxmDto();
        sfxmDto.setId(sfxm.getId());
        sfxmDto.setName(sfxm.getName());
        sfxmDto.setDescription(sfxm.getDescription());

        return sfxmDto;
    }

    public List<SfxmDto> findAllSfxmDtos() {
        List<Sfxm> sfxms=sfxmDao.findAllSfxms();
        List<SfxmDto> sfxmDtos = new ArrayList<SfxmDto>();

        for (Sfxm sfxm : sfxms) {
            sfxmDtos.add(transferToDto(sfxm));
        }
        return sfxmDtos;
    }

}
