package dev.xeo.srrtplanner.employeepackage;


import dev.xeo.srrtplanner.entity.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int theId);

	void save(Employee theEmployee);

	void deleteById(int theId);

	List<Employee> searchBy(String theName);

}
