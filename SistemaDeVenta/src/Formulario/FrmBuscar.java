package Formulario;

import java.awt.EventQueue;
import java.sql.SQLException;

//import javassist.expr.Instanceof;



import java.util.function.LongBinaryOperator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JScrollPane;

import Clases.ModeloTabla;
import Clases.ClassRegistrarProducto;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;




public class FrmBuscar extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private ModeloTabla modeloTabla;
	private JInternalFrame ventanaPadre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBuscar frame = new FrmBuscar(new JInternalFrame());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmBuscar(final JInternalFrame jInternalFrame) throws SQLException {
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		setClosable(true);
		this.ventanaPadre = jInternalFrame;
		setTitle("Buscar");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 568, 285);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {// AL MOMENTO DE REALIZAR LA BUSQUEDAD LA CONDICION SE MODIFICA POR LO QUE ESTA EN EL TEXTBOX
					
					String condicion = "1";
					
					if(jInternalFrame instanceof FrmFacturaVenta)
					{
						condicion = "descripcion like '%" + textField.getText() + "%'";
					}
					/*else if(ventanaPadre instanceof FormUsuarios)
					{
						condicion = "nombreUsuario like '%" + textField.getText() + "%'";
					}*/
					
					modeloTabla.establecerCondicion( condicion );
					modeloTabla.realizarBusqueda();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//button.setIcon(new ImageIcon(FormBuscar.class.getResource("/Recursos/search_icon.png")));
		//button.setBounds(416, 11, 59, 51);
		//contentPane.add(button);
				
		try {
			modeloTabla = new ModeloTabla("*", "tblarticulos", "1");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		modeloTabla.realizarBusqueda();
		
		table = new JTable(modeloTabla);
		
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(jInternalFrame instanceof FrmFacturaVenta)
				{
					try{
						long Codigo = Long.parseLong( modeloTabla.getValueAt(table.getSelectedRow(), 0).toString() );
						String Descripcion =  modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
						double precio =  Double.parseDouble(modeloTabla.getValueAt(table.getSelectedRow(), 2).toString());
						
						 ClassRegistrarProducto nuevoProducto = new ClassRegistrarProducto(Codigo,Descripcion, precio);
						((FrmFacturaVenta)jInternalFrame).cargarDatos(nuevoProducto);
					}
					catch (Exception ex){
						ex.printStackTrace();
					}
					
					
				}
				
				/*if(jInternalFrame instanceof FormUsuarios)
				{
					int id = Integer.parseInt( modeloTabla.getValueAt(table.getSelectedRow(), 0).toString() );
					String nombre =  modeloTabla.getValueAt(table.getSelectedRow(), 1).toString();
					String clave =  modeloTabla.getValueAt(table.getSelectedRow(), 2).toString();
					((FormUsuarios)jInternalFrame).cargarDatos(nombre, clave);
				}*/
				dispose();			
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(0, 65, 564, 195);
		contentPane.add(scrollPane);		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 564, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(116, 17, 201, 28);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Descripcion:");
		lblNombre.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNombre.setForeground(new Color(255, 255, 240));
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(6, 24, 107, 21);
		panel.add(lblNombre);
	}

	public ModeloTabla getModeloTabla() {
		return modeloTabla;
	}

	public void setModeloTabla(ModeloTabla modeloTabla) {
		this.modeloTabla = modeloTabla;
	}
}