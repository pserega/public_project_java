package by.prigozhiy.spring.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import by.prigozhiy.entity.Person;
import by.prigozhiy.spring.mybatis.mapper.Mapper;

public class Service {

	@Autowired
	private Mapper mapper;

	public List<Person> selectAllPerson() {
		return mapper.selectAllPerson();
	}

	public Person selectPerson(int id) {
		return mapper.selectPerson(id);
	}

	public int insertPerson(Person person) {
		return mapper.insertPerson(person);
	}

	// @Transactional
	public int insertPersonM(Person person) {
		return mapper.insertPersonM(person);
	}
}
