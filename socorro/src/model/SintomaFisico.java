package model;

import java.util.Date;

public class SintomaFisico extends Sintoma {
	
	public String nomeFisico;
	public String local;
	
	
	
	public SintomaFisico(String n, String l, int i, Date d,int nu) {
		this.nomeFisico = n;
		this.local= l;
		this.intensidade=i;
		this.cadastro= d;
		this.numSintomas=nu;
		
				
	}
	@Override
		public String toString() {
		return "Nome do sintoma físico: " + nomeFisico + ",local:" + local;
	}


	public  String getNomeFisico() {
		return nomeFisico;
	}
	public  void setNomeFisico(String nomeFisico) {
		this.nomeFisico = nomeFisico;
	}
	public  String getLocal() {
		return local;
	}
	public  void setLocal(String local) {
		this.local = local;
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



