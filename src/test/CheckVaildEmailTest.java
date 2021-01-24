package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.control.ControlRegister;

class CheckVaildEmailTest {

	@Test
	public void validEmailTest() {
		
		ControlRegister ctrlRegister = new ControlRegister();
		
		boolean output = ctrlRegister.checkIfEmailIsValid("gino@gino.gino");
		
		assertEquals(true,output);
	}
	
	@Test
	public void notValidEmailTest() {
		
		ControlRegister ctrlRegister = new ControlRegister();
		
		boolean output = ctrlRegister.checkIfEmailIsValid("prova.prova.prova");
		
		assertEquals(false,output);
	}

}
