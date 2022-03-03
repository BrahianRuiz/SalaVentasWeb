
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO 
{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Producto buscar(int id)
    {
        Producto p = new Producto();
        String sql="select * from producto where idProducto="+id;
        try 
        {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) 
            {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error al buscar (ProductoDAO): " + e.getMessage());
        }
        return p;
    }
    
    public int actualizarstock(int id, int stock)
    {
        String sql= "update producto set Stock=? where IdProducto=?";
        try 
        {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1,stock);
            ps.setInt(2,id);
            
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            System.out.println("Error actualizar stock (ProductoDAO): " + e.getMessage());
        }
        return r;
    }
    
    public List listar() 
    {
        String sql = "select * from producto";
        List<Producto> Lista = new ArrayList<>();
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                Lista.add(p);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error al listar (ProductoDAO): " + e.getMessage());
        }
        return Lista;
    }

    public int agregar(Producto p) 
    {
        String sql = "insert into producto(Nombres, Precio, Stock, Estado)values(?,?,?,?)";
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al agregar (ProductoDAO): " + e.getMessage());
        }
        return r;
    }

    public Producto listarIid(int id) 
    {
        Producto p = new Producto();
        String sql = "select  * from producto where IdProducto="+id;
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) 
            {
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error al listarID (ProdcutoDAO): " + e.getMessage());
        }
        return p;
    }

    public int actualizar(Producto p) 
    {
        String sql = "update  cliente set Nombres=?, Precio=?, Stock=?, Estado=? where IdProducto=?";
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setString(4, p.getEstado());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al actualizar (ProductoDAO): " + e.getMessage());
        }
        return r;
    }

    public void delete(int id) 
    {
        String sql = "delete  from producto where IdProducto=" + id;
        try 
        {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } 
        catch (Exception e) 
        {
            System.out.println("Error al borrar (ProductoDAO): "  + e.getMessage());
        }
    }
}