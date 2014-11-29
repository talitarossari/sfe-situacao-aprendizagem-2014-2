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
import javax.swing.JTextField;

import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.entity.Pessoa;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarColaboradores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField codigoP;
	public static PessoaControle pessoaC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarColaboradores frame = new ListarColaboradores();
					frame.listarTodos();
					pessoaC = new PessoaControle();
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
	public ListarColaboradores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 447, 330);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, },
				new String[] { "C\u00F3digo", "Nome" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(53);
		scrollPane.setViewportView(table);

		JButton btnSeleciona = new JButton("Selecionar");
		btnSeleciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgendamentoDeSala agenda = new AgendamentoDeSala();
				agenda.carregarColaborador(table.getSelectedRow());
				dispose();
			}
		});
		btnSeleciona.setBounds(357, 442, 100, 23);
		contentPane.add(btnSeleciona);

		JLabel label = new JLabel("C\u00F3digo:");
		label.setBounds(111, 25, 46, 14);
		contentPane.add(label);

		codigoP = new JTextField();
		codigoP.setColumns(10);
		codigoP.setBounds(165, 22, 86, 20);
		contentPane.add(codigoP);

		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaC.buscarPorId(Integer.valueOf(codigoP.getText()));
				limpar();
			}
		});
		button.setBounds(262, 21, 91, 23);
		contentPane.add(button);

	}

	private void listarTodos() {
		List<Pessoa> colaboradores = new ArrayList<Pessoa>();
		colaboradores = pessoaC.listar();

		for (Pessoa colaboradores2 : colaboradores) {
			System.out.println(colaboradores2.getNome());
		}
	}

	public void limpar() {
		table.removeAll();
	}
}
