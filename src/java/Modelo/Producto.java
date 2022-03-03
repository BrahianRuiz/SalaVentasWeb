
package Modelo;

public class Producto 
{
    int id, stock;
    String nom, estado;
    double precio;

    public Producto() {
    }

    public Producto(int id, int stock, String nom, String estado, double precio) 
    {
        this.id = id;
        this.stock = stock;
        this.nom = nom;
        this.estado = estado;
        this.precio = precio;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    public String getNom() 
    {
        return nom;
    }

    public void setNom(String nom) 
    {
        this.nom = nom;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public double getPrecio() 
    {
        return precio;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }
}
