
package Controlador;

import Config.GenerarSerie;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet 
{

    Empleado em = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    int ide;
    int idc;
    int idp;

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();
    int item;
    int cod;
    String descripcion;
    double precio;
    int cant;
    double subtotal;
    double totalpagar;
    String numeroserie;
    VentaDAO vdao = new VentaDAO();
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
        {
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            
            if (menu.equals("Principal")) 
            {
                request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            
            if (menu.equals("Empleado")) 
            {
                switch (accion) 
                {
                    case "Listar":
                        List lista = edao.listar();
                        request.setAttribute("empleados", lista);
                        break;

                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String tel = request.getParameter("txtTel");
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUser");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        Empleado e = edao.listarIid(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                        
                    case "Actualizar":
                        String dni1 = request.getParameter("txtDni");
                        String nom1 = request.getParameter("txtNombres");
                        String tel1 = request.getParameter("txtTel");
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUser");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                        
                    case "Delete":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.delete(ide);
                        request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                   
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
            }
            
            if (menu.equals("Cliente")) 
            {
                switch (accion) 
                {
                    case "Listar":
                        List lista = cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;

                    case "Agregar":
                        String dni = request.getParameter("txtDni");
                        String nom = request.getParameter("txtNombres");
                        String dir = request.getParameter("txtDir");
                        String est = request.getParameter("txtEstado");
                        c.setDni(dni);
                        c.setNom(nom);
                        c.setDir(dir);
                        c.setEs(est);
                        cdao.agregar(c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        Cliente cl = cdao.listarIid(idc);
                        request.setAttribute("cliente", cl);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                        
                    case "Actualizar":
                        String dni3 = request.getParameter("txtDni");
                        String nom3 = request.getParameter("txtNombres");
                        String dir3 = request.getParameter("txtDir");
                        String est3 = request.getParameter("txtEstado");
                        c.setDni(dni3);
                        c.setNom(nom3);
                        c.setDir(dir3);
                        c.setEs(est3);
                        c.setId(idc);
                        cdao.actualizar(c);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                        
                    case "Delete":
                        idc = Integer.parseInt(request.getParameter("id"));
                        cdao.delete(idc);
                        request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                   
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Clientes.jsp").forward(request, response);
            }
            
            if (menu.equals("Producto")) 
            {
                switch (accion) 
                {
                    case "Listar":
                        List lista = pdao.listar();
                        request.setAttribute("productos", lista);
                        break;

                    case "Agregar":
                        String nom = request.getParameter("txtNombres");
                        double pre = Double.parseDouble(request.getParameter("txtPre"));
                        int sto = Integer.parseInt(request.getParameter("txtStock"));
                        String est = request.getParameter("txtEstado");
                        p.setNom(nom);
                        p.setPrecio(pre);
                        p.setStock(sto);
                        p.setEstado(est);
                        pdao.agregar(p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;

                    case "Editar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        Producto pr = pdao.listarIid(idp);
                        request.setAttribute("producto", pr);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                        
                    case "Actualizar":
                        String h,h1;
                        if((request.getParameter("txtPre")).equals(""))
                        {
                             h="0";
                        }
                        else
                        {
                             h=request.getParameter("txtPre");
                        }
                        if((request.getParameter("txtStock")).equals(""))
                        {
                             h1="0";
                        }
                        else
                        {
                             h1=request.getParameter("txtStock");
                        }
                        String nom1 = request.getParameter("txtNombres");
                        double pre1 = Double.parseDouble(h);
                        int sto1 = Integer.parseInt(h1);
                        String est1 = request.getParameter("txtEstado");
                        p.setNom(nom1);
                        p.setPrecio(pre1);
                        p.setStock(sto1);
                        p.setEstado(est1);
                        p.setId(idp);
                        pdao.actualizar(p);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Delete":
                        idp = Integer.parseInt(request.getParameter("id"));
                        pdao.delete(idp);
                        request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    
                    default:
                        throw new AssertionError();
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
            }
            
            if (menu.equals("NuevaVenta")) 
            {
                switch (accion) 
                {
                    case "BuscarCliente":
                        String dni = request.getParameter("codigocliente");
                        c.setDni(dni);
                        c = cdao.buscar(dni);
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("c", c);
                        break;
                        
                    case "BuscarProducto":
                        int id = Integer.parseInt(request.getParameter("codigoproducto"));
                        System.out.println("num s"+numeroserie);
                        p = pdao.listarIid(id);
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("c", c);
                        request.setAttribute("producto", p);
                        request.setAttribute("lista", lista);
                        request.setAttribute("totalpagar", totalpagar);
                        break;
                        
                    case "Agregar":
                        request.setAttribute("c", c);
                        totalpagar = 0.0;
                        item += 1;
                        cod = p.getId();
                        descripcion = request.getParameter("nomproducto");
                        precio = Double.parseDouble(request.getParameter("precio"));
                        cant = Integer.parseInt(request.getParameter("cant"));
                        subtotal = precio * cant;
                        v = new Venta();
                        v.setItem(item);
                        v.setIdproducto(cod);
                        v.setDescripcionP(descripcion);
                        v.setPrecio(precio);
                        v.setCantidad(cant);
                        v.setSubtotal(subtotal);
                        lista.add(v);
                        for (int i = 0; i < lista.size(); i++) 
                        {
                            totalpagar = totalpagar + lista.get(i).getSubtotal();
                        }
                        request.setAttribute("nserie", numeroserie);
                        request.setAttribute("totalpagar", totalpagar);
                        request.setAttribute("lista", lista);
                        break;
                        
                    case "GenerarVenta":
                        //Guardar venta
                        v.setIdcliente(c.getId());
                        v.setIdempleado(1);
                        v.setNumserie(numeroserie);
                        v.setFecha("2019-06-14");
                        v.setMonto(totalpagar);
                        v.setEstado("1");
                        vdao.guardarVenta(v);
                        //Guardar Detalle ventas
                        int idv=Integer.parseInt(vdao.IdVentas());
                        for (int i = 0; i < lista.size(); i++) 
                        {
                            v = new Venta();
                            v.setId(idv);
                            v.setIdproducto(lista.get(i).getIdproducto());
                            v.setCantidad(lista.get(i).getCantidad());
                            v.setPrecio(lista.get(i).getPrecio());
                            vdao.guardarDetalleVentas(v);
                        }
                         //Actualizar Stock
                        for (int i = 0; i < lista.size(); i++) 
                        {
                            Producto  pr = new Producto();
                            int cantidad=lista.get(i).getCantidad();
                            int idproducto=lista.get(i).getIdproducto();
                            ProductoDAO aO =new ProductoDAO();
                            pr=aO.buscar(idproducto);
                            int sac =pr.getStock()-cantidad;
                            aO.actualizarstock(pr.getId(), sac);//(idproducto,sac)
                           request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                        }
                        break;

                    default:
                        v = new Venta();
                        lista = new ArrayList<>();
                        item = 0;
                        totalpagar = 0.0;
                        numeroserie = vdao.GenerarSerie();
                        if (numeroserie == null) 
                        {
                            numeroserie = "00000001";
                            request.setAttribute("nserie", numeroserie);
                        }
                        else 
                        {
                            int incrementar = Integer.parseInt(numeroserie);
                            GenerarSerie gs = new GenerarSerie();
                            numeroserie = gs.NumeroSerie(incrementar);
                            request.setAttribute("nserie", numeroserie);
                        }
                        request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                }
                request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
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
