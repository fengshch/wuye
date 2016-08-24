package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.DyqyDto;
import cn.southstone.wuye.common.dto.FkgxDto;
import cn.southstone.wuye.common.dto.WyzyDto;
import cn.southstone.wuye.server.service.DyqyService;
import cn.southstone.wuye.server.service.FkgxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/19.
 */
@RestController
public class DyqyRestController {
    @Autowired
    DyqyService dyqyService;

    @Autowired
    FkgxService fkgxService;

    @RequestMapping(value="/dyqy/root",method= RequestMethod.GET)
    public ResponseEntity<DyqyDto> getRoot(){
        DyqyDto dyqyDto=dyqyService.findRoot();
        return new ResponseEntity<DyqyDto>(dyqyDto,HttpStatus.OK);

    }

    @RequestMapping(value = "/dyqy/{id}/wyzies")
    public ResponseEntity<Set<WyzyDto>> getChildrenWyzies(@PathVariable("id") Long id) {
        Set<WyzyDto> wyzyDtos = dyqyService.findChildrenWyzies(id);
        return new ResponseEntity<Set<WyzyDto>>(wyzyDtos,HttpStatus.OK);
    }


    @RequestMapping(value = "/dyqy/{id}/fkgxes")
    public ResponseEntity<List<FkgxDto>> getChildrenFkgxes(@PathVariable("id") Long id) {
        List<FkgxDto> fkgxDtos = fkgxService.findFkgxesByDyqyId(id);
        return new ResponseEntity<List<FkgxDto>>(fkgxDtos,HttpStatus.OK);
    }

}
