package com.example.echo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dimayor {

	private ArrayList<Equipos> equipos;

	public Dimayor() {
		equipos = new ArrayList<>();
		generarInformacion();
	}

	private void generarInformacion() {
		String[] nombresEquipos = { "Americadecali", "DeportivoCali", "OnceCaldas", "IndependienteMedellin",
				"Nacional", "Millonarios" };
		int[] anioFundacion = { 1980, 1985, 1990, 1982, 1990, 1976 };
		int[] titulosGanados = { 6, 7, 4, 7, 8, 9 };

		for (int i = 0; i < 6; i++) {
			Equipos equipo = new Equipos();
			equipo.setNombreEquipo(nombresEquipos[i]);
			equipo.setTitulosGanados(titulosGanados[i]);
			//equipo.setAnioFundacion(anioFundacion[i]);
			equipos.add(equipo);
		}
	}

	public List<Equipos> getListaEquipos() {
		return equipos;
	}

	public Equipos getEquipoPorNombre(String nombreEquipo) {
		String temp = nombreEquipo;
		for (Equipos eq : equipos) {
			if (eq.getNombreEquipo().equals(temp)) {
				return eq;
			}
		}
		return null;
	}

	public void cambiarAnioFundacionEquipo(String nombreEquipo, int anioFundacion) throws Exception {
		Equipos eq = getEquipoPorNombre(nombreEquipo);
		if (eq != null) {
			//eq.setAnioFundacion(anioFundacion);
		} else {
			throw new Exception("el equipo " + nombreEquipo + " no existe");
		}
	}

	public void cambiarNumeroTitulosEquipo(String nombreEquipo, int numeroTitulos) throws Exception {
		Equipos eq = getEquipoPorNombre(nombreEquipo);
		if (eq != null) {
			eq.setTitulosGanados(numeroTitulos);
		} else {
			throw new Exception("el equipo " + nombreEquipo + " no existe");
		}
	}

	public boolean borrarEquipoDeLista(String nombreEquipo) {
		for (int i = 0; i < equipos.size(); i++) {
			if (equipos.get(i).getNombreEquipo().equals(nombreEquipo)) {
				equipos.remove(i);
				return true;
			}
		}
		return false;
	}
/*
	public void agregarNuevoEquipo(String nombreEquipo, Date anioFundacion, int titulosDeLiga) {
		equipos.add(new Equipos(nombreEquipo, anioFundacion, titulosDeLiga));
	}
	*/
}
