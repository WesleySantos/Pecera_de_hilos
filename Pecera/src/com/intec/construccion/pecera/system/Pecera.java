package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String NombrePecera = "Pecera de asesinatos";
	
	private static int cntPez_hombre, cntPez_hembra,
						cntTiburones_hombre, cntTiburones_hembra;
	
	static JLabel[] labelsPVaron;
	static JLabel[] labelsPHembra;
	
	static ArrayList<Pez> listaPeces = new ArrayList<>();
	static ArrayList<Tiburon> listaTiburones = new ArrayList<>();
	
	public static void main(String[] args) {
		
		MarcoPecera marco = new MarcoPecera(NombrePecera);
		
		//new Scanner(System.in);
		
		try 
		{
			//Using GUI	
			boolean flag = true;
			String firstNumber = null, secondNumber = null;
			
			while ( flag ) {
				firstNumber = JOptionPane.showInputDialog("Introduce la cantidad de peces hombres:");
				if ( isNumber(firstNumber) ) {
					flag = false;
				}
				if ( !flag && !(firstNumber.length() == 0) ) {
					secondNumber = JOptionPane.showInputDialog("Introduce la cantidad de peces mujeres:");
					if ( !isNumber(secondNumber)) {
						flag = true;
					}
				}
				if ( flag  || firstNumber.length() == 0 || secondNumber.length() == 0) {
					JOptionPane.showMessageDialog(null, "Uno de los numeros introducidos contiene un formato invalido, intente otra vez");
					flag = true;
				}
			}
			cntPez_hombre = Integer.parseInt(firstNumber);
			cntPez_hembra = Integer.parseInt(secondNumber);
			
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
		 
		//	Obteniendo la cantidad de tiburones machos y hembras
		
		try 
		{
			//Using GUI	
			boolean flag = true;
			String firstNumber = null, secondNumber = null;
			
			while ( flag ) {
				firstNumber = JOptionPane.showInputDialog("Introduce la cantidad de tiburones hombres:");
				if ( isNumber(firstNumber) ) {
					flag = false;
				}
				if ( !flag && !(firstNumber.length() == 0) ) {
					secondNumber = JOptionPane.showInputDialog("Introduce la cantidad de tiburones mujeres:");
					if ( !isNumber(secondNumber)) {
						flag = true;
					}
				}
				if ( flag  || firstNumber.length() == 0 || secondNumber.length() == 0) {
					JOptionPane.showMessageDialog(null, "Uno de los numeros introducidos contiene un formato invalido, intente otra vez");
					flag = true;
				}
			}
			cntTiburones_hombre = Integer.parseInt(firstNumber);
			cntTiburones_hembra = Integer.parseInt(secondNumber);
			
		} catch (Exception e) {
			cntTiburones_hombre = 10;
			cntTiburones_hembra = 10;
			System.out.printf("La cantidad de peces va"
					+ "rones introducida es invalida, se"
					+ " ha definido por default los siguientes valores:\n"
					+ "Tiburones hombres: %i\n"
					+ "Tiburones hembras: %i\n",
					cntPez_hombre, cntPez_hembra);
		}
		
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
		
		//agregando tiburones machos
		for (int i = 0; i < cntTiburones_hombre; i++) 
		{
			JLabel labeltiburon = new JLabel();
			Tiburon tiburon = new Tiburon('M', labeltiburon, 100, spawnPoint());
			
			listaTiburones.add(tiburon);
		}
		for (int i = 0; i < cntTiburones_hembra; i++) 
		{
			JLabel labeltiburon = new JLabel();
			Tiburon tiburon = new Tiburon('F', labeltiburon, 100, spawnPoint());
			
			listaTiburones.add(tiburon);
		}
		
		marco.addLabelPez(listaPeces);
		marco.addLabelTiburon(listaTiburones);
	}
	
	//genera un punto random en las coordenadas X, Y
	private static Point spawnPoint(){
		int X = randInt(10,1290);
		int Y = randInt(10, 690);
		
		Point punto = new Point(X,Y);
		
		return punto;
	}

	//genera un numero random entre el rango max ~ min
	private static int randInt(int min, int max) {
		Random rand = new Random();
		
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	//Chequea si un string es numerico
	private static boolean isNumber( String x ) {
		for ( int i = x.length()-1; i>=0; i-- ) {
			if ( x.charAt(i) > '9' || x.charAt(i) < '0') {
				return false;
			}
		}
		return true;
	}
}