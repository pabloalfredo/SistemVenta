package Clases;

import static org.junit.Assert.*;

import javax.swing.JComboBox;

import org.junit.Test;

public class CargarComboBoxTest {

	// PROBANDO QUE UN COMBOBOX SE LLENA CORRECTAMENTE
	@Test
	public void testCargarComboBoxTipoUsuario() {
		
		JComboBox<Object> ComboBox = new JComboBox<Object>();
		
		CargarComboBox CB = new CargarComboBox();
		assertTrue("El ComboBox debe estar lleno correctamente", CB.cargarComboBoxTipoUsuario(ComboBox));
	
	}

}
