package Modelo2;


import java.util.ArrayList;

public class Endereco {

		private Long   codEndereco;
		private String uf;
		private String cidade;
		private String bairro;
		private String rua;
		private String numero;
		private String cep;
		private ArrayList<Pedido> pedidos= new ArrayList<Pedido>();
		
		public Endereco(String uf,String cidade, String bairro, String rua, String numero) {
			super();
			this.uf = uf;
			this.cidade = cidade;
			this.bairro = bairro;
			this.rua = rua;
			this.numero = numero;
		}
		
		
//		public Endereco(String bairro, String rua, String numero) {
//			super();
//			this.bairro = bairro;
//			this.rua = rua;
//			this.numero = numero;
//		}


		public Long getCodEndereco() {
			return codEndereco;
		}
		public void setCodEndereco(Long codEndereco) {
			this.codEndereco = codEndereco;
		}
		public String getRua() {
			return rua;
		}
		public void setRua(String rua) {
			this.rua = rua;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		
		public ArrayList<Pedido> getPedidos() {
			return pedidos;
		}

		public void setPedidos(ArrayList<Pedido> pedidos) {
			this.pedidos = pedidos;
		}
		
//		String cidade, String bairro, String rua, String numero) {
		
		@Override
		public String toString() {
			String classe = getClass().getSimpleName() + ":";
			String texto =  String.format("%5s", classe)+ 
					" UF = "+ String.format("%2s",uf)+
					", Cidade = "+ String.format("%5s",cidade)+
					", Bairro = "+ String.format("%5s",bairro)+
					", Rua = "+ String.format("%5s",rua)+
					", N° = "+ String.format("%2s",numero);
//		
//			texto += ", pedidos:";
//			for(Pedido p : pedidos)
//				texto+= p.getCodigoPedido() + ", ";

			return texto;
		}
		
}
