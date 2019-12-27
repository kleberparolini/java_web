package br.com.alura.financas.modelo;

	import java.util.List;

import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.OneToMany;

	@Entity
	public class Conta {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		public void setId(Integer id) {
			this.id = id;
		}

		private String agencia;
		private String numero;
		private String banco;
		private String titular;
		
		@OneToMany(mappedBy = "conta")
		private List<Movimentacao> movimentacoes;
		
		public Conta() {}
		
		public Conta(Integer id) {
			this.id = id;
		}
		
		public int getId() {
			return id;
		}
		public String getAgencia() {
			return agencia;
		}
		public void setAgencia(String agencia) {
			this.agencia = agencia;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String conta) {
			this.numero = numero;
		}
		public String getBanco() {
			return banco;
		}
		public void setBanco(String banco) {
			this.banco = banco;
		}
		public String getTitular() {
			return titular;
		}
		public void setTitular(String titular) {
			this.titular = titular;
		}
		
		@Override
		public String toString() {
			return "Titular: " + this.titular + "\nAgencia: " + 
					this.agencia + "\nConta: " + this.numero;
		}
		
		public List<Movimentacao> getMovimentacoes() {
			return movimentacoes;
		}

	}