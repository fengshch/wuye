package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.CalResultDto;
import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.dao.BzxyDao;
import cn.southstone.wuye.server.domain.Bzxy;
import cn.southstone.wuye.server.service.BzxyService;
import cn.southstone.wuye.server.service.DyqyService;
import cn.southstone.wuye.server.service.FkgxService;
import cn.southstone.wuye.server.service.SfbzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("bzxyService")
@Transactional
public class BzxyServiceImpl implements BzxyService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BzxyDao bzxyDao;

    @Autowired
    SfbzService sfbzService;

    @Autowired
    FkgxService fkgxService;

    @Autowired
    DyqyService dyqyService;

    public BzxyDto findById(Long id) {
        return transferToDto(bzxyDao.findById(id));
    }

    public List<BzxyDto> findAllBzxyDtos() {
        List<Bzxy> bzxies = bzxyDao.findAllBzxies();
        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();
        for (Bzxy bzxy : bzxies) {
            BzxyDto bzxyDto = transferToDto(bzxy);
            bzxyDtos.add(bzxyDto);
        }
        return bzxyDtos;
    }

    public List<BzxyDto> findBzxiesByFkgxId(Long id) {
        List<Bzxy> bzxies = bzxyDao.findBzxiesByFkgxId(id);
        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();
        for (Bzxy bzxy : bzxies) {
            BzxyDto bzxyDto = transferToDto(bzxy);
            bzxyDtos.add(bzxyDto);
        }
        return bzxyDtos;
    }

    public List<BzxyDto> findBzxiesBySfbzId(Long id) {
        List<Bzxy> bzxies = bzxyDao.findBzxiesBySfbzId(id);
        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();
        for (Bzxy bzxy : bzxies) {
            BzxyDto bzxyDto = transferToDto(bzxy);
            bzxyDtos.add(bzxyDto);
        }
        return bzxyDtos;
    }

    public List<BzxyDto> findBzxiesBySfxmId(Long id) {
        List<Bzxy> bzxies = bzxyDao.findBzxiesBySfxmId(id);
        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();
        for (Bzxy bzxy : bzxies) {
            BzxyDto bzxyDto = transferToDto(bzxy);
            bzxyDtos.add(bzxyDto);
        }
        return bzxyDtos;
    }

    public List<CalResultDto> calculateBySfxmId(Long id) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        List<BzxyDto> bzxies = findBzxiesBySfxmId(id);
        List<CalResultDto> calResultDtos = new ArrayList<>();
        for (BzxyDto bzxyDto : bzxies) {
            Long fkgxId=bzxyDto.getFkgxId();
            Long sfbzId=bzxyDto.getSfbzId();
            BigDecimal amount = new BigDecimal(0);
            try {
                logger.debug(bzxyDto.getFormula());
                amount = new BigDecimal((double)nashorn.eval(bzxyDto.getFormula()));
               /* String sample1=" var Foo = Java.type('cn.southstone.wuye.server.cal.Foo');";
                sample1+="var foo = new Foo();foo.setA(5.0);foo.setB(2.0);";
                sample1+="foo.sum();";
                amount = new BigDecimal((double)nashorn.eval(sample1));
*/
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            CalResultDto calResultDto =new CalResultDto();
            calResultDto.setFkgxId(fkgxId);
            calResultDto.setSfbzId(sfbzId);
            calResultDto.setAmount(amount);
            calResultDtos.add(calResultDto);
        }
        return calResultDtos;
    }

    public BzxyDto transferToDto(Bzxy bzxy) {
        BzxyDto bzxyDto = new BzxyDto();
        bzxyDto.setId(bzxy.getId());
        FkgxDto fkgxDto = fkgxService.transferToDto(bzxy.getFkgx());
        bzxyDto.setFkgxId(fkgxDto.getId());

        bzxyDto.setKhNo(fkgxDto.getKhNo());
        bzxyDto.setKhName(fkgxDto.getKhName());
        bzxyDto.setFormula(bzxy.getSfbz().getFormula());
        bzxyDto.setSfbzId(bzxy.getSfbz().getId());
        bzxyDto.setSfbzName(bzxy.getSfbz().getName());
        bzxyDto.setKssfrq(fkgxDto.getKsjfrq());
        bzxyDto.setJssfrq(fkgxDto.getJsjfrq());
        bzxyDto.setSfsf(fkgxDto.isSfsf());
        bzxyDto.setSfxmName(bzxy.getSfbz().getSfxm().getName());
        return bzxyDto;
    }

    @Override
    public List<BzxyDto> findBzxiesByDyqyId(Long id) {

        Set<WyzyDto> wyzyDtos = dyqyService.findChildrenWyzies(id);

        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();

        for (WyzyDto wyzyDto : wyzyDtos) {
            bzxyDtos.addAll(findBzxiesByWyzyId(wyzyDto.getId()));
        }
        return bzxyDtos;
    }

    @Override
    public List<BzxyDto> findBzxiesByWyzyId(Long id) {
        List<Bzxy> bzxies = bzxyDao.findBzxiesByWyzyId(id);
        List<BzxyDto> bzxyDtos = new ArrayList<BzxyDto>();
        for (Bzxy bzxy : bzxies) {
            BzxyDto bzxyDto = transferToDto(bzxy);
            bzxyDtos.add(bzxyDto);
        }
        return bzxyDtos;
    }


}
