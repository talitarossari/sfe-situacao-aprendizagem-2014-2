package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class CadastroDeSalas extends JFrame {

	private JPanel contentPane;
	private JTextField textSala;
	private JLabel lblCadastroDeSalas;
	private JComboBox comboLocalizacao;
	private JComboBox comboTipo;
	private JComboBox comboLugares;
	private JButton btnCancelar;
	private JButton botaoExcluir;
	private JButton btnCadastrar;
	private JButton botaoEditar;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 442, 21);
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
				AgendamentoDeSala agendamento = new AgendamentoDeSala();
				agendamento.setVisible(true);
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
		
		lblCadastroDeSalas = new JLabel("Cadastro De Salas");
		lblCadastroDeSalas.setFont(new Font("Arial", Font.BOLD, 30));
		lblCadastroDeSalas.setBounds(81, 46, 270, 31);
		contentPane.add(lblCadastroDeSalas);
		
		JLabel lblNewLabel = new JLabel("Localiza\u00E7\u00E3o:");
		lblNewLabel.setBounds(42, 100, 79, 14);
		contentPane.add(lblNewLabel);
		
		comboLocalizacao = new JComboBox();
		comboLocalizacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Bloco A - Andar 1", "Bloco A - Andar 2", "Bloco B - Andar 1", "Bloco B - Andar 2", "Bloco C - Andar 1", "Bloco C - Andar 2", "Bloco D - Andar 1", "Bloco D - Andar 2", "Bloco E - Andar 1", "Bloco E - Andar 2", "Bloco F - Andar 1", "Bloco F - Andar 2", "Bloco G - Andar 1", "Bloco G - Andar 2"}));
		comboLocalizacao.setBounds(42, 123, 122, 22);
		contentPane.add(comboLocalizacao);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(263, 101, 100, 14);
		contentPane.add(lblSala);
		
		textSala = new JTextField();
		textSala.setBounds(263, 125, 100, 20);
		contentPane.add(textSala);
		textSala.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(42, 232, 46, 14);
		contentPane.add(lblTipo);
		
		comboTipo = new JComboBox();
		comboTipo.setBounds(42, 257, 122, 22);
		contentPane.add(comboTipo);
		
		JLabel lblQuantidadeLugares = new JLabel("N\u00BA Lugares:");
		lblQuantidadeLugares.setBounds(263, 232, 122, 14);
		contentPane.add(lblQuantidadeLugares);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(341, 376, 91, 23);
		contentPane.add(btnCadastrar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 376, 91, 23);
		contentPane.add(btnCancelar);
		
		comboLugares = new JComboBox();
		comboLugares.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "00 - 10", "10 - 20", "20 - 30", "30 - 40", "40 ou mais."}));
		comboLugares.setBounds(263, 257, 88, 22);
		contentPane.add(comboLugares);
		
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(177, 376, 91, 23);
		contentPane.add(botaoExcluir);
		
		botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboLocalizacao.setEnabled(true);
				comboTipo.setEnabled(true);
				comboLugares.setEnabled(true);
				textSala.setEditable(true);
				botaoEditar.setVisible(false);
				btnCadastrar.setVisible(true);
				btnCadastrar.setText("Alterar");
			}
		});
		botaoEditar.setBounds(341, 376, 91, 23);
		contentPane.add(botaoEditar);
		botaoEditar.setVisible(false);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(10, 376, 91, 23);
		contentPane.add(botaoCancelar);
		botaoExcluir.setVisible(false);
		botaoCancelar.setVisible(false);
		
		
	}
	
	public void PesquisaSalas(){
		lblCadastroDeSalas.setText("Visualizar Sala:");
		botaoExcluir.setVisible(true);
		botaoCancelar.setVisible(true);
		botaoEditar.setVisible(true);
		btnCadastrar.setVisible(false);
		btnCancelar.setVisible(false);
		comboLocalizacao.setEnabled(false);
		comboTipo.setEnabled(false);
		textSala.setEditable(false);
		comboLugares.setEnabled(false);
	}
}
