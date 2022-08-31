package control;

import java.util.Calendar;
import java.util.Date;

import model.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public SintomaFisico[] getFisicos() {
		return this.d.getFisicos();
	}
	
	public int getQtdFisicos() {
		return this.d.getQtdFisicos();
	}
	
	public int getQtdMentais() {
		return this.d.getQtdMentais();
	}
	
	public SintomaMental[] getMentais() {
		return this.d.getMentais();
	}
	
	public Pessoa[] getPessoas() {
		return this.d.getPessoas();
	}

	public Ciclo[] getCiclos() {
		return this.d.getCiclos();
	}
	
	public int getQtdCiclos() {
		return this.d.getQtdCiclos();
	}


	public boolean inserirEditarMental(String[] dadosMentais) {
		if(!dadosMentais[3].matches("[0-9]+") || !dadosMentais[4].matches("[0-9]+") || 
				!dadosMentais[5].matches("[0-9]+") || !dadosMentais[6].matches("[0-9]+")) {
			return false;
		} else {
				SintomaMental m = new SintomaMental(dadosMentais[1], Integer.parseInt(dadosMentais[2]), 
						dadosMentais[3], Integer.parseInt(dadosMentais[4])); 
				d.inserirEditarMental(m,Integer.parseInt(dadosMentais[0]));
				return true;
		}
	}
	// a posicao 0 do vetor dadosAlunos indica onde os dados devem ser inseridos
	public boolean inserirEditarFisicos(String[] dadosFisicos) {
		if(!dadosFisicos[3].matches("[0-9]+") || !dadosFisicos[4].matches("[0-9]+") || 
				!dadosFisicos[5].matches("[0-9]+") || !dadosFisicos[6].matches("[0-9]+")) {
			return false;
		} else {
				SintomaFisico f = new SintomaFisico(dadosFisicos[1], dadosFisicos[2], Integer.parseInt(dadosFisicos[3]), 
						dadosFisicos[4], Integer.parseInt(dadosFisicos[5]));
				d.inserirEditarFisico(f, Integer.parseInt(dadosFisicos[0]));
				return true;
		}
	}
	
	public boolean removerMental(int i) {
		int qtdCiclos = d.getQtdCiclos();
		String mentalRemovido = d.getMentais()[i].getNomeMental();
		String aux;
		for (int j = 0; j < qtdCiclos; j++) { 
			aux = d.getCiclos()[j].getSintomaMental().getNomeMental();
			if(mentalRemovido.compareTo(aux) == 0) 
				return false; //n�o � poss�vel remover aluno pois ele est� matriculado em um curso
		}
		
		if(i == (d.getQtdMentais() - 1)) { // O aluno a ser removido est� no final do array
			d.setQtdMentais(d.getQtdMentais() - 1);
			d.getMentais()[d.getQtdMentais()] = null;
			return true;
		} else { // o aluno a ser removido est� no meio do array
			int cont = 0;
			while(d.getMentais()[cont].getNomeMental().compareTo(mentalRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdMentais() - 1; j++) {
				d.getMentais()[j] = null;
				d.getMentais()[j] = d.getMentais()[j+1];
			}
			d.getMentais()[d.getQtdMentais()] = null;
			d.setQtdMentais(d.getQtdMentais() - 1);
			return true;
		}
	}
	
	public boolean removerFisico(int i) {
		int qtdCiclos = d.getQtdCiclos();
		String fisicoRemovido = d.getFisicos()[i].getNomeFisico();
		String aux;
		for (int j = 0; j < qtdCiclos; j++) {
			aux = d.getCiclos()[j].getSintomaFisico().getNomeFisico();
			if(fisicoRemovido.compareTo(aux) == 0) 
				return false;
			//n�o � poss�vel remover professor pois ele � respons�vel por um curso
		}
		if(i == (d.getQtdFisicos() - 1)) { // O prof a ser removido est� no final do array
			d.setQtdFisicos(d.getQtdFisicos() - 1);
			d.getFisicos()[d.getQtdFisicos()] = null;
			return true;
		} else { // o prof a ser removido est� no meio do array
			int cont = 0;
			while(d.getFisicos()[cont].getNomeFisico().compareTo(fisicoRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQtdFisicos() - 1; j++) {
				d.getFisicos()[j] = null;
				d.getFisicos()[j] = d.getFisicos()[j+1];
			}
			d.getFisicos()[d.getQtdFisicos()] = null;
			d.setQtdFisicos(d.getQtdFisicos() - 1);
			return true;
		}
	}

	
}
