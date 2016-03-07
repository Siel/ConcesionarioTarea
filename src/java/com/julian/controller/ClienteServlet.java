/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.controller;

import com.julian.Dao.ClienteDao;
import com.julian.Dao.ClienteDaoLocal;
import com.julian.model.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Siel
 */
public class ClienteServlet extends HttpServlet {

    @EJB
    private ClienteDaoLocal clienteDao;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String action=request.getParameter("action");
        String clienteIdStr= request.getParameter("identificacion");
        int clienteId=0;
        if(clienteIdStr!=null && !clienteIdStr.equals(""))
            clienteId=Integer.parseInt(clienteIdStr);
        
       String identificacion=request.getParameter("identificacion");
       String nombre=request.getParameter("nombre");
       String apellido=request.getParameter("apellido");
       String edad=request.getParameter("edad");
       String direccion=request.getParameter("direccion");
       String telefono=request.getParameter("telefono");
       
       Cliente cliente=new Cliente(clienteId,identificacion,nombre,apellido,edad,direccion,telefono);
        
       if("Add".equalsIgnoreCase(action)){
       clienteDao.addCliente(cliente);
       }  else  if("Edit".equalsIgnoreCase(action)){
           clienteDao.editCliente(cliente);
       }else   if("Delete".equalsIgnoreCase(action)){
           clienteDao.deleteCliente(clienteId);
       }else  if("Search".equalsIgnoreCase(action)){
           cliente=clienteDao.getCliente(clienteId);
       }
       
       request.setAttribute("cliente",cliente);
       request.setAttribute("allClientes", clienteDao.getAllClientes());
       request.getRequestDispatcher("clienteinfo.jsp").forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
