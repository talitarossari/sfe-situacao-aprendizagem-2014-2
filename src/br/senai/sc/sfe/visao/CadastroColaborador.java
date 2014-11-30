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
		pessoaC = new PessoaControle();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 467, 21);
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
				Intancias instancia = new Intancias();
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
		
		labelCad = new JLabel("Cadastro De Colaborador");
		labelCad.setFont(new Font("Arial", Font.PLAIN, 30));
		labelCad.setBounds(57, 61, 338, 35);
		contentPane.add(labelCad);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(206, 142, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(49, 142, 46, 14);
		contentPane.add(lblCpf);
		MaskFormatter mascara = null;
		try{
			mascara = new MaskFormatter("###.###.###-##");
		} catch (Exception e) {
			e.printStackTrace();
		}
		cpfC = new JFormattedTextField(mascara);
		
		cpfC.setBounds(49, 164, 105, 20);
		contentPane.add(cpfC);
		
		nomeC = new JTextField();
		nomeC.setBounds(203, 164, 192, 20);
		contentPane.add(nomeC);
		nomeC.setColumns(10);
		
		JLabel lblFun = new JLabel("Fun\u00E7\u00E3o:");
		lblFun.setBounds(49, 250, 46, 14);
		contentPane.add(lblFun);
		
		comboFuncao = new JComboBox();
		comboFuncao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Professor", "Coordenador", "Diretor"}));
		comboFuncao.setBounds(49, 275, 105, 22);
		contentPane.add(comboFuncao);
		
		JLabel lblreaDeAtuao = new JLabel("\u00C1rea de Atua\u00E7\u00E3o:");
		lblreaDeAtuao.setBounds(206, 250, 189, 14);
		contentPane.add(lblreaDeAtuao);
		
		comboAtuacao = new JComboBox();
		comboAtuacao.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Automacao", "Coordenacao", "Informatica"}));
		comboAtuacao.setBounds(206, 275, 189, 22);
		contentPane.add(comboAtuacao);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(nomeC.getText());
				pessoa.setCpf(cpfC.getText());
				pessoa.setFuncao((String)comboFuncao.getSelectedItem());
				pessoa.setAreaAtuacao((String)comboAtuacao.getSelectedItem());
				pessoa.getUsuario().setLogin("a");
				pessoa.getUsuario().setSenha(00);
			
				try {
					pessoaC.salvar(pessoa);
					limpar();				
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		});
		btnCadastrar.setBounds(351, 428, 91, 23);
		contentPane.add(btnCadastrar);
		
		botaoEditar = new JButton("Editar");
		botaoEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeC.setEnabled(true);
				comboAtuacao.setEnabled(true);
				comboFuncao.setEnabled(true);
				botaoEditar.setVisible(false);
				btnCadastrar.setVisible(true);
				btnCadastrar.setText("Alterar");
			}
		});
		botaoEditar.setBounds(351, 428, 91, 23);
		contentPane.add(botaoEditar);
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setBounds(24, 428, 91, 23);
		contentPane.add(botaoCancelar);
		
		botaoExcluir = new JButton("Excluir");
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaC.remover(Integer.valueOf(idColaborador.getText()));
			}
		});
		botaoExcluir.setBounds(186, 428, 91, 23);
		contentPane.add(botaoExcluir);
		
		idColaborador = new JLabel("");
		idColaborador.setBounds(341, 82, 46, 14);
		contentPane.add(idColaborador);
		botaoExcluir.setVisible(false);
		botaoCancelar.setVisible(false);
		botaoEditar.setVisible(false);
		
	}
	
	public void VerColaborador(String id){
		limpar();
		Pessoa pessoa = pessoaC.buscarPorId(Integer.parseInt(id)); 
		idColaborador.setText(String.valueOf(pessoa.getIdPessoa()));
		cpfC.setText(pessoa.getCpf());
		nomeC.setText(pessoa.getNome());
		comboAtuacao.setSelectedItem(pessoa.getAreaAtuacao());
		comboFuncao.setSelectedItem(pessoa.getFuncao());
		labelCad.setText("Visualizar Colaborador:");
		botaoCancelar.setVisible(true);
		btnCadastrar.setVisible(false);
		botaoEditar.setVisible(true);
		cpfC.setEnabled(false);
		nomeC.setEnabled(false);
		comboAtuacao.setEnabled(false);
		comboFuncao.setEnabled(false);
	}
	
	public void limpar(){
		idColaborador.setText("0");
		cpfC.setText("");
		nomeC.setText("");
		comboAtuacao.setSelectedIndex(0);
		comboFuncao.setSelectedIndex(0);	
	}
}
