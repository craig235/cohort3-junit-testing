package com.qa.junit.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

import com.qa.junit.exception.EmployeeNotFoundException;
import com.qa.junit.exception.InvalidInputException;
import com.qa.junit.model.Employee;

import java.util.List;

public class RepositoryTest {
	
	/*
	 * To test Repository class
	 */
	
	Repository repository;
	
	@BeforeEach
	public void setUp() {
		this.repository = new Repository();
	}
	
	@AfterEach
	public void cleanUp() {
		this.repository = null;
	}
	
	@Test
	@DisplayName("getEmpById(id) -> Return Employee")
	public void givenExistingId_whenGetEmployeeById_thenReturnEmployee() throws EmployeeNotFoundException, InvalidInputException {
		//testing the code
		//expected vs actual
		Employee employee = this.repository.getEmployeeById(111);
		assertNotNull(employee);
		assertEquals("emp1", employee.getName());
		assertEquals(32423.23,employee.getSalary());
		
	}
	
	@Test
	@DisplayName("getEmployeeById(id) -> Throws EmployeeNotFoundException")
	public void givenNonExistingId_whenGetEmployeeById_thenThrowEmployeeNotFoundException() {
		
		assertThrows(EmployeeNotFoundException.class, () -> this.repository.getEmployeeById(888) );
	}
	
	@Test
	@DisplayName("getEmployeeById(invalid) -> Throws InvalidInputException")
	public void givenInvalidInputAsId_whenGetEmpoyeeById_thenThrowInvalidInputException() {
		assertThrows(InvalidInputException.class, () -> this.repository.getEmployeeById(-100) );
	}
	
	/*
	 * Write the test cases for getAllEmployees
	 */
	@Test
	@DisplayName("getAllEmployee")
	public void givenNoInput_whenGetAllEmpoyee() {
		List<Employee> list = this.repository.getAllEmployee();
		assertNotNull(list);
		Assertions.assertNotEquals(0,list.size());
	}

	/*
	 * Write the test cases for addEmployee(employee)
	 */
	@Test
	@DisplayName("addEmployee")
	public void givenEmployee_addEmployeeToRepository_thenEmployeeNotFoundException () throws EmployeeNotFoundException, InvalidInputException {

		// add
		Employee employee = new Employee(444, "emp4", 62423.23);
		boolean result = this.repository.addEmployee(employee);
		assert(result);

		// retrieve and check
		employee = this.repository.getEmployeeById(444);
		assertNotNull(employee);
		assertEquals("emp4", employee.getName());
		assertEquals(62423.23,employee.getSalary());
	}
}
