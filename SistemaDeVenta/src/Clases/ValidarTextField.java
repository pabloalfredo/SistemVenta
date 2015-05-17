package Clases;


import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class ValidarTextField {               // SE CREARON DOS FUNCIONES QUE RECIBEN COMO PARAMETRO UN TEXFIELD Y SE HACEN LAS CORRESPONDIENTE VALIDACIONES
	public void AdmitirSoloLetras(final JTextField textfield){
		textfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e){        // valida que solo se pueda introducir letras en el textfield
				int letra =(int) e.getKeyChar();
				if(letra>=48 && letra<=57 || letra>=0 && letra <=31 || letra>=33 && letra <=64 || letra>=91 && letra <=96 || letra>=123 && letra <=129 || letra>=131 && letra <=159 || letra>=166 && letra <=255 ){
					e.consume();
					
				}
			}
		});
	}
	public void AdmitirSoloNumeros(final JTextField textfield){
		textfield.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {       // valida que solo se pueda introducir numeros en el texfield
				int letra =(int) e.getKeyChar();
				if(letra>=0 && letra<=31 || letra>=33 && letra<=47 || letra>=58 && letra<=255 ){
					e.consume();
					
				}
			}
		});
	}
	
// VALIDAR QUE EL TEXFIEL NO ESTE EN BLANCO
public static int validarTextField (String nombreCampo, JTextField txt){
		
		if(txt.getText().trim().length() <=0 )
		{
			txt.setBorder(new MatteBorder(2, 2, 2, 2,  new Color(178, 34, 34)));
			txt.requestFocus();
			return 0;
		}
		else
		{
			txt.setBorder(new MatteBorder(2, 2, 2, 2,  new Color(0, 128, 128)));
			return 1;
		}
	}
}
