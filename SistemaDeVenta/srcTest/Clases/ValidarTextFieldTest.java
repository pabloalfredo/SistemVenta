package Clases;

import static org.junit.Assert.*;

import java.awt.Container;
import java.sql.SQLException;

import javax.swing.JTextField;

import org.junit.Test;

import Formulario.FrmMarcaProducto;

public class ValidarTextFieldTest {

// PROBANDO QUE LOS TEXFIELD NO SE DEJEN EN BLANCO
	@Test
	public void testvalidarTextField() {
		
		JTextField txt = new JTextField();
		txt.setText("Grensoftf");
		
		assertEquals("El TextField no debe estar en blanco", 1,ValidarTextField.validarTextField("NombreCampo", txt));
		
	}
	
// PROBANDO QUE LOS CAMPOS SE LIMPIAN CORRECTAMENTE
	@Test
	public void testLimpiarCampos(){
		Container contenedor = new Container();
		JTextField txt = new JTextField();
		txt.setText("texto en el campo");
		contenedor.add(txt);
		ValidarTextField.limpiarCamposTextField(contenedor);
		
		assertEquals("Los JTextField estan en blanco", "", txt.getText());

	}
	

}
