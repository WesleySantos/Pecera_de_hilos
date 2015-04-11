package com.intec.construccion.pecera.graficos;

import java.awt.Color;
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
	
	public void addLabelPez(ArrayList<Pez> peces){

		for(Pez p: peces){
			parteAgua.add(definirLabel(p.getLabel(), 'P', p.getSexo()));
			
			//System.out.println(p.getState());
			Thread c = new Thread(p) ;//p;
			c.start();
			//p.start();
		}

	}

	
	public void addLabelTiburon(ArrayList<Tiburon> tiburones){

		for(Tiburon t: tiburones){
			parteAgua.add(definirLabel(t.getLabel(), 'T', t.getSexo()));
			Thread c = new Thread(t) ;//p;
			c.start();
//			t.start();
		}

	}
	
	private JLabel definirLabel(JLabel label, char animal, char sexo){
		
		if(animal == 'P'){
			if(sexo == 'M'){
				label.setIcon(pezMacho);
				label.setBounds(0, 0, 38, 27);
			}else{
				label.setIcon(pezHembra);
				label.setBounds(0, 0, 48, 26);
			}
		}else{
			if(sexo == 'M'){
				label.setIcon(tibuMacho);
				label.setBounds(0, 0, 100, 43);
			}else{
				label.setIcon(tibuHembra);
				label.setBounds(0, 0, 87, 44);
			}
		}
		
		label.setBackground(Color.cyan);
		label.setOpaque(true);
		label.setVisible(true);
		
		return label;
	}
}