package Clases;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AplicarTemaVentana {
	
	public void temaliquid(){
		try {
			UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel"); //Esto tenemos que cambiarlo por el nombre
                                                                        //de la clase del Look And Feel utilizado
				// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
		
		
	}
	public void temaNibus(){
		try {
      // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel"); //Esto tenemos que cambiarlo por el nombre
                                                                        //de la clase del Look And Feel utilizado
		 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
		
		
	}

}
