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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.senai.sc.sfe.controle.AgendaControle;
import br.senai.sc.sfe.controle.PessoaControle;
import br.senai.sc.sfe.controle.SalaControle;
import br.senai.sc.sfe.dao.AgendaDao;
import br.senai.sc.sfe.entity.Agenda;
import br.senai.sc.sfe.entity.Pessoa;
import br.senai.sc.sfe.entity.Sala;

import javax.swing.JTextPane;

public class AgendamentoDeSala extends JFrame {

	private JPanel contentPane;
	private JComboBox comboMes;
	private JComboBox comboAno;
	private JComboBox comboHorario;
	private JComboBox comboDia;
	Agenda agenda;
	Sala sala;
	Pessoa pessoa;
	SalaControle salaC;
	PessoaControle pessoaC;
	AgendaControle agendaC;
	public JLabel lblColaborador;
	static ListarColaboradores lc = new ListarColaboradores();
	static ListarSalas salas = new ListarSalas();
	Intancias instancia;
	public JTextField idColaborador;
	public JTextField idSala;
	AgendaDao agendaDao;

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
		instancia = new Intancias();
		agendaC = new AgendaControle();
		pessoaC = new PessoaControle();
		agendaDao = new AgendaDao();
		salaC = new SalaControle();
		pessoa = new Pessoa();
		sala = new Sala();
		agenda = new Agenda();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 515);
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

		JLabel lblAgendamentoDeSalas = new JLabel("Agendamento De Salas");
		lblAgendamentoDeSalas.setFont(new Font("Arial", Font.BOLD, 30));
		lblAgendamentoDeSalas.setBounds(63, 56, 332, 44);
		contentPane.add(lblAgendamentoDeSalas);

		JLabel lblSala = new JLabel("Sala:");
		lblSala.setBounds(24, 141, 32, 14);
		contentPane.add(lblSala);

		lblColaborador = new JLabel("Colaborador:");
		lblColaborador.setBounds(233, 141, 102, 14);
		contentPane.add(lblColaborador);

		comboHorario = new JComboBox();
		comboHorario.setModel(new DefaultComboBoxModel(
				new String[] { "Selecione", "08h00 - 12h00", "13h30 - 17h30",
						"18h30 - 22h30" }));
		comboHorario.setBounds(24, 284, 124, 22);
		contentPane.add(comboHorario);

		JLabel lblHorrio = new JLabel("Hor\u00E1rio:");
		lblHorrio.setBounds(24, 265, 46, 14);
		contentPane.add(lblHorrio);

		comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" }));
		comboDia.setBounds(365, 284, 82, 22);
		contentPane.add(comboDia);

		JLabel lblDia = new JLabel("Dia:");
		lblDia.setBounds(365, 265, 91, 14);
		contentPane.add(lblDia);

		comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho",
				"Julho", "Agosto", "Setembro", "Outubro", "Novembro",
				"Dezembro" }));
		comboMes.setBounds(263, 284, 92, 22);
		contentPane.add(comboMes);

		JLabel lblM = new JLabel("M\u00EAs:");
		lblM.setBounds(263, 265, 40, 14);
		contentPane.add(lblM);

		comboAno = new JComboBox();
		comboAno.setModel(new DefaultComboBoxModel(new String[] { "Selecione",
				"2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
		comboAno.setBounds(167, 284, 86, 22);
		contentPane.add(comboAno);

		JLabel lblAno = new JLabel("Ano:");
		lblAno.setBounds(167, 265, 46, 14);
		contentPane.add(lblAno);

		JButton btnAgendar = new JButton("Agendar");
		btnAgendar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
					pessoa = pessoaC.buscarPorId(Integer.parseInt(idColaborador.getText()));
					sala = salaC.buscarPorId(Integer.parseInt(idSala.getText()));
					
					System.out.println(pessoa);
					System.out.println(sala);
					
					agenda.getPessoa().setIdPessoa(pessoa.getIdPessoa());
					agenda.getPessoa().setAreaAtuacao(pessoa.getAreaAtuacao());
					agenda.getPessoa().setCpf(pessoa.getCpf());
					agenda.getPessoa().setFuncao(pessoa.getFuncao());
					agenda.getPessoa().setNome(pessoa.getNome());
					agenda.getSala().setDescricao(sala.getDescricao());
					agenda.getSala().setIdSala(sala.getIdSala());
					agenda.getSala().setLocalizacao(sala.getLocalizacao());
					agenda.getSala().setQuantidadeLugares(sala.getQuantidadeLugares());
					agenda.getSala().setTipo(sala.getTipo());
					agenda.setHorario((String) comboHorario.getSelectedItem());
					agenda.setAno((String) comboAno.getSelectedItem());
					agenda.setDia((String) comboDia.getSelectedItem());
					agenda.setMes((String) comboMes.getSelectedItem());

					try {
						agendaDao.salvar(agenda);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						e.printStackTrace();
					}
			
		}});
		btnAgendar.setBounds(356, 443, 91, 23);
		contentPane.add(btnAgendar);

		JButton btnCancela = new JButton("Cancelar");
		btnCancela.setBounds(24, 443, 91, 23);
		contentPane.add(btnCancela);
		
		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instancia.getInstanceColaboradores().setVisible(true);
				
			}
		});
		botaoBuscar.setBounds(365, 165, 89, 23);
		contentPane.add(botaoBuscar);
		
		idColaborador = new JTextField();
		idColaborador.setBounds(233, 166, 121, 20);
		contentPane.add(idColaborador);
		idColaborador.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instancia.getInstanceSala().setVisible(true);
				
			}
		});
		btnBuscar.setBounds(134, 165, 89, 23);
		contentPane.add(btnBuscar);
		
		idSala = new JTextField();
		idSala.setBounds(24, 166, 100, 20);
		contentPane.add(idSala);
		idSala.setColumns(10);

	}

	

	public void carregarAgenda(Agenda agenda) {
		idColaborador.setText(String.valueOf(agenda.getPessoa().getIdPessoa()));
		idSala.setText(String.valueOf(agenda.getSala().getIdSala()));
		comboAno.setSelectedItem(agenda.getAno());
		comboDia.setSelectedItem(agenda.getDia());
		comboHorario.setSelectedItem(agenda.getHorario());
		comboMes.setSelectedItem(agenda.getMes());
	}

	public void limpar() {
		idSala.setText("");
		idColaborador.setText("");
		comboAno.setSelectedIndex(0);
		comboDia.setSelectedIndex(0);
		comboHorario.setSelectedIndex(0);
		comboMes.setSelectedIndex(0);
	}
}
