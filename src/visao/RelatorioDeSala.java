package visao;


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

public class RelatorioDeSala extends JFrame {

	private JPanel contentPane;
	private JTable table;

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
		setTitle("Salas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 449);
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
		
		JLabel lblRelatrioDeSalas = new JLabel("Relat\u00F3rio de Salas");
		lblRelatrioDeSalas.setFont(new Font("Arial", Font.PLAIN, 30));
		lblRelatrioDeSalas.setBounds(97, 25, 241, 45);
		contentPane.add(lblRelatrioDeSalas);
		
		JLabel lblBuscarPor = new JLabel("M\u00EAs:");
		lblBuscarPor.setBounds(174, 81, 112, 14);
		contentPane.add(lblBuscarPor);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(174, 102, 112, 22);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("Gerar");
		btnBuscar.setBounds(309, 102, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 135, 422, 224);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Colaborador", "Localiza\u00E7\u00E3o", "Sala", "Data"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(131);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Imprimir");
		btnNewButton.setBounds(341, 370, 91, 22);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.setBounds(11, 370, 91, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(57, 81, 46, 14);
		contentPane.add(lblAno);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "2014"}));
		comboBox_1.setBounds(57, 102, 91, 22);
		contentPane.add(comboBox_1);
	}
}
