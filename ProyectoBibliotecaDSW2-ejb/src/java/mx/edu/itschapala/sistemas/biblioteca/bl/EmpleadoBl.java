/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.EmpleadoDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Empleado;
/**
 *
 * @author Admin
 */
@Stateless
public class EmpleadoBl implements EmpleadoBlLocal {
    @EJB
    private EmpleadoDaoLocal empleadoDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean registrar(Empleado empleado) {
        empleadoDao.crear(empleado);
        return true;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        empleadoDao.remover(empleado);
        return true;
    }

    @Override
    public boolean modificar(Empleado empleado) {
        empleadoDao.editar(empleado);
        return true;
    }

    @Override
    public List<Empleado> getLista() {
        return empleadoDao.buscarTodos();
    }

    @Override
    public Empleado getPorId(int id) {
        return empleadoDao.buscarPorId(id);
    }
}
