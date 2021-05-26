package com.emergentes.controlador;

import com.emergentes.dao.UsuariosDAO;
import com.emergentes.dao.UsuariosDAOimpl;
import com.emergentes.modelo.Usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UsuariosControlador", urlPatterns = {"/UsuariosControlador"})
public class UsuariosControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Usuarios us = new Usuarios();
            int id;
            UsuariosDAO dao = new UsuariosDAOimpl();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    request.setAttribute("usuarios", us);
                    request.getRequestDispatcher("frmusuarios.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    us = dao.getById(id);
                    request.setAttribute("usuarios", us);
                    request.getRequestDispatcher("frmusuarios.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("UsuariosControlador");
                    break;
                case "view":
                    // Obtener la lista de registros
                    List<Usuarios> lista = dao.getAll();
                    request.setAttribute("usuarios",lista);
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
                    break;
            }
            
        }catch(Exception ex){
            System.out.println("Error " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String usuario = request.getParameter("usuario");
        String correo =  request.getParameter("correo");
        String clave = request.getParameter("clave");
        
        Usuarios us = new Usuarios();
        
        us.setId(id);
        us.setUsuario(usuario);
        us.setCorreo(correo);
        us.setClave(clave);
        
        UsuariosDAO dao = new UsuariosDAOimpl();
        if (id == 0){
            try {
                // Nuevo registro
                dao.insert(us);
            } catch (Exception ex) {
                System.out.println("Error al insertar "+ex.getMessage());
            }
        }
        else{
            try {
                // Edicion de registro
                dao.update(us);
            } catch (Exception ex) {
                System.out.println("Error al editar "+ex.getMessage());
            }
        }
        //response.sendRedirect("UsuariosControlador");
    }
}
