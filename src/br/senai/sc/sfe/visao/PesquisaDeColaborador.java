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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.entity.Pessoa;

public class PesquisaDeColaborador extends JFrame {

	private JPanel contentPane;
	private JTextField palavraChave;
	private JTable table;
	private JComboBox comboBusca;
	PessoaControle pessoaC;
	Pessoa pessoa;
	private DefaultTableModel tableModel = new DefaultTableModel();
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
		
		JLabel lblPesquisaDeColaboradores = new JLabel("Pesquisa de Colaboradores");
		lblPesquisaDeColaboradores.setBounds(38, 22, 366, 35);
		lblPesquisaDeColaboradores.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblPesquisaDeColaboradores);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(10, 67, 103, 14);
		contentPane.add(lblBuscarPor);
		
		comboBusca = new JComboBox();
		comboBusca.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Nome", "Fun\u00E7\u00E3o", "\u00C1rea de Atua\u00E7\u00E3o"}));
		comboBusca.setBounds(10, 83, 103, 22);
		contentPane.add(comboBusca);
		
		JLabel lblPalavraChave = new JLabel("Palavra - Chave:");
		lblPalavraChave.setBounds(137, 68, 99, 14);
		contentPane.add(lblPalavraChave);
		
		palavraChave = new JTextField();
		palavraChave.setBounds(137, 85, 220, 20);
		contentPane.add(palavraChave);
		palavraChave.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String palavra = palavraChave.getText();
				if(comboBusca.getSelectedIndex() == 1 && palavra ==null){
					pessoaC.buscarPorNome(palavra);
				}
				if(comboBusca.getSelectedIndex() == 2 && palavra ==null){
					pessoaC.buscarPorFuncao(palavra);
				}
				if(comboBusca.getSelectedIndex() == 3 && palavra ==null){
					pessoaC.buscarPorArea(palavra);
				}
				
			}
		});
		btnBuscar.setBounds(367, 83, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 448, 300);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tableModel.addColumn("Codigo:");
		tableModel.addColumn("Nome do Colamorador:");
		tableModel.addColumn("Função:");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(2).setPreferredWidth(108);
		scrollPane.setViewportView(table);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 428, 91, 23);
		contentPane.add(btnLimpar);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				CadastroColaborador cc= new CadastroColaborador();
				//cc.VerColaborador(pessoa);
				cc.setVisible(true);
				dispose();
			}
		});
		btnVisualizar.setBounds(367, 428, 91, 23);
		contentPane.add(btnVisualizar);
	}
	public void limpar(){
		palavraChave.setText("");
		comboBusca.setSelectedIndex(0);
		table.removeAll();
	}

}
