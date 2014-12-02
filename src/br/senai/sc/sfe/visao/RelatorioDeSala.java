package br.senai.sc.sfe.visao;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import br.senai.sc.sfe.controle.AgendaControle;
import br.senai.sc.sfe.controle.SalaControle;
import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.entity.Sala;
import javax.swing.SwingConstants;

public class RelatorioDeSala extends JFrame {

	private JPanel contentPane;
	private JTable table;
	AgendaControle agendaC;
	Agenda agenda;
	private JComboBox comboMes;
	private JComboBox comboAno;
	SalaControle salaC;
	private DefaultTableModel tableModel = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioDeSala frame = new RelatorioDeSala();
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
	public RelatorioDeSala() {
		salaC = new SalaControle();
		setTitle("Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 466, 21);
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
		
		JLabel lblRelatrioDeSalas = new JLabel("Relat\u00F3rio de Salas");
		lblRelatrioDeSalas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDeSalas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblRelatrioDeSalas.setBounds(0, 25, 466, 45);
		contentPane.add(lblRelatrioDeSalas);
		
		JLabel lblBuscarPor = new JLabel("M\u00EAs:");
		lblBuscarPor.setBounds(174, 81, 112, 14);
		contentPane.add(lblBuscarPor);
		
		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboMes.setBounds(174, 102, 112, 22);
		contentPane.add(comboMes);
		
		JButton btnBuscar = new JButton("Gerar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Sala> salas = salaC.buscarPorAnoEMes((String)comboAno.getSelectedItem(), (String)comboMes.getSelectedItem());
			}
		});
		btnBuscar.setBounds(309, 102, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 446, 297);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tableModel.addColumn("Código:");
		tableModel.addColumn("Colaborador:");
		tableModel.addColumn("Sala:");
		tableModel.addColumn("Data");
		tableModel.addColumn("Horário:");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setBounds(365, 443, 91, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnNewButton_1.setBounds(10, 443, 91, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(57, 81, 46, 14);
		contentPane.add(lblAno);
		
		comboAno = new JComboBox();
		comboAno.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "2014"}));
		comboAno.setBounds(57, 102, 91, 22);
		contentPane.add(comboAno);
	}
	
	public void limpar(){
		comboAno.setSelectedIndex(0);
		comboMes.setSelectedIndex(0);
	}
}
