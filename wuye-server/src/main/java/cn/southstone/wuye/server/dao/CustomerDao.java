package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Customer;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface CustomerDao {
    public Customer findById(Long id);

    public List<Customer> findAllCustomers();

}
