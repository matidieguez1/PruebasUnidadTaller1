package Testing;

import Modelo.Administrador;

import Modelo.Colaborador;
import Modelo.Grupo_de_Clientes;

import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class BddTest1 {
    BddTestFixture1 fixture1= new BddTestFixture1();
    public BddTest1() {
        super();
    }
    @Before
    public void setUp()
    {
        this.fixture1.setUp();
    }
    
    @After
    public void tearDown()
    {
        this.fixture1.tearDown();
    }
    
    /**
     * Verificar si el usuario es admin, con datos que coinciden.
     */
    @Test
    public void test_EsAdmin1()
    {
        Administrador admin=null;
        admin=this.fixture1.base.esAdmin("admin", "1234");
        assertNotNull("No coinciden el admin con el dato valido",admin);
               
    }
    /**
     * Verificar si el usuario es admin, con datos que NO coinciden.
     */
    @Test
    public void test_EsAdmin2()
    {
        Administrador admin=null;
        admin=this.fixture1.base.esAdmin("adminMAL", "1234");
        assertNull("No coinciden el admin con el dato valido",admin);
               
    }
    /**
     * elimina un grupo existente.
     */
    @Test
    public void test_DeleteGroup1()
    {
        this.fixture1.base.deleteGRupo(1);
        Grupo_de_Clientes grupo= new Grupo_de_Clientes("nombre",1);
        assertFalse("No elimino el grupo correctamente",this.fixture1.base.getGrupos().containsValue(grupo));
    }

    /**
     * elimina un grupo NO existente.
     */
    @Test
    public void test_DeleteGroup2()
    {
        this.fixture1.base.deleteGRupo(2);
     
        assertTrue("Elimino un elemento incorrecto",this.fixture1.base.getGrupos().size()==1);
    }
}
