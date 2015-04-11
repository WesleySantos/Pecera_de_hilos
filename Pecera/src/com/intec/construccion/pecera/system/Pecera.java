package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pecera {
	
	private final static String NombrePecera = "Pecera de los inmortales";
	private static int cntPez_hombre, cntPez_hembra;
	static JLabel[] labelsPVaron;
	static JLabel[] labelsPHembra;
	
	static ArrayList<Pez> listaPeces = new ArrayList<>();
	static ArrayList<Tiburon> listaTiburones = new ArrayList<>();
	
	static MarcoPecera marco;
	
	public static void main(String[] args) {
		
		 marco = new MarcoPecera(NombrePecera);
		
		//new Scanner(System.in);
		
		try 
		{
			/*
			System.out.println("Introduce la cantidad de peces hombres: ");
			cntPez_hombre = reader.nextInt();
			System.out.println("Introduce la cantidad de peces mujeres: ");
			cntPez_hembra = reader.nextInt();
			System.out.println("Ejecutando...");
			*/
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
		
		//agregando tiburones manualmente
		JLabel labeltibu1 = new JLabel();
		JLabel labeltibu2 = new JLabel();
		JLabel labeltibu3 = new JLabel();
		JLabel labeltibu4 = new JLabel();
		JLabel labeltibu5 = new JLabel();
		JLabel labeltibu6 = new JLabel();
		
		Tiburon tibu1 = new Tiburon('M', labeltibu1, 100, spawnPoint());
		Tiburon tibu2 = new Tiburon('M', labeltibu2, 100, spawnPoint());
		Tiburon tibu3 = new Tiburon('F', labeltibu3, 100, spawnPoint());
		Tiburon tibu4 = new Tiburon('M', labeltibu4, 100, spawnPoint());
		Tiburon tibu5 = new Tiburon('M', labeltibu5, 100, spawnPoint());
		Tiburon tibu6 = new Tiburon('F', labeltibu6, 100, spawnPoint());
		
		listaTiburones.add(tibu1);
		listaTiburones.add(tibu2);
		listaTiburones.add(tibu3);
		listaTiburones.add(tibu4);
		listaTiburones.add(tibu5);
		listaTiburones.add(tibu6);
		

		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel label4 = new JLabel();
		JLabel label5 = new JLabel();
		JLabel label6 = new JLabel();
		JLabel label7 = new JLabel();
		JLabel label8 = new JLabel();
		
		Pez pez3 = new Pez('M', label1, 100, spawnPoint());
		pez3.setNumero(1);
		Pez pez4 = new Pez('M', label2, 100, spawnPoint());
		pez4.setNumero(2);
		Pez pez5 = new Pez('M', label3, 100, spawnPoint());
		pez5.setNumero(3);
		Pez pez6 = new Pez('M', label4, 100, spawnPoint());
		pez6.setNumero(4);
		
		/*Pez pez7 = new Pez('F', label5, 100, spawnPoint());
		pez7.setNumero(5);
		Pez pez8 = new Pez('F', label6, 100, spawnPoint());
		pez8.setNumero(6);
		Pez pez9 = new Pez('F', label7, 100, spawnPoint());
		pez9.setNumero(7);
		Pez pez10 = new Pez('F', label8, 100, spawnPoint());
		pez10.setNumero(8);
		*/

		/*marco.parteAgua.add(marco.definirLabel(pez3.getLabel(), 'P', pez3.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez4.getLabel(), 'P', pez4.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez5.getLabel(), 'P', pez5.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez6.getLabel(), 'P', pez6.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez7.getLabel(), 'P', pez7.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez8.getLabel(), 'P', pez8.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez9.getLabel(), 'P', pez9.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez10.getLabel(), 'P', pez10.getSexo()));
		*/
		listaPeces.add(pez3);
		listaPeces.add(pez4);
		listaPeces.add(pez5);
		listaPeces.add(pez6);
		/*listaPeces.add(pez7);
		listaPeces.add(pez8);
		listaPeces.add(pez9);
		listaPeces.add(pez10);
		*/
		
		/*marco.parteAgua.add(marco.definirLabel(pez3.getLabel(), 'P', pez3.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez4.getLabel(), 'P', pez4.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez5.getLabel(), 'P', pez5.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez6.getLabel(), 'P', pez6.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez7.getLabel(), 'P', pez7.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez8.getLabel(), 'P', pez8.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez9.getLabel(), 'P', pez9.getSexo()));
		marco.parteAgua.add(marco.definirLabel(pez10.getLabel(), 'P', pez10.getSexo()));
		*/
		/*pez3.start();
		pez4.start();
		pez5.start();
		pez6.start();
		pez7.start();
		pez8.start();
		pez9.start();
		pez10.start();
		*/
		
		agregarAlMarco(listaPeces);
		agregarAlMarcoT(listaTiburones);
		
	}
	
	static public void agregarAlMarco(ArrayList<Pez> listaPeces){
		marco.addLabelPez(listaPeces);
	}
	
	static public void agregarAlMarcoT(ArrayList<Tiburon> listaTiburones){
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