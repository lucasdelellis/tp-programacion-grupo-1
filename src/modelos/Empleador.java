package modelos;

import java.util.ArrayList;
import java.util.Iterator;

import enums.Locaciones;
import enums.Rubros;
import modelos.comisiones.Rubro;
import util.Util;

public class Empleador extends Usuario implements Runnable {

	private String nombre;
	private ITipoPersona tipoPersona;
	private Rubro rubro;
	private ArrayList<TicketBusquedaEmpleado> tickets = new ArrayList<TicketBusquedaEmpleado>();

	public Empleador(String nombreUsuario, String contrasena, ITipoPersona tipoPersona, Rubro rubro) {
		super(nombreUsuario, contrasena);
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
	}

	public Empleador(String nombreUsuario, String contrasena, String nombre, ITipoPersona tipoPersona, Rubro rubro) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.tipoPersona = tipoPersona;
		this.rubro = rubro;
	}

	public void agregarTicket(TicketBusquedaEmpleado ticket) {
		this.tickets.add(ticket);
	}

	public Iterator<TicketBusquedaEmpleado> getTickets() {
		return tickets.iterator();
	}

	public String getNombre() {
		return nombre;
	}

	public ITipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public Rubro getRubro() {
		return rubro;
	}

	@Override
	public String toString() {
		return "Empleador [" + super.toString() + " nombre=" + nombre + ", tipoPersona=" + tipoPersona + ", rubro="
				+ rubro + ", tickets=" + tickets.size() + "]";
	}

	@Override
	public void finalizarTicket() {
		this.puntaje += 50;
	}

	@Override
	public void cancelarTicket() {
	}

	public void puntajeNoElegido() {
		this.puntaje -= 20;
	}

	public void puntajePrimerLugar() {
		this.puntaje += 10;
	}
	
	@Override
	public void run() {
		Agencia agencia = Agencia.getInstancia();
		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.CUALQUIERA, Rubros.COMERCIO_INTERNACIONAL));
		Util.espera();
		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.HOME_OFFICE, Rubros.COMERCIO_LOCAL));
		Util.espera();
		agencia.agregarTicketABolsa(new TicketSimplificado(this, Locaciones.PRESENCIAL, Rubros.COMERCIO_INTERNACIONAL));
	}

}
