package Testing;

import Modelo.GeneralException;

import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminTest1 {
    public AdminTestFixture1 fixture1= new AdminTestFixture1();
    public AdminTest1() {
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
     * Agregar distintos elementos a la base de datos sin tener ninguno previamente almacenado.<br>
     * 
     */
    @Test
    public void testAgregar_Usuario1()
    {
        try {
            this.fixture1
                .admin
                .agregarUsuario("nombreApe", "email", "telefono", "nombreUsuario", "contraseña", this.fixture1.base);
            assertTrue("No se agrego el usuario",this.fixture1.base.getListaUsuarios().containsKey("nombreUsuario"));
                
        } catch (GeneralException e) {
            fail("repite algo inexistente");
        }
        
    }
    @Test
    public void testAgregar_Grupo1()
    {
        try {
            this.fixture1
                .admin.agregarGrupo("nombre", 1);
            assertTrue("No se agrego el grupo",this.fixture1.base.getGrupos().containsKey(1));
        } catch (GeneralException e) {
            fail("repite algo inexistente");
        }
        
    }
    @Test
    public void testAgregar_Servicio1()
    {
        try {
            this.fixture1
                .admin.agregarServicio("descripcion", "tipo", 1.0);
            assertTrue("No se agrego el servicio",this.fixture1.base.getServicios().containsKey("descripcion"));
        } catch (GeneralException e) {
            fail("repite algo inexistente");
        }
        
    }
    @Test
    public void testAgregar_Cliente1()
    {
        try {
            this.fixture1
                .admin.agregarCliente("nombreApe", "email", "000000000000", "CUIT", "razonSocial", "grupoClientes");
            assertTrue("No se agrego el cliente",this.fixture1.base.getClientes().containsKey("nombreApe"));
        } catch (GeneralException e) {
            fail("repite algo inexistente");
        }
        
    }
    /**
     * Informar las tareas sin tener ninguna previamente en la base de datos.<br>
     */
    @Test
    public void testInformeEstadoTareas()
    {
        this.fixture1.admin.informeEstadoTareas("colaborador");
        fail("devuelve un Array sin elementos");
    }
    
    
}
