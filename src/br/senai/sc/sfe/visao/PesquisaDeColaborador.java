package br.senai.sc.sfe.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.entity.Pessoa;

import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;

public class PesquisaDeColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField palavraChave;
	private JTable table;
	private JComboBox comboBusca;
	PessoaControle pessoaC;
	Pessoa pessoa;
	private DefaultTableModel tableModel = new DefaultTableModel();
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaDeColaborador frame = new PesquisaDeColaborador();
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
	public PesquisaDeColaborador() {
		pessoaC = new PessoaControle();
		pessoa = new Pessoa();
		setTitle("Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 468, 21);
		contentPane.add(menuBar);

		JMenu mnTelaInicial = new JMenu("Tela Inicial");
		menuBar.add(mnTelaInicial);

		JMenuItem mntmTelaInicial = new JMenuItem("Tela Inicial");
		mntmTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial tela = new TelaInicial();
				tela.setVisible(true);
				dispose();
			}
		});
		mnTelaInicial.add(mntmTelaInicial);

		JMenu mnSalas = new JMenu("Salas");
		menuBar.add(mnSalas);

		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroDeSalas cadastro = new CadastroDeSalas();
				cadastro.setVisible(true);
				dispose();
			}
		});
		mnSalas.add(mntmCadastrar);

		JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaDeSala pesquisa = new PesquisaDeSala();
				pesquisa.setVisible(true);
				dispose();
			}
		});
		mnSalas.add(mntmPesquisar);

		JMenuItem mntmAgendar = new JMenuItem("Agendar");
		mntmAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instancias instancia = new Instancias();
				instancia.getInstanceAgenda().setVisible(true);
				dispose();
			}
		});
		mnSalas.add(mntmAgendar);

		JMenuItem mntmRelatrios = new JMenuItem("Relat\u00F3rios");
		mntmRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioDeSala relatorio = new RelatorioDeSala();
				relatorio.setVisible(true);
				dispose();
			}
		});
		mnSalas.add(mntmRelatrios);

		JMenu mnColaboradores = new JMenu("Colaboradores");
		menuBar.add(mnColaboradores);

		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroColaborador cadastro = new CadastroColaborador();
				cadastro.setVisible(true);
				dispose();
			}
		});
		mnColaboradores.add(mntmCadastrar_1);

		JMenuItem mntmPesquisar_1 = new JMenuItem("Pesquisar");
		mntmPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaDeColaborador pesquisa = new PesquisaDeColaborador();
				pesquisa.setVisible(true);
				dispose();
			}
		});
		mnColaboradores.add(mntmPesquisar_1);

		JMenu mnSair = new JMenu("Sair");
		menuBar.add(mnSair);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);

				dispose();
			}
		});
		mnSair.add(mntmSair);

		JLabel lblPesquisaDeColaboradores = new JLabel(
				"Pesquisa de Colaboradores");
		lblPesquisaDeColaboradores.setBounds(47, 39, 366, 35);
		lblPesquisaDeColaboradores.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblPesquisaDeColaboradores);

		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(10, 85, 103, 14);
		contentPane.add(lblBuscarPor);

		comboBusca = new JComboBox();
		comboBusca.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione", "Nome", "Fun\u00E7\u00E3o",
				"\u00C1rea de Atua\u00E7\u00E3o" }));
		comboBusca.setBounds(10, 101, 103, 22);
		contentPane.add(comboBusca);

		JLabel lblPalavraChave = new JLabel("Palavra - Chave:");
		lblPalavraChave.setBounds(137, 86, 99, 14);
		contentPane.add(lblPalavraChave);

		palavraChave = new JTextField();
		palavraChave.setBounds(137, 103, 220, 20);
		contentPane.add(palavraChave);
		palavraChave.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<Pessoa> pessoas = new ArrayList<Pessoa>();
				String palavra = palavraChave.getText();
				if (palavra == null || palavra.trim().isEmpty()) {
					limpar();
					listarTodos();
				} else {
					if (comboBusca.getSelectedIndex() == 1) {

						List<Pessoa> colaboradores = new ArrayList<Pessoa>();
						colaboradores = pessoaC.buscarPorNome(palavra);
						limpar();
						for (Pessoa colaboradores2 : colaboradores) {
							tableModel.addRow(new Object[] {
									colaboradores2.getIdPessoa(),
									colaboradores2.getNome(),
									colaboradores2.getFuncao(),
									colaboradores2.getAreaAtuacao() });
						}
					}
				}
				if (comboBusca.getSelectedIndex() == 2) {
					List<Pessoa> colaboradores = new ArrayList<Pessoa>();
					colaboradores = pessoaC.buscarPorFuncao(palavra);
					limpar();
					for (Pessoa colaboradores2 : colaboradores) {
						tableModel.addRow(new Object[] {
								colaboradores2.getIdPessoa(),
								colaboradores2.getNome(),
								colaboradores2.getFuncao(),
								colaboradores2.getAreaAtuacao() });
					}
				}
				if (comboBusca.getSelectedIndex() == 3) {
					List<Pessoa> colaboradores = new ArrayList<Pessoa>();
					colaboradores = pessoaC.buscarPorArea(palavra);
					limpar();
					for (Pessoa colaboradores2 : colaboradores) {
						tableModel.addRow(new Object[] {
								colaboradores2.getIdPessoa(),
								colaboradores2.getNome(),
								colaboradores2.getFuncao(),
								colaboradores2.getAreaAtuacao() });
					}
				}

			}
		});

		btnBuscar.setBounds(367, 101, 91, 23);
		contentPane.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 448, 300);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableModel.addColumn("Codigo:");
		tableModel.addColumn("Nome do Colaborador:");
		tableModel.addColumn("Função:");
		tableModel.addColumn("Area de Atuação:");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(7);
		table.getColumnModel().getColumn(2).setPreferredWidth(25);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);
		scrollPane.setViewportView(table);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 442, 91, 23);
		contentPane.add(btnLimpar);

		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int indice = table.getSelectedRow();
				Pessoa pessoa = new Pessoa();
				CadastroColaborador cc = new CadastroColaborador();
				cc.VerColaborador(String.valueOf(tableModel.getValueAt(indice,
						0)));
				cc.setVisible(true);
				dispose();
			}
		});
		btnVisualizar.setBounds(367, 442, 91, 23);
		contentPane.add(btnVisualizar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\big\\Desktop\\FUNDO.png"));
		label.setBounds(0, -108, 466, 584);
		contentPane.add(label);
	}

	public void limpar() {
		palavraChave.setText("");
		comboBusca.setSelectedIndex(0);
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);

		}
	}

	public void listarTodos() {
		List<Pessoa> colaboradores = new ArrayList<Pessoa>();
		colaboradores = pessoaC.listar();
		limpar();
		for (Pessoa colaboradores2 : colaboradores) {
			tableModel.addRow(new Object[] { colaboradores2.getIdPessoa(),
					colaboradores2.getNome(), colaboradores2.getFuncao(),
					colaboradores2.getAreaAtuacao() });
		}
	}

}
