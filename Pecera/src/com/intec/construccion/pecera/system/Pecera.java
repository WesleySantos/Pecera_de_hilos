package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String NombrePecera = "Pecera de asesinatos";
	private static int cntPez_hombre, cntPez_hembra;
	private static Scanner reader;
	
	static JLabel[] labelsPVaron;
	static JLabel[] labelsPHembra;
	
	static ArrayList<Pez> listaPeces = new ArrayList<>();
	static ArrayList<Pez> listaTiburones = new ArrayList<>();
	
	public static void main(String[] args) {
		
		MarcoPecera marco = new MarcoPecera(NombrePecera);
		
		reader = new Scanner(System.in); //	Instance of the scanner
		
		try 
		{
			System.out.println("Introduce la cantidad de peces hombres: ");
			cntPez_hombre = reader.nextInt();
			System.out.println("Introduce la cantidad de peces mujeres: ");
			cntPez_hembra = reader.nextInt();
			System.out.println("Ejecutando...");
			
		} catch (Exception e) {
			cntPez_hombre = 10;
			cntPez_hembra = 10;
			System.out.printf("La cantidad de peces va"
					+ "rones introducida es invalida, se"
					+ " ha definido por default los siguientes valores:\n"
					+ "Peces hombres: %i\n"
					+ "Peces hembras: %i\n",
					cntPez_hombre, cntPez_hembra);
		}
		
		labelsPVaron = new JLabel[cntPez_hombre + 1];
		labelsPHembra = new JLabel[cntPez_hembra + 1];
		 
		//	Insertando los peces hombres
		for (int i = 0; i < cntPez_hombre; i++) {

			labelsPVaron[i] = new JLabel();
			Pez pez1 = new Pez('M', labelsPVaron[i], 100, spawnPoint());
			
			listaPeces.add(pez1);
		}
		//	Insertando los peces hembras
		for (int i = 0; i < cntPez_hembra; i++) {
			
			labelsPHembra[i] = new JLabel();
			Pez pez2 = new Pez('F', labelsPHembra[i], 100, spawnPoint());
		
			listaPeces.add(pez2);
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