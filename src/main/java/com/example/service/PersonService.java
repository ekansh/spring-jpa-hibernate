package com.example.service;

import java.util.List;

import com.example.entity.Person;

public interface PersonService {
    void add(Person person);
    List<Person> listPersons();
}
