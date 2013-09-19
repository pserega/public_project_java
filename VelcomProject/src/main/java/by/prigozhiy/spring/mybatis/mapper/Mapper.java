package by.prigozhiy.spring.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import by.prigozhiy.entity.Person;

/*
 * http://blog.mybatis.org/p/products.html
 */
public interface Mapper {

	/******************************************
	 * Retrieves the List of person
	 * 
	 * @return person list
	 */
	// SQL query in xml "Mapper.xml"
	public List<Person> selectAllPerson();

	/******************************************
	 * Retrieves a person
	 * 
	 * @param person
	 *            id
	 * @return person
	 */
	// SQL query using annotation
	@Select("SELECT * FROM person")
	public List<Person> selectAllPerson2();

	/******************************************
	 * Retrieves a person
	 * 
	 * @param person
	 *            id
	 * @return person
	 */
	// SQL query using annotation
	@Select("SELECT * FROM person WHERE id = #{id}")
	public Person selectPerson(int id);

	/******************************************
	 * Insert a person
	 * 
	 * @param person
	 * @return int
	 */
	// @Insert("INSERT INTO person (name) VALUES (#{name})")
	public int insertPerson(Person person);
}
