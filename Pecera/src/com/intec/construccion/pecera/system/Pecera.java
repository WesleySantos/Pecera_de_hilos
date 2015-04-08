package com.intec.construccion.pecera.system;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {

	public static void main(String[] args) {
		new MarcoPecera("la real pecera");
		Pez pez1 = new Pez('M');
		pez1.start();
	}

}
