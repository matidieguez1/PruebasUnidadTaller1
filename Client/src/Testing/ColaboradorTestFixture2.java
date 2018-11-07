package Testing;

import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Colaborador;

import Modelo.GeneralException;
import Modelo.Servicio;

import java.util.ArrayList;

public class ColaboradorTestFixture2
{
    BaseDeDatos base = new BaseDeDatos();
    Colaborador colTest = new Colaborador("nombreApe", "email","telefono","Colaborador","nombreUsuario","contraseña",this.base);

    public ColaboradorTestFixture2()
    {
        super();
    }
    
    public void setUp()
    {
        Colaborador usuario1= new Colaborador("nombreApe", "email", "000000000000","colaborador", "nombreUsuario2", "contraseña", this.base);
        Colaborador usuario2= new Colaborador("nombreApe2", "email", "000000000001","colaborador", "nombreUsuario3", "contraseña", this.base);
        
        Cliente cliente=new Cliente("nom","email","000000000000","cuit","razonsocial","grupoclientes");
        Servicio servicio = new Servicio("descripcion","tipo",1.0);

        try {
            usuario1.agregarTarea(1, cliente, servicio);
        } catch (GeneralException e) {
        }
        try {
            usuario2.agregarTarea(2, cliente, servicio);
        } catch (GeneralException e) {
        }
    }
    
    public void tearDown() {

        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
}
