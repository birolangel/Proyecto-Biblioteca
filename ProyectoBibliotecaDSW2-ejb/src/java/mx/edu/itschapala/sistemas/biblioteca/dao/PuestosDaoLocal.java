/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.dao;

import java.util.List;
import javax.ejb.Local;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puestos;

/**
 *
 * @author Admin
 */
@Local
public interface PuestosDaoLocal {

    void crear(Puestos puestos);

    void editar(Puestos puestos);

    void remover(Puestos puestos);

    Puestos buscarPorId(Object id);

    List<Puestos> buscarTodos();

    List<Puestos> buscarEnRango(int[] range);

    int contar();
    
}
