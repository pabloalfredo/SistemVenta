package Formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JScrollPane;



import Clases.ClassBaseDeDatos;
import Clases.ClassRegistrarProducto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmFacturaVenta extends JInternalFrame {
	private JTextField txtcodigoProducto;
	private JTextField txtSubTotal;
	private JTextField txtDescuento;
	private JTextField txtTotal;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtITBIS;
	private JLabel lblTotalProductos;
	private long ID = 0;
	private ClassRegistrarProducto validarExistencia;
	private JButton btnAgregarProductoenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFacturaVenta frame = new FrmFacturaVenta();
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
	public FrmFacturaVenta() {
		
		setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 128, 128)));
		setClosable(true);
		setForeground(new Color(0, 0, 128));
		setFont(new Font("SansSerif", Font.BOLD, 18));
		setTitle("Nueva Venta");
		setFrameIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/B86765EE0.png")));
		//AplicarTemaVentana aplicar = new AplicarTemaVentana();
		//aplicar.temaNibus();
		getContentPane().setBackground(new Color(135, 206, 235));
		setBounds(100, 100, 862, 617);
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Codigo del Producto");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(4, 316, 201, 34);
		getContentPane().add(label);
		
		txtcodigoProducto = new JTextField();
		txtcodigoProducto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtcodigoProducto.setBackground(new Color(230, 230, 250));
		txtcodigoProducto.setForeground(new Color(0, 0, 102));
		txtcodigoProducto.setFont(new Font("MV Boli", Font.BOLD, 27));
		txtcodigoProducto.setColumns(10);
		txtcodigoProducto.setBounds(222, 310, 306, 42);
		getContentPane().add(txtcodigoProducto);
		
		btnAgregarProductoenter = new JButton("       Agregar Producto [Enter]");
		agregarArticulo(btnAgregarProductoenter);
		btnAgregarProductoenter.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/8EF214180.png")));
		btnAgregarProductoenter.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAgregarProductoenter.setHorizontalAlignment(SwingConstants.LEFT);
		btnAgregarProductoenter.setForeground(new Color(0, 0, 102));
		btnAgregarProductoenter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAgregarProductoenter.setBounds(540, 310, 298, 42);
		getContentPane().add(btnAgregarProductoenter);
		
		JLabel lblSubtotal = new JLabel("SubTotal:");
		lblSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubtotal.setForeground(new Color(0, 0, 128));
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSubtotal.setBounds(23, 432, 88, 40);
		getContentPane().add(lblSubtotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtSubTotal.setText("$0.00");
		txtSubTotal.setForeground(Color.RED);
		txtSubTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(116, 429, 138, 34);
		getContentPane().add(txtSubTotal);
		
		txtDescuento = new JTextField();
		txtDescuento.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtDescuento.setText("$0.00");
		txtDescuento.setForeground(Color.RED);
		txtDescuento.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(116, 470, 138, 34);
		getContentPane().add(txtDescuento);
		
		JLabel lblDescuento = new JLabel("Descuento:");
		lblDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuento.setForeground(new Color(0, 0, 128));
		lblDescuento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescuento.setBounds(4, 479, 107, 40);
		getContentPane().add(lblDescuento);
		
		txtTotal = new JTextField();
		txtTotal.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtTotal.setText("$0.00");
		txtTotal.setForeground(Color.RED);
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtTotal.setColumns(10);
		txtTotal.setBounds(116, 548, 138, 34);
		getContentPane().add(txtTotal);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setForeground(new Color(0, 0, 128));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotal.setBounds(44, 547, 67, 40);
		getContentPane().add(lblTotal);
		
		JLabel lblTipoDeComprobante = new JLabel("Tipo de Comprobante:");
		lblTipoDeComprobante.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipoDeComprobante.setForeground(new Color(0, 0, 128));
		lblTipoDeComprobante.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTipoDeComprobante.setBounds(455, 11, 169, 28);
		getContentPane().add(lblTipoDeComprobante);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(625, 12, 213, 28);
		getContentPane().add(comboBox);
		
		JLabel lblNumeroFactura = new JLabel("Numero Factura:");
		lblNumeroFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroFactura.setForeground(new Color(0, 0, 128));
		lblNumeroFactura.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroFactura.setBounds(455, 41, 169, 28);
		getContentPane().add(lblNumeroFactura);
		
		textField_4 = new JTextField();
		textField_4.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_4.setBackground(new Color(230, 230, 250));
		textField_4.setColumns(10);
		textField_4.setBounds(625, 42, 213, 28);
		getContentPane().add(textField_4);
		
		JLabel lblNfc = new JLabel("NFC:");
		lblNfc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNfc.setForeground(new Color(0, 0, 128));
		lblNfc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNfc.setBounds(564, 71, 60, 28);
		getContentPane().add(lblNfc);
		
		textField_5 = new JTextField();
		textField_5.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_5.setBackground(new Color(230, 230, 250));
		textField_5.setColumns(10);
		textField_5.setBounds(625, 72, 213, 28);
		getContentPane().add(textField_5);
		
		JLabel label_7 = new JLabel("Fecha:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(new Color(0, 0, 128));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(585, 103, 49, 28);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Hora:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(new Color(0, 0, 128));
		label_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_8.setBounds(718, 103, 51, 28);
		getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("05/09/2015");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_9.setBounds(626, 103, 98, 28);
		getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("05:45:23");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(UIManager.getColor("ArrowButton.disabledText"));
		label_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_10.setBounds(762, 103, 76, 28);
		getContentPane().add(label_10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		scrollPane.setBounds(15, 143, 823, 161);
		getContentPane().add(scrollPane);
		String codigo ="<html><h4 font color = blue>Cantidad</h3></html>";
		String descripcion ="<html><h4 font color = blue>Decripcion</h3></html>";
		String cantidad ="<html><h4 font color = blue>Cantidad</h3></html>";
		String precio ="<html><h4 font color = blue>Precio</h3></html>";
		String descuento ="<html><h4 font color = blue>Descuento</h3></html>";
		String total ="<html><h4 font color = blue>Total</h3></html>";
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, new Integer(1), null, null, null},
			},
			new String[] {
				"<html><h4 font color = blue>Codigo</h3></html>", "<html><h4 font color = blue>Descripcion</h3></html>", "<html><h4 font color = blue>Cantidad</h3></html>", "<html><h4 font color = blue>Precio</h3></html>", "<html><h4 font color = blue>Descuento</h3></html>", "<html><h4 font color = blue>Total</h3></html>"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, Integer.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(264);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(61);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		JButton btnCancelesc = new JButton("Cancel [Esc]");
		btnCancelesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelarVenta();
			}
		});
		btnCancelesc.setBorder(null);
		btnCancelesc.setForeground(new Color(0, 0, 128));
		btnCancelesc.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/29C5898C8.png")));
		btnCancelesc.setVerticalTextPosition(SwingConstants.TOP);
		btnCancelesc.setVerifyInputWhenFocusTarget(false);
		btnCancelesc.setIconTextGap(2);
		btnCancelesc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelesc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCancelesc.setBounds(740, 353, 98, 63);
		getContentPane().add(btnCancelesc);
		
		JButton btnCantif = new JButton("Canti [F3]");
		btnCantif.setBorder(null);
		btnCantif.setForeground(new Color(0, 0, 128));
		btnCantif.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/D1F0AC18D.png")));
		btnCantif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cantidadArticulos();
			}
		});
		btnCantif.setVerticalTextPosition(SwingConstants.TOP);
		btnCantif.setVerifyInputWhenFocusTarget(false);
		btnCantif.setIconTextGap(2);
		btnCantif.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCantif.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCantif.setBounds(105, 353, 89, 63);
		getContentPane().add(btnCantif);
		
		JButton btnCobrarf = new JButton("Cobrar [F2]");
		btnCobrarf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				
					cobrar();
			}
		});
		btnCobrarf.setBorder(null);
		btnCobrarf.setForeground(new Color(0, 0, 128));
		btnCobrarf.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/5E1E8BF80.png")));
		btnCobrarf.setVerticalTextPosition(SwingConstants.TOP);
		btnCobrarf.setVerifyInputWhenFocusTarget(false);
		btnCobrarf.setIconTextGap(2);
		btnCobrarf.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCobrarf.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCobrarf.setAlignmentY(1.0f);
		btnCobrarf.setBounds(14, 353, 89, 63);
		getContentPane().add(btnCobrarf);
		
		JButton btnLimpiaresc = new JButton("Limpiar [F11]");
		btnLimpiaresc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				limpiarCampos();
			}
		});
		btnLimpiaresc.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/51BD969F7.png")));
		btnLimpiaresc.setVerticalTextPosition(SwingConstants.TOP);
		btnLimpiaresc.setVerifyInputWhenFocusTarget(false);
		btnLimpiaresc.setIconTextGap(2);
		btnLimpiaresc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLimpiaresc.setForeground(new Color(0, 0, 128));
		btnLimpiaresc.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLimpiaresc.setBorder(null);
		btnLimpiaresc.setBounds(630, 354, 98, 63);
		getContentPane().add(btnLimpiaresc);
		
		JButton btnGlobalf_1 = new JButton("Global [F10]");
		btnGlobalf_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				descuentoGlobal();
			}
		});
		btnGlobalf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/desc.png")));
		btnGlobalf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnGlobalf_1.setVerifyInputWhenFocusTarget(false);
		btnGlobalf_1.setIconTextGap(2);
		btnGlobalf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGlobalf_1.setForeground(new Color(0, 0, 128));
		btnGlobalf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnGlobalf_1.setBorder(null);
		btnGlobalf_1.setBounds(524, 354, 98, 63);
		getContentPane().add(btnGlobalf_1);
		
		JButton btnLineaf_1 = new JButton("Linea [F9]");
		btnLineaf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				descuentoLinea();
			}
		});
		btnLineaf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/desc.png")));
		btnLineaf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnLineaf_1.setVerifyInputWhenFocusTarget(false);
		btnLineaf_1.setIconTextGap(2);
		btnLineaf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLineaf_1.setForeground(new Color(0, 0, 128));
		btnLineaf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLineaf_1.setBorder(null);
		btnLineaf_1.setBounds(414, 354, 98, 63);
		getContentPane().add(btnLineaf_1);
		
		JButton btnQuitarf_1 = new JButton("Remover Fila  [F8]");
		btnQuitarf_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnQuitarf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarArticulosSeleccionados();
			}
		});
		btnQuitarf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/AE9D39F1E.png")));
		btnQuitarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnQuitarf_1.setVerifyInputWhenFocusTarget(false);
		btnQuitarf_1.setIconTextGap(2);
		btnQuitarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuitarf_1.setForeground(new Color(0, 0, 128));
		btnQuitarf_1.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnQuitarf_1.setBorder(null);
		btnQuitarf_1.setBounds(304, 354, 98, 63);
		getContentPane().add(btnQuitarf_1);
		
		JButton btnBuscarf_1 = new JButton("Buscar [F7]");
		btnBuscarf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarArticulos();
			}
		});
		btnBuscarf_1.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/E937E1E0B.png")));
		btnBuscarf_1.setVerticalTextPosition(SwingConstants.TOP);
		btnBuscarf_1.setVerifyInputWhenFocusTarget(false);
		btnBuscarf_1.setIconTextGap(2);
		btnBuscarf_1.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarf_1.setForeground(new Color(0, 0, 128));
		btnBuscarf_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnBuscarf_1.setBorder(null);
		btnBuscarf_1.setBounds(195, 354, 98, 63);
		getContentPane().add(btnBuscarf_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_6.setBackground(new Color(230, 230, 250));
		textField_6.setBounds(128, 97, 298, 34);
		getContentPane().add(textField_6);
		
		JLabel label_1 = new JLabel("Direccion");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 0, 128));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(59, 95, 67, 28);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Nombre");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(0, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(68, 65, 58, 28);
		getContentPane().add(label_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_7.setBackground(new Color(230, 230, 250));
		textField_7.setBounds(128, 67, 298, 28);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setDefaultLocale(null);
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		textField_8.setBackground(new Color(230, 230, 250));
		textField_8.setBounds(127, 33, 98, 31);
		getContentPane().add(textField_8);
		
		JLabel lblCodCliente = new JLabel("Cod Cliente");
		lblCodCliente.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodCliente.setForeground(new Color(0, 0, 128));
		lblCodCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCodCliente.setBounds(6, 35, 120, 28);
		getContentPane().add(lblCodCliente);
		
		JButton button = new JButton("Buscar [F4]");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				busquedaCliente();
			}
		});
		button.setIcon(new ImageIcon(FrmFacturaVenta.class.getResource("/Recursos/E937E1E0B.png")));
		button.setHorizontalTextPosition(SwingConstants.RIGHT);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setForeground(new Color(0, 0, 102));
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(226, 30, 200, 35);
		getContentPane().add(button);
		
		txtITBIS = new JTextField();
		txtITBIS.setText("$0.00");
		txtITBIS.setForeground(Color.RED);
		txtITBIS.setFont(new Font("Tahoma", Font.BOLD, 22));
		txtITBIS.setColumns(10);
		txtITBIS.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 128, 128)));
		txtITBIS.setBounds(116, 510, 138, 34);
		getContentPane().add(txtITBIS);
		
		JLabel lblItbis = new JLabel("ITBIS:");
		lblItbis.setHorizontalAlignment(SwingConstants.RIGHT);
		lblItbis.setForeground(new Color(0, 0, 128));
		lblItbis.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblItbis.setBounds(44, 509, 67, 40);
		getContentPane().add(lblItbis);
		
		JLabel lblTotalDeProductos = new JLabel("Total de Productos:");
		lblTotalDeProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalDeProductos.setForeground(new Color(0, 0, 128));
		lblTotalDeProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalDeProductos.setBounds(540, 432, 188, 40);
		getContentPane().add(lblTotalDeProductos);
		
		lblTotalProductos = new JLabel("0");
		lblTotalProductos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalProductos.setForeground(Color.RED);
		lblTotalProductos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalProductos.setBounds(740, 432, 35, 40);
		getContentPane().add(lblTotalProductos);
		
		 Dimension tamFrame=this.getSize();//para obtener las dimensiones del frame
	     Dimension tamPantalla=Toolkit.getDefaultToolkit().getScreenSize();      //para obtener el tamanio de la pantalla
	     setLocation((tamPantalla.width-tamFrame.width)/2, (tamPantalla.height-tamFrame.height)/2);  //para posicionar
	        
        suscribirComponetesAlManejoDeTeclas();
    	table.changeSelection(0, 0, false, false);
	}

	/**
	 * @param btnAgregarProductoenter
	 */
	private void agregarArticulo(JButton btnAgregarProductoenter) {
		btnAgregarProductoenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				    DefaultTableModel tabla = (DefaultTableModel) table.getModel();
			    	String Descripcion = null;
					double precio = 0;
					int cantidadTabla=0;
				// CUANDO SE PRESIONE TAB SE IMPLEMENTARA ESTA CONDICION.
		    	/////////////////////////////////////////////////////////////////BUSQUEDA BASE DE DATOS
				//////////////// ESTO IRA EN LA CLASE FACTURA
				
				//table.editCellAt(table.getSelectedRow(), 0);//LE INDICA A LA TABLA QUE LA CELDA A SIDO EDITADA.
			//	Object valor=table.getValueAt(table.getSelectedRow(), 0);
				 // ID= (valor==null)?0:Integer.parseInt(valor.toString());//OPERADOR TERNARIO 
				ID = Long.parseLong(txtcodigoProducto.getText().trim());
				  
				if (ID >0){
				    	
						ResultSet rs;
						try {
							rs = (ResultSet) ClassBaseDeDatos.getConnection().createStatement().executeQuery("select nombreArticulo, efectivo from tblarticulos where codigoProducto = '"+ID +"'");
								while (rs.next()){
								Descripcion=rs.getString(1);
								precio=rs.getDouble(2);
								
								}
						} catch (ClassNotFoundException e) {
							JOptionPane.showMessageDialog(null, "El Codigo no existe en el registro");
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
		    	
		    	////////////////////////////////////////////////////////////////////////////////////////////////////
					
			       
			        
			         cantidadTabla = Integer.parseInt(tabla.getValueAt(table.getSelectedRow(), 2).toString());
			         validarExistencia = new ClassRegistrarProducto(ID, cantidadTabla);
			        try {
						if (validarExistencia.validarExistenciaInventario() == true){
							 tabla.setValueAt(Descripcion, table.getSelectedRow(), 1);
						     tabla.setValueAt(precio, table.getSelectedRow(), 3);
							
							ActualizarTabla();
						      ActualizarTotal();
						      sumarFilas();
					          agregarFila();
					          txtcodigoProducto.setText("");
							
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			      
			         // ValidarSiCodigoExiste();
				      
		
				
				
			}
		});
	}


	//SUSCRIBIR COMPONENTES AL MANEJO DE EVENTOS, ESTE METOD CAPTURA LOS EVENTOS DEL FORMULARIO
///////////////////////////////////////////////////////////////////
	public void suscribirComponetesAlManejoDeTeclas(){              /// metodo para suscribir componentes al manejo de teclas 
		Component [] componentes = getContentPane().getComponents();   // creacion de arreglo de componentes
		for (Component componente: componentes) {
			
			componente.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					
					
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					
					
				}
				
				@Override                                      /// teclas de acceso rapido formularios de venta
				public void keyPressed(KeyEvent evento) {
					
					
					if(evento.getKeyCode() == KeyEvent.VK_F2){   // capturando la tecla precionada 
						cobrar();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F3){
						cantidadArticulos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F4){
						busquedaCliente();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F7){
						buscarArticulos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F8){
						eliminarArticulosSeleccionados();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F9){
						descuentoLinea();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F10){
						descuentoGlobal();
					}
					if(evento.getKeyCode() == KeyEvent.VK_F11){
						limpiarCampos();
					}
					if(evento.getKeyCode() == KeyEvent.VK_ESCAPE){
						cancelarVenta();
					}
					if(evento.getKeyCode() == KeyEvent.VK_ENTER){
						agregarArticulo(btnAgregarProductoenter);
					}
				}
			});
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// METODOS PARA LAS ACCCIONES DE LOS BOTONES DEL FORMULARIO DE VENTA DE ARTICULOS
	private void cobrar() {
		FrmCobroFactura frm = new FrmCobroFactura();
		getDesktopPane().add(frm);
		frm.setVisible(true);
	}
	private void cantidadArticulos() {
			FrmCantida frm = new FrmCantida();
			getDesktopPane().add(frm);
			frm.setVisible(true);
		}
	public void buscarArticulos(){
		try {
			FrmBuscar busqueda = new FrmBuscar(FrmFacturaVenta.this);
			busqueda.getModeloTabla().establecerAtributos("codigoProducto, nombreArticulo, efectivo, Existencia");
			busqueda.getModeloTabla().establecerTabla("tblarticulos");
			busqueda.getModeloTabla().establecerCondicion("1");
			
			busqueda.getModeloTabla().realizarBusqueda();
			busqueda.getModeloTabla().fireTableStructureChanged();
			getDesktopPane().add(busqueda);
			busqueda.setVisible(true);
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1);
		}
		
		
		
		/*FrmBuscarProducto frm = new FrmBuscarProducto();
		getDesktopPane().add(frm);
		frm.setVisible(true); */
	}
	private void busquedaCliente() {                                                          // llamada a los distintos fomrularios y acciones del formualrio venta
		/*FrmBuscarCliente frm = new FrmBuscarCliente();
		getDesktopPane().add(frm);
		frm.setVisible(true);*/
	}
	private void eliminarArticulosSeleccionados(){

		DefaultTableModel model = (DefaultTableModel) table.getModel(); 
			//METODO PARA ELIMINAR LA FILA
		int a = table.getSelectedRow(); 

		if (a<0){

		        JOptionPane.showMessageDialog(null,
		        "Debe seleccionar una fila de la tabla" );  

		}else {
		     int confirmar=JOptionPane.showConfirmDialog(null,  
		     "Esta seguro que desea Eliminar el registro? ");


		            if(JOptionPane.OK_OPTION==confirmar) {
		                     
		                    model.removeRow(a);
		                    ActualizarTotal();	
		                    sumarFilas();
		             }
		}
			JOptionPane.showMessageDialog(null, "El articulo a sido eliminado");
		}
	
	//===============================================================================================
	
	
	
	public void ActualizarTabla(){
		//ESTE METODO SE UTILIZA PARA REALIZAR EL CALCULO DE LAS CANTIDADES Y EL PRECIO Y OBTENER EL SUBTOTAL EN UNA FILA.
		DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		
		String validarCodigoExistente = null;
		validarCodigoExistente = (String) tabla.getValueAt(table.getSelectedRow(), 1);
		
			Object cantidadObject=tabla.getValueAt(table.getSelectedRow(), 2);
			Object precioObject=tabla.getValueAt(table.getSelectedRow(), 3);
			
        	float cantidad= (cantidadObject==null)?0:Float.parseFloat(cantidadObject.toString());
        	float precio= (precioObject==null)?0:Float.parseFloat(precioObject.toString());	
		
		float total = cantidad * precio;
		
		tabla.setValueAt(total, table.getSelectedRow(), 5);		
	}
	
	private void ActualizarTotal()
    {//	METODO PARA ACTUALIZAR LA SUMA DE LOS SUBTOTALES, ESTE METODO RECORRE LA TABLA Y ASIGNA AL TXTTOTAL, SE ASIGNARA DONDE QUIERA QUE SE HAGAN CAMBIOS A LA TABLA.
		//DefaultTableModel tabla = (DefaultTableModel) table.getModel();
        double total = 0;
        double numero =0;
       double ITBIS = 0;
        double totalFactura = 0;
        //recorrer todas las filas de la segunda columna y va sumando las cantidades
   
	        for( int i=0 ; i<table.getRowCount(); i++)
	        {
	            
	                //capturamos valor de celda
	             try {
	            	
	            	Object numeroObject=table.getValueAt(i, 5);
	            	numero= (numeroObject==null)?0:Double.parseDouble(numeroObject.toString());
	            	 
	            	
					total += numero;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	   
		}
	        ITBIS = total * 0.18;
		    totalFactura = total + ITBIS;
        //muestra en el componente
		    String subtotalConFormato = String.format(Locale.US, "%.2f", total);//LE DA FORMATO PARA QUE EN EL TEXTBOX APARENZCAN CON LOS DOS DIGITOS.
		    String ITBISConFormato = String.format(Locale.US, "%.2f", ITBIS);
		    String totalFacturaConFormato = String.format(Locale.US, "%.2f", totalFactura);
        this.txtSubTotal.setText( String.valueOf(subtotalConFormato) );
        this.txtITBIS.setText( String.valueOf(ITBISConFormato) );
        this.txtTotal.setText( String.valueOf(totalFacturaConFormato) );
    }
	
	private void sumarFilas(){//		METODO PARA SUMAR TODOS LOS PRODUCTOS.
		

		//DefaultTableModel tabla = (DefaultTableModel) table.getModel();
        int total = 0;
        
        //recorrer todas las filas de la segunda columna y va sumando las cantidades
   
	        for( int i=0 ; i<table.getRowCount(); i++)
	        {
	            
	           total++;  
	   
		}
	    if (total == 0)
	    {
	    	DefaultTableModel tabla = (DefaultTableModel) table.getModel();
			tabla.addRow(new Object[]{null, null, null, 1, null});
	    }
     
        //muestra en el componente
        this.lblTotalProductos.setText( String.valueOf(total) );
}

	//==============================================================================
	private void descuentoGlobal() {
		FrmDescuentoGlobal frm = new FrmDescuentoGlobal();
		getDesktopPane().add(frm);
		frm.setVisible(true);
	}

	private void descuentoLinea() {
		FrmDescuentoLinea frm = new FrmDescuentoLinea();
	    getDesktopPane().add(frm);
		frm.setVisible(true);
	}
	private void limpiarCampos(){
			JOptionPane.showMessageDialog(null, "Campos Limpiados Correctamente");
		}
	private void cancelarVenta() {
		dispose();
	}
	public void cargarDatos(ClassRegistrarProducto NuevaFila) 
	{	DefaultTableModel tabla = (DefaultTableModel) table.getModel();
		long codigoRecibido = NuevaFila.getCodigoProducto();
		String descripcionRecibida = NuevaFila.getDescripcion();
		double precioRecibido = NuevaFila.getEfectivo();
		
		
		tabla.setValueAt(codigoRecibido, table.getSelectedRow(), 0);
        tabla.setValueAt(descripcionRecibida, table.getSelectedRow(), 1);
        tabla.setValueAt(precioRecibido, table.getSelectedRow(), 2);
		
		table.changeSelection(table.getSelectedRow(), 3, false, false);
		table.requestFocus();
		
	}
	private void agregarFila(){//METODO PARA AGREGAR UNA NUEVA FILA A LA TABLA
			//if (validarFilaBlanco!=null){
		//if (noPermitirAgregarMasFilasEnBlanco()==true){
			DefaultTableModel tabla= (DefaultTableModel) table.getModel();
			tabla.addRow(new Object[]{null, null, null, 1, null});
			int ultimaFila = tabla.getRowCount();
			table.changeSelection(ultimaFila + 1, 0, false, false);
			table.requestFocus();
		//}
	}
}