package com.gugu.service;

import com.gugu.base.PageInfo;
import com.gugu.model.Person;

public interface PersonService {
    Person registe(Person person);

    PageInfo<Person> getPersonList(PageInfo pageInfo, String searchValue);

    Person get(String loginNo);

    void update(Person person);

    void delete(Integer id);
}
