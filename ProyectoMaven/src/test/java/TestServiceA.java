import Services.ServiceA;
import Services.impl.ServiceAimpl;
import org.junit.Assert;
import org.junit.Test;

public class TestServiceA {


    @Test
    public void TestSumar(){
    int a = 2;
    int b = 2;
    ServiceA A = new ServiceAimpl();
        Assert.assertEquals(A.sumar(a, b), 4);
    }
}
