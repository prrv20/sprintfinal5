package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ListadoUsuarios
 */
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuarios() {
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
		
		String rut = request.getParameter("rut");
		String dia = request.getParameter("dia");
		String hora = request.getParameter("hora");
		String lugar =request.getParameter("lugar");
		String cantidad = request.getParameter("cantidad");
		
		request.setAttribute("rut", rut);
		request.setAttribute("dia", dia);
		request.setAttribute("hora", hora);
		request.setAttribute("lugar", lugar);
		request.setAttribute("cantidad", cantidad);
		request.getRequestDispatcher("listar_capacitaciones.jsp").forward(request, response);
	}

}
