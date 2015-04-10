package com.intec.construccion.pecera.system;

import java.awt.Point;
import java.util.Random;

import javax.swing.JLabel;

public class Pez extends Thread{

	private char sexo;
	private JLabel label;
	private int limite;
	public Point puntoLabel;
	
	public Pez(char sexo, JLabel label, int limite, Point punto){
		this.setSexo(sexo);
		this.setLabel(label);
		this.setLimite(limite);
		this.puntoLabel = punto;
	}
	
	@Override
	public void run(){
		int X = puntoLabel.x;
		int Y = puntoLabel.y;
		
		for(int i = 0; i < limite; i++){
			try {
				//obtiene el punto presente del label
<<<<<<< HEAD
				Point punto = moveOnMatrix(X,Y);
=======
				
				
				//Point punto = new Point(); //   moveOnMatrix(X,Y);
>>>>>>> 5f08930f1500e2dddb6e8f03bb2574ac7160483b
				
				int xy[] = new int[2];
				xy[0] = X;
				xy[1] = Y;
				
				xy = GetXY(xy);
				
				X = xy[0];
				Y = xy[1];
				
				//X = punto.x;
				//Y = punto.y;
				
				label.setLocation(X,Y);
				
				Thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		yield();
	}
	
	private int[] GetXY(int[] xy){
		Random rand = new Random();
		int number = rand.nextInt(8);
		
		switch(number){
		case 0:	//izquierda
			
			if(xy[0] -1 > 0)
				xy[0] = xy[0]-1;
			
			break;
		case 1:	//derecha
			
			if(xy[0]+1 < 1300)
				xy[0] = xy[0]+1;
			break;
		case 2:	//arriba
			
			if(xy[1]-1 > 0)
				xy[1] = xy[1]-1;
			
			break;
		case 3:	//abajo
			
			if(xy[1]+1 < 700)
				xy[1] = xy[1] +1;
			
			break;
		case 4:	//superior izquierda
			
			if( xy[0] -1 > 0 && xy[1] -1 >0)
				xy[0] = xy[0]-1;xy[1] = xy[1]-1;
			
			break;
		case 5:	//superior derecha
			
			if(xy[0]+1 < 1300 && xy[1]-1 > 0)
				xy[0]= xy[0]+1; xy[1]= xy[1]-1;
			
			break;
		case 6:	//inferior izquierda
			
			if(xy[0]-1 > 0 && xy[1]+1 < 700)
				xy[0]= xy[0]-1;  xy[1]= xy[1]+1;
			
			break;
		case 7:	//inferior derecha
			
			if(xy[0]+1 < 1300 && xy[1]+1 < 700)
				xy[0]= xy[0]+1; xy[1]= xy[1]+1; 
				
			break;
		}
			
		return xy;
	}
	
	//genera un punto aleatorio al rededor de las coordenadas de parametro 
	private Point moveOnMatrix(int x, int y){
		Random rand = new Random();
		
		Point punto = null;
		
		int number = rand.nextInt(8);
		
		switch(number){
		case 0:	//izquierda
			
			if(x-1 > 0)
				punto = new Point(x-1,y);
			
			break;
		case 1:	//derecha
			
			if(x+1 < 1300)
				punto = new Point(x+1,y);
			
			break;
		case 2:	//arriba
			
			if(y-1 > 0)
				punto = new Point(x,y-1);
			
			break;
		case 3:	//abajo
			
			if(y+1 < 700)
				punto = new Point(x,y+1);
			
			break;
		case 4:	//superior izquierda
			
			if(x-1 > 0 && y-1 >0)
				punto = new Point(x-1,y-1);
			
			break;
		case 5:	//superior derecha
			
			if(x+1 < 1300 && y-1 > 0)
				punto = new Point(x+1,y-1);
			
			break;
		case 6:	//inferior izquierda
			
			if(x-1 > 0 && y+1 < 700)
				punto = new Point(x-1,y+1);
			
			break;
		case 7:	//inferior derecha
			
			if(x+1 < 1300 && y+1 < 700)
				punto = new Point(x+1,y+1);
				
			break;
		}
			
		return punto;
	}


	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
}
