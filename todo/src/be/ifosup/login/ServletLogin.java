package be.ifosup.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = {"/"})
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupérer les 2 champs du formulaire
        String nom = request.getParameter("nom");
        String pass = request.getParameter("pass");
        // verification
        if (LoginDAO.valid(nom,pass)){
            request.getSession().setAttribute("nom",nom);
            System.out.println("OK");
            response.sendRedirect("todo");
        }else{
            request.setAttribute("errorMessage","Login/pass invalide !");
            request.getRequestDispatcher("/vues/login.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/vues/login.jsp").forward(request,response);
    }
}
