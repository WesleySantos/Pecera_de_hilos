package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String JLabelName = "Pecera de asesinatos";
	//Este es el nombre que va a tener el Frame de la pecera
	public static void main(String[] args) {
		MarcoPecera marco = new MarcoPecera("la real pecera");		
	//	MarcoPecera marco = new MarcoPecera(JLabelName);		
	//	marco.addLabelAnimal("pez", 'M', spawnPoint());
		
		ArrayList<Pez> listaPeces = new ArrayList<>(); 
		JLabel label = new JLabel("");

		for (int i = 0; i < 5; i++) {
			Pez pez1 = new Pez('M', label, 200, spawnPoint());
			listaPeces.add(pez1);
		}
		
		marco.addLabelAnimal(listaPeces);
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