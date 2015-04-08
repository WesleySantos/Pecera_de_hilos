package com.intec.construccion.pecera.system;

public class Tiburon extends Thread{

	private char sexo;
	
	public Tiburon(char sexo){
		this.setSexo(sexo);
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	@Override
	public void run(){
		
	}
}
