package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.control.ControlRegister;

class CheckUsernameAlreadyTakenTest {

	@Test
	public void checkUserAlreadyTaken() {
		
		
		ControlRegister ctrlRegister = new ControlRegister();
		
		String output = ctrlRegister.checkUsernameAlreadyTaken("gino");
		
		assertEquals("trovato", output); //username already taken
		
	}
	
	@Test
	public void checkUserNotTaken() {
		
		ControlRegister ctrlRegister = new ControlRegister();
		
		String output = ctrlRegister.checkUsernameAlreadyTaken("pippo");
		
		assertEquals("non trovato", output); //username free
	}

}
