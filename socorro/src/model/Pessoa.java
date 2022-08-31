package model;

import java.util.Date;

/**
 * Recebe os dados gerais de pessoa, além de editar esses dados.
 * @author Mylena e Sabrina. 
 */

public class Pessoa {
	public String nome;
	public Date nascimento;
		
	
	public Pessoa(String n, Date nc) {
		nome=n;
		nascimento=nc;
		
		
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

	

	//Talvez seja melhor na controle
	
	public void editarDados(String nome, Date nascimento, String senha) {
		this.setNome(nome);
		this.setNascimento(nascimento);		
		
		
	}
}
