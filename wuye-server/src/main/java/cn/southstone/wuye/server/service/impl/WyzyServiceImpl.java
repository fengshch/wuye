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

import java.util.HashSet;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("wyzyService")
@Transactional
public class WyzyServiceImpl implements WyzyService {


    public WyzyDto transferToDto(Wyzy wyzy) {
        WyzyDto wyzyDto = new WyzyDto();
        wyzyDto.setId(wyzy.getId());
        wyzyDto.setNo(wyzy.getNo());
        wyzyDto.setName(wyzy.getName());
        wyzyDto.setZylb(wyzy.getZylb());
        wyzyDto.setJzmj(wyzy.getJzmj());
        wyzyDto.setSfmj(wyzy.getSfmj());
        wyzyDto.setDyqyId(wyzy.getDyqy().getId());
        wyzyDto.setDescription(wyzy.getDescription());
        return wyzyDto;
    }
}
