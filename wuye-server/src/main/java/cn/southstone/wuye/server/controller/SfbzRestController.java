package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.SfbzDto;
import cn.southstone.wuye.server.service.SfbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
@RestController
public class SfbzRestController {
    @Autowired
    SfbzService sfbzService;

    @RequestMapping(value="/sfbzs",method= RequestMethod.GET)
    public ResponseEntity<List<SfbzDto>> listAllSfbzx(){

        List<SfbzDto> sfbzDtos = sfbzService.findAllSfbzDtos();
        return new ResponseEntity< List<SfbzDto>>(sfbzDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "/sfxm/{id}/sfbzs", method = RequestMethod.GET)
    public ResponseEntity<List<SfbzDto>> getSfbzsBySfxmId(@PathVariable("id") Long id) {
        List<SfbzDto> sfbzDtos = sfbzService.findBySfxmId(id);
        return new ResponseEntity< List<SfbzDto>>(sfbzDtos,HttpStatus.OK);
    }


}
