package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import modelo.Conexion;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String run;
	private String nombreCompleto;
	private String fechaNacimiento;
	private String telefono;
	private String direccion;
	private String comuna;
	private String afp;
	private String sistemaSalud;
	private String fechaIngreso;
	private String titulo;
	private String area;
	private String experiencia;
	private String tipoUsuario;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String run = request.getParameter("run");
		String nombreCompleto = request.getParameter("nombreCompleto");
		String fechaNacimiento = request.getParameter("fechaNacimiento");
		String telefono = request.getParameter("telefono");
		String direccion = request.getParameter("direccion");
		String comuna = request.getParameter("comuna");
		String afp = request.getParameter("afp");
		String sistemaSalud = request.getParameter("sitemaSalud");
		String fechaIngreso = request.getParameter("fechaIngreso");
		String titulo = request.getParameter("titulo");
		String area = request.getParameter("area");
		String experiencia = request.getParameter("experiencia");
		String tipoUsuario = request.getParameter("tipoUsuario");
		
		CrearUsuario usuario = new CrearUsuario();
		usuario.setRun(run);
		usuario.setNombreCompleto(nombreCompleto);
		usuario.setFechaNacimiento(fechaNacimiento);
		usuario.setTelefono(telefono);
		usuario.setDireccion(direccion);
		usuario.setComuna(comuna);
		usuario.setAfp(afp);
		usuario.setSistemaSalud(sistemaSalud);
		usuario.setFechaIngreso(fechaIngreso);
		usuario.setTitulo(titulo);
		usuario.setArea(area);
		usuario.setExperiencia(experiencia);
		usuario.setTipoUsuario(tipoUsuario);
		
		Conexion conexion = Conexion.getInstancia();
		conexion.crearUsuario(usuario);
		
		request.getRequestDispatcher("ListarUsuarios").forward(request, response);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public String getSistemaSalud() {
		return sistemaSalud;
	}

	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
