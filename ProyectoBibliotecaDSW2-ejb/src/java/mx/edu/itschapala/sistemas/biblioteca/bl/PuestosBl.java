/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.PuestosDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puestos;

/**
 *
 * @author Admin
 */
@Stateless
public class PuestosBl implements PuestosBlLocal {
    @EJB
    private PuestosDaoLocal puestosDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean registrar(Puestos puestos) {
        puestosDao.crear(puestos);
        return true;
    }

    @Override
    public boolean eliminar(Puestos puestos) {
        puestosDao.remover(puestos);
        return true;
    }

    @Override
    public boolean modificar(Puestos puestos) {
        puestosDao.editar(puestos);
        return true;
    }

    @Override
    public List<Puestos> getLista() {
        return puestosDao.buscarTodos();
    }

    @Override
    public Puestos getPorId(int id) {
        return puestosDao.buscarPorId(id);
    }
}
