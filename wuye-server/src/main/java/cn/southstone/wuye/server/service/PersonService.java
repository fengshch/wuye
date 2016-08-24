package cn.southstone.wuye.server.service;

import cn.southstone.wuye.common.dto.PersonDto;
import cn.southstone.wuye.server.domain.Person;

import java.util.List;

/**
 * Created by fengs on 2016/8/19.
 */
public interface PersonService {
    PersonDto findById(Long id);

    List<PersonDto> listAllPersons();
}
