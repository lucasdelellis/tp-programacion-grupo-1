package modelos;

import excepciones.ContrasenaIncorrectaException;

public abstract class Usuario implements Logueable {
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	@Override
	public void login(String contrasena) throws ContrasenaIncorrectaException {
		if (!this.contrasena.equals(contrasena)) {
			throw new ContrasenaIncorrectaException("Contrasena incorrecta");
		}
	}

	public abstract void finalizarTicket();

	public abstract void cancelarTicket();

	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public int getPuntaje() {
		return puntaje;
	}

	@Override
	public String toString() {
		return "nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", puntaje=" + puntaje;
	}
}
