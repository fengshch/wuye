package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.*;
import cn.southstone.wuye.server.domain.Fkgx;
import cn.southstone.wuye.server.service.DyqyService;
import cn.southstone.wuye.server.service.FkgxService;
import cn.southstone.wuye.server.service.QyzyService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by fengs on 2016/8/19.
 */
@RestController
public class QyzyRestController {
    @Autowired
    QyzyService qyzyService;



    @RequestMapping(value="/qyzy/root",method= RequestMethod.GET)
    public ResponseEntity<QyzyDto> getRoot(){
        QyzyDto qyzyDto= qyzyService.findRoot();

        return new ResponseEntity<QyzyDto>(qyzyDto,HttpStatus.OK);

    }



    @RequestMapping(value = "/qyzy/{id}/fkgxes")
    public ResponseEntity<List<FkgxDto>> getChildrenFkgxes(@PathVariable("id") Long id, @RequestParam("lb") String lb) {
        List<FkgxDto> fkgxDtos = qyzyService.findChildrenFkgxes(id, lb);
        return new ResponseEntity<List<FkgxDto>>(fkgxDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "/qyzy/{id}/bzxies")
    public ResponseEntity<List<BzxyDto>> getChildrenBzxies(@PathVariable("id") Long id, @RequestParam("lb") String lb) {
        List<BzxyDto> bzxyDtos = qyzyService.findChildrenBzxies(id, lb);
        return new ResponseEntity<List<BzxyDto>>(bzxyDtos,HttpStatus.OK);
    }

}
