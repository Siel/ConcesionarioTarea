/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.julian.controller;

import com.julian.Dao.ClienteDaoLocal;
import com.julian.Dao.VehiculoDaoLocal;
import com.julian.Dao.VentaDaoLocal;
import com.julian.model.Cliente;
import com.julian.model.Vehiculo;
import com.julian.model.Venta;
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
public class VentaServlet extends HttpServlet {

    @EJB
    private VehiculoDaoLocal vehiculoDao;

    @EJB
    private ClienteDaoLocal clienteDao;

    @EJB
    private VentaDaoLocal ventaDao;

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
        String ventaIdStr= request.getParameter("ventaId");
        int ventaId=0;
        if(ventaIdStr!=null && !ventaIdStr.equals(""))
            ventaId=Integer.parseInt(ventaIdStr);
        
        String clienteIdStr=request.getParameter("clienteId");
        int clienteId=0;
        if(clienteIdStr!=null && !clienteIdStr.equals(""))
            clienteId=Integer.parseInt(clienteIdStr);
        
        String modelo=request.getParameter("modelo");
        /*int vehiculoId=0;
        if(vehiculoIdStr!=null && !vehiculoIdStr.equals(""))
            vehiculoId=Integer.parseInt(vehiculoIdStr);
       */
       String matricula=request.getParameter("matricula");
       String fecha=request.getParameter("fecha");
       
       //Cliente cliente= new Cliente(1036939812,"1036939812","Tatiana","Escobar","25","direccionTati","5611213");
       //Vehiculo vehiculo = new Vehiculo(1,"fabricante","2017/03/20","cilindraje","potencia",5000000,true,"imagen","modelo");
       
       Cliente cliente = clienteDao.getCliente(clienteId);
       Vehiculo vehiculo = vehiculoDao.getVehiculo(modelo);
       
       Venta venta=new Venta(ventaId, cliente, vehiculo, matricula, fecha);
        
       if("Add".equalsIgnoreCase(action)){
       ventaDao.addVenta(venta);
       }  else  if("Edit".equalsIgnoreCase(action)){
           ventaDao.editVenta(venta);
       }else   if("Delete".equalsIgnoreCase(action)){
           ventaDao.deleteVenta(ventaId);
       }else  if("Search".equalsIgnoreCase(action)){
           venta=ventaDao.getVenta(ventaId);
       }
       
       request.setAttribute("venta",venta);
       request.setAttribute("allVentas", ventaDao.getAllVentas());
       request.getRequestDispatcher("ventainfo.jsp").forward(request, response);
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
