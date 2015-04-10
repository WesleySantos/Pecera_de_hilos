package com.intec.construccion.pecera.graficos;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.*;

import com.intec.construccion.pecera.Imagenes.manejador.ManejadorImagen;
import com.intec.construccion.pecera.system.Pez;
import com.intec.construccion.pecera.system.Tiburon;

public class MarcoPecera extends JFrame{
	
	JPanel parteAgua = new JPanel();
	JPanel parteTierra = new JPanel();
	
	ManejadorImagen manejadorImagen = new ManejadorImagen();
	
	ImageIcon pezHembra = manejadorImagen.animales[0];
	ImageIcon pezMacho = manejadorImagen.animales[1];
	ImageIcon tibuHembra = manejadorImagen.animales[2];
	ImageIcon tibuMacho = manejadorImagen.animales[3];
	
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
        setLayout(null);
	}
	
	private void dividirPecera(){
				
		parteAgua.setVisible(true);
		parteAgua.setBackground(Color.cyan);
		parteAgua.setOpaque(true);
		
		parteTierra.setVisible(true);
		parteTierra.setBackground(Color.darkGray);
		parteTierra.setOpaque(true);
		
		add(parteAgua);
		add(parteTierra);
		parteAgua.setBounds(0, 0, 1300, 620);
		parteTierra.setBounds(0, 620, 1300, 80);
		
	}	
//	public void addLabelAnimal(String animal, char sexo, Point spawn){
	public void addLabelAnimal(ArrayList<Pez> pez){
	
		JLabel jl = new JLabel("");
		
		for(Pez p: pez){
			parteAgua.add(definirLabel(p.getLabel()));
			//p.getLabel().setLocation(p.puntoLabel);
			//repaint();
			p.start();
		}
/*
		if(animal == "pez"){
			
			if(sexo == 'M'){							//pez macho
				JLabel label = new JLabel("");
				label.setLocation(spawn);
				parteAgua.add(definirLabel(label));
				
				Pez pez = new Pez('M', label, 200, spawn);
				pez.start();
			}else{										//pez hembra
				JLabel label = new JLabel("");
				label.setLocation(spawn);
				parteAgua.add(definirLabel(label));
				
				Pez pez = new Pez('F', label, 200, spawn);
				pez.start();
			}
			
		}else{
			
			if(sexo == 'M'){							//tiburon macho
				JLabel label = new JLabel("");
				label.setLocation(spawn);
				parteAgua.add(definirLabel(label));
				
				Tiburon tiburon = new Tiburon('M', label, 200, spawn);
				tiburon.start();
			}else{										//tiburon hembra
				JLabel label = new JLabel("");
				label.setLocation(spawn);
				parteAgua.add(definirLabel(label));
				
				Tiburon tiburon = new Tiburon('F', label, 200, spawn);
				tiburon.start();
			}
			
		}
		*/
	}
	
	private JLabel definirLabel(JLabel label){
		label.setIcon(pezMacho);
		label.setBackground(Color.cyan);
		label.setOpaque(true);
		label.setVisible(true);
		label.setBounds(10, 0, 100, 70);
		
		return label;
	}
}