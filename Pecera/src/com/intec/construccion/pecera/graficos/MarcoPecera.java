package com.intec.construccion.pecera.graficos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import com.intec.construccion.pecera.Imagenes.manejador.ManejadorImagen;
import com.intec.construccion.pecera.system.Pez;
import com.intec.construccion.pecera.system.Tiburon;

public class MarcoPecera extends JFrame{
	
	JPanel parteAgua = new JPanel();
	JPanel parteTierra = new JPanel();
	
	public MarcoPecera(String titulo) {
		setTitle(titulo);
		crearMarco();
	}
	
	private void crearMarco(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        dividirPecera();
        
	}
	
	private void dividirPecera(){
				
		parteAgua.setVisible(true);
		parteAgua.setBackground(Color.cyan);
		parteAgua.setOpaque(true);
		
		parteTierra.setVisible(true);
		parteTierra.setBackground(Color.darkGray);
		parteTierra.setOpaque(true);
		
		setLayout(null);
		
		add(parteAgua);
		add(parteTierra);
		parteAgua.setBounds(0, 0, 1300, 620);
		parteTierra.setBounds(0, 620, 1300, 80);
		
	}
	
	public void addLabelAnimal(String animal, char sexo){
		ManejadorImagen manejadorImagen = new ManejadorImagen();
		
		ImageIcon pezHembra = manejadorImagen.animales[0];
		ImageIcon pezMacho = manejadorImagen.animales[1];
		ImageIcon tibuHembra = manejadorImagen.animales[2];
		ImageIcon tibuMacho = manejadorImagen.animales[3];
		
		if(animal == "pez"){
			//Pez pez = new Pez(sexo);
			if(sexo == 'M'){
				JLabel labelPezM = new JLabel(pezMacho);
				parteAgua.add(labelPezM);
			}else{
				JLabel labelPezF = new JLabel(pezHembra);
				parteAgua.add(labelPezF);
			}
		}else{
			//Tiburon tiburon = new Tiburon(sexo);
			if(sexo == 'M'){
				JLabel labelTibuM = new JLabel(tibuMacho);
				parteAgua.add(labelTibuM);
			}else{
				JLabel labelTibuF = new JLabel(tibuHembra);
				parteAgua.add(labelTibuF);
			}
		}
		
	}
}



