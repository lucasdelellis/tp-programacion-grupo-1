package vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import modelos.TicketBusquedaEmpleado;

public class EmpleadoVista extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel controlTicket;
	private JPanel puntajePanLabel;
	private JLabel puntajeLabel;
	private JPanel puntajePanText;
	private JTextPane puntajeText;
	private JPanel suspenderBotonPan;
	private JButton suspenderBoton;
	private JPanel cambiarBotonPan;
	private JButton cambiarBoton;
	private JPanel activarBotonPan;
	private JButton activarBoton;
	private JPanel mostrarBotonPan;
	private JButton mostrarBoton;
	private JPanel ticketSimplificadoPan;
	private JButton ticketSimplificado;
	private JPanel ganadorTicket;
	private JScrollPane scrollPane;
	private JList listaEmpleadores;
	private JPanel elegirBotonPan;
	private JButton elegirBoton;

	/**
	 * Create the frame.
	 */
	public EmpleadoVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		controlTicket = new JPanel();
		contentPane.add(controlTicket);
		controlTicket.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel puntajePan = new JPanel();
		controlTicket.add(puntajePan);
		puntajePan.setLayout(new GridLayout(0, 2, 0, 0));
		
		puntajePanLabel = new JPanel();
		puntajePan.add(puntajePanLabel);
		
		puntajeLabel = new JLabel("Puntaje:");
		puntajePanLabel.add(puntajeLabel);
		
		puntajePanText = new JPanel();
		puntajePan.add(puntajePanText);
		
		puntajeText = new JTextPane();
		puntajePanText.add(puntajeText);
		
		suspenderBotonPan = new JPanel();
		controlTicket.add(suspenderBotonPan);
		
		suspenderBoton = new JButton("Suspender Ticket");
		suspenderBotonPan.add(suspenderBoton);
		
		cambiarBotonPan = new JPanel();
		controlTicket.add(cambiarBotonPan);
		
		cambiarBoton = new JButton("Cambiar Ticket");
		cambiarBotonPan.add(cambiarBoton);
		
		activarBotonPan = new JPanel();
		controlTicket.add(activarBotonPan);
		
		activarBoton = new JButton("Activar Ticket");
		activarBotonPan.add(activarBoton);
		
		mostrarBotonPan = new JPanel();
		controlTicket.add(mostrarBotonPan);
		
		mostrarBoton = new JButton("Mostrar Ticket");
		mostrarBotonPan.add(mostrarBoton);
		
		ticketSimplificadoPan = new JPanel();
		controlTicket.add(ticketSimplificadoPan);
		
		ticketSimplificado = new JButton("Ticket Simplificado");
		ticketSimplificadoPan.add(ticketSimplificado);
		
		ganadorTicket = new JPanel();
		contentPane.add(ganadorTicket);
		ganadorTicket.setLayout(new GridLayout(2, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		ganadorTicket.add(scrollPane);
		
		listaEmpleadores = new JList<>();
		scrollPane.setViewportView(listaEmpleadores);
		
		elegirBotonPan = new JPanel();
		ganadorTicket.add(elegirBotonPan);
		
		elegirBoton = new JButton("Elegir");
		elegirBotonPan.add(elegirBoton);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		suspenderBoton.addActionListener(actionListener);
		activarBoton.addActionListener(actionListener);
		cambiarBoton.addActionListener(actionListener);
		mostrarBoton.addActionListener(actionListener);
		elegirBoton.addActionListener(actionListener);
		ticketSimplificado.addActionListener(actionListener);
	}
	
	
	public TicketBusquedaEmpleado getTicketSeleccionado() {
		return (TicketBusquedaEmpleado)this.listaEmpleadores.getSelectedValue();
	}
	

}