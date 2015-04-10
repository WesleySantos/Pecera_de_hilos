package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String NombrePecera = "Pecera de asesinatos";
	
	static JLabel[] labels;
	static ArrayList<Pez> listaPeces = new ArrayList<>();
	
	public static void main(String[] args) {
		
		MarcoPecera marco = new MarcoPecera(NombrePecera);
		
		 labels = new JLabel[3];
		
		
		for (int i = 0; i < 3; i++) {
			labels[i] = new JLabel();
			
			Pez pez1 = new Pez('M', labels[i], 100, spawnPoint());
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