package com.subash.api.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class RegisterServiceImplTest {

	@Autowired
	RegisterServiceImpl registerService;
	
//	@Test
//	void testAddRegister() {
//		Register register = new Register(0,"SUBASH","ganapathy56781@gmail.com","12345678@12");
//		assertEquals("AddRegister Success", registerService.addRegister(register));
//	}
	
//	@Test
//	void testAddRegisterFalse() {
//		Register register = null;
//		assertEquals("AddRegister Fail", registerService.addRegister(register));
//	}

	@Test
	void testCheckCredentials() {
		String email = "ssubash56781@gmail.com";
		String password = "123456";
		
		assertTrue(registerService.checkCredentials(email, password));
	}
//	@Test
//	void testCheckCredentialsFalse() {
//		String email = "ga56781@gmail.com";
//		String password = "123456";
//		
//		assertFalse(registerService.checkCredentials(email, password));
//	}

}
