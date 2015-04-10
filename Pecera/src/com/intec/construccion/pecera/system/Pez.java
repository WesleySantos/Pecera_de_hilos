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
		int x = puntoLabel.x;
		int y = puntoLabel.y;
		
		label.setLocation(x,y);
		
		
		for(int i = 0; i < limite; i++){
			try {
				
				//Point punto = new Point(); //   moveOnMatrix(X,Y);
				
				//int xy[] = new int[2];
				//xy[0] = X;
				//xy[1] = Y;
				
				//xy = GetXY(xy);
				
				//X = xy[0];
				//Y = xy[1];
								
				int X = label.getLocation().x;
				int Y = label.getLocation().y;
				
				moveOnMatrix(X,Y);
				
				Thread.sleep(0);
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
	private void moveOnMatrix(int x, int y){
		Random rand = new Random();
		
		int number = rand.nextInt(8);
		
		switch(number){
		case 0:	//izquierda
			
			for(int i = 0; i < 50; i++){
				
				if(x-1 > 0)
					try {
						label.setLocation(x-i,y);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 1:	//derecha
			
			for(int i = 0; i < 50; i++){
				if(x+1 < 1300)
					try {
						label.setLocation(x+i,y);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 2:	//arriba
			
			for(int i = 0; i < 50; i++){
				if(y-1 > 0)
					try {
						label.setLocation(x,y-i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 3:	//abajo
			
			for(int i = 0; i < 50; i++){
				if(y+1 < 700)
					try {
						label.setLocation(x,y+i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 4:	//superior izquierda
			
			for(int i = 0; i < 50; i++){
				if((x-1 > 0) && (y-1 >0))
					try {
						label.setLocation(x-i,y-i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 5:	//superior derecha
			
			for(int i = 0; i < 50; i++){
				if((x+1 < 1300) && (y-1 > 0))
					try {
						label.setLocation(x+i,y-i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 6:	//inferior izquierda
			
			for(int i = 0; i < 50; i++){
				if((x-1 > 0) && (y+1 < 700))
					try {
						label.setLocation(x-i,y+i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		case 7:	//inferior derecha
			
			for(int i = 0; i < 50; i++){
				if((x+1 < 1300) && (y+1 < 700))
					try {
						label.setLocation(x+i,y+i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
			
			break;
		}
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

