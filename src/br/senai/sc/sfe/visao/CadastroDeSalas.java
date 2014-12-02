package br.senai.sc.sfe.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.senai.sc.sfe.controle.SalaControle;
import br.senai.sc.sfe.dao.SalaDao;
import br.senai.sc.sfe.entity.Sala;
import javax.swing.SwingConstants;

public class CadastroDeSalas extends JFrame {

	private JPanel contentPane;
	private JTextField descricaoSala;
	private JLabel label;
	private JComboBox comboLocalizacao;
	private JComboBox comboTipo;
	private JComboBox comboLugares;
	private JButton btnCancelar;
	private JButton botaoExcluir;
	private JButton btnCadastrar;
	private JButton botaoEditar;
	SalaDao salaDao;
	SalaControle salaC;
	static Sala sala;
	private JLabel idSala;
	private JButton botaoCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroDeSalas frame = new CadastroDeSalas();
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
	public CadastroDeSalas() {
		sala = new Sala();
		salaC = new SalaControle();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 467, 21);
		contentPane.add(menuBar);

		salaDao = new SalaDao();

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

		label = new JLabel("Cadastro De Salas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 30));
		label.setBounds(0, 43, 467, 46);
		contentPane.add(label);

		JLabel lblNewLabel = new JLabel("Localiza\u00E7\u00E3o:");
		lblNewLabel.setBounds(60, 143, 79, 14);
		contentPane.add(lblNewLabel);

		comboLocalizacao = new JComboBox();
		comboLocalizacao
				.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
						"Bloco A - Andar 1", "Bloco A - Andar 2",
						"Bloco B - Andar 1", "Bloco B - Andar 2",
						"Bloco C - Andar 1", "Bloco C - Andar 2",
						"Bloco D - Andar 1", "Bloco D - Andar 2",
						"Bloco E - Andar 1", "Bloco E - Andar 2",
						"Bloco F - Andar 1", "Bloco F - Andar 2",
						"Bloco G - Andar 1", "Bloco G - Andar 2" }));
		comboLocalizacao.setBounds(60, 166, 122, 22);
		contentPane.add(comboLocalizacao);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(281, 144, 100, 14);
		contentPane.add(lblSala);

		descricaoSala = new JTextField();
		descricaoSala.setBounds(281, 168, 100, 20);
		contentPane.add(descricaoSala);
		descricaoSala.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(60, 275, 46, 14);
		contentPane.add(lblTipo);

		comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"Inform\u00E1tica", "Automa\u00E7\u00E3o", "Auditorio",
				"Coordena\u00E7\u00E3o", "Secretaria" }));
		comboTipo.setBounds(60, 300, 122, 22);
		contentPane.add(comboTipo);

		JLabel lblQuantidadeLugares = new JLabel("N\u00BA Lugares:");
		lblQuantidadeLugares.setBounds(281, 275, 122, 14);
		contentPane.add(lblQuantidadeLugares);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"Deseja salvar?");
				if (result == JOptionPane.YES_OPTION) {
				sala.setLocalizacao((String) comboLocalizacao.getSelectedItem());
				sala.setDescricao(descricaoSala.getText());
				sala.setQuantidadeLugares((String) comboLugares
						.getSelectedItem());
				sala.setTipo((String) comboTipo.getSelectedItem());
				try {
					salaDao.salvar(sala);
					limpar();
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				} catch (Exception ee) {
					JOptionPane.showMessageDialog(null, ee.getMessage());
					ee.printStackTrace();
				}
			}}
		});
		btnCadastrar.setBounds(351, 427, 91, 23);
		contentPane.add(btnCadastrar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,
						"Deseja cancelar?");
				if (result == JOptionPane.YES_OPTION) {
					limpar();
				}

			}
		});
		btnCancelar.setBounds(23, 427, 91, 23);
		contentPane.add(btnCancelar);
		
		comboLugares = new JComboBox();
		comboLugares.setModel(new DefaultComboBoxModel(new String[] {
				"Selecione", "00 - 10", "10 - 20", "20 - 30", "30 - 40",
				"40 ou mais." }));
		comboLugares.setBounds(281, 300, 88, 22);
		contentPane.add(comboLugares);

		botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null,
						"Deseja mesmo excliur esta sala?");
				if (result == JOptionPane.YES_OPTION) {
					salaDao.remover(Integer.parseInt(idSala.getText()));
					JOptionPane.showMessageDialog(null, "Sala excluida com sucesso!");
					limpar();
				}

			}
		});
		botaoExcluir.setBounds(194, 427, 91, 23);
		contentPane.add(botaoExcluir);

		botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null,"Deseja editar?");
				if (result == JOptionPane.YES_OPTION) {
				comboLocalizacao.setEnabled(true);
				comboTipo.setEnabled(true);
				comboLugares.setEnabled(true);
				descricaoSala.setEditable(true);
				botaoEditar.setVisible(false);
				btnCadastrar.setVisible(true);
				btnCadastrar.setText("Alterar");
				botaoExcluir.setVisible(true);
				label.setText("Editar Sala:");
				}

			}
		});
		botaoEditar.setBounds(351, 427, 91, 23);
		contentPane.add(botaoEditar);
		botaoEditar.setVisible(false);

		idSala = new JLabel("");
		idSala.setBounds(378, 83, 46, 14);
		contentPane.add(idSala);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null,"Deseja salvar?");
				if (result == JOptionPane.YES_OPTION) {
					PesquisaDeSala ps = new PesquisaDeSala();
					ps.listarTodos();
					ps.setVisible(true);
				}
			}
		});
		botaoCancelar.setBounds(25, 427, 89, 23);
		contentPane.add(botaoCancelar);
		botaoCancelar.setVisible(false);
		botaoExcluir.setVisible(false);

	}

	public void visualizarSalas(String id) {
		sala = salaC.buscarPorId(Integer.parseInt(id));
		comboLocalizacao.setSelectedItem(sala.getLocalizacao());
		descricaoSala.setText(sala.getDescricao());
		comboTipo.setSelectedItem(sala.getTipo());
		comboLugares.setSelectedItem(sala.getQuantidadeLugares());
		label.setText("Visualizar Sala:");
		botaoEditar.setVisible(true);
		btnCadastrar.setVisible(false);
		comboLocalizacao.setEnabled(false);
		comboTipo.setEnabled(false);
		descricaoSala.setEditable(false);
		comboLugares.setEnabled(false);
		botaoCancelar.setVisible(true);
		btnCancelar.setVisible(false);
		
	}

	public void limpar() {
		comboLocalizacao.setSelectedIndex(0);
		comboLugares.setSelectedIndex(0);
		comboTipo.setSelectedIndex(0);
		descricaoSala.setText("");
	}
}
