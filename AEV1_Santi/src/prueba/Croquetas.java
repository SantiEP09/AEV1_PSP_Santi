package prueba;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Croquetas implements Runnable {

	private int limite = 0;
	private String tipo;
	private int tiempo;
	private static int tiempoTotal;
	private int croquetaJamon;
	private int croquetaPollo;
	private int croquetaQueso;
	private int croquetaBacalao;

	public Croquetas(String tipo) {
		
		this.tipo = tipo;
	}

	public void run() {
		
		prepararCroqueta(tipo);
	}
	
	/**
	 * Método sincronizado para preparar croquetas, menzionando cuando se empiezan y se terminan
	 * @param tipo indica el tipo de croqueta
	 */
	synchronized private void prepararCroqueta(String tipo) {

		if (tipo.equals("jamon")) {
			croquetaJamon++;
			limite++;
			tiempo = 5000;
			System.err.println("Croqueta de " + tipo + " empezada");
			try {
				Thread.sleep(tiempo);
				System.out.println("Croqueta de " + tipo + " terminada");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempoTotal += 5000;
		}

		if (tipo.equals("pollo")) {
			croquetaPollo++;
			limite++;
			tiempo = 6000;
			System.err.println("Croqueta de " + tipo + " empezada");
			try {
				Thread.sleep(tiempo);
				System.out.println("Croqueta de " + tipo + " terminada");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempoTotal += 6000;
		}

		if (tipo.equals("bacalao")) {
			croquetaBacalao++;
			limite++;
			tiempo = 7000;
			System.err.println("Croqueta de " + tipo + " empezada");
			try {
				Thread.sleep(tiempo);
				System.out.println("Croqueta de " + tipo + " terminada");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempoTotal += 7000;
		}

		if (tipo.equals("queso")) {
			croquetaQueso++;
			limite++;
			tiempo = 8000;
			System.err.println("Croqueta de " + tipo + " empezada");
			try {
				Thread.sleep(tiempo);
				System.out.println("Croqueta de " + tipo + " terminada");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempoTotal += 8000;
		}
	}
}