package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;


import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;

import Clases.ClassCategoriaProducto;
import Clases.ModeloTabla;
import Clases.ValidarTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class FrmCategoriaProducto extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCategoriaProducto;
	private JTable table;
	private JTextField txtBuscarCategoriaProducto;
	private String categoriaProducto;
	private ModeloTabla modeloTabla;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCategoriaProducto frame = new FrmCategoriaProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCategoriaProducto() {
		
		setForeground(new Color(0, 0, 128));
		setFrameIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/com/birosoft/liquid/icons/computericon.png")));
		setTitle("Categoria de Productos");
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 425, 400);
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setBounds(239, 332, 64, 32);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmCategoriaProducto frm = new FrmCategoriaProducto();
				frm.isClosed();
			}
		});
		getContentPane().setLayout(null);
		btnEliminar.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/eliminar.png")));
		btnEliminar.setForeground(new Color(0, 0, 128));
		btnEliminar.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(btnEliminar);
		
		JButton btnAgregarCategoriaProducto = new JButton(""); // boton agregar una Nueva Categoria de producto
		agregarCategoriaProducto(btnAgregarCategoriaProducto); // llamada a la funion
		btnAgregarCategoriaProducto.setBounds(6, 332, 64, 32);
		btnAgregarCategoriaProducto.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/B61A1E0B3.png")));
		btnAgregarCategoriaProducto.setForeground(new Color(0, 0, 128));
		btnAgregarCategoriaProducto.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(btnAgregarCategoriaProducto);
		
		JButton btnEditar = new JButton("");
		btnEditar.setBounds(158, 332, 64, 32);
		btnEditar.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/902BCB3FC.png")));
		btnEditar.setForeground(new Color(0, 0, 128));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(btnEditar);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setBounds(82, 332, 64, 32);
		btnImprimir.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/impfv.png")));
		btnImprimir.setForeground(new Color(0, 0, 128));
		btnImprimir.setFont(new Font("SansSerif", Font.BOLD, 18));
		getContentPane().add(btnImprimir);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 101, 419, 219);
		tabbedPane.setBackground(new Color(0, 139, 139));
		getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Nueva Categoria", new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/B7D02FDEF.png")), panel_1, null);
		panel_1.setLayout(null);
		
		txtCategoriaProducto = new JTextField();
		txtCategoriaProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // PERMITE QUE SOLO SE INGRESEN LETRAS EN EL TEXTFIELD
				validar.AdmitirSoloLetras(txtCategoriaProducto);						// SE LE PASA POR PARAMETRO UN TEXTFIELD
			}
		});
		txtCategoriaProducto.setBounds(165, 20, 248, 28);
		panel_1.add(txtCategoriaProducto);
		txtCategoriaProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtCategoriaProducto.setForeground(new Color(0, 0, 128));
		txtCategoriaProducto.setBackground(new Color(230, 230, 250));
		txtCategoriaProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtCategoriaProducto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre de la Categoria");
		lblNewLabel.setBounds(6, 26, 167, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Busqueda de Categoria", new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/6B6F6D5EB.png")), panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 37, 407, 142);
		panel.add(scrollPane_1);
		
		try {
			modeloTabla = new ModeloTabla("idCategoriaProducto as Id, Descripcion as 'Nombre de la Categoria'", "tblCategoriaProducto", "1");
			modeloTabla.realizarBusqueda();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		
		table = new JTable(modeloTabla);
		
		scrollPane_1.setColumnHeaderView(table);
		scrollPane_1.setViewportView(table);

		txtBuscarCategoriaProducto = new JTextField();
		txtBuscarCategoriaProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				ValidarTextField validar = new ValidarTextField();           // PERMITE QUE SOLO SE INGRESEN LETRAS EN EL TEXTFIELD
				validar.AdmitirSoloLetras(txtBuscarCategoriaProducto);						// SE LE PASA POR PARAMETRO UN TEXTFIELD
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
				busquedaPorCategoria();
			}
		});
		txtBuscarCategoriaProducto.setBounds(78, 7, 150, 28);
		panel.add(txtBuscarCategoriaProducto);
		txtBuscarCategoriaProducto.setForeground(new Color(0, 0, 128));
		txtBuscarCategoriaProducto.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtBuscarCategoriaProducto.setColumns(10);
		txtBuscarCategoriaProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtBuscarCategoriaProducto.setBackground(new Color(230, 230, 250));
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setBounds(22, 15, 55, 16);
		panel.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBuscar.setForeground(new Color(0, 0, 128));
		lblBuscar.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busquedaPorCategoria();
			}
		});
		button_4.setBounds(232, 2, 64, 37);
		panel.add(button_4);
		button_4.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/E937E1E0B.png")));
		button_4.setForeground(new Color(0, 0, 128));
		button_4.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 419, 92);
		panel_2.setBackground(new Color(0, 128, 128));
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCategoriasProductos = new JLabel("Categorias Productos");
		lblCategoriasProductos.setBounds(97, 6, 316, 40);
		lblCategoriasProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoriasProductos.setForeground(new Color(248, 248, 255));
		lblCategoriasProductos.setFont(new Font("SansSerif", Font.BOLD, 31));
		panel_2.add(lblCategoriasProductos);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/menuart.png")));
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("SansSerif", Font.BOLD, 13));
		label.setBounds(6, 6, 79, 80);
		panel_2.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBounds(0, 326, 419, 44);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSalir = new JButton("");
		btnSalir.setBounds(349, 6, 64, 32);
		panel_3.add(btnSalir);
		salirInternalFrame(btnSalir);
		btnSalir.setIcon(new ImageIcon(FrmCategoriaProducto.class.getResource("/Recursos/salir.png")));
		btnSalir.setForeground(new Color(0, 0, 128));
		btnSalir.setFont(new Font("SansSerif", Font.BOLD, 18));
		
		Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
        setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
        
		

	}

	private void salirInternalFrame(JButton btnSalir) {
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
	}

	private void agregarCategoriaProducto(JButton btnAgregarCategoriaProducto) {
		btnAgregarCategoriaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				categoriaProducto = txtCategoriaProducto.getText();
				ClassCategoriaProducto objetoCategoriaProducto = new ClassCategoriaProducto(categoriaProducto);
				try{
					objetoCategoriaProducto.insertarCategoriaProducto();
				}
				catch(ClassNotFoundException e){
					e.printStackTrace();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	private void busquedaPorCategoria() {
		try{
			String condicion = "1";
			condicion = "Descripcion like '%" + txtBuscarCategoriaProducto.getText() + "%'";
			modeloTabla.establecerCondicion( condicion );
			modeloTabla.realizarBusqueda();
		}
		catch(SQLException e1){
			e1.printStackTrace();
		}
	}
}
