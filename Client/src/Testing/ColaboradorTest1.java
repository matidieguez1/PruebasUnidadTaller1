package Testing;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

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
    public void testAgregar_tarea() {
       try
          {
            HashMap usuarios = fixture1.base.getListaUsuarios();
           
            fail("agregar sinonimo nulo no dispara excepcion.");
          }
          catch( final Exception e )
          {
    /*      Nota : La excepcion debe ser la correspondiente al mensaje */
            final String msg = "Sinonimo Invalido";
            assertEquals("No genera la excepcion de Sinonimo Invalido",msg, e.getMessage());
          }
        
     }
    
}
