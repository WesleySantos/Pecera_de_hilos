package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String NombrePecera = "Pecera de asesinatos";
	
	static JLabel[] labelsPVaron;
	static JLabel[] labelsPHembra;
	
	static ArrayList<Pez> listaPeces = new ArrayList<>();
	static ArrayList<Tiburon> listaTiburones = new ArrayList<>();
	
	public static void main(String[] args) {
		
		MarcoPecera marco = new MarcoPecera(NombrePecera);
		
		labelsPVaron = new JLabel[10];
		labelsPHembra = new JLabel[10];
		 
		for (int i = 0; i < 10; i++) {
			labelsPVaron[i] = new JLabel();
			Pez pez1 = new Pez('M', labelsPVaron[i], 100, spawnPoint());
			
			labelsPHembra[i] = new JLabel();
			Pez pez2 = new Pez('F', labelsPHembra[i], 100, spawnPoint());
			
			listaPeces.add(pez1);
			listaPeces.add(pez2);

		}
		
		//agregando tiburones manualmente
		JLabel labeltibu1 = new JLabel();
		JLabel labeltibu2 = new JLabel();
		JLabel labeltibu3 = new JLabel();
		
		Tiburon tibu1 = new Tiburon('M', labeltibu1, 100, spawnPoint());
		Tiburon tibu2 = new Tiburon('M', labeltibu2, 100, spawnPoint());
		Tiburon tibu3 = new Tiburon('F', labeltibu3, 100, spawnPoint());
		
		listaTiburones.add(tibu1);
		listaTiburones.add(tibu2);
		listaTiburones.add(tibu3);
		
		
		marco.addLabelPez(listaPeces);
		marco.addLabelTiburon(listaTiburones);
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