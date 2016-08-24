package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.DyqyDto;
import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.dao.DyqyDao;
import cn.southstone.wuye.server.domain.Dyqy;
import cn.southstone.wuye.server.domain.Wyzy;
import cn.southstone.wuye.server.service.DyqyService;
import cn.southstone.wuye.server.service.WyzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("dyqyService")
@Transactional
public class DyqyServiceImpl implements DyqyService {
    @Autowired
    DyqyDao dyqyDao;

    @Autowired
    WyzyService wyzyService;

    public DyqyDto findRoot() {
        Dyqy dyqy =dyqyDao.findById(1L);
        DyqyDto dyqyDto=null;
        if (null != dyqy) {
            dyqyDto = transferToDto(dyqy);
        }
        return dyqyDto;
    }

    public Set<WyzyDto> findChildrenWyzies(Long id) {
        Set<Wyzy> wyzies = dyqyDao.findChildrenWyzies(id);
        Set<WyzyDto> wyzyDtos = new HashSet<WyzyDto>();

        for (Wyzy wyzy : wyzies) {
            WyzyDto wyzyDto = wyzyService.transferToDto(wyzy);
            wyzyDtos.add(wyzyDto);
        }

        return  wyzyDtos;
    }

    public DyqyDto transferToDto(Dyqy dyqy) {
        DyqyDto dyqyDto=new DyqyDto();
        dyqyDto.setId(dyqy.getId());
        if (null != dyqy.getParent()) {
            dyqyDto.setParentId(dyqy.getParent().getId());

        }

        dyqyDto.setName(dyqy.getName());
        dyqyDto.setQylb(dyqy.getQylb());
        dyqyDto.setDescription(dyqy.getDescription());

        for (Dyqy child : dyqy.getChildren()) {
            DyqyDto childDto = transferToDto(child);
            dyqyDto.addChild(childDto);
        }
        return dyqyDto;
    }



}
