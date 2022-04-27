package modelos.comisiones;

import modelos.IComision;
import modelos.IDoubleDispatch;

public abstract class PuestoLaboralDecorator implements IComision, IDoubleDispatch {
	protected IComision encapsulado;

	public PuestoLaboralDecorator(IComision encapsulado) {
		this.encapsulado = encapsulado;
	}

	// DECORATOR QUE TIENE DOUBLE DISPATCH Y UTILIZA TEMPLATE
	@Override
	public double calcularComision() {
		return this.calcularPorcentaje() * this.encapsulado.calcularComision();
	}
}
