package com.qa.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {
	
	//Write test cases
	
	//@BeforeAll -> static method
	//@AfterAll -> static method
	//@BeforeEach
	//@AfterEach
	//@Test
	
	@BeforeAll
	public static void setUp() {
		//database connection
		//configuration
		//initialization of data
		//Executed only once before all the test cases
		System.out.println("@BeforeAll -> setUp ");
	}
	
	@AfterAll
	public static void cleanUp() {
		//making the resources null
		//Executed only once after all the test cases
		System.out.println("@AfterAll --> cleanUp");
	}
	
	/*
	 * Executed before each test case
	 */
	@BeforeEach
	public void init() {
		
		System.out.println("@BeforeEach -> init");
	}

	/*
	 * Executed after each test case
	 */
	@AfterEach
	public void tearDown() {
		System.out.println("@AfterEach -> tearDown");
	}
	
	@Test
	@DisplayName("Test Scenario - 1")
	public void testMethod1() {
		System.out.println("Test Scenario 1");
	}
	@Test
	@DisplayName("Test Scenario - 2")
	public void testMethod2() {
		System.out.println("Test Scenario 2");
	}
}
