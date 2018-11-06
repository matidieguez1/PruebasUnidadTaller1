package sinonimos;

public class diccionarioTestFixture1 {
    diccionario dicctest=new diccionario();
    
    public diccionarioTestFixture1() {
    }

    public void setUp() {
        dicctest.getListaSinonimos().add(new sinonimo("Casa","vivienda"));
        dicctest.getListaSinonimos().add(new sinonimo("Casa","hogar"));
        dicctest.getListaSinonimos().add(new sinonimo("perro","can"));
        dicctest.getListaSinonimos().add(new sinonimo("calle","rua"));
    }

    public void tearDown() {
        dicctest.getListaSinonimos().clear();
    }
}
