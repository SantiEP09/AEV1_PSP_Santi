package prueba;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class Lanzadora extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldJamon;
	private JTextField textFieldPollo;
	private JTextField textFieldBacalao;
	private JTextField textFieldQueso;
	private static long inicio;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Lanzadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 252);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 215, 0));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCroquetas = new JLabel("INTRODUCE CROQUETAS");
		lblCroquetas.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblCroquetas.setBounds(69, 28, 325, 31);
		contentPane.add(lblCroquetas);
		
		textFieldJamon = new JTextField();
		textFieldJamon.setText("0");
		textFieldJamon.setBounds(26, 114, 76, 31);
		contentPane.add(textFieldJamon);
		textFieldJamon.setColumns(10);
		
		JLabel lblJamon = new JLabel("Jamón");
		lblJamon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJamon.setBounds(39, 84, 65, 19);
		contentPane.add(lblJamon);
		
		JLabel lblPollo = new JLabel("Pollo");
		lblPollo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPollo.setBounds(152, 89, 45, 13);
		contentPane.add(lblPollo);
		
		textFieldPollo = new JTextField();
		textFieldPollo.setText("0");
		textFieldPollo.setBounds(134, 114, 76, 31);
		contentPane.add(textFieldPollo);
		textFieldPollo.setColumns(10);
		
		JLabel lblBacalao = new JLabel("Bacalao");
		lblBacalao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBacalao.setBounds(249, 89, 56, 13);
		contentPane.add(lblBacalao);
		
		textFieldBacalao = new JTextField();
		textFieldBacalao.setText("0");
		textFieldBacalao.setBounds(240, 114, 76, 31);
		contentPane.add(textFieldBacalao);
		textFieldBacalao.setColumns(10);
		
		JLabel lblQueso = new JLabel("Queso");
		lblQueso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQueso.setBounds(362, 89, 46, 13);
		contentPane.add(lblQueso);
		
		textFieldQueso = new JTextField();
		textFieldQueso.setText("0");
		textFieldQueso.setColumns(10);
		textFieldQueso.setBounds(347, 114, 76, 31);
		contentPane.add(textFieldQueso);
		
		JButton btnEjecutar = new JButton("Producir");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio = System.nanoTime();
				int cantJamon = Integer.parseInt(textFieldJamon.getText());
				int cantPollo = Integer.parseInt(textFieldPollo.getText());
				int cantBacalao = Integer.parseInt(textFieldBacalao.getText());
				int cantQueso = Integer.parseInt(textFieldQueso.getText());
				ejecutarLanzadora(cantJamon,cantPollo,cantBacalao,cantQueso);
			}
		});
		btnEjecutar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEjecutar.setBounds(134, 165, 182, 40);
		contentPane.add(btnEjecutar);
		this.setVisible(true);
	}
	
	/**
	 * Método para ejecutar la clase lanzadora
	 * @param numero1 
	 * @param numero2 
	 * @param numero3 
	 * @param numero4 
	 */
	public static void ejecutarLanzadora(int numero1, int numero2, int numero3, int numero4) {
		
		try {
			String clase = "prueba.Procesadora";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(String.valueOf(numero1));
			command.add(String.valueOf(numero2));
			command.add(String.valueOf(numero3));
			command.add(String.valueOf(numero4));
			ProcessBuilder builder = new ProcessBuilder(command);
			Process p = builder.inheritIO().start();
			p.waitFor();
			long fin = System.nanoTime();
			// Con el tiempo de inicio y de fin se saca lo que ha tardado en hacerse la croqueta
			double tiempo = (fin - inicio) / 1000000000;
			JOptionPane.showMessageDialog(null, "Tiempo total: " + tiempo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}