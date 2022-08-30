package model;

import java.util.Date;

public class Ciclo {
	
	private Pessoa pessoa;
	private Date dataInicioMenstruacao;
	private Date dataFinalMenstruacao;
	private int duracaoCiclo;
	private SintomaMental sintomaMental;
	private SintomaFisico sintomaFisico;
	
	
	
	public Ciclo(Pessoa p, Date i, Date f, int d, SintomaMental m, SintomaFisico s) {
		dataInicioMenstruacao = i;
		dataFinalMenstruacao = f;
		duracaoCiclo = d; 
		sintomaMental = m;
		sintomaFisico = s;
	}

	

	public void cadastrar() {
		int qtd;
		Ciclo c = this;
		SintomaFisico f = this.getSintomaFisico();
		qtd = f.getNumSintomas();
		f.setNumSintomas(qtd+1);
		SintomaMental m = this.getSintomaMental();
		qtd = m.getNumSintomas();
		m.setNumSintomas(qtd+1);
		c.setPessoa(pessoa);
		c.setDataFinalMenstruacao(dataFinalMenstruacao);
		c.setDataInicioMenstruacao(dataInicioMenstruacao);
		c.setDuracaoCiclo(qtd);
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public  Date getDataInicioMenstruacao() {
		return dataInicioMenstruacao;
	}


	public void setDataInicioMenstruacao(Date dataInicioMenstruacao) {
		this.dataInicioMenstruacao = dataInicioMenstruacao;
	}


	public  Date getDataFinalMenstruacao() {
		return dataFinalMenstruacao;
	}


	public void setDataFinalMenstruacao(Date dataFinalMenstruacao) {
		this.dataFinalMenstruacao = dataFinalMenstruacao;
	}

	public int getDuracaoCiclo() {
		return duracaoCiclo;
	}


	public  void setDuracaoCiclo(int duracaoCiclo) {
		this.duracaoCiclo = duracaoCiclo;
	}


	public  SintomaMental getSintomaMental() {
		return sintomaMental;
	}


	public void setSintomaMental(SintomaMental sintomaMental) {
		this.sintomaMental = sintomaMental;
	}


	public SintomaFisico getSintomaFisico() {
		return sintomaFisico;
	}

	public void setSintomaFisico(SintomaFisico sintomaFisico) {
		this.sintomaFisico = sintomaFisico;
	}


	
	public String toString() {
		return "Ciclo d@ " + pessoa.getNome() + "teve início em: " + dataInicioMenstruacao+ ", com duração de " + duracaoCiclo+
				". Assim " + dataFinalMenstruacao+ "foi o último dia.";
	}

	
}