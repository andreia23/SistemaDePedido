package Modelo2;

public class Produto {

//		private Integer    codProduto;
		private String  nomeProduto;
		private Boolean bloqueado;
		private Float   valorProduto;
		
		
		public Produto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}

//		public Long getCodProduto() {
//			return codProduto;
//		}
//		public void setCodProduto(Long codProduto) {
//			this.codProduto = codProduto;
//		}
		public String getNomeProduto() {
			return nomeProduto;
		}
		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}
		public Boolean getBloqueado() {
			return bloqueado;
		}
		public void setBloqueado(Boolean bloqueado) {
			this.bloqueado = bloqueado;
		}
		public Float getValorProduto() {
			return valorProduto;
		}
		public void setValorProduto(Float valorProduto) {
			this.valorProduto = valorProduto;
		}
		

		@Override
		public String toString() {
			String classe = getClass().getSimpleName() + ":";
			String texto =  String.format("%5s", classe)+ 
//					" CodigoProduto = "+ codProduto + 
					"  NomeProduto = "+ nomeProduto;
			
			return texto;
			
		}

		
}										
