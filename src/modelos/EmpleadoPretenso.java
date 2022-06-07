package modelos;

import java.util.Date;

import util.Util;

public class EmpleadoPretenso extends Usuario implements IComision, Runnable {
	private String nombre;
	private String apellido;
	private String telefono;
	private Date fechaNacimiento;
	private TicketBusquedaEmpleo ticket;
	
	private TicketSimplificado ganador = null;

	public EmpleadoPretenso(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
	}

	public EmpleadoPretenso(String nombreUsuario, String contrasena, String nombre, String apellido, String telefono,
			Date fechaNacimiento) {
		super(nombreUsuario, contrasena);
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setTicket(TicketBusquedaEmpleo ticket) {
		this.ticket = ticket;
	}

	public TicketBusquedaEmpleo getTicket() {
		return ticket;
	}

	public TicketSimplificado getGanador() {
		return ganador;
	}

	public void setGanador(TicketSimplificado ganador) {
		this.ganador = ganador;
	}

	@Override
	public String toString() {
		return "EmpleadoPretenso [nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", fechaNacimiento=" + fechaNacimiento + ", " + super.toString() + "]";
	}

	@Override
	public void finalizarTicket() {
		this.puntaje += 10;

	}

	@Override
	public void cancelarTicket() {
		this.puntaje--;
	}

	public void puntajeUltimoLugar() {
		this.puntaje -= 5;
	}

	public void puntajePrimerLugar() {
		this.puntaje += 5;
	}

	/**
	 * Devuelve el sueldo pretendido.
	 */
	@Override
	public double calcularComision() {
		return this.ticket.getFormulario().getRemuneracion().getSueldoPretendido();
	}

	/**
	 * <b>Pre:</b> el puntaje es un valor positivo. Devuelve el puntaje en
	 * porcentaje.
	 */
	@Override
	public double calcularPorcentaje() {
		return (this.getPuntaje() * 0.01 < 1) ? this.getPuntaje() * 0.01 : 1;
	}

	@Override
	public void run() {
		Agencia agencia = Agencia.getInstancia();
		Util.espera();
		agencia.busquedaBolsa(this);
		if (!ganador.getLocacion().mismaLocacion(this.ticket.getFormulario().getLocacion())) {
			agencia.devuelveBolsa(ganador);
			ganador = null;
		}
	}
}
