/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

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
    //Sobrecarga de metodo constructor
    public clsArticulo(){
        
    }
    
    //Imprimir en consola los datos del articulo.
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio;
        return articulo;
    }

    public String getDescripcion(){
        return this.descripcion;
    }
    
    // Guardar información 
    public void guardar(){
        // Instanciando la clase de MODELO
        mArticulo article = new mArticulo();
        // Enviamos la cadena de texto para guardar en el archivo
        article.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> llenarLista(){
        // Instancia desde lo datos (modelo)
        mArticulo mArticle = new mArticulo();
        // Llenamos la variable con los datos desde el modelo
        ArrayList<String> datos = mArticle.consultar();
        
        // Creamos la plantilla en blanco para el modelo
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        // llenamos la plantilla con los datos del modelo
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        // devolvemos los datos cargados en el modelo de lista
        return modelLista;
    }
    
    public void actualizar(String newCodigo, String newDescripcion,
        String newPrecio){
        
        // Generamos la nueva linea del registro
        String nuevaLinea = newCodigo + "|" + newDescripcion + "|" +
                newPrecio;
        String lineaOriginal = this.codigo.trim() + "|" + 
                this.descripcion.trim() + "|" + this.precio;
        //Imprimir los nuevos valores
        System.out.println("Nuevo valores:" + nuevaLinea);
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la actualización del registro
        mArticulo mArticle = new mArticulo();
        mArticle.update(lineaOriginal, nuevaLinea, 
                "listado_articulos.txt");
    }
    
    public void eliminar(){
        // Registro a eliminar
        String lineaOriginal = this.codigo + "|" + this.descripcion +
                "|" + this.precio;
        System.out.println("Valores Originales:" + lineaOriginal);
        // Solicita la eliminación del registro
        mArticulo mArticle = new mArticulo();
        mArticle.delete(lineaOriginal, "listado_articulos.txt");
    }
}
