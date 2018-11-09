package Testing;


import Modelo.Cliente;
import Modelo.Colaborador;
import Modelo.GeneralException;
import Modelo.Servicio;

import Modelo.Tarea;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class ColaboradorTest2
{
    ColaboradorTestFixture2 fixture2 = new ColaboradorTestFixture2();
    
    public ColaboradorTest2()
    {
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
     * Agregar una tarea nueva teniendo una tarea abierta
     */
    @Test
    public void test_AgregarTarea()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);

        try
        {
            this.fixture2.colTest.agregarTarea(25, cliente, servicio);
            fail("No deberia agregar una tarea teniendo otra abierta");
        } catch (GeneralException e)
        {
            String s = "Hay tareas abiertas";
            assertEquals("No lanzo la excepcion esperada",s,e.getMessage());
        }
    }    
    
  
    /**
     *  Abrir tarea estando pausada
     */
    @Test
    public void test_AbrirTarea()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
        Tarea tarea2 = new Tarea(this.fixture2.colTest,cliente,servicio);

        HashMap<Integer,Tarea> tareas = this.fixture2.colTest.getTareas();
        String msj = tarea2.getEstado().toString();
        
        this.fixture2.colTest.abrirTarea(tareas.get(tarea2).getID());
                
        assertNotSame("No cambio el estado",msj,tareas.get(tarea2).getEstado().toString());
    }
    
    /**
     * Pausar tarea estando abierta
     *
     */
    @Test
    public void test_PausarTarea()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
        Tarea tarea1 = new Tarea(this.fixture2.colTest,cliente,servicio);

        HashMap<Integer,Tarea> tareas = this.fixture2.colTest.getTareas();
        String msj = tarea1.getEstado().toString();
        
        this.fixture2.colTest.pausarTarea(tareas.get(tarea1).getID());
                
        assertNotSame("No cambio el estado",msj,tareas.get(tarea1).getEstado().toString());
    }
    
    /**
     * Cerrar tarea estando abierta
     */
    @Test
    public void test_CerrarTarea1()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
        Tarea tarea1 = new Tarea(this.fixture2.colTest,cliente,servicio);

        HashMap<Integer,Tarea> tareas = this.fixture2.colTest.getTareas();
        String msj = tarea1.getEstado().toString();
        
        this.fixture2.colTest.cerrarTarea(tareas.get(tarea1).getID());
                
        assertNotSame("No cambio el estado",msj,tareas.get(tarea1).getEstado().toString());
    }
    
    /**
     * Cerrar tarea estando pausada
     */
    @Test
    public void test_CerrarTarea2()
    {
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
        Tarea tarea2 = new Tarea(this.fixture2.colTest,cliente,servicio);

        HashMap<Integer,Tarea> tareas = this.fixture2.colTest.getTareas();
        String msj = tarea2.getEstado().toString();
        
        this.fixture2.colTest.cerrarTarea(tareas.get(tarea2).getID());
                
        assertNotSame("No cambio el estado",msj,tareas.get(tarea2).getEstado().toString());
    }
}

