package Services.impl;

import Services.ServiceA;

public class ServiceAimpl implements ServiceA {

    @Override
    public int sumar(int a, int b) {
        return a + b;
    }
}
