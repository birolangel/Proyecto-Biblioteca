/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;
/**
 *
 * @author Admin
 */
@Local
public interface AutorBLLocal {

    boolean registrar(Autor autor);

    boolean eliminar(Autor autor);

    Autor getPorld(int id);

    List<Autor> getLista();

    boolean modificar(Autor autor);

   
    
}
