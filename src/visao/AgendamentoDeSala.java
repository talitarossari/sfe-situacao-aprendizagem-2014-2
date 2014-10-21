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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AgendamentoDeSala extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendamentoDeSala frame = new AgendamentoDeSala();
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
	public AgendamentoDeSala() {
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
		
		JLabel lblAgendamentoDeSalas = new JLabel("Agendamento De Salas");
		lblAgendamentoDeSalas.setFont(new Font("Arial", Font.BOLD, 30));
		lblAgendamentoDeSalas.setBounds(62, 36, 332, 44);
		contentPane.add(lblAgendamentoDeSalas);
		
		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(15, 115, 32, 14);
		contentPane.add(lblSala);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(15, 132, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarSalas salas = new ListarSalas();
				salas.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(111, 131, 77, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(210, 115, 102, 14);
		contentPane.add(lblColaborador);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(210, 132, 129, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarColaboradores lc = new ListarColaboradores();
				lc.setVisible(true);
				dispose();
			}
		});
		btnBuscar_1.setBounds(358, 131, 77, 23);
		contentPane.add(btnBuscar_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "08h00 - 12h00", "13h30 - 17h30", "18h30 - 22h30"}));
		comboBox.setBounds(15, 233, 102, 22);
		contentPane.add(comboBox);
		
		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(15, 214, 46, 14);
		contentPane.add(lblHorrio);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_1.setBounds(344, 233, 91, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(344, 214, 91, 14);
		contentPane.add(lblDia);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_2.setBounds(242, 233, 92, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblM = new JLabel("M\u00EAs:");
		lblM.setBounds(242, 214, 40, 14);
		contentPane.add(lblM);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_3.setBounds(135, 233, 86, 22);
		contentPane.add(comboBox_3);
		
		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(135, 214, 46, 14);
		contentPane.add(lblAno);
		
		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.setBounds(344, 389, 91, 23);
		contentPane.add(btnAgendar);
		
		JButton btnCancela = new JButton("Cancelar");
		btnCancela.setBounds(15, 389, 91, 23);
		contentPane.add(btnCancela);
	}
}
