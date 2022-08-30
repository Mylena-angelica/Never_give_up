package model;


import java.util.Date;

public class SintomaMental extends Sintoma {
	
	public String nomeMental;
	
	
	
	
	public SintomaMental(String n, int i, Date d, int nu) {
		this.nomeMental = n;
		this.intensidade=i;
		this.cadastro=d;
		this.numSintomas= nu;
		
				
	}
	
	@Override
		public String toString() {
		return "Nome do sintoma mental: " + nomeMental ;
	}


	public String getNomeMental() {
		return nomeMental;
	}
	public void setNomeMental(String nomeMental) {
		this.nomeMental = nomeMental;
	}
	
@Override
	public int getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(int intensidade) {
		this.intensidade = intensidade;
	}

	public Date getCadastro() {
		return cadastro;
	}
	public void setCadastro(Date cadastro) {
		this.cadastro= cadastro;
	}
	
	}

