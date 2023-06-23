package com.Galaxy.junit4.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.Galaxy.dto.AccountDTO;
import com.Galaxy.service.AccountService;

public class AccountService4Testcase {

	/*
	 * 1. Junit 4.0 testcase class does not extend any class 
	 * 2. Junit 4.0 supports annotation. All lifecycle methods are denoted by annotation 
	 * 3. Method denoted by @BeforeClass annotation is called before testcase is started 
	 * 5. Method denoted by @AfterClass annotation is called after testcase is finished 
	 * 6. Method denoted by @Before annotation is called before starting each test method 
	 * 7. Method denoted by @After annotation is called after finishing each test method 
	 * 8. Test methods are denoted by  @Test annotation
	 * 9. setUpBeforeClass, tearDownAfterClass, setUp, and tearDown methods are optional
	 */

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Occupy resources like JDBC connection, JNDI connection, File connection etc. required to execute testcase
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//Release resources like JDBC connection, JNDI connection, File connection etc. required to execute testcase
	}

	@Before
	public void setUp() throws Exception {
		//Initialize common objects required to execute test methods  
	}

	@After
	public void tearDown() throws Exception {
		//Release common objects required to execute test methods  
	}

	@Test
	public void testAdd() {
		AccountDTO dto = new AccountDTO();
		dto.setId(1);
		dto.setNumber("SB123456");
		dto.setName("Galaxy Technologies");
		dto.setBalance(10000);
		AccountService.add(dto);

		dto = AccountService.get(1);

		// IF DTO is null then record is not inserted and display error message.

		assertNotNull("Account is NOT added", dto);

		// Or
		/*
		 * if(dto == null){
		 * 
		 * fail("Account is NOT added"); }
		 */

	}

	@Test
	public void testUpdate() {

		AccountDTO dto = new AccountDTO();
		dto.setId(1);
		dto.setNumber("SB123456");
		dto.setName("NCS Pvt Ltd");
		dto.setBalance(50000);
		AccountService.update(dto);

		dto = AccountService.get(1);

		assertEquals("Account Not Updated", "NCS Pvt Ltd".equals(dto.getName()));

		// Or
		/*
		 * if(!"NCS Pvt Ltd".equals(dto.getName())){ fail("Account Not Updated",
		 * "NCS Pvt Ltd"); }
		 */

	}

	@Test
	public void testDelete() {
		AccountDTO dto = new AccountDTO();
		dto.setId(1);
		AccountService.delete(dto);

		dto = AccountService.get(1);
		// IF DTO is NOT null then record is not deleted and display error
		// message.
		assertNull("Account is NOT deleted", dto);

		// Or
		/*
		 * if(dto != null){
		 * 
		 * fail("Account is NOT deleted"); }
		 */

	}

	@Test
	public void testGet() {

		AccountDTO dto = AccountService.get(1);

		assertNotNull("Account was not found", dto);

	}

}
