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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.senai.sc.sfe.controle.SalaControle;
import br.senai.sc.sfe.entity.Sala;

public class PesquisaDeSala extends JFrame {

	private JPanel contentPane;
	private JTextField palavraChave;
	private JTable table;
	private JComboBox comboBusca;
	SalaControle salaC;
	Sala sala;
	private DefaultTableModel tableModel = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaDeSala frame = new PesquisaDeSala();
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
	public PesquisaDeSala() {
		salaC = new SalaControle();
		setTitle("Salas");
		salaC = new SalaControle();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 514);
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
		
		JLabel lblPesquisaDeSalas = new JLabel("Pesquisa de Salas");
		lblPesquisaDeSalas.setBounds(105, 47, 251, 42);
		lblPesquisaDeSalas.setFont(new Font("Arial", Font.PLAIN, 30));
		contentPane.add(lblPesquisaDeSalas);
		
		JLabel lblBuscarPor = new JLabel("Buscar Por:");
		lblBuscarPor.setBounds(10, 100, 79, 14);
		contentPane.add(lblBuscarPor);
		
		comboBusca = new JComboBox();
		comboBusca.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Localiza\u00E7\u00E3o", "Lugares", "Sala", "Tipo"}));
		comboBusca.setBounds(10, 115, 111, 22);
		contentPane.add(comboBusca);
		
		JLabel lblPalavraChave = new JLabel("Palavra - Chave:");
		lblPalavraChave.setBounds(131, 100, 119, 14);
		contentPane.add(lblPalavraChave);
		
		palavraChave = new JTextField();
		palavraChave.setBounds(131, 117, 225, 20);
		contentPane.add(palavraChave);
		palavraChave.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String palavra = palavraChave.getText();
				if(palavra == null || palavra.trim().isEmpty()){
					listarTodos();
				}else{
				if(comboBusca.getSelectedIndex() == 1){
					List<Sala> salas = new ArrayList<Sala>();
					salas=salaC.buscarPorLocalizacao(palavra);
					limpar();
					for (Sala salas2 : salas) {
						tableModel.addRow(new Object[] { salas2.getIdSala(),salas2.getLocalizacao(),
								salas2.getDescricao(), salas2.getTipo(),
								salas2.getQuantidadeLugares() });
					}
				}
				if(comboBusca.getSelectedIndex() == 2){
					List<Sala> salas = new ArrayList<Sala>();
					salas=salaC.buscarPorLugares(palavra);
					limpar();
					for (Sala salas2 : salas) {
						tableModel.addRow(new Object[] { salas2.getIdSala(),salas2.getLocalizacao(),
								salas2.getDescricao(), salas2.getTipo(),
								salas2.getQuantidadeLugares() });
					}
					
				}
				if(comboBusca.getSelectedIndex() == 3){
					List<Sala> salas = new ArrayList<Sala>();
					salas=salaC.buscarPorSala(palavra);
					limpar();
					for (Sala salas2 : salas) {
						tableModel.addRow(new Object[] { salas2.getIdSala(),salas2.getLocalizacao(),
								salas2.getDescricao(), salas2.getTipo(),
								salas2.getQuantidadeLugares() });
					}
					
				}
				if(comboBusca.getSelectedIndex() == 4){
					List<Sala> salas = new ArrayList<Sala>();
					salas=salaC.buscarPorTipo(palavra);
					limpar();
					for (Sala salas2 : salas) {
						tableModel.addRow(new Object[] { salas2.getIdSala(),salas2.getLocalizacao(),
								salas2.getDescricao(), salas2.getTipo(),
								salas2.getQuantidadeLugares() });
					}
					
				}}
			}
		});
		btnBuscar.setBounds(366, 115, 91, 23);
		contentPane.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 149, 447, 280);
		contentPane.add(scrollPane);
		
		table = new JTable();
		tableModel.addColumn("Codigo");
		tableModel.addColumn("Localização:");
		tableModel.addColumn("Sala:");
		tableModel.addColumn("Tipo:");
		tableModel.addColumn("Nº Lugares:");
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(4);
		table.getColumnModel().getColumn(2).setPreferredWidth(6);
		table.getColumnModel().getColumn(4).setPreferredWidth(8);
		scrollPane.setViewportView(table);
		
		JButton btnVisualizar = new JButton("Visualizar");
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroDeSalas salas = new CadastroDeSalas();
				int indice = table.getSelectedRow();
				salas.visualizarSalas(String.valueOf(tableModel.getValueAt(indice,0)));
				salas.setVisible(true);
				dispose();
				
			}
		});
		btnVisualizar.setBounds(366, 442, 91, 23);
		contentPane.add(btnVisualizar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(10, 442, 89, 23);
		contentPane.add(btnLimpar);
	}
	
	public void limpar() {
		palavraChave.setText("");
		comboBusca.setSelectedIndex(0);
		while (tableModel.getRowCount() > 0) {
			tableModel.removeRow(0);

		}
	}

	private void listarTodos() {
		List<Sala> salas = new ArrayList<Sala>();
		salas = salaC.listar();
		limpar();
		for (Sala salas2 : salas) {
			tableModel.addRow(new Object[] { salas2.getIdSala(),salas2.getLocalizacao(),
					salas2.getDescricao(), salas2.getTipo(),
					salas2.getQuantidadeLugares() });
		}
	}

}
