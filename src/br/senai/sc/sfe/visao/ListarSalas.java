package br.senai.sc.sfe.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.senai.sc.sfe.controle.SalaControle;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ListarSalas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idSala;
	Sala sala;
	SalaControle salaC;
	private DefaultTableModel tableModel = new DefaultTableModel();
	String idSalaA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarSalas frame = new ListarSalas();
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
	public ListarSalas() {
		salaC = new SalaControle();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 447, 360);
		contentPane.add(scrollPane);

		table = new JTable();
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Localização:");
		tableModel.addColumn("Sala:");
		tableModel.addColumn("Tipo:");
		tableModel.addColumn("Lugares:");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		scrollPane.setViewportView(table);

		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result2 = JOptionPane.showConfirmDialog(null,
						"Deseja selecionar esta sala?");
				if (result2 == JOptionPane.YES_OPTION) {
				int indice = table.getSelectedRow();
				Pessoa pessoa = new Pessoa();
				idSalaA = String.valueOf(tableModel.getValueAt(indice, 0));
				Instancias instancia = new Instancias();
				instancia.getInstanceAgenda().idSala.setText(idSalaA);
				
				dispose();
				}
			}
		});
		table.setModel(tableModel);
		btnSelecionar.setBounds(357, 442, 100, 23);
		contentPane.add(btnSelecionar);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(109, 33, 46, 14);
		contentPane.add(lblCdigo);

		idSala = new JTextField();
		idSala.setBounds(163, 30, 86, 20);
		contentPane.add(idSala);
		idSala.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
				if (idSala.getText() == null
						|| idSala.getText().trim().isEmpty()) {
					listarTodos();
				} else {
					
				}
			}
		});
		btnBuscar.setBounds(260, 29, 91, 23);
		contentPane.add(btnBuscar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\big\\Desktop\\FUNDO.png"));
		label.setBounds(10, -179, 466, 655);
		contentPane.add(label);
	}

	private void listarTodos() {
		List<Sala> salas = new ArrayList<Sala>();
		salas = salaC.listar();
		limpar();
		for (Sala salas2 : salas) {
			tableModel.addRow(new Object[] { salas2.getIdSala(),
					salas2.getLocalizacao(), salas2.getDescricao(),
					salas2.getTipo(), salas2.getQuantidadeLugares() });
		}
	}

	public void limpar() {
		idSala.setText("");
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}

}
