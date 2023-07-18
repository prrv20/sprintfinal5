package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controlador.ActualizarCapacitacion;
import controlador.CrearCapacitacion;
import controlador.EditarCapacitacion;
import controlador.EditarUsuario;
import controlador.ListarCapacitacion;
import controlador.ListarUsuarios;
import controlador.Login;
import controlador.CrearUsuario;
import controlador.ActualizarUsuario;
import controlador.ContactoController;


public class Conexion {
    private static Conexion instancia;
    private Connection conexion;

    private Conexion() {

    }   
    
    public Connection obtenerConexion() {
        String url = "jdbc:mysql://54.80.27.42:3306/";
        String db = "asesorias";
        String usuario = "Hola";
        String password = "Hola.2023";
        String driver ="com.mysql.cj.jdbc.Driver";
        Connection conexion = null;
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url+db, usuario, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al cargar el controlador de la base de datos.");
            e.printStackTrace();
        } 
        
        if (conexion == null) {
            throw new RuntimeException("No se pudo establecer la conexión a la base de datos.");
        }
        
        return conexion;
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    // Métodos CRUD

    public List<ListarCapacitacion> obtenerCapacitaciones() {
        List<ListarCapacitacion> capacitaciones = new ArrayList<>();
        String consulta = "SELECT id, rut, diaCapacitacion, hora, lugar, cantidadAsistente FROM asesorias.capacitacion";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
            	ListarCapacitacion capacitacion = new ListarCapacitacion();
                capacitacion.setId(resultSet.getInt("id"));
                capacitacion.setRut(resultSet.getString("rut"));
                capacitacion.setDia(resultSet.getString("diaCapacitacion"));
                capacitacion.setHora(resultSet.getString("hora"));
                capacitacion.setLugar(resultSet.getString("lugar"));
                capacitacion.setCantidad(resultSet.getString("cantidadAsistente"));
                
                capacitaciones.add(capacitacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }
    
    public EditarCapacitacion obtenerCapacitacionesPorId(int id) {
        EditarCapacitacion capacitacion = null;
        String consulta = "SELECT id, rut, diaCapacitacion, hora, lugar, cantidadAsistente FROM asesorias.capacitacion WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    capacitacion = new EditarCapacitacion();
                    capacitacion.setId(resultSet.getInt("id"));
                    capacitacion.setRut(resultSet.getString("rut"));
                    capacitacion.setDia(resultSet.getString("diaCapacitacion"));
                    capacitacion.setHora(resultSet.getString("hora"));
                    capacitacion.setLugar(resultSet.getString("lugar"));
                    capacitacion.setCantidad(resultSet.getString("cantidadAsistente"));
                    
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitacion;
    }


    public void crearCapacitacion(CrearCapacitacion capacitacion) {
        String consulta = "INSERT INTO asesorias.capacitacion (rut, diaCapacitacion, hora, lugar, cantidadAsistente) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, capacitacion.getRut());
            statement.setString(2, capacitacion.getDia());
            statement.setString(3, capacitacion.getHora());
            statement.setString(4, capacitacion.getLugar());
            statement.setString(5, capacitacion.getCantidad());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCapacitacion(ActualizarCapacitacion capacitacion) {
        String consulta = "UPDATE asesorias.capacitacion SET rut = ?, diaCapacitacion = ?, hora = ?, lugar = ?, cantidadAsistente = ? WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
        	
        	statement.setString(1, capacitacion.getRut());
            statement.setString(2, capacitacion.getDia());
            statement.setString(3, capacitacion.getHora());
            statement.setString(4, capacitacion.getLugar());
            statement.setString(5, capacitacion.getCantidad());
            statement.setInt(6, capacitacion.getId());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCapacitacion(int id) {
        String consulta = "DELETE FROM capacitacion WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean validarUsuario(Login login) {
    	boolean status = false;
    	String consulta = "SELECT * from asesorias.login WHERE user = ? and password = ? ";
    	
    	try (Connection conexion = obtenerConexion();
    		PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, login.getUsername());
            statement.setString(2, login.getPassword());
            
            System.out.println(statement);
            ResultSet rs = statement.executeQuery();
            status = rs.next();

    	} catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    		
    	}
    
    public void crearUsuario(CrearUsuario usuario) {
    	String consulta = "INSERT INTO asesorias.usuario (rut, nombreCompleto, fechaNacimiento, telefono, direccion, comuna, afp, sistemaSalud, fechaIngreso, titulo, area, experiencia, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	
    	try (Connection conexion = obtenerConexion();
    		PreparedStatement statement = conexion.prepareStatement(consulta)) {
    		statement.setString(1, usuario.getRun());
    		statement.setString(2, usuario.getNombreCompleto());
    		statement.setString(3, usuario.getFechaNacimiento());
    		statement.setString(4, usuario.getTelefono());
    		statement.setString(5, usuario.getDireccion());
    		statement.setString(6, usuario.getComuna());
    		statement.setString(7, usuario.getAfp());
    		statement.setString(8, usuario.getSistemaSalud());
    		statement.setString(9, usuario.getFechaIngreso());
    		statement.setString(10, usuario.getTitulo());
    		statement.setString(11, usuario.getArea());
    		statement.setString(12, usuario.getExperiencia());
    		statement.setString(13, usuario.getTipoUsuario());
    		
    		statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<ListarUsuarios> obtenerUsuarios() {
    	List<ListarUsuarios> listaUsuarios = new ArrayList<>();
    			
    	String consulta = "SELECT id, rut, nombreCompleto, fechaNacimiento, telefono, direccion, comuna, afp, sistemaSalud, fechaIngreso, titulo, area, experiencia, tipoUsuario FROM asesorias.usuario";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta);
             ResultSet resultSet = statement.executeQuery()) {
        	
        	while (resultSet.next()) {
            	ListarUsuarios usuario = new ListarUsuarios();
                usuario.setId(resultSet.getInt("id"));
                usuario.setRun(resultSet.getString("rut"));
                usuario.setNombreCompleto(resultSet.getString("nombreCompleto"));
                usuario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                usuario.setTelefono(resultSet.getString("telefono"));
                usuario.setDireccion(resultSet.getString("direccion"));
                usuario.setComuna(resultSet.getString("comuna"));
                usuario.setAfp(resultSet.getString("afp"));
                usuario.setSistemaSalud(resultSet.getString("sistemaSalud"));
                usuario.setFechaIngreso(resultSet.getString("fechaIngreso"));
                usuario.setTitulo(resultSet.getString("titulo"));
                usuario.setArea(resultSet.getString("area"));
                usuario.setExperiencia(resultSet.getString("experiencia"));
                usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));
                
                listaUsuarios.add(usuario);
                
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaUsuarios;
        }
    
    public EditarUsuario editarUsuarioID(int id) {
        EditarUsuario usuario = null;
        String consulta = "SELECT id, rut, nombreCompleto, fechaNacimiento, telefono, direccion, comuna, afp, sistemaSalud, fechaIngreso, titulo, area, experiencia, tipoUsuario FROM asesorias.usuario WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    usuario = new EditarUsuario();
                    
                    usuario.setId(resultSet.getInt("id"));
                    usuario.setRun(resultSet.getString("rut"));
                    usuario.setNombreCompleto(resultSet.getString("nombreCompleto"));
                    usuario.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
                    usuario.setTelefono(resultSet.getString("telefono"));
                    usuario.setDireccion(resultSet.getString("direccion"));
                    usuario.setComuna(resultSet.getString("comuna"));
                    usuario.setAfp(resultSet.getString("afp"));
                    usuario.setSistemaSalud(resultSet.getString("sistemaSalud"));
                    usuario.setFechaIngreso(resultSet.getString("fechaIngreso"));
                    usuario.setTitulo(resultSet.getString("titulo"));
                    usuario.setArea(resultSet.getString("area"));
                    usuario.setExperiencia(resultSet.getString("experiencia"));
                    usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
    
    public void actualizarUsuario(ActualizarUsuario usuario) {
        String consulta = "UPDATE asesorias.usuario SET rut = ?, nombreCompleto = ?, fechaNacimiento = ?, telefono = ?, direccion = ?, comuna = ?, afp = ?, sistemaSalud = ?, fechaIngreso = ?, titulo = ?, area = ?, experiencia = ?, tipoUsuario = ? WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
        	
        	statement.setString(1, usuario.getRun());
    		statement.setString(2, usuario.getNombreCompleto());
    		statement.setString(3, usuario.getFechaNacimiento());
    		statement.setString(4, usuario.getTelefono());
    		statement.setString(5, usuario.getDireccion());
    		statement.setString(6, usuario.getComuna());
    		statement.setString(7, usuario.getAfp());
    		statement.setString(8, usuario.getSistemaSalud());
    		statement.setString(9, usuario.getFechaIngreso());
    		statement.setString(10, usuario.getTitulo());
    		statement.setString(11, usuario.getArea());
    		statement.setString(12, usuario.getExperiencia());
    		statement.setString(13, usuario.getTipoUsuario());
            statement.setInt(14,usuario.getId());
            
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarUsuario(int id) {
        String consulta = "DELETE FROM usuario WHERE id = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    
    public boolean registrar(Contacto contacto) {
		String query = "INSERT INTO contacto(nombre, email, mensaje) values (?, ?, ? )";
		
		
		try {Connection conexion = obtenerConexion();
			
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.setString(1, contacto.getNombre());
			statement.setString(2, contacto.getEmail());
			statement.setString(3, contacto.getMensaje());
			
			if(statement.executeUpdate()>0) {
				System.out.println("Agregado Correctamente");
				return true;
			} else {
				System.out.println("No se pudo Agregar");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
}
                	   


    
    
    
    		
 
    
    
  
   
