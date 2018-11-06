package sinonimos;

import java.util.ArrayList;

public class diccionario {
    
    private ArrayList<sinonimo> ListaSinonimos = new ArrayList();
    
    public diccionario() {
        super();
    }
    
    public void agregar_sinonimo(sinonimo sin)
    {
            ListaSinonimos.add(sin);
    }  
    
    public void eliminar_sinonimo(sinonimo sin)
    {
        ListaSinonimos.remove(sin);        
    }
    
    public ArrayList<sinonimo> busqueda_sinonimo(String Palabra) 
    {
        ArrayList<sinonimo> salida = new ArrayList();
        ListaSinonimos.forEach(sinonimo -> {if (sinonimo.getPalabra_clave().equals(Palabra)){salida.add(sinonimo); }});
        return salida;
    }


    public ArrayList<sinonimo> getListaSinonimos() {
        return ListaSinonimos;
    }
}
