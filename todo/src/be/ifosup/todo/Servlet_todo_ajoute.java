package be.ifosup.todo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_todo_ajoute", urlPatterns = {"/add-todo"})
public class Servlet_todo_ajoute extends HttpServlet {
    private TodoService todoService = new TodoService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //Récupération des champs du formulaire
        String nouveauTodo = request.getParameter("todo");
        String categorie = request.getParameter("categorie");

        //Ajout d'un todo
        todoService.ajouteTodo(new Todo(nouveauTodo,categorie));

        //Redirection
        response.sendRedirect("todo");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/vues/todoAdd.jsp").forward(request,response);
    }
}
