package Testing;

import Modelo.BaseDeDatos;
import Modelo.Colaborador;
import Modelo.Grupo_de_Clientes;

public class BddTestFixture1 {
    BaseDeDatos base=new BaseDeDatos();
    public BddTestFixture1() {
        super();
    }
    
    public void setUp()
    {
        this.base.getGrupos().put(1, new Grupo_de_Clientes("nombre",1));
        this.base.getClientes().clear();
        Colaborador usuario1= new Colaborador("nombreApe", "email", "000000000000","colaborador", "nombreUsuario", "contraseña", this.base);
        this.base.getListaUsuarios().put( "nombreUsuario",usuario1);
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
