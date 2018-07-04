/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;

/**
 *
 * @author Kevin
 */
public interface Operaciones {
    //se indicaran las operaciones basicas a realizar en esta interface
    //son consultas generales que sirven para cualquier tabla de la DB
    public String insertar(Object obj);
    public String eliminar(Object obj);
    public String modificar(Object obj);
    public String consultas(Object obj);
    
    //para ver resultados (listados)
    public LinkedList<?> consultar();
    //para poder filtrar, hay que indicar la columna y el criterio (condicion)
    public LinkedList<?> filtrar(String campo, String criterio);
    
}
