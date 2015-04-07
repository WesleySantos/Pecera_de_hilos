package com.intec.construccion.pecera.graficos;

import java.awt.Color;
import javax.swing.*;

public class MarcoPecera extends JFrame{
	
	public MarcoPecera(String titulo) {
		setTitle(titulo);
		crearMarco();
	}
	
	private void crearMarco(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(1300, 700);
        setLocationRelativeTo(null);
        dividirPecera();
        
	}
	
	private void dividirPecera(){
		JPanel parteAgua = new JPanel();
		JPanel parteTierra = new JPanel();
				
		parteAgua.setVisible(true);
		parteAgua.setBackground(Color.cyan);
		parteAgua.setOpaque(true);
		
		parteTierra.setVisible(true);
		parteTierra.setBackground(Color.darkGray);
		parteTierra.setOpaque(true);
		
		setLayout(null);
		
		add(parteAgua);
		add(parteTierra);
		parteAgua.setBounds(0, 0, 1300, 600);
		parteTierra.setBounds(0, 600, 1300, 100);
		
	}
}
