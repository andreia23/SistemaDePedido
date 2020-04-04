//package Modelo2;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//
//
//
//public class Usuario1 {
//		
//		private String   nomeUsuario;
//		private String   cpf;
//		private String   sexo;
//		private Long     fone;
//		private LocalDate datanasc;
//		private Endereco endereco;
//		private String   email;
////		private String   nomeLogin;
//		private String   senha;
//		private Boolean  bloqueado;
//		private ArrayList<Pedido> pedidos= new ArrayList<Pedido>();
//		
//		
//
//		public Usuario(String nomeUsuario, String cpf, LocalDate datanasc, String email, String senha) {
//			super();
//			this.nomeUsuario = nomeUsuario;
//			this.cpf = cpf;
//			this.datanasc = datanasc;
//			this.email = email;
//			this.senha = senha;
//		}
//
//		public String getNomeUsuario() {
//			return nomeUsuario;
//		}
//		
//		public void setNomeUsuario(String nomeUsuario) {
//			this.nomeUsuario = nomeUsuario;
//		}
//		
//		public String getCpf() {
//			return cpf;
//		}
//		
//		public void setCpf(String cpf) {
//			this.cpf = cpf;
//		}
//		
//		public String getSexo() {
//			return sexo;
//		}
//		
//		public void setSexo(String sexo) {
//			this.sexo = sexo;
//		}
//		
//		public Long getFone() {
//			return fone;
//		}
//		
//		public void setFone(Long fone) {
//			this.fone = fone;
//		}
//		
//		public LocalDate getDatanasc() {
//			return datanasc;
//		}
//		
//		public void setDatanasc(LocalDate datanasc) {
//			this.datanasc = datanasc;
//		}
//
//		public Endereco getEndereco() {
//			return endereco;
//		}
//		
//		public void setEndereco(Endereco endereco) {
//			this.endereco = endereco;
//		}
//		
//		public String getEmail() {
//			return email;
//		}
//		
//		public void setEmail(String email) {
//			this.email = email;
//		}
//		
////		public String getNomeLogin() {
////			return nomeLogin;
////		}
////		
////		public void setNomeLogin(String nomeLogin) {
////			this.nomeLogin = nomeLogin;
////		}
//		
//		public String getSenha() {
//			return senha;
//		}
//		
//		public void setSenha(String senha) {
//			this.senha = senha;
//		}
//		
//		public Boolean getBloqueado() {
//			return bloqueado;
//		}
//		
//		public void setBloqueado(Boolean bloqueado) {
//			this.bloqueado = bloqueado;
//		}
//		
//		public void adicionar(Pedido p){
//			p.setUsuario(this);
//			this.pedidos.add(p);
//		}
//
//		public void remover(Pedido p){
//			p.setUsuario(null);
//			this.pedidos.remove(p);
//		}
//		
//
//		public Pedido localizar(String usu){
//			for(Pedido p : pedidos)
//				if (p.getCodigoPedido().equals(usu))
//					return p;
//			return null;
//		}
//		
//		public ArrayList<Pedido> getPedidos() {
//			return pedidos;
//		}
//
//
//		
//		@Override
//		public String toString() {
//			String classe = getClass().getSimpleName() + ":";
//			String texto =  String.format("%10s", classe)      + 
//					" nome=" + String.format("%5s",nomeUsuario)+
//					", cpf=" + String.format("%5s",cpf)        +
//					", data de nascimento=" + datanasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))+
//					", email=" + String.format("%5s",email)+
//					", senha=" + String.format("%5s",senha);
//					
//			return texto;
////
////			texto += ", pedidos:";
////			for(Pedido p : pedidos)
////				texto+= p.getCodigoPedido() + ", ";
//
//			
//		}
//		
//}
