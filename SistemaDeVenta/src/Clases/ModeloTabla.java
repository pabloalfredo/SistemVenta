package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conexion;
	private Statement instruccion;
	private ResultSet conjuntoResultados;
	private ResultSetMetaData metadatos;
	private int cantidadDeFilas;
	private int cantidadDeColumnas;
	private String tabla;
	private String atributos; 
	private String condicion;

	public ModeloTabla(String atributos, String tabla, String condicion) throws SQLException, ClassNotFoundException {
		
		this.establecerAtributos(atributos);
		this.establecerTabla(tabla);
		this.establecerCondicion(condicion);
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection( "jdbc:mysql://localhost/dbproyecto", "root", "alfredo1234" );
	}
	
	public void realizarBusqueda() throws SQLException
	{
		String sql = String.format("SELECT %s FROM %s WHERE %s", obtenerAtributos(), obtenerTabla(), obtenerCondicion()); 
		
		//System.out.println(sql);
		instruccion = conexion.createStatement();
		conjuntoResultados = instruccion.executeQuery(sql);
		metadatos = conjuntoResultados.getMetaData();
		
		conjuntoResultados.last();
		cantidadDeFilas = conjuntoResultados.getRow();
		cantidadDeColumnas = metadatos.getColumnCount();
		fireTableStructureChanged();
	}
	
	public String getColumnName( int columna ) throws IllegalStateException
	{
		try {
			
			String nombre = metadatos.getColumnName(columna + 1);
			if(nombre.equalsIgnoreCase("id")) nombre = "Codigo";
			
			return ponerEnNegritas(nombre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	private String ponerEnNegritas(String texto)
	{
		return "<html><b><font color = Navy>" + texto + "</font> </b></html>";
	}
	
	public Class<?> getColumnClass(int columna) throws IllegalStateException
	{
		// determina la clase de Java de la columna
		try {
			String nombreClase = metadatos.getColumnClassName(columna + 1);

			// devuelve objeto Class que representa a nombreClase
			return Class.forName(nombreClase);
		}// fin de try
		catch (Exception excepcion) {
			excepcion.printStackTrace();
		}// fin de catch

		return Object.class;// si ocurren problemas en el c�digo anterior, asume
							// el tipo Object
	}// fin del m�todo getColumnClass

	@Override
	public Object getValueAt(int fila, int columna) {

		try {
			conjuntoResultados.absolute(fila + 1);
			return conjuntoResultados.getObject(columna + 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
		
	}

	@Override
	public int getRowCount()
	{
		return cantidadDeFilas;
	}

	@Override
	public int getColumnCount()
	{
		return cantidadDeColumnas;
	}

	public String obtenerAtributos() {
		return atributos;
	}

	public void establecerAtributos(String atributos) {
		this.atributos = atributos;
	}

	public String obtenerTabla() {
		return tabla;
	}

	public void establecerTabla(String tabla) {
		this.tabla = tabla;
	}

	public String obtenerCondicion() {
		return condicion;
	}

	public void establecerCondicion(String condicion) {
		this.condicion = condicion;
	}

}
