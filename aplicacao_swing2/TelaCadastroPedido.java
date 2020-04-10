package aplicacao_swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada2.Fachada2;

public class TelaCadastroPedido {

	private JFrame frmCadastroDeTelefone;
	private JLabel label1;
	private JLabel label2;

	private JLabel lb1UF;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblRua;
	private JLabel lblNumero;
	
	private JTextField UfField ;
	private JTextField cidadeField ;
	private JTextField bairroField;
	private JTextField ruaField ;
	private JTextField numeroField;
	
	
	private JButton button2;
	private JButton button3;
	

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
	public TelaCadastroPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmCadastroDeTelefone = new JFrame();
		frmCadastroDeTelefone.setTitle("Cadastro de Pedido");
		frmCadastroDeTelefone.setBounds(100, 100, 309, 280);
		frmCadastroDeTelefone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeTelefone.getContentPane().setLayout(null);
		
		label1 = new JLabel("ENDEREÇO DE ENTREGA");
		label1.setBounds(70, 11, 180, 14);
		frmCadastroDeTelefone.getContentPane().add(label1);
				
		//UF
		lb1UF = new JLabel("UF:");
		lb1UF.setBounds(25, 55, 46, 14);
		frmCadastroDeTelefone.getContentPane().add(lb1UF);
	
		//CAMPO UF
		UfField = new JTextField();
		UfField .setBounds(65, 51, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(UfField );
		UfField .setColumns(10);
		
		//CIDADE
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(25, 78, 78, 14);
		frmCadastroDeTelefone.getContentPane().add(lblCidade);
		
		// CAMPO CIDADE
		cidadeField = new JTextField();
		cidadeField .setColumns(10);
		cidadeField .setBounds(75, 75, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(cidadeField );
		
		//BAIRRO
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(25, 102, 110, 14);
		frmCadastroDeTelefone.getContentPane().add(lblBairro);
				
		// CAMPO BAIRRO
		bairroField= new JTextField();
		bairroField.setColumns(10);
		bairroField.setBounds(75, 99, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(bairroField);
		
		//RUA
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(25, 125, 142, 14);
		frmCadastroDeTelefone.getContentPane().add(lblRua);
				
		// CAMPO RUA
		ruaField = new JTextField();
		ruaField .setColumns(10);
		ruaField .setBounds(75, 123, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(ruaField );
		
		//NUMERO
		lblNumero = new JLabel("N°:");
		lblNumero.setBounds(25, 149, 174, 14);
		frmCadastroDeTelefone.getContentPane().add(lblNumero);
					
		// CAMPO NUMERO
		numeroField= new JTextField();
		numeroField.setColumns(10);
		numeroField.setBounds(75, 147, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(numeroField);
		
		label2 = new JLabel("");
		label2.setBounds(20, 220, 189, 14);
		frmCadastroDeTelefone.getContentPane().add(label2);
		
		
		
		//BOTÃO PARA REALIZAR PEDIDO
		button2 = new JButton("Realizar Pedido");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String uf = UfField.getText();
					String cidade = cidadeField.getText();
					String bairro = bairroField.getText();
					String rua = ruaField.getText();
					String numero = numeroField.getText();
					Fachada2.realizarPedido(uf, cidade, bairro, rua, numero);
					TelaCadastroItens j = new TelaCadastroItens();
//					label2.setText("Pedido realizado");
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}

		});
		
		button2.setBounds(10, 193, 123, 23);
		frmCadastroDeTelefone.getContentPane().add(button2);
		
		//BOTÃO PARA VER PEDIDOS DO USUARIO LOGADO
		button3 = new JButton("Meus Pedidos");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					TelaPedidos j = new TelaPedidos();
					j.setVisible(true);
					
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}

		});
		button3.setBounds(158, 193, 123, 23);
		frmCadastroDeTelefone.getContentPane().add(button3);
		
		
		//mostrar a janela
		frmCadastroDeTelefone.setVisible(true);
	}
}
