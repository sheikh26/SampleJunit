package com.Galaxy.junit3.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.Galaxy.dto.AccountDTO;
import com.Galaxy.service.AccountService;

import junit.fparamework.TestCase;

/*
 * 1. Junit 3.0 testcase class must extend org.junit.Testcase
 * 2. Junit 3.0 does not support annotation wereas Junit 4.0 does support annotation 
 * 3. Each method name must start with 'test' suffix
 * 4. setUpBeforeClass() method is called before testcase is started
 * 5. tearDownAfterClass() is called after testcase is finished
 * 6. setUp() method is called before starting each test method
 * 7. tearDown() methods is called after finishing each test method
 * 8. setUpBeforeClass, tearDownAfterClass, setUp, and tearDown methods are optional
 */

public class AccountService3Testcase extends TestCase {
	
	
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Called Before Begning Testcase");
	}

	public static void tearDownAfterClass() throws Exception {
		System.out.println("Called After Ending Testcase");
	}

	public void setUp() throws Exception {
		System.out.println("Called Before starting individual test");
	}

	public void tearDown() throws Exception {
		System.out.println("Called after finishing individual test");
	}
	
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
		
		//Or 
		/*if(dto == null){
			
			fail("Account is NOT added");
		}*/
		
		
	}

	public void testUpdate() {

		AccountDTO dto = new AccountDTO();
		dto.setId(2);
		dto.setNumber("SB123456");
		dto.setName("NCS Pvt Ltd");
		dto.setBalance(50000);
		AccountService.update(dto);
		
		//dto = AccountService.get(1);
		
		//assertEquals("Account Not Updated", "NCS Pvt Ltd".equals(dto.getName()));

		
		//Or 
		/*if(!"NCS Pvt Ltd".equals(dto.getName())){
			fail("Account Not Updated", "NCS Pvt Ltd");
		}*/

		
	}

	public void testDelete() {
		AccountDTO dto = new AccountDTO();
		dto.setId(1);
		AccountService.delete(dto);

		dto = AccountService.get(1);
		// IF DTO is NOT null then record is not deleted and display error message.
		assertNull("Account is NOT deleted", dto);
		
		//Or 
		/*if(dto != null){
			
			fail("Account is NOT deleted");
		}*/
		
		
	}

	public void testGet() {

		AccountDTO dto = AccountService.get(1);

		assertNotNull("Account was not found", dto);
		
	}

}
