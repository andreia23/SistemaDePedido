package Modelo2;

public class PedidoItem {

		private Integer codPedidoItem;
		private Pedido  pedido;
		private Integer quantidadeItem;
		private Float   valorItem;
		private Produto produto;
		
		
		public PedidoItem(Integer codPedidoItem, Pedido pedido, Integer quantidadeItem, Produto produto) {
			super();
			this.codPedidoItem = codPedidoItem + 1;
			this.pedido = pedido;
			this.quantidadeItem = quantidadeItem;
			this.produto = produto;
		}


		public Pedido getPedido() {
			return pedido;
		}
		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}
		
		public Integer getCodPedidoItem() {
			return codPedidoItem;
		}
		public void setCodPedidoItem(Integer codPedidoItem) {
			this.codPedidoItem = codPedidoItem;
		}
		
		public Integer getQuantidadeItem() {
			return quantidadeItem;
		}
		public void setQuantidadeItem(Integer quantidadeItem) {
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
		
		
		@Override
		public String toString() {
			String classe = getClass().getSimpleName() + ":";
			String texto =  String.format("%5s", classe)+ 
					" CodigoItem = "+ codPedidoItem + 
					"  Pedido = "+ String.format("%1s",pedido.getCodigoPedido())+
					"  Quantidade = "+ quantidadeItem +
					"  Produto = "+ produto.getNomeProduto();	
			return texto;
		}

}
