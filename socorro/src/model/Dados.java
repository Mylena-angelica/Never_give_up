package model;

import java.util.*;

public class Dados {
	private  Pessoa[] pessoas = new Pessoa[50];
	private int qtdPessoas = 1;
	private Ciclo [] ciclos = new Ciclo[50];
	private int qtdCiclos = 0;
	private SintomaFisico[] fisicos = new SintomaFisico[50];
	private int qtdFisicos = 0;
	private SintomaMental[] mentais = new SintomaMental[50];
	private int qtdMentais = 0;
	
	
	
	public void fillWithSomeData() {
		Date d = Calendar.getInstance().getTime();
		for(int i = 0; i < 5; i++) {
			pessoas[i] = new Pessoa();
			fisicos[i] = new SintomaFisico("Sintoma"+i, "Local do corpo"+i, i, d, i);
			mentais[i] = new SintomaMental("Sintoma"+i, i, d, i);
			ciclos[i] = new Ciclo(pessoas[i],d,d,i, mentais[i], fisicos[i]);
						
		}
		
		qtdFisicos = 5;
		qtdMentais = 4;
		qtdPessoas = 1;
		qtdCiclos = 1;
		
	}
	
	public Pessoa[] getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(Pessoa[] pessoas) {
		this.pessoas = pessoas;
	}
	
	public final int getQtdPessoas() {
		return qtdPessoas;
	}

	public final void setQtdPessoas(int qtdPessoas) {
		this.qtdPessoas = qtdPessoas;
	}
	
	public Ciclo[] getCiclos() {
		return ciclos;
	}
	public void setCiclos(Ciclo[] ciclos) {
		this.ciclos = ciclos;
	}
	public void inserirEditarCiclo( Ciclo c, int pos) {
		this.ciclos[pos] = c;
		if(pos == qtdCiclos) qtdCiclos++;
	}
	
	public int getQtdCiclos() {
		return qtdCiclos;
	}
	public void setQtdCiclos(int qtdCiclos) {
		this.qtdCiclos = qtdCiclos;
	}
	
		
	public SintomaFisico[] getFisicos() {
		return fisicos;
	}
	
	public void setFisicos(SintomaFisico[] fisicos) {
		this.fisicos = fisicos;
	}
	public void inserirEditarFisico( SintomaFisico f, int pos) {
		this.fisicos[pos] = f;
		if(pos == qtdFisicos) qtdFisicos++;
	}
	
	
	public int getQtdFisicos() {
		return qtdFisicos;
	}
	public void setQtdFisicos(int qtdFisicos) {
		this.qtdFisicos = qtdFisicos;
	}

	

	public final SintomaMental[] getMentais() {
		return mentais;
	}

	public final void setMentais(SintomaMental[] mentais) {
		this.mentais = mentais;
	}

	public final int getQtdMentais() {
		return qtdMentais;
	}

	public final void setQtdMentais(int qtdMentais) {
		this.qtdMentais = qtdMentais;
	}
	
	public void inserirEditarMental( SintomaMental m, int pos) {
		this.mentais[pos] = m;
		if(pos == qtdMentais) qtdMentais++;
	}
	
	

}

