package sinonimos;

public class diccionarioTestFixture2 {
    diccionario dicctest=new diccionario();
    
    public diccionarioTestFixture2() {
    }

    public void setUp() {
        dicctest.getListaSinonimos().clear();
    }

    public void tearDown() {
        dicctest.getListaSinonimos().clear();
    }
}
