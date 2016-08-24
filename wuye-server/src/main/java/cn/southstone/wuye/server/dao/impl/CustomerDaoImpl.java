package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.CustomerDao;
import cn.southstone.wuye.server.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
@Repository
public class CustomerDaoImpl extends AbstractDao<Long,Customer> implements CustomerDao {

    public Customer findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAllCustomers() {
        List<Customer> customers= getSession().createQuery("from Customer").list();
        return customers;
    }
}
