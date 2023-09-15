package VentanaConfirmacionLenta;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

/** Ejercicio de hilos con ventanas. Programa esta clase para que se cree una ventana
 * que pida un dato de texto al usuario y un botón de confirmar para que se confirme.
 * Haz que al pulsar edl botón de confirmación se llame al procesoConfirmar()
 * que simula un proceso de almacenamiento externo que tarda unos segundos.
 * Observa que hasta que ocurre esta confirmación la ventana no responde.
 * 1. Arréglalo para que la ventana no se quede "frita" hasta que se acabe de confirmar.
 * 2. Haz que el botón de "confirmar" no se pueda pulsar dos veces mientras el proceso
 * de confirmación se esté realizando
 * @author andoni.eguiluz @ ingenieria.deusto.es
 */
public class VentanaConfirmacionLenta extends JFrame{

		private static Random r = new Random();
	// Este método simula un proceso que tarda un tiempo en hacerse (entre 5 y 10 segundos)
	private static void procesoConfirmar() {
		try {
			Thread.sleep( 5000 + 1000*r.nextInt(6) );
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) {
		// TODO Desarrollar la clase de acuerdo a los comentarios de la cabecera
	VentanaConfirmacionLenta v = new VentanaConfirmacionLenta();
	
	v.setBounds(200, 200, 400, 400);
	v.setTitle("Ventana de confirmacion lenta");
	v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	
	JPanel pnl = new JPanel(new GridLayout(10,2));
	v.add(pnl);
	
	JTextField txt = new JTextField();

	JLabel lbl = new JLabel("Introduce un dato de texto");
	
	JButton btn = new JButton("Confirmacion");
	
	pnl.add(lbl);
	pnl.add(txt);
	pnl.add(btn);
	
	btn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			btn.setEnabled(false);
			procesoConfirmar();
			btn.setEnabled(true);
		}
		
	});
	
	v.setVisible(true);
	}
	
	

}
