package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DocenteController;
import controller.AsignaturaController;
import controller.AsignaturaspordocenteController;
import model.Docente;
import model.Asignatura;
import model.Asignaturaspordocente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtf;
	private JComboBox<Docente> jcb;
	private JButton btnFiltrar;
	private JButton btnCargar;
	private JButton btnAniadirTodos;
	private JButton btnAniadir;
	private JButton btnQuitar;
	private JButton btnQuitarTodos;
	private JButton btnGuardar;
	
	private JList jl;
	private JList jl2;
	private DefaultListModel<Asignatura> dlm = new DefaultListModel<Asignatura>();
	private DefaultListModel<Asignatura> dlm2 = new DefaultListModel<Asignatura>();
	private List<Asignatura> l = AsignaturaController.findAll();

	/**
	 * Carga la aplicación
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crea el frame
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Docentes y asignaturas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jtf = new JTextField();
		GridBagConstraints gbc_jtf = new GridBagConstraints();
		gbc_jtf.weightx = 1.0;
		gbc_jtf.insets = new Insets(0, 0, 5, 5);
		gbc_jtf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf.gridx = 0;
		gbc_jtf.gridy = 1;
		contentPane.add(jtf, gbc_jtf);
		jtf.setColumns(10);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDocentes();
			}
		});
		GridBagConstraints gbc_btnFiltrar = new GridBagConstraints();
		gbc_btnFiltrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnFiltrar.gridx = 1;
		gbc_btnFiltrar.gridy = 1;
		contentPane.add(btnFiltrar, gbc_btnFiltrar);
		
		jcb = new JComboBox<Docente>();
		GridBagConstraints gbc_jcb = new GridBagConstraints();
		gbc_jcb.insets = new Insets(0, 0, 5, 5);
		gbc_jcb.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb.gridx = 0;
		gbc_jcb.gridy = 2;
		contentPane.add(jcb, gbc_jcb);
		
		btnCargar = new JButton("Cargar materias");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getAsignaturas();
			}
		});
		GridBagConstraints gbc_btnCargar = new GridBagConstraints();
		gbc_btnCargar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargar.gridx = 1;
		gbc_btnCargar.gridy = 2;
		contentPane.add(btnCargar, gbc_btnCargar);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignaturas no seleccionadas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Asignaturas seleccionadas");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jl = new JList(dlm);
		
		JScrollPane scrollPane = new JScrollPane(jl);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		btnAniadirTodos = new JButton(">>");
		btnAniadirTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirTodos();
			}
		});
		GridBagConstraints gbc_btnAniadirTodos = new GridBagConstraints();
		gbc_btnAniadirTodos.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadirTodos.gridx = 1;
		gbc_btnAniadirTodos.gridy = 1;
		panel.add(btnAniadirTodos, gbc_btnAniadirTodos);
		
		jl2 = new JList(dlm2);
		
		JScrollPane scrollPane_1 = new JScrollPane(jl2);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 4;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		btnAniadir = new JButton(">");
		btnAniadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadir();
			}
		});
		GridBagConstraints gbc_btnAniadir = new GridBagConstraints();
		gbc_btnAniadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAniadir.gridx = 1;
		gbc_btnAniadir.gridy = 2;
		panel.add(btnAniadir, gbc_btnAniadir);
		
		btnQuitar = new JButton("<");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitar();
			}
		});
		btnQuitar.setToolTipText("");
		GridBagConstraints gbc_btnQuitar = new GridBagConstraints();
		gbc_btnQuitar.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitar.gridx = 1;
		gbc_btnQuitar.gridy = 3;
		panel.add(btnQuitar, gbc_btnQuitar);
		
		btnQuitarTodos = new JButton("<<");
		btnQuitarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarTodos();
			}
		});
		GridBagConstraints gbc_btnQuitarTodos = new GridBagConstraints();
		gbc_btnQuitarTodos.insets = new Insets(0, 0, 0, 5);
		gbc_btnQuitarTodos.gridx = 1;
		gbc_btnQuitarTodos.gridy = 4;
		panel.add(btnQuitarTodos, gbc_btnQuitarTodos);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel_1.add(btnGuardar);
	}
	
	/**
	 * Método para obtener los docentes
	 */
	private void getDocentes() {
		jcb.removeAllItems();
		List<Docente> l = DocenteController.findByLikeName(jtf.getText());
		for (Docente o : l) {
			jcb.addItem(o);
		}
	}
	
	/**
	 * Método para obtener las asignaturas
	 * @return 
	 */
	private void getAsignaturas() {
		dlm.removeAllElements();
		dlm2.removeAllElements();
		List<Asignaturaspordocente> apd = AsignaturaspordocenteController.findByIdDocente(((Docente) jcb.getSelectedItem()).getId());
		List<Asignatura> a = AsignaturaController.findAll();
		for (Asignaturaspordocente o : apd) {
			dlm2.addElement(o.getAsignatura());
			for (int i = a.size() - 1; i >= 0; i--) {
				if (a.get(i).getId() == o.getAsignatura().getId()) {
					a.remove(a.get(i));
				}
			}
		}
		dlm.addAll(a);
	}

	/**
	 * Método para añadir los elementos seleccionados
	 */
	private void aniadir() {
		dlm2.addAll(jl.getSelectedValuesList());
		for (int i = jl.getSelectedIndices().length - 1; i >= 0; i--) {
			dlm.removeElementAt(jl.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * Método para añadir todos los elementos
	 */
	private void aniadirTodos() {
		dlm.removeAllElements();
		dlm2.removeAllElements();
		dlm2.addAll(l);
	}
	
	/**
	 * Método para eliminar los elementos seleccionados
	 */
	private void quitar() {
		dlm.addAll(jl2.getSelectedValuesList());
		for (int i = jl2.getSelectedIndices().length - 1; i >= 0; i--) {
			dlm2.removeElementAt(jl2.getSelectedIndices()[i]);
		}
	}
	
	/**
	 * Método para eliminar todos los elementos
	 */
	public void quitarTodos() {
		dlm.removeAllElements();
		dlm2.removeAllElements();
		dlm.addAll(l);
	}
	
	/**
	 * Método para guardar los datos
	 */
	public void guardar() {
		List<Asignaturaspordocente> l = AsignaturaspordocenteController.findByIdDocente(((Docente) jcb.getSelectedItem()).getId());
		for (Asignaturaspordocente o : l) {
			AsignaturaspordocenteController.eliminar(o);
		}
		for (int i = 0; i < dlm2.size(); i++) {
			Asignaturaspordocente o = new Asignaturaspordocente();
			o.setDocente((Docente) jcb.getSelectedItem());
			o.setAsignatura(dlm2.getElementAt(i));
			AsignaturaspordocenteController.insertar(o);
		}
	}

}
