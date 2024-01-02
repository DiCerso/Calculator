import Services.ServiceA;
import Services.ServiceB;
import Services.impl.ServiceAimpl;
import Services.impl.ServiceBimpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TestServiceB {

    @Test
    public void TestMultiplicar(){
        ServiceB B = new ServiceBimpl();
        int a = 2;
        int b = 2;
        Assert.assertEquals(B.multiplicar(a, b), 4);
    }

    @Test
    public void TestMultiplicarSuma(){
        ServiceB B = new ServiceBimpl();
        ServiceA A = new ServiceAimpl();
        B.setServiceA(A);
        int a = 2;
        int b = 2;
        int multi = 2;
        Assert.assertEquals(B.multiplicarSuma(a, b, multi), 8);
    }

    @Test
    public void TestMultiplicarSumaMockito(){
        ServiceB B = new ServiceBimpl();
        ServiceA A = Mockito.mock(ServiceA.class);//emulo el servicio con mockito utilizando la interfaz
        Mockito.when(A.sumar(2, 2)).thenReturn(4);//emulo el metodo con mockito con la interfaz


        B.setServiceA(A);
        int a = 2;
        int b = 2;
        int multi = 2;
        Assert.assertEquals(B.multiplicarSuma(a, b, multi), 8);
    }
}
