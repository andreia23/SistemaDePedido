package Modelo2;

public class PedidoItem {

		
		private Pedido  pedido;
		private Long    codPedidoItem;
		private Long    quantidadeItem;
		private Float   valorItem;
		private Produto produto;
		
		public PedidoItem() {
			super();
		}
		
		public Pedido getPedido() {
			return pedido;
		}
		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}
		
		public Long getCodPedidoItem() {
			return codPedidoItem;
		}
		public void setCodPedidoItem(Long codPedidoItem) {
			this.codPedidoItem = codPedidoItem;
		}
		
		public Long getQuantidadeItem() {
			return quantidadeItem;
		}
		public void setQuantidadeItem(Long quantidadeItem) {
			this.quantidadeItem = quantidadeItem;
		}
		
		public Float getValorItem() {
			return valorItem;
		}
		public void setValorItem(Float valorItem) {
			this.valorItem = valorItem;
		}
		public Produto getProduto() {
			return produto;
		}
		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		
		
		
		
		
}
