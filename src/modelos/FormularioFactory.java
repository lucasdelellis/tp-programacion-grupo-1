package modelos;

import enums.CargasHorarias;
import enums.Estudios;
import enums.Experiencias;
import enums.Locaciones;
import enums.PuestosLaborales;
import enums.RangosEtarios;
import enums.Remuneraciones;
import enums.Rubros;
import modelos.aspectos.CargaCompleta;
import modelos.aspectos.CargaExtendida;
import modelos.aspectos.CargaHoraria;
import modelos.aspectos.CargaMedia;
import modelos.aspectos.HomeOffice;
import modelos.aspectos.Indistinto;
import modelos.aspectos.Locacion;
import modelos.aspectos.Presencial;

public class FormularioFactory {

	public Formulario getFormulario(Locaciones locacion, Remuneraciones remuneracion, double v1, double v2,
			CargasHorarias cargaHoraria, PuestosLaborales puestoLaboral, RangosEtarios rangoEtario,
			Experiencias experienciaPrevia, Estudios estudios, Rubros rubro) {
		Locacion locacionResultado = null;
		CargaHoraria cargaHorariaResultado = null;

		switch (locacion) {
		case CUALQUIERA:
			locacionResultado = new Indistinto();
			break;
		case HOME_OFFICE:
			locacionResultado = new HomeOffice();
			break;
		case PRESENCIAL:
			locacionResultado = new Presencial();
			break;
		default:
			break;
		}

		switch (cargaHoraria) {
		case COMPLETA:
			cargaHorariaResultado = new CargaCompleta();
			break;
		case EXTENDIDA:
			cargaHorariaResultado = new CargaExtendida();
			break;
		case MEDIA:
			cargaHorariaResultado = new CargaMedia();
			break;
		default:
			break;
		}

		return new Formulario(locacionResultado, remuneracion.getPosicion(), v1, v2, cargaHorariaResultado,
				puestoLaboral.getPosicion(), rangoEtario.getPosicion(), experienciaPrevia.getPosicion(),
				estudios.getPosicion(), rubro);
	}

}