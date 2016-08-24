package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.CustomerDto;
import cn.southstone.wuye.server.domain.Customer;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface CustomerService {
    CustomerDto findById(Long id);

    List<CustomerDto> listAllCustomers();

    CustomerDto transferToDto(Customer customer);
}
