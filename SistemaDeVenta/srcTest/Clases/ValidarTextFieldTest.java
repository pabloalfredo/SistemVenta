package Clases;

import static org.junit.Assert.*;

import javax.swing.JTextField;

import org.junit.Test;

public class ValidarTextFieldTest {

	@Test
	public void testvalidarTextField() {
		
		JTextField txt = new JTextField();
		txt.setText("");
		
		assertEquals("El TextField no debe estar en blanco", 1,ValidarTextField.validarTextField("NombreCampo", txt));
	}

}
