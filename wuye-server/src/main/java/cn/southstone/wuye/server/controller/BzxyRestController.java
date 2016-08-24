package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.BzxyDto;
import cn.southstone.wuye.common.dto.CalResultDto;
import cn.southstone.wuye.server.service.BzxyService;
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
public class BzxyRestController {
    @Autowired
    BzxyService bzxyService;

    @RequestMapping(value="/bzxies",method= RequestMethod.GET)
    public ResponseEntity<List<BzxyDto>> listAllBzxies(){
        List<BzxyDto> bzxyDtos = bzxyService.findAllBzxyDtos();

        return new ResponseEntity<List<BzxyDto>>(bzxyDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "/sfxm/{id}/bzxies", method = RequestMethod.GET)
    public ResponseEntity<List<BzxyDto>> getSfbzsBySfxmId(@PathVariable("id") Long id) {
        List<BzxyDto> bzxyDtos = bzxyService.findBzxiesBySfxmId(id);

        return new ResponseEntity<List<BzxyDto>>(bzxyDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "/sfxm/{id}/amounts", method = RequestMethod.GET)
    public ResponseEntity<List<CalResultDto>> getAmountsBySfxmId(@PathVariable("id") Long id) {
        List<CalResultDto> calResultDtos = bzxyService.calculateBySfxmId(id);

        return new ResponseEntity<List<CalResultDto>>(calResultDtos,HttpStatus.OK);
    }

    @RequestMapping(value = "/sfbz/{id}/bzxies", method = RequestMethod.GET)
    public ResponseEntity<List<BzxyDto>> getSfbzsBySfbzId(@PathVariable("id") Long id) {
        List<BzxyDto> bzxyDtos = bzxyService.findBzxiesBySfbzId(id);

        return new ResponseEntity<List<BzxyDto>>(bzxyDtos,HttpStatus.OK);
    }
    @RequestMapping(value = "/fkgx/{id}/bzxies", method = RequestMethod.GET)
    public ResponseEntity<List<BzxyDto>> getSfbzsByFkgxId(@PathVariable("id") Long id) {
        List<BzxyDto> bzxyDtos = bzxyService.findBzxiesByFkgxId(id);

        return new ResponseEntity<List<BzxyDto>>(bzxyDtos,HttpStatus.OK);
    }



}
