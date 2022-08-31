package control;


import java.util.Date;

import model.*;

public class ControleCiclo{
	private Ciclo[] c;
	private int qtdCiclos;
	
	public ControleCiclo(ControleDados d) {
		c = d.getCiclos();
		qtdCiclos = d.getQtdCiclos();
		
	}
	
	public String[] getNumero() {
		String[] s = new String[qtdCiclos];
		for(int i = 1; i < qtdCiclos; i++) {
			s[i] = c[i].getNumero();
		}
		
		return s;
	}


	public int getQtdCiclos() {
		return qtdCiclos;
	}

	public void setQtdCiclos(int qtdCiclos) {
		this.qtdCiclos = qtdCiclos;
	}
	
	public Pessoa getPessoa(int i) {		
		return c[i].getPessoa();
	}
	
	public SintomaFisico getSintomaFisico(int i) {
		return c[i].getSintomaFisico();
	}
	public SintomaMental getSintomaMental(int i) {
		return c[i].getSintomaMental();
	}
	
	public Date getDataInicioMenstruacao(int i) {
			return c[i].getDataInicioMenstruacao();
		}
	public Date getDataFinalMenstruacao(int i) {
		return c[i].getDataFinalMenstruacao();
	}
	public int getDuracaoCiclo(int i) {
		return c[i].getDuracaoCiclo();
	}
	public String getNumero(int i) {
		return c[i].getNumero();
	}
		
	
	
	
}

