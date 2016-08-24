package cn.southstone.wuye.server.dao.impl;

import cn.southstone.wuye.server.dao.AbstractDao;
import cn.southstone.wuye.server.dao.PersonDao;
import cn.southstone.wuye.server.dao.ZzjgDao;
import cn.southstone.wuye.server.domain.Person;
import cn.southstone.wuye.server.domain.Zzjg;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
@Repository
public class PersonDaoImpl extends AbstractDao<Long,Person> implements PersonDao {
    public Person findById(Long id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    public List<Person> findAllPersons() {
        List<Person> persons=getSession().createQuery("from Person").list();

        return persons;
    }
}
