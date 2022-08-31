package control;


import java.util.Date;

import model.*;

public class ControlePessoa{
	private Pessoa[] p;
	
	
	public ControlePessoa(ControleDados d) {
		p = d.getPessoas();
		
		
	}
		
	public String getNome(int i) {		
		return p[i].getNome();
	}
	
	public Date getNascimento(int i) {
		return p[i].getNascimento();
	}
	
	
	
	
}

