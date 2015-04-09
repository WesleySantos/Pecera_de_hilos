package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.Random;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {

	public static void main(String[] args) {
		MarcoPecera marco = new MarcoPecera("la real pecera");		
		marco.addLabelAnimal("pez", 'M', spawnPoint());
	}
	
	//genera un punto random en las coordenadas X, Y
	private static Point spawnPoint(){
		int X = randInt(1,1299);
		int Y = randInt(1,699);
		
		Point punto = new Point(X,Y);
		
		return punto;
	}

	//genera un numero random entre el rango max ~ min
	private static int randInt(int min, int max) {
		Random rand = new Random();
		
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
