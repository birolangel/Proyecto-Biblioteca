/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import mx.edu.itschapala.sistemas.biblioteca.bl.EmpleadoBlLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Empleado;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class EmpleadoBean {
  @EJB
    private EmpleadoBlLocal empleadoBL;
    
    private List<Empleado> lista;
        
    
    /**
     * Creates a new instance of EmpleadoBean
     */
    public EmpleadoBean() {
    }
    public List<Empleado> getLista(){
        lista=empleadoBL.getLista();
        return lista;
    }
}
