import com.example.PizzaOrden.PizzaOrden;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
    Author: Gabriel de Jesús Silva Valencia
    GitHub: https://github.com/GabrielSilvaMx/pryDeveloperEngineering
    Módulo: Desarrollo de software agil
    Niveles de software testing- Actividad 01
    BEDU.ORG
 */
public class PizzaOrdenTest {
    PizzaOrden nuevaOrden;

    @BeforeClass
    public void initialConditions() {
        nuevaOrden = new PizzaOrden();
    }

    @Test(priority = 1)
    public void verificaOpcionVeganaVerdadera() {
        nuevaOrden.setOpcionVeg("Y");
        boolean esVegana = nuevaOrden.getOpcionVeg();
        Assert.assertEquals(esVegana, true);
        System.out.println(String.valueOf(esVegana));
    }

    @Test(priority = 2)
    public void verificaIngredientePimiento() {
        nuevaOrden.setIngrediente1("a");
        Assert.assertEquals("Pimiento", nuevaOrden.getIngrediente1());
        System.out.println(nuevaOrden.getIngrediente1());
    }

    @Test(priority = 3)
    public void verificaIngredienteHongos() {
        nuevaOrden.setIngrediente1("b");
        Assert.assertEquals("Hongos", nuevaOrden.getIngrediente1());
        System.out.println(nuevaOrden.getIngrediente1());
    }

    @Test(priority = 4)
    public void verificaOpcionMayuscula() {
        nuevaOrden.preguntarPizzaVegetariana();
        //Assert.assertEquals("Y",s);
    }

}
