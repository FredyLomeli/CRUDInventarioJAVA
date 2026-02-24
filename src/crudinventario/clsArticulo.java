/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

/**
 *
 * @author Fredy
 */
public class clsArticulo {
    
    // Atributos que necesito que tenga mi objeto articulo
    private String codigo;
    private String descripcion;
    private Double precio;
    
    //Constructor
    public clsArticulo(String codigo, String descripcion, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    //Imprimir en consola los datos del articulo.
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio;
        return articulo;
    }
    
    // Guardar información 
    public void guardar(){
        System.out.println(this.aTexto());
    }
}
