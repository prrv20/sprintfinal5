package controlador;
import java.io.IOException;
import modelo.Conexion;
import modelo.ContactoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Contacto;
/**
 * Servlet implementation class ContactoServlet
 */
@WebServlet("/ContactoController")
public class ContactoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactoController() {
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
		
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String mensaje = request.getParameter("mensaje");
		
		Contacto contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setEmail(email);
		contacto.setMensaje(mensaje);
		
		Conexion conexion = Conexion.getInstancia();
		

		if(conexion.registrar(contacto)) {
			request.setAttribute("mensaje", "Gracias por contactarnos...");
		} else {
			request.setAttribute("mensaje", "No se pudo Enviar..");
		}
		
		request.getRequestDispatcher("contacto.jsp").forward(request, response);
	}
}
