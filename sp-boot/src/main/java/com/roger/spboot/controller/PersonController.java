package com.roger.spboot.controller;

import com.roger.spboot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 访问Person对象，测试yaml语法
 */
@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping("person")
    public Person getPerson() {
        return person;
    }
}
