package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.common.dto.QyzyDto;
import cn.southstone.wuye.server.dao.DyqyDao;
import cn.southstone.wuye.server.domain.Dyqy;
import cn.southstone.wuye.server.domain.Wyzy;
import cn.southstone.wuye.server.service.BzxyService;
import cn.southstone.wuye.server.service.FkgxService;
import cn.southstone.wuye.server.service.QyzyService;
import cn.southstone.wuye.server.service.WyzyService;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("qyzyService")
@Transactional
public class QyzyServiceImpl implements QyzyService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DyqyDao dyqyDao;

    @Autowired
    WyzyService wyzyService;

    @Autowired
    FkgxService fkgxService;

    @Autowired
    BzxyService bzxyService;


    public QyzyDto findRoot() {
        return findById(1L);
    }

    public QyzyDto findById(Long id) {

        Dyqy dyqy = dyqyDao.findById(id);
        QyzyDto qyzyDto =transferDyqyToDto(dyqy);


        return qyzyDto;
    }

    public List<FkgxDto> findChildrenFkgxes(Long id, String lb) {
        List<FkgxDto> fkgxDtos = new ArrayList<FkgxDto>();


       if ("qy".equalsIgnoreCase(lb)) {

            fkgxDtos = fkgxService.findFkgxesByDyqyId(id);
        } else if ("zy".equalsIgnoreCase(lb)) {
                fkgxDtos = fkgxService.findFkgxesByWyzyId(id);

        }
        return fkgxDtos;
    }

    @Override
    public List<BzxyDto> findChildrenBzxies(Long id, String lb) {
        List<BzxyDto> bzxyDtos = new ArrayList<>();

        if ("qy".equalsIgnoreCase(lb)) {
            bzxyDtos = bzxyService.findBzxiesByDyqyId(id);
        } else if ("zy".equalsIgnoreCase(lb)) {
            bzxyDtos = bzxyService.findBzxiesByWyzyId(id);
        }
        return bzxyDtos;
    }

    public QyzyDto transferDyqyToDto(Dyqy dyqy) {
        QyzyDto qyzyDto = new QyzyDto();
        qyzyDto.setId(dyqy.getId());
        qyzyDto.setLb("qy");
        qyzyDto.setName(dyqy.getName());
        if (null != dyqy.getParent()) {
            qyzyDto.setParentId(dyqy.getParent().getId());
        }

        qyzyDto.setDescription(dyqy.getDescription());
        for (Wyzy wyzy : dyqy.getWyzies()) {
            qyzyDto.getChildren().add(transferWyzyToDto(wyzy));
        }
        for (Dyqy child : dyqy.getChildren()) {
            QyzyDto childDto = transferDyqyToDto(child);
            qyzyDto.getChildren().add(childDto);


        }
        return qyzyDto;
    }

    public QyzyDto transferWyzyToDto(Wyzy wyzy) {
        QyzyDto qyzyDto = new QyzyDto();
        qyzyDto.setId(wyzy.getId());
        qyzyDto.setLb("zy");
        qyzyDto.setName(wyzy.getName());
        if (null != wyzy.getDyqy()) {
            qyzyDto.setParentId(wyzy.getDyqy().getId());
        }

        qyzyDto.setDescription(wyzy.getDescription());


        return qyzyDto;
    }







}
