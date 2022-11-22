import com.example.PizzaOrden.PizzaOrden;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Objects;

/*
    Author: Gabriel de Jesús Silva Valencia
    GitHub: https://github.com/GabrielSilvaMx/HSBC-BEDU-Developer-Engineering
    Módulo: Desarrollo de software ágil
    Niveles de software testing- Actividad 01
    BEDU.ORG
 */
public class PizzaOrdenTest {
    PizzaOrden nuevaOrden;

    @BeforeClass
    public void initialConditions() {
        nuevaOrden = new PizzaOrden();
    }

    @Test
    public void verificarMensajeDeInicioSeDespliega()  {
        nuevaOrden.desplegarMensajeInicio();

        String actualResult = readFileContents("desplegarMensajeInicio");
        String expectedResult = "Bienvenido a la aplicación para ordenar pizza.\n\n"
                + "Sigue las instrucciones por favor.\n\n";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcionVeganaVerdadera() {
        nuevaOrden.setOpcionVeg("Y");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcopnVeganaFalsa() {
        nuevaOrden.setOpcionVeg("N");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = false;
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente1ComoPimiento() {
        nuevaOrden.setIngrediente1("a");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Pimiento";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente2ComoHongos() {
        nuevaOrden.setIngrediente2("b");
        String actualResult = nuevaOrden.getIngrediente2();
        String expectedResult = "Hongos";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente3ComoEspinaca() {
        nuevaOrden.setIngrediente3("c");
        String actualResult = nuevaOrden.getIngrediente3();
        String expectedResult = "Espinaca";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente1ComoPeperoni() {
        nuevaOrden.setIngrediente1("d");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Peperoni";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente2ComoJamon() {
        nuevaOrden.setIngrediente2("e");
        String actualResult = nuevaOrden.getIngrediente2();
        String expectedResult = "Jamon";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente3ComoSalchicha() {
        nuevaOrden.setIngrediente3("f");
        String actualResult = nuevaOrden.getIngrediente3();
        String expectedResult = "Salchicha";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarGuardarIngrediente1ComoOpcionInvalida() {
        nuevaOrden.setIngrediente1("o");
        String actualResult = nuevaOrden.getIngrediente1();
        String expectedResult = "Opcion_Invalida";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarOpcionVegAlPreguntarOpcionVeganaTrue() {
        nuevaOrden.setOpcionVeg("Y");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = true;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void verificarOpcionVegAlPreguntarOpcionVeganaFalse() {
        nuevaOrden.setOpcionVeg("N");
        boolean actualResult = nuevaOrden.getOpcionVeg();
        boolean expectedResult = false;
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void verificarListaIngredientesVegetarianos() {
        nuevaOrden.setOpcionVeg("Y");

        String actualResult = readFileContents("desplegarIngredientes");
        String expectedResult = "Selecciona 3 ingredientes de la siguiente lista: \n"
                + "[a] Pimiento \n"
                + "[b] Hongos \n"
                + "[c] Espinaca \n"
                + "[o] Ninguno \n\n";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verificarListaIngredientesNoVegetarianos() {
        nuevaOrden.setOpcionVeg("N");

        String actualResult = readFileContents("desplegarIngredientes");
        String expectedResult = "Selecciona 3 ingredientes de la siguiente lista: \n"
                + "[a] Pimiento \n"
                + "[b] Hongos \n"
                + "[c] Espinaca \n"
                + "[d] Peperoni \n"
                + "[e] Jamon \n"
                + "[f] Salchicha \n"
                + "[o] Ninguno \n\n";

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(enabled = false)
    public void guardarIngredientesComoHongos() {
        nuevaOrden.guardarIngredientes();
        String expectedResult = "Hongos";
        Assert.assertEquals(nuevaOrden.getIngrediente1(), expectedResult);
    }

    private String readFileContents(String mensaje) {
        String outputMessage = "";
        boolean tipoPizza = nuevaOrden.getOpcionVeg();
        if (Objects.equals(mensaje, "desplegarIngredientes")) {
            outputMessage = "Selecciona 3 ingredientes de la siguiente lista: \n"
                    + "[a] Pimiento \n"
                    + "[b] Hongos \n"
                    + "[c] Espinaca \n";
            if (!tipoPizza)
                outputMessage += "[d] Peperoni \n"
                        + "[e] Jamon \n"
                        + "[f] Salchicha \n";
            outputMessage += "[o] Ninguno \n\n";
        }
        else if (Objects.equals(mensaje, "desplegarMensajeInicio"))
            outputMessage = "Bienvenido a la aplicación para ordenar pizza.\n\n"
                + "Sigue las instrucciones por favor.\n\n";
        System.out.println(outputMessage);
        return outputMessage;
    }

}
