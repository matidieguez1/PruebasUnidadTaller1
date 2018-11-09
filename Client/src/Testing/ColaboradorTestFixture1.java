package Testing;

import Modelo.BaseDeDatos;
import Modelo.Colaborador;

public class ColaboradorTestFixture1
{
    BaseDeDatos base = new BaseDeDatos();
    Colaborador colTest = new Colaborador("nombreApe", "email","telefono","Colaborador","nombreUsuario","contraseña",this.base);
 
    public ColaboradorTestFixture1()
    {
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
    
    public void tearDown() {

        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
}
