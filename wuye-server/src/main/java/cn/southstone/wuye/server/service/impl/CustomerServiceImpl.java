package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.CustomerDto;
import cn.southstone.wuye.server.dao.CustomerDao;
import cn.southstone.wuye.server.domain.Customer;
import cn.southstone.wuye.server.domain.GrCustomer;
import cn.southstone.wuye.server.domain.JgCustomer;
import cn.southstone.wuye.server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    public CustomerDto findById(Long id) {
        Customer customer = customerDao.findById(id);
        CustomerDto customerDto= transferToDto(customer);
        return customerDto;
    }

    public List<CustomerDto> listAllCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        List<Customer> customers = customerDao.findAllCustomers();
        for (Customer customer : customers) {
            CustomerDto customerDto = transferToDto(customer);
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }

    public CustomerDto transferToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setNo(customer.getNo());

        customerDto.setFptt(customer.getFptt());
        customerDto.setKhyh(customer.getKhyh());
        customerDto.setYhzh(customer.getYhzh());

        if (customer instanceof GrCustomer) {
            customerDto.setName(((GrCustomer)customer).getPerson().getName());
        } else if (customer instanceof JgCustomer) {
            customerDto.setName(((JgCustomer)customer).getZzjg().getName());
        }


        return customerDto;
    }


}
