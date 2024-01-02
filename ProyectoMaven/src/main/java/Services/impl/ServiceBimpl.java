package Services.impl;

import Services.ServiceA;
import Services.ServiceB;

public class ServiceBimpl implements ServiceB {


    private ServiceA serviceA;
    @Override
    public ServiceA getServiceA() {
        return serviceA;
    }

    @Override
    public void setServiceA(ServiceA service) {
        this.serviceA = service;
    }

    @Override
    public int multiplicarSuma(int a, int b, int multiplicador) {
        return (serviceA.sumar(a, b) * multiplicador);
    }

    @Override
    public int multiplicar(int a, int b) {
        return a * b;
    }
}
