package com.example.demo.mapper.extend;

import com.example.demo.mapper.PersonMapper;
import com.example.demo.object.Person;

import java.util.List;

public interface PersonMapperExtend extends PersonMapper {

    List<Person> findAll();

}
