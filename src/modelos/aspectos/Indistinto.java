package modelos.aspectos;

import modelos.IEnfrentableAspectos;

public class Indistinto extends Locacion {

	@Override
	public double enfrentar(IEnfrentableAspectos o) {
		return o.enfrentarTercero();
	}

	@Override
	public double enfrentarPrimero() {
		return 1;
	}

	@Override
	public double enfrentarSegundo() {
		return -1;
	}

	@Override
	public double enfrentarTercero() {
		return 1;
	}

}
