package com.gugu.service.impl;

import com.gugu.base.PageInfo;
import com.gugu.model.Person;
import com.gugu.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Override
    public Person registe(Person person) {
        return null;
    }

    @Override
    public PageInfo<Person> getPersonList(PageInfo pageInfo, String searchValue) {
        return null;
    }

    @Override
    public Person get(String loginNo) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Integer id) {

    }
}
