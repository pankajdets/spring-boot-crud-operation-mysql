package com.pankaj.springbootcrudoperation.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.pankaj.springbootcrudoperation.model.Students;

public interface StudentsRepository extends CrudRepository<Students, Integer> {
//CrudRepository is a Spring data interface and to use it we need to create our interface by extending CrudRepository for a specific type.	
/* Below are methods by default methods available in CrudRepository. Spring provides CrudRepository implementation class automatically at runtime.
	 
	<S extends T> S save(S entity);
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
	Optional<T> findById(ID id);
	boolean existsById(ID id);
	Iterable<T> findAll();
	Iterable<T> findAllById(Iterable<ID> ids);
	long count();
	void deleteById(ID id);
	void delete(T entity);
	void deleteAllById(Iterable<? extends ID> ids);
	void deleteAll(Iterable<? extends T> entities);
	void deleteAll();
*/

//Below are Customer Finder Methods/ Drived Query Methods
public List<Students> findByStudentName(String name);
public List<Students> findByNativePlaceAndStudentName(String nativePlace, String name);
// We can create drived query methods as per our need. No need to implement it. spring data jpa will provide implementation at runtime
//To make methods refer documentation https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
public List<Students> findByStudentNameStartingWith(String prefix);
public List<Students> findByStudentNameLike(String likePattern);
public List<Students> findByStudentIdLessThan(int id);
public List<Students> findByStudentIdIn(Collection<Integer> ids);
public List<Students> findByStudentNameOrderByStudentName(String name);


//Lets experiment on Custom Query
//Method1: JPQL: Java Persistance Query Language
//@Query("SELECT s FROM Students s WHERE s.nativePlace=?1")
//public List<Students>  getStudentsByNativePlace(String nativePlace);

/*Another way
@Query("SELECT s FROM Students s WHERE s.nativePlace =:n")
public List<Students>  getStudentsByNativePlace(@Param("n") String nativePlace);
*/
	
//Method2: Native Query(SQL Query)
@Query(value="SELECT * FROM Students WHERE native_place=?1", nativeQuery= true)
public List<Students>  getStudentsByNativePlace(String nativePlace);
}
