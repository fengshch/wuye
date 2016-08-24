package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.SfxmDto;
import cn.southstone.wuye.server.service.SfxmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
@RestController
public class SfxmRestController {
    @Autowired
    SfxmService sfxmService;

    @RequestMapping(value="/sfxms",method= RequestMethod.GET)
    public ResponseEntity<List<SfxmDto>> listAllSfxms(){
        List<SfxmDto> sfxmDtos = sfxmService.findAllSfxmDtos();

        return new ResponseEntity<List<SfxmDto>>(sfxmDtos,HttpStatus.OK);

    }
}
