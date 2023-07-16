package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.lang.*;



/**
 * Servlet implementation class UserLogin
 */

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		
		  // Set the content type of response to "text/html"
        response.setContentType("text/html");
  
        // Get the print writer object to write into the response
        PrintWriter out = response.getWriter();
  
        // Get the session object
        HttpSession session = request.getSession();
  
        // Get User entered details from the request using request parameter.
        String user = request.getParameter("usName");
        String password = request.getParameter("usPass");
  
        // Validate the password - If password is correct, 
        // set the user in this session
        // and redirect to welcome page
        if (user.equals("admin")) {
            
            if (password.equals("1234")) {
                session.setAttribute("admin", user);
                response.sendRedirect("usuario.jsp?name=" + user);

            }
            // If the password is wrong, display the error message on the login page.
            else {
            RequestDispatcher rd = request.getRequestDispatcher("login_user.jsp");
            out.println("<font color=red>Contraseña incorrecta, intenta nuevamente</font>");
            rd.include(request, response);  
            }
            
            }
            
            else {
                RequestDispatcher rd = request.getRequestDispatcher("login_user.jsp");
                out.println("<font color=red>Usuario incorrecto, intenta nuevamente</font>");
                rd.include(request, response);
            }
        // Close the print writer object.
        out.close();
    }
	

}
