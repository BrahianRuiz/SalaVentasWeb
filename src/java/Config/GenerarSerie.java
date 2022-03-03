
package Config;

public class GenerarSerie 
{
    int dato;
    String numero;
    public String NumeroSerie(int dato) 
    {
        this.dato = dato + 1;
        numero = String.format("%08d", this.dato);
        return numero;
    }  
}
