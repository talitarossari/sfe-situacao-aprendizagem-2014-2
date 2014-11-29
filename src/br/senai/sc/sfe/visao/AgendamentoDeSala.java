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

import br.senai.sc.sfe.controle.AgendaControle;
import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;

public class AgendamentoDeSala extends JFrame {

	private JPanel contentPane;
	private JTextField idSala;
	private JTextField idColaborador;
	private JComboBox comboMes;
	private JComboBox comboAno;
	private JComboBox comboHorario;
	private JComboBox comboDia;
	Agenda agenda;
	Sala sala;
	Pessoa pessoa;
	AgendaControle agendaC;

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

		idSala = new JTextField();
		idSala.setEditable(true);
		idSala.setBounds(15, 132, 86, 20);
		contentPane.add(idSala);
		idSala.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarSalas salas = new ListarSalas();
				salas.setVisible(true);

			}
		});
		btnBuscar.setBounds(111, 131, 77, 23);
		contentPane.add(btnBuscar);

		JLabel lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(210, 115, 102, 14);
		contentPane.add(lblColaborador);

		idColaborador = new JTextField();
		idColaborador.setEditable(true);
		idColaborador.setBounds(210, 132, 129, 20);
		contentPane.add(idColaborador);
		idColaborador.setColumns(10);

		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListarColaboradores lc = new ListarColaboradores();
				lc.setVisible(true);

			}
		});
		btnBuscar_1.setBounds(349, 131, 77, 23);
		contentPane.add(btnBuscar_1);

		comboHorario = new JComboBox();
		comboHorario.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "08h00 - 12h00", "13h30 - 17h30",
						"18h30 - 22h30" }));
		comboHorario.setBounds(15, 233, 102, 22);
		contentPane.add(comboHorario);

		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(15, 214, 46, 14);
		contentPane.add(lblHorrio);

		comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" }));
		comboDia.setBounds(344, 233, 91, 22);
		contentPane.add(comboDia);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(344, 214, 91, 14);
		contentPane.add(lblDia);

		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho",
				"Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" }));
		comboMes.setBounds(242, 233, 92, 22);
		contentPane.add(comboMes);

		JLabel lblM = new JLabel("M\u00EAs:");
		lblM.setBounds(242, 214, 40, 14);
		contentPane.add(lblM);

		comboAno = new JComboBox();
		comboAno.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
		comboAno.setBounds(135, 233, 86, 22);
		contentPane.add(comboAno);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(135, 214, 46, 14);
		contentPane.add(lblAno);

		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int idS = Integer.parseInt(idSala.getText());
				int idC = Integer.parseInt(idColaborador.getText());
				sala.setIdSala(idS);
				pessoa.setIdPessoa(idC);
				agenda.setSala(sala);
				agenda.setPessoa(pessoa);
				agenda.setHorario((String) comboHorario.getSelectedItem());
				agenda.setAno((String) comboAno.getSelectedItem());
				agenda.setDia((String) comboDia.getSelectedItem());
				agenda.setMes((String) comboMes.getSelectedItem());

				try {
					agendaC.salvar(agenda);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			}

		});
		btnAgendar.setBounds(344, 389, 91, 23);
		contentPane.add(btnAgendar);

		JButton btnCancela = new JButton("Cancelar");
		btnCancela.setBounds(15, 389, 91, 23);
		contentPane.add(btnCancela);
	}

	public void carregarSala(Integer idsala){
		idSala.setText((String.valueOf(idsala)));
	}
	
	public void carregarColaborador(Integer idcolaborador){
		idColaborador.setText((String.valueOf(idcolaborador)));
	}
	
	public void carregarAgenda(Agenda agenda){
		idColaborador.setText(String.valueOf(agenda.getPessoa().getIdPessoa()));
		idSala.setText(String.valueOf(agenda.getSala().getIdSala()));
		comboAno.setSelectedItem(agenda.getAno());
		comboDia.setSelectedItem(agenda.getDia());
		comboHorario.setSelectedItem(agenda.getHorario());
		comboMes.setSelectedItem(agenda.getMes());
	}
	
	public void limpar(){
		idColaborador.setText("");
		idSala.setText("");
		comboAno.setSelectedItem("");
		comboDia.setSelectedItem("");
		comboHorario.setSelectedItem("");
		comboMes.setSelectedItem("");
	}
	
}
