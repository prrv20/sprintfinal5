package interfaces;

import java.util.List;

import controlador.ListarUsuarios;
import modelo.Usuario;


public interface IUsuario {
	
	void crearUsuario(Usuario usuario);
	
	void eliminarUsuario(int id);
	
	void actualizarUsuario(Usuario usuario);
	
	void editarUsuario(int id);
	
	List<ListarUsuarios> listarUsuarios();

}
