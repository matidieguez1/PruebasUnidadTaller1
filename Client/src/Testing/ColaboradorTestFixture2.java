package Testing;

import Modelo.AbiertaState;
import Modelo.BaseDeDatos;
import Modelo.CerradaState;
import Modelo.Cliente;
import Modelo.Colaborador;

import Modelo.GeneralException;
import Modelo.Grupo_de_Clientes;
import Modelo.IState;
import Modelo.PausadaState;
import Modelo.Servicio;

import Modelo.Tarea;

import java.util.ArrayList;

public class ColaboradorTestFixture2
{
    BaseDeDatos base = new BaseDeDatos();
    Colaborador colTest = new Colaborador("nombreApe", "email","telefono","Colaborador","nombreUsuario","contraseņa",this.base);

    public ColaboradorTestFixture2()
    {
        super();
    }
    
    public void setUp()
    {
        //EL COLABORADOR TIENE UNA TAREA ABIERTA.
        
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);
       
        Tarea tarea1 = new Tarea(this.colTest,cliente,servicio);                      
        Tarea tarea2 = new Tarea(this.colTest,cliente,servicio);
        Tarea tarea3 = new Tarea(this.colTest,cliente,servicio);
        
        tarea2.setEstado(new PausadaState(tarea2));
        tarea3.setEstado(new CerradaState(tarea3));
              
        this.colTest.getTareas().put(1, tarea1);
        this.colTest.getTareas().put(2, tarea2);
        this.colTest.getTareas().put(3, tarea3);
        
        
        this.base.getTareas().add(tarea1);
        this.base.getTareas().add(tarea2);
        this.base.getTareas().add(tarea3);
        
        this.base.getListaUsuarios().put("nombreUsuario",this.colTest);
              
        this.base.getClientes().put("nom", cliente);
        this.base.getGrupos().put(1, new Grupo_de_Clientes("nombre",1));
        this.base.getServicios().put("descripcion",servicio);
    }
    
    public void tearDown() {

        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
}
