package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.SfbzDto;
import cn.southstone.wuye.server.dao.SfbzDao;
import cn.southstone.wuye.server.domain.Bzxy;
import cn.southstone.wuye.server.domain.Sfbz;
import cn.southstone.wuye.server.service.BzxyService;
import cn.southstone.wuye.server.service.SfbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("sfbzService")
@Transactional
public class SfbzServiceImpl implements SfbzService {
    @Autowired
    SfbzDao sfbzDao;


    @Autowired
    BzxyService bzxyService;

    public SfbzDto findById(Long id) {
        return transferToDto(sfbzDao.findById(id));
    }

    public List<SfbzDto> findAllSfbzDtos() {
        List<Sfbz> sfbzs = sfbzDao.findAllSfbzs();

        List<SfbzDto> sfbzDtos = new ArrayList<SfbzDto>();

        for (Sfbz sfbz : sfbzs) {
            SfbzDto sfbzDto = transferToDto(sfbz);
            sfbzDtos.add(sfbzDto);
        }

        return sfbzDtos;
    }

    public List<SfbzDto> findBySfxmId(Long id) {
        List<Sfbz> sfbzs = sfbzDao.findBySfxmId(id);

        List<SfbzDto> sfbzDtos = new ArrayList<SfbzDto>();

        for (Sfbz sfbz : sfbzs) {
            SfbzDto sfbzDto = transferToDto(sfbz);
            sfbzDtos.add(sfbzDto);
        }

        return sfbzDtos;
    }

    public SfbzDto transferToDto(Sfbz sfbz) {
        SfbzDto sfbzDto= new SfbzDto();
        sfbzDto.setId(sfbz.getId());
        sfbzDto.setName(sfbz.getName());
        sfbzDto.setDescription(sfbz.getDescription());
        sfbzDto.setSfxmId(sfbz.getSfxm().getId());
        sfbzDto.setFormula(sfbz.getFormula());

        return sfbzDto;
    }



}
