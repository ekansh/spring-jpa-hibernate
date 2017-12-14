package com.example.dao;

import java.util.List;

import com.example.entity.Person;

public interface PersonDao {
   void add(Person person);
   List<Person> listPersons();
}
