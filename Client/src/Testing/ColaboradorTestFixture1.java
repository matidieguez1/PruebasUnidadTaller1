package Testing;

import Modelo.BaseDeDatos;
import Modelo.Colaborador;

public class ColaboradorTestFixture1
{
    Colaborador colTest = new Colaborador();
    BaseDeDatos bddTest = new BaseDeDatos();
    
    public ColaboradorTestFixture1()
    {
        super();
    }
    
    public void setUp()
    {
        this.bddTest.getTareas().clear();
        this.bddTest.getServicios().clear();
        this.bddTest.getClientes().clear();
        this.bddTest.getListaUsuarios().clear();
        this.bddTest.getGrupos().clear();
    }
    
    public void tearDown() {
        this.bddTest.getTareas().clear();
        this.bddTest.getServicios().clear();
        this.bddTest.getClientes().clear();
        this.bddTest.getListaUsuarios().clear();
        this.bddTest.getGrupos().clear();
    }
}
