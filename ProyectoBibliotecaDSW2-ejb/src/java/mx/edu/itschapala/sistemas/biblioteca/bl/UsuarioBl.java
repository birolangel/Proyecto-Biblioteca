/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.bl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mx.edu.itschapala.sistemas.biblioteca.dao.UsuarioDaoLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Usuario;

/**
 *
 * @author Admin
 */
@Stateless
public class UsuarioBl implements UsuarioBlLocal {
    @EJB
    private UsuarioDaoLocal usuarioDao;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public boolean registrar(Usuario usuario) {
        usuarioDao.crear(null);
        return true;
    }

    @Override
    public boolean eliminar(Usuario usuario) {
        return true;
    }

    @Override
    public boolean modificar(Usuario usuario) {
        return true;
    }

    @Override
    public List<Usuario> getLista() {
        return null;
    }

    @Override
    public Usuario getPorId(int id) {
        return null;
    }
}
