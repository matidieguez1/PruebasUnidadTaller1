package Testing;

import Modelo.Administrador;
import Modelo.BaseDeDatos;
import Modelo.Cliente;
import Modelo.Colaborador;
import Modelo.GeneralException;
import Modelo.Grupo_de_Clientes;
import Modelo.Servicio;
import Modelo.Usuario;
/**
 * Escenario con base de datos llena.
 */
public class AdminTestFixture2 {
    BaseDeDatos base=new BaseDeDatos();
    Administrador admin= this.base.getAdmin();
    public AdminTestFixture2() {
        super();
    }
    public void setUp()
    {
        Colaborador usuario1= new Colaborador("nombreApe", "email", "000000000000","colaborador", "nombreUsuario", "contraseña", this.base);
        Colaborador usuario2= new Colaborador("nombreApe2", "email", "000000000001","colaborador", "nombreUsuario2", "contraseña", this.base);
        
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
    int id =1;
        this.base.getListaUsuarios().put("nombreUsuario", usuario1);
        this.base.getListaUsuarios().put("nombreUsuario2", usuario2);
        this.base.getClientes().put("nom", cliente);
        this.base.getGrupos().put(id, new Grupo_de_Clientes("nombre",id));
        this.base.getServicios().put("descripcion",servicio);
        
    }
    public void tearDown()
    {
        this.base.getClientes().clear();
        this.base.getGrupos().clear();
        this.base.getListaUsuarios().clear();
        this.base.getServicios().clear();
        this.base.getTareas().clear();
    }
}
