package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.dao.FkgxDao;
import cn.southstone.wuye.server.domain.Fkgx;
import cn.southstone.wuye.server.domain.GrCustomer;
import cn.southstone.wuye.server.domain.JgCustomer;
import cn.southstone.wuye.server.service.CustomerService;
import cn.southstone.wuye.server.service.DyqyService;
import cn.southstone.wuye.server.service.FkgxService;
import cn.southstone.wuye.server.service.WyzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("fkgxService")
@Transactional
public class FkgxServiceImpl implements FkgxService {

    @Autowired
    FkgxDao fkgxDao;

    @Autowired
    CustomerService customerService;

    @Autowired
    WyzyService wyzyService;

    @Autowired
    DyqyService dyqyService;

    public FkgxDto findById(Long id) {
        Fkgx fkgx = fkgxDao.findById(id);

        FkgxDto fkgxDto = transferToDto(fkgx);


        return fkgxDto;
    }

    public List<FkgxDto> listAllFkgxes() {
        List<FkgxDto> fkgxDtos = new ArrayList<FkgxDto>();

        List<Fkgx> fkgxes = fkgxDao.findAllFkgxes();
        for (Fkgx fkgx : fkgxes) {
            fkgxDtos.add(transferToDto(fkgx));
        }
        return fkgxDtos;
    }

    public List<FkgxDto> findFkgxesByWyzyId(Long id) {
        List<FkgxDto> fkgxDtos = new ArrayList<FkgxDto>();

        List<Fkgx> fkgxes = fkgxDao.findByWyzyId(id);
        for (Fkgx fkgx : fkgxes) {
            fkgxDtos.add(transferToDto(fkgx));
        }
        return fkgxDtos;
    }

    public List<FkgxDto> findFkgxesByCustomerId(Long id) {
        List<FkgxDto> fkgxDtos = new ArrayList<FkgxDto>();

        List<Fkgx> fkgxes = fkgxDao.findByCustomerId(id);
        for (Fkgx fkgx : fkgxes) {
            fkgxDtos.add(transferToDto(fkgx));
        }
        return fkgxDtos;
    }

    public List<FkgxDto> findFkgxesByDyqyId(Long id) {
        List<FkgxDto> fkgxDtos = new ArrayList<FkgxDto>();
        Set<WyzyDto> wyzyDtos = dyqyService.findChildrenWyzies(id);
        for (WyzyDto wyzyDto : wyzyDtos) {
            fkgxDtos.addAll(findFkgxesByWyzyId(wyzyDto.getId()));
        }

        return fkgxDtos;
    }

    public FkgxDto transferToDto(Fkgx fkgx) {
         FkgxDto fkgxDto = new FkgxDto();

        fkgxDto.setId(fkgx.getId());
        fkgxDto.setZyId(fkgx.getWyzy().getId());
        fkgxDto.setZyNo(fkgx.getWyzy().getNo());
        fkgxDto.setZyName(fkgx.getWyzy().getName());
        fkgxDto.setKhId(fkgx.getCustomer().getId());
        fkgxDto.setKhNo(fkgx.getCustomer().getNo());

        if (fkgx.getCustomer() instanceof GrCustomer) {
            fkgxDto.setKhName(((GrCustomer) fkgx.getCustomer()).getPerson().getName());
        } else if (fkgx.getCustomer() instanceof JgCustomer) {
            fkgxDto.setKhName(((JgCustomer) fkgx.getCustomer()).getZzjg().getName());
        }

        fkgxDto.setSfsf(fkgx.isSfsf());
        fkgxDto.setKsjfrq(fkgx.getKsjfrq());
        fkgxDto.setJsjfrq(fkgx.getJsjfrq());
        return fkgxDto;
    }


}
