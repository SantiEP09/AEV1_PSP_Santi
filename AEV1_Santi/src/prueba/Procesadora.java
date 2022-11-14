package prueba;

import java.awt.Component;

import javax.swing.JOptionPane;

public class Procesadora {

	public static void main(String args[]) {

		int capacidad = 100;
		int numJamon = Integer.valueOf(args[0]);
		int numPollo = Integer.valueOf(args[1]);
		int numBacalao = Integer.valueOf(args[2]);
		int numQueso = Integer.valueOf(args[3]);

		Thread hiloJamon;
		Thread hiloPollo;
		Thread hiloBacalao;
		Thread hiloQueso;

		try {
			for (int i = 1; i <= numJamon; i++) {
				Croquetas Jamon = new Croquetas("jamon");
				hiloJamon = new Thread(Jamon);
				hiloJamon.start();
			}

			for (int i = 1; i <= numPollo; i++) {
				Croquetas Pollo = new Croquetas("pollo");
				hiloPollo = new Thread(Pollo);
				hiloPollo.start();
			}

			for (int i = 1; i <= numBacalao; i++) {
				Croquetas Bacalao = new Croquetas("bacalao");
				hiloBacalao = new Thread(Bacalao);
				hiloBacalao.start();
			}

			for (int i = 1; i <= numQueso; i++) {
				Croquetas Queso = new Croquetas("queso");
				hiloQueso = new Thread(Queso);
				hiloQueso.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}