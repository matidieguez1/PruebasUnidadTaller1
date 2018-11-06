package Testing;

import Modelo.Administrador;
import Modelo.BaseDeDatos;
/**
 * Pruebo como reacciona el admin frente a una base de datos vacia.<br>
 */
public class AdminTestFixture1 {
    BaseDeDatos base=new BaseDeDatos();
    Administrador admin= this.base.getAdmin();
    public AdminTestFixture1() {
        super();
    }
    
    public void setUp()
    {
        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
    public void tearDown()
    {
        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
}
