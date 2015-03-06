/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puestos;

/**
 *
 * @author Admin
 */
@Local
public interface PuestosBlLocal {

    boolean registrar(Puestos puestos);

    boolean eliminar(Puestos puestos);

    boolean modificar(Puestos puestos);

    List<Puestos> getLista();

    Puestos getPorId(int id);
    
}
