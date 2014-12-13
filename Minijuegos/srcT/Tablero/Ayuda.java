package Tablero;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

//Mensaje de ayuda para el juego 
public class Ayuda extends JDialog implements ActionListener {

	private Ayuda ventana = this;
	
	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Create the dialog.
	 */
	public Ayuda(Tetris padre) {
		
        super(padre, true);
        setTitle("Ayuda");
		setBounds(100, 100, 432, 465);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JScrollPane scrollPane = new JScrollPane();
			JTextArea textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBackground(new Color(255, 250, 205));
			textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
			scrollPane.setViewportView(textArea);
			textArea.setRows(21);
			textArea.setColumns(30);
			contentPanel.add(scrollPane);
			textArea.setText("\n                           Tetris\n                           ---------------\n\n" +
					"          Pulsa jugar y comienza el juego.\n\n          El ordenador genera una figura de\n" +
					"          cuatro cuadrados que va descendiendo          \n          por el tablero.\n\n          El jugador tiene que colocar esas\n          figuras estratégicamente\n" +
					"         (rotándolas, moviéndolas) con el objetivo de  \n          crear el número máximo de líneas\n          completas de cuadrados.\n" +
					"          En el menú tiene la opción de pausar la partida,\n          de cambiar de nivel y de terminar la partida,\n          a parte de salir del juego.\n" +
					"          Para mover las figuras, se utilizan\n          las flechas de dirección  del teclado. \n          La flecha izquierda, desplaza \n          la figura hacia la izquierda, \n" +
					"          la flecha derecha, hacia la derecha,\n          la flecha superior rota la figura \n          y la flecha inferior se ocupa de bajar la figura\n          dos posiciones de golpe.\n" +
					"          El juego termina cuando no entran más figuras\n          en el tablero, es decir, cuando una toque\n          la parte superior del tablero.\n");
			textArea.setCaretPosition(0);   

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("ok");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("ok")) {
			ventana.dispose();
		}		
	}

}
