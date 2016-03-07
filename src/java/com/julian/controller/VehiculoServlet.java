/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.controller;

import com.julian.Dao.VehiculoDaoLocal;
import com.julian.model.Vehiculo;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoDaoLocal vehiculoDao;

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
        String vehiculoIdStr= request.getParameter("vehiculoId");
        int vehiculoId=0;
        if(vehiculoIdStr!=null && !vehiculoIdStr.equals(""))
            vehiculoId=Integer.parseInt(vehiculoIdStr);
        
        String fabricante=request.getParameter("fabricante");
        String fecha=request.getParameter("fecha");
       String cilindraje=request.getParameter("cilindraje");
       String potencia=request.getParameter("potencia");
       
       String precioStr=request.getParameter("precio");
       int precio=0;
       if(precioStr!=null && !precioStr.equals(""))
          precio=Integer.parseInt(precioStr);

       
       boolean transmision=true;
       String imagen=request.getParameter("imagen");
       String modelo=request.getParameter("modelo");
       
       Vehiculo vehiculo=new Vehiculo(vehiculoId,fabricante,fecha, cilindraje,potencia,precio,transmision,imagen,modelo);
        
       if("Add".equalsIgnoreCase(action)){
       vehiculoDao.addVehiculo(vehiculo);
       }  else  if("Edit".equalsIgnoreCase(action)){
           vehiculoDao.editVehiculo(vehiculo);
       }else   if("Delete".equalsIgnoreCase(action)){
           vehiculoDao.deleteVehiculo(vehiculoId);
       }else  if("Search".equalsIgnoreCase(action)){
           vehiculo=vehiculoDao.getVehiculo(vehiculoId);
       }
       
       request.setAttribute("vehiculo",vehiculo);
       request.setAttribute("allVehiculos", vehiculoDao.getAllVehiculo());
       request.getRequestDispatcher("vehiculoinfo.jsp").forward(request, response);
        
        
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
