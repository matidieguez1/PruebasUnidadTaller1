package Testing;

import Modelo.Cliente;
import Modelo.Servicio;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;


public class ColaboradorTest1
{
    ColaboradorTestFixture1 fixture1 = new ColaboradorTestFixture1();

    public ColaboradorTest1()
    {
        super();
    }

    @Before
    public void setUp()
    {
        fixture1.setUp();
    }

    @After
    public void tearDown()
    {
        fixture1.tearDown();
    }

    /**
     * agregar una tarea con la lista de tareas vacias
     */
    @Test
    public void testAgregar_tarea()
    {
        try
        {
            Cliente cliente = new Cliente("nom", "email", "000000000000", "cuit", "razonsocial", "grupoclientes");
            Servicio servicio = new Servicio("descripcion", "tipo", 1.0);

            this.fixture1
                .colTest
                .agregarTarea(1, cliente, servicio);

            assertTrue("No agrego correctamente la tarea", this.fixture1
                                                               .colTest
                                                               .getTareas()
                                                               .size() == 1);
        } catch (final Exception e)
        {
            fail("No deberia lanzar ninguna excepcion");
        }
    }


}
