package model;

import java.util.Date;

public class Pessoa {
	public String nome;
	public Date nascimento;
	
	
	public Pessoa() {
		
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	
}
