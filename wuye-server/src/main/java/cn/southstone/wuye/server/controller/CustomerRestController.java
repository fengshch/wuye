package cn.southstone.wuye.server.controller;

import cn.southstone.wuye.common.dto.CustomerDto;
import cn.southstone.wuye.common.dto.PersonDto;
import cn.southstone.wuye.server.domain.Customer;
import cn.southstone.wuye.server.service.CustomerService;
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
public class CustomerRestController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/customers",method= RequestMethod.GET)
    public ResponseEntity<List<CustomerDto>> listAllCustomers(){
        List<CustomerDto> customerDtos= customerService.listAllCustomers();

        return new ResponseEntity<List<CustomerDto>>(customerDtos,HttpStatus.OK);

    }
}
