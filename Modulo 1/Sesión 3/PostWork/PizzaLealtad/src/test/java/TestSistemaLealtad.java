import com.example.SistemaLealtad.SistemaLealtad;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
    Author: Gabriel de Jesús Silva Valencia
    GitHub: https://github.com/GabrielSilvaMx/HSBC-BEDU-Developer-Engineering
    Módulo: Desarrollo de software ágil
    Niveles de software testing- Actividad 02
    BEDU.ORG
 */

public class TestSistemaLealtad {
    SistemaLealtad nuevaOrden;

    @BeforeClass
    public void initialConditions() {
        nuevaOrden = new SistemaLealtad();
    }

    @Test
    public void verificarClienteSinTarjeta() {
        nuevaOrden.setEstatusTarjeta(false);
        Assert.assertEquals(nuevaOrden.getEstatusTarjeta(),false);
    }

    @Test
    public void verificarClienteConTarjeta() {
        nuevaOrden.setEstatusTarjeta(true);
        Assert.assertEquals(nuevaOrden.getEstatusTarjeta(),true);
    }

    @Test
    public void verificarSaldoMenorA50() {
        nuevaOrden.setSaldoPuntos(49);
        Assert.assertEquals(nuevaOrden.mostrarProductosExtras(), "");
    }

    @Test
    public void verificarSaldoEntre50Y100() {
        nuevaOrden.setSaldoPuntos(50);
        Assert.assertEquals(nuevaOrden.mostrarProductosExtras(), "Espagueti");
        Assert.assertEquals(nuevaOrden.getEstatusCupon(), false);
    }

    @Test
    public void verificarSaldoEntre100Y150() {
        nuevaOrden.setSaldoPuntos(101);
        Assert.assertEquals(nuevaOrden.mostrarProductosExtras(), "Espagueti,Queso Extra");
        Assert.assertEquals(nuevaOrden.getEstatusCupon(), false);
    }

    @Test
    public void verificarSaldoMayorA150() {
        nuevaOrden.setSaldoPuntos(151);
        Assert.assertEquals(nuevaOrden.mostrarProductosExtras(), "Espagueti,Queso Extra,Cupon Pizza Gratis");
        Assert.assertEquals(nuevaOrden.getEstatusCupon(), false);
    }

    @Test
    public void verificarGuardarCupon() {
        nuevaOrden.usarCupon("N");
        Assert.assertEquals(nuevaOrden.getEstatusCupon(), true);
    }

    @Test
    public void verificarNoGuardarCupon() {
        nuevaOrden.usarCupon("Y");
        Assert.assertEquals(nuevaOrden.getEstatusCupon(), false);
    }
}
