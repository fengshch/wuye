package cn.southstone.wuye.server.dao;


import cn.southstone.wuye.server.domain.Person;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface PersonDao {
    public Person findById(Long id);

    public List<Person> findAllPersons();

}
