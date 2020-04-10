package aplicacao_swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada2.Fachada2;

public class TelaCadastroUsuario {

	private JFrame frmCadastroDePessoa;
	private JLabel lb1Nome;
	private JLabel lb1Cpf;
	private JLabel lb1DataNas;
	private JLabel lb1Email;
	private JLabel lb1Senha;
	
	private JTextField NomeField;
	private JTextField CpfField;
	private JTextField DataField;
	private JTextField EmailField;
	private JTextField SenhaField;
	private JButton button2;
	private JLabel label2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroPessoa window = new TelaCadastroPessoa();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaCadastroUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDePessoa = new JFrame();
		frmCadastroDePessoa.setTitle("Cadastro de Pessoa");
		frmCadastroDePessoa.setBounds(100, 100, 321, 240);
		frmCadastroDePessoa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDePessoa.getContentPane().setLayout(null);
	
		
		//NOME
		lb1Nome = new JLabel("Nome:");
		lb1Nome.setBounds(25, 34, 46, 14);
		frmCadastroDePessoa.getContentPane().add(lb1Nome);
		
		//CAMPO DO NOME
		NomeField = new JTextField();
		NomeField.setBounds(62, 31, 130, 20);
		frmCadastroDePessoa.getContentPane().add(NomeField);
		NomeField.setColumns(10);
		
		//CPF
		lb1Cpf = new JLabel("CPF:");
		lb1Cpf.setBounds(25, 50, 46, 30);
		frmCadastroDePessoa.getContentPane().add(lb1Cpf);
		
//		String nome,String cpf,String datanasc, String email, String senha
		
		//CAMPO  CPF
		CpfField = new JTextField();
		CpfField.setBounds(62, 55, 130, 20);
		frmCadastroDePessoa.getContentPane().add(CpfField);
		CpfField.setColumns(10);
		
		//DADANASCI   DE UM PARA O OUTRO É 16 E ALTURA É 16
		lb1DataNas = new JLabel("Data de Nascimento:");
		lb1DataNas.setBounds(25, 66, 46, 46);
		frmCadastroDePessoa.getContentPane().add(lb1DataNas);
				
		//CAMPO DATANASCI só muda o segundo campo é 24
		DataField = new JTextField();
		DataField.setBounds(68, 79, 130, 20);
		frmCadastroDePessoa.getContentPane().add(DataField);
		DataField.setColumns(10);
		
		//EMAIL
		lb1Email = new JLabel("Email:");
		lb1Email.setBounds(25, 82, 46, 62);
		frmCadastroDePessoa.getContentPane().add(lb1Email);
			
		//CAMPO EMAIL
		EmailField = new JTextField();
		EmailField.setBounds(68, 103, 130, 20);
		frmCadastroDePessoa.getContentPane().add(EmailField);
		EmailField.setColumns(10);
		
		//SENHA
		lb1Senha = new JLabel("Senha:");
		lb1Senha.setBounds(25, 98, 46, 78);
		frmCadastroDePessoa.getContentPane().add(lb1Senha);
					
		//CAMPO SENHA
		SenhaField = new JTextField();
		SenhaField.setBounds(68, 127, 130, 20);
		frmCadastroDePessoa.getContentPane().add(SenhaField);
		SenhaField.setColumns(10);
				
		
		
		
		label2 = new JLabel("");
		label2.setBounds(26, 109, 189, 14);
		frmCadastroDePessoa.getContentPane().add(label2);
		
		button2 = new JButton("Cadastrar Pessoa");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String nome = NomeField.getText();
					String cpf = CpfField.getText();
                    String datanas = DataField.getText();
					String email = EmailField.getText();
					String senha = SenhaField.getText();
					Fachada2.cadastrarUsuario(nome,cpf,datanas,email,senha);
					label2.setText("pessoa cadastrada");
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}
		});
		button2.setBounds(76, 164, 145, 23);
		frmCadastroDePessoa.getContentPane().add(button2);
		
		//mostrar a janela
		frmCadastroDePessoa.setVisible(true);
	}
}
