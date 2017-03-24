package com.example.echo;

import java.util.List;
import com.example.echo.Equipos;
import com.example.echo.Dimayor;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;

@Api(name = "dimayor123", version = "v1")
public class Echo {

	private Dimayor entidad;
	private ManageEquipos manager = new ManageEquipos();

	@ApiMethod(name = "listaEquipos")
	public List<Equipos> getListaEquipos() {
		//return entidad.getListaEquipos();
		return manager.listEquipo();
	}

	@ApiMethod(name = "getNombreEquipo", path = "getNombreEquipo/{nombreEquipo}")
	public Equipos getEquipoPorNombre(@Named("nombreEquipo") String nombre) {
		if (entidad == null) {
			entidad = new Dimayor();
		}
		Equipos eq = entidad.getEquipoPorNombre(nombre);
		return eq;
	}

	@ApiMethod(name = "setAnioFundacion", path = "setAnioFundacion/{nombreEquipo}")
	public void cambiarAnioFundacion(@Named("nombreEquipo") String nombreEquipo,
			@Named("anioFundacion") Integer anioFundacion) throws Exception {
		if (entidad == null) {
			entidad = new Dimayor();
		}
		entidad.cambiarAnioFundacionEquipo(nombreEquipo, anioFundacion);
	}
/*
	@ApiMethod(name = "eliminarEquipo", path = "eliminarEquipo/{nombreEquipo}")
	public boolean eliminarEquipoPorNombre(@Named("nombreEquipo") String nombreEquipo) {
		return entidad.borrarEquipoDeLista(nombreEquipo);
	}
*/
	/*
	@ApiMethod(name = "crearEquipo", httpMethod = HttpMethod.POST)
	public void crearEquipo(Equipo equipo) {
		//entidad.agregarNuevoEquipo(equipo.getNOMBRE_EQUIPO(), equipo.getANIO_FUNDACION(), equipo.getTITULOS_GANADOS());
		//manager.addEquipo(equipo.getNOMBRE_EQUIPO(), equipo.getANIO_FUNDACION(), equipo.getTITULOS_GANADOS());
	}
*/
	@ApiMethod(name = "consultarEquipo", path = "consultarEquipo/{nombreEquipo}")
	public Equipos consultarEquipoPorNombre(@Named("nombreEquipo") String nombre) {
		return entidad.getEquipoPorNombre(nombre);
	}
/*
	private Equipo getEquiposConLetra(String letra) {
	  
	  Equipo eq = new Equipo();
	  
	  try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
	  DriverManager.getConnection("jdbc:mysql://localhost:3306/COMPUNUBE_1",
	  "root", "12345"); // here sonoo is database name, root is username
	  and password Statement stmt = con.createStatement(); ResultSet rs =
	  stmt.executeQuery(
	  "SELECT E.NOMBRE_EQUIPO  FROM EQUIPOS E WHERE NOMBRE_EQUIPO LIKE '%"
	  +letra+"%';");
	  
	  System.out.println("RESULTSET"); while (rs.next()) { Date anioFundacion =
	  rs.getDate(3); int titulos = rs.getInt(4); String nombre =
	  rs.getString(2); System.out.println(anioFundacion);
	  System.out.println(titulos); System.out.println(nombre);
	  eq.setAnioFundacion(anioFundacion); eq.setNombreEquipo(nombre);
	  eq.setTitulosDeLiga(titulos); }
	  
	  } catch (Exception e) { System.out.println("ERORR");
	  System.out.println(e); }
	  
	  return eq; }
*/
}