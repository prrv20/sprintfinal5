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
import controlador.ListarCapacitacion;
import controlador.Login;

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
    }
  
   
