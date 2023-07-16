package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import modelo.Conexion;


/**
 * Servlet implementation class UserLogin
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
    

	public Login () {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if (action == null) {
			request.getRequestDispatcher("usuario.jsp").forward(request, response);
		} else {
			if (action.equalsIgnoreCase("cerrar_sesion.jsp")) {
				session.removeAttribute("usName");
				response.sendRedirect("Login");
			}
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		 PrintWriter out = response.getWriter();
		 HttpSession session = request.getSession();
		
		 String username = request.getParameter("username");
	     String password = request.getParameter("password");
	     
	     Login login = new Login();
	     login.setUsername(username);
	     login.setPassword(password);

	     Conexion conexion = Conexion.getInstancia();
	     	     
	     if (conexion.validarUsuario(login)) {
	         if (username.equals("admin")) {
	             if (password.equals("1234")) {
	                 session.setAttribute("admin", username);
	                 response.sendRedirect("usuario.jsp?name=" + username);
	             } else {
	                 RequestDispatcher rd = request.getRequestDispatcher("login_user.jsp");
	                 out.println("<font color=red>Usuario / Password incorrecto, intenta nuevamente</font>");
	                 rd.include(request, response);
	             }
	         } else {
	             RequestDispatcher rd = request.getRequestDispatcher("login_user.jsp");
	             out.println("<font color=red>Usuario / Password incorrecto, intenta nuevamente</font>");
	             rd.include(request, response);
	         }
	     } else {
	         RequestDispatcher rd = request.getRequestDispatcher("login_user.jsp");
	         out.println("<font color=red>Usuario / Password incorrecto, intenta nuevamente</font>");
	         rd.include(request, response);
	     }

	     out.close();
	 }
		
		  // Set the content type of response to "text/html"
        
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
