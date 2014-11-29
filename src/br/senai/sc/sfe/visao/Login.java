package br.senai.sc.sfe.visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.senai.sc.sfe.controle.UsuarioControle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setBounds(25, 268, 51, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("   Senha:");
		lblSenha.setBounds(25, 299, 51, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(80, 265, 190, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(80, 296, 190, 20);
		contentPane.add(passwordField);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioControle usuarioC = new UsuarioControle();
				Integer senha = Integer.parseInt(passwordField.getText());
				boolean resultado = usuarioC.buscarUsuario(textField.getText(), senha);
				if(resultado){
				TelaInicial tela = new TelaInicial();
				tela.setVisible(true);
				dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario e/ou senha Incorreto!");
				}
			}
		});
		btnEntrar.setBounds(109, 327, 91, 23);
		contentPane.add(btnEntrar);
	}

}
