package com.intec.construccion.pecera.Imagenes.manejador;


import javax.swing.ImageIcon;

public class ManejadorImagen {

	public static ImageIcon [] elementos, animales;
	
	
	public ManejadorImagen() {

		elementos = new ImageIcon[2];
		animales = new ImageIcon[4];
		
		cargarElementos();
		cargarAnimales();	
	}
	
	private void cargarElementos(){
		elementos[0] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/burbujas.png"));
		elementos[1] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/piedras.png"));		
	}
	
	private void cargarAnimales(){
		animales[0] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/pezhembra.png"));
		animales[1] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/pezmacho.png"));
		animales[2] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/tiburonhembra.png"));
		animales[3] = new ImageIcon(getClass().getResource("/com/intec/construccion/pecera/Imagenes/png/tiburonmacho.png"));
	}

	public ImageIcon[] getElementos() {
		return elementos;
	}
	
	public ImageIcon[] getAnimales() {
		return animales;
	}
}