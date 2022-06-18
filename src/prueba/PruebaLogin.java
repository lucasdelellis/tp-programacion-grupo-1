package prueba;

import controladores.LoginController;
import modelos.Agencia;
import modelos.EmpleadoPretenso;

public class PruebaLogin {

	public static void main(String[] args) {
		LoginController controller = new LoginController();
		
		Agencia agencia = Agencia.getInstancia();

		EmpleadoPretenso ep1 = new EmpleadoPretenso("Renzo", "GenioInformatico");
		EmpleadoPretenso ep2 = new EmpleadoPretenso("Teo", "Ramos");
		EmpleadoPretenso ep3 = new EmpleadoPretenso("Cami", "Cacace");
		EmpleadoPretenso ep4 = new EmpleadoPretenso("Guille", "Profe!");
		
		agencia.registrarUsuario(ep1);
		agencia.registrarUsuario(ep2);
		agencia.registrarUsuario(ep3);
		agencia.registrarUsuario(ep4);
	}

}