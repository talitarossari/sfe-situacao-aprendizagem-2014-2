package br.senai.sc.sfe.visao;

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

import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.entity.Pessoa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarColaboradores extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField codigoP;
	public PessoaControle pessoaC;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnSeleciona;
	public static String idDoColaborador = "";
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarColaboradores frame = new ListarColaboradores();
					frame.setVisible(true);
					frame.limpar();
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
		pessoaC = new PessoaControle();
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
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Nome Do Colaborador");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		scrollPane.setViewportView(table);

		btnSeleciona = new JButton("Selecionar");
		btnSeleciona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result2 = JOptionPane.showConfirmDialog(null,
						"Deseja selecionar este funcionario?");
				if (result2 == JOptionPane.YES_OPTION) {
				int indice = table.getSelectedRow();
				Pessoa pessoa = new Pessoa();
				setId(String.valueOf(tableModel.getValueAt(indice, 0)));
				Instancias instancia = new Instancias();
				instancia.getInstanceAgenda().idColaborador.setText(getId());
				dispose();
				}
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
				if (codigoP.getText() == null
						|| codigoP.getText().trim().isEmpty()) {
					listarTodos();
				} else {
					Pessoa pessoa1 = pessoaC.buscarPorId(Integer.valueOf(codigoP.getText()));
					limpar();
					tableModel.addRow(new Object[] { pessoa1.getIdPessoa(),
							pessoa1.getNome() });
				}
			}
		});
		button.setBounds(262, 21, 91, 23);
		contentPane.add(button);
		
		label_1 = new JLabel("");
		label_1.setBounds(0, -177, 466, 653);
		contentPane.add(label_1);

	}

	public String getId() {
		return idDoColaborador;
	}

	public void setId(String idC) {
		this.idDoColaborador = idC;
	}

	private void listarTodos() {
		List<Pessoa> colaboradores = new ArrayList<Pessoa>();
		colaboradores = pessoaC.listar();
		limpar();
		for (Pessoa colaboradores2 : colaboradores) {
			tableModel.addRow(new Object[] { colaboradores2.getIdPessoa(),
					colaboradores2.getNome() });
		}
	}

	public void limpar() {
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);
			
		}
	}


}
