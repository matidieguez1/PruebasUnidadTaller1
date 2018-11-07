package Testing;

import Modelo.Cliente;
import Modelo.Colaborador;

import Modelo.GeneralException;

import Modelo.Grupo_de_Clientes;
import Modelo.Servicio;

import Modelo.Tarea;

import java.util.ArrayList;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class AdminTest2 {
    AdminTestFixture2 fixture2= new AdminTestFixture2();
    public AdminTest2() {
        super();
    }
    
    @Before
    public void setUp()
    {
        fixture2.setUp();
    }

    @After
    public void tearDown() 
    {
        fixture2.tearDown();
    }
    
    /**
     * Agregar un usuario existente.
     */
    @Test
    public void testAgregar_Usuario()
    {
        try {
            this.fixture2.admin
                .agregarUsuario("nombreApe", "email", "000000000000", "nombreUsuario", "contraseña",
                                this.fixture2.base);
            fail("No deberia agregar un usuario repetido");
        } catch (GeneralException e) {
            String msg="Nombre de usuario ya existente";
            assertEquals("No genera la escepcion correcta (Usuario ya existente)",msg,e.getMessage());
        }
    }
    /**
     * eliminar usuario de la base de datos.
     */
    @Test
    public void testEliminar_Usuario()
    {
        this.fixture2.admin.eliminarUsuario("nombreUsuario");
        assertFalse("Elimino incorrectamente el usuario",this.fixture2.base.getListaUsuarios().containsKey("nombreUsuario"));
        
    }
    /**
     * eliminar tarea creada del usuario existente.<br>
     */
    @Test
    public void testEliminar_Tarea()
    {
        Colaborador usuario1= new Colaborador("nombreApe", "email", "000000000000","colaborador", "nombreUsuario", "contraseña", this.fixture2.base);
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
        
        Tarea tarea= new Tarea(usuario1,cliente,servicio);
        
        this.fixture2.admin.eliminarTarea(tarea);
        assertFalse("Elimino incorrectamente la tarea",this.fixture2.base.getTareas().contains(tarea));

    }
    /**
     * Agrega grupo a la base con una id que ya existe.
     */
    @Test
    public void testAgregar_Grupo()
    {

        try {
            this.fixture2
                .admin
                .agregarGrupo("nombre", 1);
            fail("No deberia agregar un grupo repetido");
        } catch (GeneralException e) {
            String s="Grupo de cliente ya existente";
            assertEquals("No lanzo la excepcion correcta",s,e.getMessage());
        }
    }
    /**
     * Eliminar grupo existente.
     */
    @Test
    public void testEliminar_Grupo1()
    {
        int id =1;
        Grupo_de_Clientes grupo=new Grupo_de_Clientes("nombre",id);
        this.fixture2.admin.eliminarGrupo(grupo);
        assertFalse("No elimino correctamente",this.fixture2.base.getGrupos().containsValue(grupo));
    }
    /**
     * Eliminar grupo no existente.
     */
    @Test
    public void testEliminar_Grupo2()
    {
        Grupo_de_Clientes grupo=new Grupo_de_Clientes("nombre2",2);
        int cant= this.fixture2.base.getGrupos().size();
        this.fixture2.admin.eliminarGrupo(grupo);
        assertTrue("Elimino un grupo no existente",cant==this.fixture2.base.getGrupos().size());
        
    }
    /**
     * Agrega un servicio existente.
     */
    @Test
    public void testAgregar_Servicio()
    {
        try {
            this.fixture2
                .admin
                .agregarServicio("descripcion", "tipo", 1.0);
            fail("Agrego un servicio existente");
        } catch (GeneralException e) {
            String s="Servicio ya existente";
            assertEquals("Lanzo una excepcion distinta a la esperada",s,e.getMessage());
        }
    }
    /**
     * Elimina un servicio existente.
     */
    @Test
    public void testEliminar_Servicio1()
    {
        try {
            this.fixture2
                .admin
                .eliminarServicio("descripcion");
            assertFalse("No elimino correctamente",this.fixture2.base.getServicios().containsKey("descripcion"));
        } catch (GeneralException e) {
            fail("No elimino el servicio correctamente");
          
        }
    }
    /**
     * Elimina un servicio que no esta.
     */
    public void testEliminar_Servicio2()
    {
        try {
            this.fixture2
                .admin
                .eliminarServicio("descripcion23232323");
            fail("No lanzo la excepcion esperada");
        } catch (GeneralException e) {
            String s="No existe el servicio";
            assertEquals("Lanzo una excepcion distinta a la esperada",s,e.getMessage());
        }
    }
    
    /**
     * Agregar Cliente existente.
     */
    @Test
    public void testAgregar_Cliente()
    {
        try {
            this.fixture2
                .admin
                .agregarCliente("nom", "email", "000000000000", "CUIT", "razonSocial", "grupoClientes");
            fail("Agrego un cliente existente");
        } catch (GeneralException e) {
            String s="Cliente ya registrado";
            assertEquals("Lanzo una excepcion distinta a la esperada",s,e.getMessage());
        }
    }
    /**
     * Eliminar un cliente existente.
     */
    @Test
    public void testEliminar_Cliente1()
    {
        try {
            this.fixture2
                .admin
                .eliminarCliente("nom");
            assertFalse("No lo elimino correctamente",this.fixture2.base.getClientes().containsKey("nombreApe"));
        } catch (GeneralException e) {
            fail("Lanzo una excepcion no deaseada");
        }
    }

    /**
     * Eliminar un cliente NO existente.
     */
    @Test
    public void testEliminar_Cliente2()
    {
        try {
            this.fixture2
                .admin
                .eliminarCliente("nombreApe23232323");
            fail("No lanzo la excepcion esperada");
        } catch (GeneralException e) {
            String s="No existe el cliente";
            assertEquals("Lanzo una excepcion distinta a la esperada",s,e.getMessage());
        }
    }
    
    /**
     * Pedir informe de todos los colaboradores.
     */
    @Test
    public void test_informeEstadoTareas1()
    {
        ArrayList<String[]>informe=this.fixture2.admin.informeEstadoTareas("todos");
        assertTrue("No informo correctamente",informe.size()==2);
        //NUNCA SE ASIGAN EL SERVICIO EN EL CONSTRUCTOR DE TAREA
    }
    /**
     * Pedir informe de 1 colaborador existente.
     */
    @Test
    public void test_informeEstadoTareas2()
    {
       ArrayList<String[]>informe= this.fixture2.admin.informeEstadoTareas("nombreUsuario");
        assertTrue("No informo correctamente",informe.size()==1);
        //COMPARA UN OBJETO COLABORADOR CON UN STRING
        
    }
    /**
     * Pedir informe de 1 colaborador no existente.
     */
    @Test
    public void test_informeEstadoTareas3()
    {
       ArrayList<String[]>informe= this.fixture2.admin.informeEstadoTareas("nombreUsuario22222222");
        assertTrue("No informo correctamente",informe.size()==0);
    }
    
    /**
     * 
     */
    @Test
    public void test_InformeTareasPeriodo()
    {
        Date inicio=new Date();
        Date fin= new Date();
        //Hacer, fijarse que ingresando ciertos Dates , se obtenga el resultado esperado.
    }
}
