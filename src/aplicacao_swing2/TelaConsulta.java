package aplicacao_swing2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada2.Fachada2;

public class TelaConsulta extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnCriar;
	private JButton btnPessoasComN;
	private JButton btnTelefonesPorPrefixo;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem window = new TelaListagem();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TelaConsulta() {
		setTitle("Consultar");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 655, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnCriar = new JButton("Usuarios por parte do nome");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String nom = JOptionPane.showInputDialog("digite parte do nome");
					textArea.setText(Fachada2.consultarUsuarioPorParteNome(nom));
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(429, 13, 210, 23);
		contentPane.add(btnCriar);

		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(20, 11, 399, 160);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);
		
		btnPessoasComN = new JButton("Usuarios com N pedidos");
		btnPessoasComN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = Integer.parseInt( JOptionPane.showInputDialog("quantos pedidos?") );
				textArea.setText(Fachada2.consultarPessoasNPedidos(n));

			}
		});
		btnPessoasComN.setBounds(429, 47, 210, 23);
		contentPane.add(btnPessoasComN);
		
		btnTelefonesPorPrefixo = new JButton("Pedidos por produto");
		btnTelefonesPorPrefixo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prefixo = JOptionPane.showInputDialog("digite o produto");
				textArea.setText(Fachada2.consultarPedidoPorProduto(prefixo));

			
			}
		});
		btnTelefonesPorPrefixo.setBounds(429, 81, 210, 23);
		contentPane.add(btnTelefonesPorPrefixo);
	}
}
