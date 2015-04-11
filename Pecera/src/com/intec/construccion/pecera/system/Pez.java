package com.intec.construccion.pecera.system;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;

import com.intec.construccion.pecera.graficos.MarcoPecera;

public class Pez extends Thread {

	private char sexo;
	private JLabel label;
	private int limite;
	public Point puntoLabel;
	public int numero = 0;
	ArrayList<Integer> lista = new ArrayList<>();

	public Pez(char sexo, JLabel label, int limite, Point punto) {
		this.setSexo(sexo);
		this.setLabel(label);
		this.setLimite(limite);
		this.puntoLabel = punto;
	}

	@Override
	public void run() {
		int x = puntoLabel.x;
		int y = puntoLabel.y;

		label.setLocation(x, y);

		for (int i = 0; i < limite; i++) {
			try {

				int X = label.getLocation().x;
				int Y = label.getLocation().y;

				moveOnMatrix(X, Y);

				Thread.sleep(10);

				chequeaPez(label);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		yield();
	}

	public void chequeaPez(JLabel label) {
		boolean bandera = false;
		ArrayList<Pez> lis = new ArrayList<>();

		for (Pez p : Pecera.listaPeces) {
			bandera = p.getLabel().getBounds().intersects(label.getBounds());

			if (bandera) {
				if (p.getSexo() == this.getSexo()) {
					lista.add(p.getNumero());
					eliminarPez(p);
					System.out.println(p.getNumero());
					// eliminarPez(label);
					break;
				} else {
					Pez pezx = new Pez('F', new JLabel(), this.getLimite(),
							new Point(500, 500));
					lis.add(pezx);
					Pecera.agregarAlMarco(lis);
					System.out.println("peces para reproducir");
				}

			}
		}
	}

	public void eliminarPez(Pez p) {
		int k = 0;
		for (int i = 0; i < lista.size(); i++) {
			if (p.getNumero() == lista.get(i)) {
				k = 1;
				if (k == 1) {
					// getLabel().setIcon(null) ;
					p.getLabel().setBackground(Color.red);
					p.stop();

					k = 0;
				}
			}
		}
		System.out.println("eliminado");

	}

	// genera un punto aleatorio al rededor de las coordenadas de parametro
	private void moveOnMatrix(int x, int y) {
		Random rand = new Random();

		int number = rand.nextInt(8);

		switch (number) {
		case 0: // izquierda

			for (int i = 0; i < 50; i++) {

				if (x - 1 > 0)
					try {
						label.setLocation(x - i, y);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 1: // derecha

			for (int i = 0; i < 50; i++) {
				if (x + 1 < 1300)
					try {
						label.setLocation(x + i, y);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 2: // arriba

			for (int i = 0; i < 50; i++) {
				if (y - 1 > 0)
					try {
						label.setLocation(x, y - i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 3: // abajo

			for (int i = 0; i < 50; i++) {
				if (y + 1 < 700)
					try {
						label.setLocation(x, y + i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 4: // superior izquierda

			for (int i = 0; i < 50; i++) {
				if ((x - 1 > 0) && (y - 1 > 0))
					try {
						label.setLocation(x - i, y - i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 5: // superior derecha

			for (int i = 0; i < 50; i++) {
				if ((x + 1 < 1300) && (y - 1 > 0))
					try {
						label.setLocation(x + i, y - i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 6: // inferior izquierda

			for (int i = 0; i < 50; i++) {
				if ((x - 1 > 0) && (y + 1 < 700))
					try {
						label.setLocation(x - i, y + i);
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}

			break;
		case 7: // inferior derecha

			for (int i = 0; i < 50; i++) {
				if ((x + 1 < 1300) && (y + 1 < 700))
					try {
						label.setLocation(x + i, y + i);
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
