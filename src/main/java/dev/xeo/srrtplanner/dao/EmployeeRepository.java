package dev.xeo.srrtplanner.dao;

import dev.xeo.srrtplanner.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


	// add a method to sort by last name
    List<Employee> findAllByOrderByLastNameAsc();

	// search by name
    List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
