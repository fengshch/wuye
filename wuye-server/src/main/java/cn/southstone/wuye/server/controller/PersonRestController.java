package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.PersonDto;
import cn.southstone.wuye.server.service.PersonService;
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
public class PersonRestController {
    @Autowired
    PersonService personService;

    @RequestMapping(value="/persons",method= RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> listAllPersons(){
        List<PersonDto> personDtos= personService.listAllPersons();
        return new ResponseEntity<List<PersonDto>>(personDtos,HttpStatus.OK);

    }
}
