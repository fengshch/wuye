package cn.southstone.wuye.server.service.impl;

import cn.southstone.wuye.common.dto.PersonDto;
import cn.southstone.wuye.server.dao.PersonDao;
import cn.southstone.wuye.server.domain.Person;
import cn.southstone.wuye.server.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengs on 2016/8/20.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao personDao;

    public PersonDto findById(Long id) {
        Person person = personDao.findById(id);
        PersonDto personDto= transferToDto(person);
        return personDto;
    }

    private PersonDto transferToDto(Person person) {
        PersonDto personDto=new PersonDto();
        personDto.setId(person.getId());
        personDto.setName(person.getName());
        personDto.setXb(person.getXb());
        personDto.setCsrq(person.getCsrq());
        personDto.setDescription(person.getDescription());
        personDto.setZjmc(person.getZjmc());
        personDto.setZjhm(person.getZjhm());
        personDto.setYddh(person.getYddh());
        personDto.setGddh(person.getGddh());

        return personDto;
    }

    public List<PersonDto> listAllPersons() {
        List<PersonDto> personDtos = new ArrayList<PersonDto>();
        List<Person> persons = personDao.findAllPersons();
        for (Person person : persons) {
            PersonDto personDto = transferToDto(person);
            personDtos.add(personDto);
        }
        return personDtos;
    }
}
