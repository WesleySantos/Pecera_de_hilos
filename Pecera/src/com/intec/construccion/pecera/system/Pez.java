package com.intec.construccion.pecera;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Pez extends Thread{
	private char sexo;
	private Integer pasos = 20;
	Random rand = new Random();
	int number;
	
	String[][] matrix = new String[][]{
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "},
			{" 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "," 0 "}
	};
	
	public Pez(char sexo){
		this.setSexo(sexo);
	}

	@Override
	public void run(){
		int x = randInt(0,9);
		int y = randInt(0,9);
		
		matrix[x][y] = "><>";
		
		showMatrix();
		
		moveOnMatrix(x,y);
		
		yield();
	}
	
	private void moveOnMatrix(int x, int y){
		
		for(int i = 0; i < pasos; i++){
			number = rand.nextInt(2);
			
			if(number == 1){
				clearConsole();
				
				if(y+1 != 10){
					matrix[x][y] = " 0 ";
					matrix[x][y+1] = "><>";
					y++;
				}else{
					matrix[x][y] = " 0 ";
					matrix[x][y-1] = "><>";
					y--;
				}
				showMatrix();
			}else{
				clearConsole();
				
				if(x+1 != 10){
					matrix[x][y] = " 0 ";
					matrix[x+1][y] = "><>";
					x++;
				}else{
					matrix[x][y] = " 0 ";
					matrix[x-1][y] = "><>";
					x--;
				}
				showMatrix();
			}
		}
	}

	private void clearConsole(){
		for(int clear = 0; clear < 10; clear++)
		  {
		     System.out.println("\n") ;
		  }
	}
	
	public void showMatrix(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				System.out.print(matrix[i][j]);
			}
			System.out.print("\n");
		}
	}
	
	private int randInt(int min, int max) {

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo2) {
		this.sexo = sexo2;
	}
	
}
