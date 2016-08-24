package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.ZzjgDto;
import cn.southstone.wuye.server.service.ZzjgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fengs on 2016/8/19.
 */
@RestController
public class ZzjgRestController {
    @Autowired
    ZzjgService zzjgService;

    @RequestMapping(value="/zzjg/root",method= RequestMethod.GET)
    public ResponseEntity<ZzjgDto> getRoot(){
        ZzjgDto zzjgDto=zzjgService.findRoot();
        return new ResponseEntity<ZzjgDto>(zzjgDto,HttpStatus.OK);

    }
}
