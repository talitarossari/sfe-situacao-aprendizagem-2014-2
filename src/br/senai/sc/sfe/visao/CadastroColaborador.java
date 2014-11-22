package br.senai.sc.sfe.visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.entity.Pessoa;

public class CadastroColaborador extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField cpfC;
	private JTextField nomeC;
	private JButton botaoCancelar;
	private JButton botaoEditar;
	private JButton botaoExcluir;
	private JLabel labelCad;
	private JComboBox comboFuncao;
	private JComboBox comboAtuacao;
	private JButton btnCadastrar;
	private JButton btnCancelar;
	private JLabel idColaborador;
	PessoaControle pessoaC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaborador frame = new CadastroColaborador();
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
	public CadastroColaborador() {
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
		
		labelCad = new JLabel("Cadastro De Colaborador");
		labelCad.setFont(new Font("Arial", Font.PLAIN, 30));
		labelCad.setBounds(49, 36, 338, 35);
		contentPane.add(labelCad);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(198, 111, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(41, 111, 46, 14);
		contentPane.add(lblCpf);
		MaskFormatter mascara = null;
		try{
			mascara = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		cpfC = new JFormattedTextField(mascara);
		
		cpfC.setBounds(41, 133, 105, 20);
		contentPane.add(cpfC);
		
		nomeC = new JTextField();
		nomeC.setBounds(195, 133, 192, 20);
		contentPane.add(nomeC);
		nomeC.setColumns(10);
		
		JLabel lblFun = new JLabel("Fun\u00E7\u00E3o:");
		lblFun.setBounds(41, 219, 46, 14);
		contentPane.add(lblFun);
		
		comboFuncao = new JComboBox();
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Professor", "Coordenador", "Diretor"}));
		comboFuncao.setBounds(41, 244, 105, 22);
		contentPane.add(comboFuncao);
		
		JLabel lblreaDeAtuao = new JLabel("\u00C1rea de Atua\u00E7\u00E3o:");
		lblreaDeAtuao.setBounds(198, 219, 189, 14);
		contentPane.add(lblreaDeAtuao);
		
		comboAtuacao = new JComboBox();
		comboAtuacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Automacao", "Coordenacao", "Informatica"}));
		comboAtuacao.setBounds(198, 244, 189, 22);
		contentPane.add(comboAtuacao);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 372, 91, 23);
		contentPane.add(btnCancelar);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoa pessoa = new Pessoa();
				pessoa.setIdPessoa(Integer.parseInt(idColaborador.getText()));
				pessoa.setCpf(cpfC.getText());
				pessoa.setFuncao((String)comboFuncao.getSelectedItem());
				pessoa.setAreaAtuacao((String)comboAtuacao.getSelectedItem());
			
				try {
					pessoaC.salvar(pessoa);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		});
		btnCadastrar.setBounds(341, 372, 91, 23);
		contentPane.add(btnCadastrar);
		
		botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cpfC.setEnabled(true);
				nomeC.setEnabled(true);
				comboAtuacao.setEnabled(true);
				comboFuncao.setEnabled(true);
				botaoEditar.setVisible(false);
				btnCadastrar.setVisible(true);
				btnCadastrar.setText("Alterar");
				
				
			}
		});
		botaoEditar.setBounds(341, 372, 91, 23);
		contentPane.add(botaoEditar);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(10, 372, 91, 23);
		contentPane.add(botaoCancelar);
		
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.setBounds(176, 372, 91, 23);
		contentPane.add(botaoExcluir);
		
		idColaborador = new JLabel("");
		idColaborador.setBounds(341, 82, 46, 14);
		contentPane.add(idColaborador);
		botaoExcluir.setVisible(false);
		botaoCancelar.setVisible(false);
		botaoEditar.setVisible(false);
		
	}
	
	public void VerColaborador(){
		labelCad.setText("Visualizar Colaborador:");
		botaoExcluir.setVisible(true);
		botaoCancelar.setVisible(true);
		btnCadastrar.setVisible(false);
		btnCancelar.setVisible(false);
		botaoEditar.setVisible(true);
		cpfC.setEnabled(false);
		nomeC.setEnabled(false);
		comboAtuacao.setEnabled(false);
		comboFuncao.setEnabled(false);
		
	}
}
