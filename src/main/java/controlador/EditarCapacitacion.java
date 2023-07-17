package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import modelo.Conexion;

/**
 * Servlet implementation class EditarCapacitacion
 */
@WebServlet("/Editar-Capacitaciones")
public class EditarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String rut;
	private String dia;
	private String hora;
	private String lugar;
	private String cantidad;
	private String capacitaciones;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCapacitacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Conexion conexion = Conexion.getInstancia();
		EditarCapacitacion capacitacion = conexion.obtenerCapacitacionesPorId(id);

        request.setAttribute("capacitacion", capacitacion);
        request.getRequestDispatcher("editar_capacitacion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getCapacitaciones() {
		return capacitaciones;
	}

	public void setCapacitaciones(String capacitaciones) {
		this.capacitaciones = capacitaciones;
	}

}
