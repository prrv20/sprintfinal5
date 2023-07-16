package interfaces;

import java.util.List;

import controlador.ListarCapacitacion;
import modelo.Capacitacion;

public interface ICapacitacion {
	
	void crearCapacitacion(Capacitacion capacitacion );
	
	List<ListarCapacitacion> listarCapacitacion();
	
	void eliminarCapacitacion(int id);
	
	void actualizarCapacitacion(Capacitacion capacitacion);
	
	void editarCapacitacion(int id);

}
