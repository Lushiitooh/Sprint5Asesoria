package com.example.modulo5.controller;

import com.example.modulo5.dao.ILogin;
import com.example.modulo5.dao.daoimpl.LoginDaoImpl;
import com.example.modulo5.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/LoginSv")
public class LoginSv extends HttpServlet{
    private int runInput;
    private String passwordInput ;
    private ILogin usuarioLogin = new LoginDaoImpl();
    private Usuario usuario;
    private int tipoUsuarioSV;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSv() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter salidaImpresion = response.getWriter();

        String requestUsuario = "";
        String requestPassword = "";

        requestUsuario = request.getParameter("run");
        requestPassword = request.getParameter("password");

        int requestUsuarioInt = Integer.parseInt(requestUsuario);

        System.out.println(Integer.parseInt(requestUsuario) + " " + requestPassword);

        usuario = usuarioLogin.usuarioLogin(requestUsuarioInt);
        String prueba = usuario.getNombres();
        System.out.println(prueba);

        runInput = requestUsuarioInt;
        passwordInput = requestPassword;
        tipoUsuarioSV = usuario.getIdTipoUsuario();


        if(!(runInput == usuario.getRun()) || !passwordInput.equals(usuario.getPassword())) {
            salidaImpresion.println("<script type=\"text/javascript\">");
            salidaImpresion.println("alert('RUN o password incorrectos');");
            salidaImpresion.println("location='views/login.jsp';");
            salidaImpresion.println("</script>");

        } else {

            HttpSession sesionUsuario= request.getSession(true);
            sesionUsuario.setAttribute("tipoUsuario", tipoUsuarioSV);
            RequestDispatcher rd = request.getRequestDispatcher("/ListarCapacitacionSv");
            rd.forward(request, response);
        }
    }
}
