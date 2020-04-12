package Modelo2;

import java.time.LocalDate;
import java.util.ArrayList;


public class Pedido {
		
//		private static int sequence = 0;

		private Integer codigoPedido;
		private Usuario  usuario;
		private Endereco enderecoEntrega;
		private String   status;
		private Float    valorPedido;
		private Float    valorTaxa;
		private Float    valorTotal;
		private LocalDate     dataPedido;
		private ArrayList<PedidoItem> itens= new ArrayList<PedidoItem>();
		
		
		public Pedido(Integer codigoPedido,Usuario usuario, Endereco enderecoEntrega) {
			this.codigoPedido = codigoPedido;
			this.usuario = usuario;
			this.enderecoEntrega = enderecoEntrega;
		}
		
		public Integer getCodigoPedido() {
			return codigoPedido;
		}
		public void setCodigoPedido(Integer codigoPedido) {
			this.codigoPedido = codigoPedido;
		}
		public Usuario getUsuario() {
			return usuario;
		}
		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}
		public Endereco getEnderecoEntrega() {
			return enderecoEntrega;
		}
		public void setEnderecoEntrega(Endereco enderecoEntrega) {
			this.enderecoEntrega = enderecoEntrega;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Float getValorPedido() {
			return valorPedido;
		}
		public void setValorPedido(Float valorPedido) {
			this.valorPedido = valorPedido;
		}
		public Float getValorTaxa() {
			return valorTaxa;
		}
		public void setValorTaxa(Float valorTaxa) {
			this.valorTaxa = valorTaxa;
		}
		
		public Float getValorTotal() {
			return valorTotal;
		}
		
		public void setValorTotal(Float valorTotal) {
			this.valorTotal = valorTotal;
		}
		
		public LocalDate getDataPedido() {
			return dataPedido;
		}
		
		public void setDataPedido(LocalDate dataPedido) {
			this.dataPedido = dataPedido;
		
		}
		public void adicionar(PedidoItem p){
			p.setPedido(this);
			this.itens.add(p);
		}

		public void remover(PedidoItem p){
			p.setPedido(null);
			this.itens.remove(p);
		}
		
		
		public PedidoItem localizar(Integer num){
			for(PedidoItem p : itens) {
				if (p.getCodPedidoItem().equals(num))
					return p;
			}
			return null;
		}
		
		
		public ArrayList<PedidoItem> getItens() {
			return itens;
		}

	
		@Override
		public String toString() {
					String classe = getClass().getSimpleName() + ":";
					String texto =  String.format("%5s", classe)+ 
							" CodigoPedido = "+ codigoPedido + 
							"  Usuario = "+ String.format("%5s",usuario.getCpf())+
							   "  "+enderecoEntrega;
					
					texto += ", Itens:";
					for(PedidoItem p : itens)
						texto+= p.getCodPedidoItem() + ", ";

					return texto;
		}

		
}
