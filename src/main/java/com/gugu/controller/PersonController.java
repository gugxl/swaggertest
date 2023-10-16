package com.gugu.controller;

import com.gugu.annotation.BusLog;
import com.gugu.base.PageInfo;
import com.gugu.model.Person;
import com.gugu.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@BusLog(name = "人员管理")
@RequestMapping("/person")
public class PersonController {

    @Autowired(required=false)
    private PersonService personService;

    private static final Integer MAX_COUNT = 100;

    @PostMapping
    @BusLog(describe = "添加单条人员信息")
    public Person add(@RequestBody Person person) {
        Person result = personService.registe(person);
        log.info("//增加person执行完成");
        return result;
    }

    @GetMapping
    @BusLog(describe = "人员信息列表查询")
    public PageInfo<Person> list(Integer page, Integer limit, String searchValue) {

        PageInfo<Person> pageInfo = personService.getPersonList(new PageInfo<>(page, limit), searchValue);
        log.info("//查询person列表执行完成");
        return pageInfo;
    }

    @GetMapping("/{loginNo}")
    @BusLog(describe = "人员信息详情查询")
    public Person info(@PathVariable String loginNo, String phoneVal) {
        Person person = personService.get(loginNo);
        log.info("//查询person详情执行完成");
        return person;
    }

    @PutMapping
    @BusLog(describe = "修改人员信息")
    public String edit(@RequestBody Person person) {
        personService.update(person);
        log.info("//查询person详情执行完成");
        return String.valueOf(System.currentTimeMillis());
    }
    @DeleteMapping
    @BusLog(describe = "删除人员信息")
    public String edit(@PathVariable(name = "id") Integer id) {
        personService.delete(id);
        log.info("//查询person详情执行完成");
        return String.valueOf(System.currentTimeMillis());
    }
}
