/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.AutorDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Admin
 */
@Stateless
public class AutorBL implements AutorBLLocal {
    @EJB
    private AutorDaoLocal autorDao;

    @Override
    public boolean registrar(Autor autor) {
        autorDao.crear(autor);
        return true;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public boolean eliminar(Autor autor) {
        autorDao.remover(autor);
        return false;
    }

    @Override
    public Autor getPorld(int id) {
        return autorDao.buscarPorId(id);
    }

    @Override
    public List<Autor> getLista() {
        return autorDao.buscarTodos();
    }

    @Override
    public boolean modificar(Autor autor) {
        autorDao.editar(autor);
        return false;
    }

 
}
