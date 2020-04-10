package aplicacao_swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada2.Fachada2;

public class TelaCadastroItens {

	private JFrame frmCadastroDeTelefone;
	private JLabel label1;
	private JTextField textField;
	private JButton button2;
	private JButton button3;
	private JLabel label2;
	private JLabel lblNumero;
	private JTextField textField_1;

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
	public TelaCadastroItens() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeTelefone = new JFrame();
		frmCadastroDeTelefone.setTitle("Cadastro de Itens");
		frmCadastroDeTelefone.setBounds(100, 100, 309, 180);
		frmCadastroDeTelefone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroDeTelefone.getContentPane().setLayout(null);
		
		//PRODUTO
		label1 = new JLabel("Produto:");
		label1.setBounds(25, 11, 60, 14);
		frmCadastroDeTelefone.getContentPane().add(label1);
		
		//CAMPO PRODUTO
		textField = new JTextField();
		textField.setBounds(78, 8, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(textField);
		textField.setColumns(10);
		
		//QUANTIDADE
		lblNumero = new JLabel("Quantidade:");
		lblNumero.setBounds(25, 39, 78, 14);
		frmCadastroDeTelefone.getContentPane().add(lblNumero);
		
		//CAMPO QUANTIDADE
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(98, 39, 86, 20);
		frmCadastroDeTelefone.getContentPane().add(textField_1);
		
		
		label2 = new JLabel("");
		label2.setBounds(25, 120, 189, 14);
		frmCadastroDeTelefone.getContentPane().add(label2);
		
		
		//BOTÃO PARA CADASTRAR ITEM		
		button2 = new JButton("Finalizar Pedido");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String produto = textField.getText();
					String numero = textField_1.getText();
					Integer num = Integer.parseInt(numero);
					Fachada2.selecionarItens(produto, num);
					label2.setText("Item cadastrado");
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}
		});
		button2.setBounds(10, 88, 124, 23);
		frmCadastroDeTelefone.getContentPane().add(button2);
		
		
		//BOTÃO PARA VER ITENS DO PEDIDO
		button3 = new JButton("Meus Itens");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					TelaItens j = new TelaItens();
					j.setVisible(true);
					
				}
				catch(Exception e) {
					label2.setText(e.getMessage());
				}
			}

		});
		button3.setBounds(158, 88, 124, 23);
		frmCadastroDeTelefone.getContentPane().add(button3);
		
		
		
		//mostrar a janela
		frmCadastroDeTelefone.setVisible(true);
	}
}