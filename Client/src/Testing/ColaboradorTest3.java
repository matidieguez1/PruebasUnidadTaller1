package Testing;

import Modelo.Cliente;
import Modelo.GeneralException;
import Modelo.Servicio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;
public class ColaboradorTest3
{
    ColaboradorTestFixture3 fixture3 = new ColaboradorTestFixture3();
    
    public ColaboradorTest3()
    {
        super();
    }
    
    @Before
    public void setUp()
    {
        fixture3.setUp();
    }

    @After
    public void tearDown() 
    {
        fixture3.tearDown();
    }
    
    /**
     * Agregar una tarea nueva sin tener tareas abiertas previamente
     */
    @Test
    public void test_AgregarTarea()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);

        try
        {
            this.fixture3.colTest.agregarTarea(25, cliente, servicio);
            assertTrue("No agrego la tarea correctamente",this.fixture3.colTest.getTareas().size()==4);
        } catch (GeneralException e)
        {
            fail("No deberia lanzar ninguna excepcion");
        }
    }        
    
}
