package org.example.Transaction.Impl;

import org.example.Client.ClientDao;
import org.example.Client.Impl.ClientImpl;
import org.example.Client.Interface.Client;
import org.example.Transaction.Interface.Transaction;

public class TransaccionImpl implements Transaction {

    Client usuario = new ClientImpl();

    @Override//se puede acceder a este metodo tanto con TransaccionImpl como con Transaccion
    public void ConfirmarTransaccion(ClientDao user) {
        usuario.Guardar(user);
    }

    @Override
    public void EliminarTransaccion(ClientDao user) {
        usuario.Eliminar(user);
    }


    public void hola(){ //no se puede acceder a este metodo a menos que se crea una variable de tipo TransaccionImpl
        System.out.println("Hola");
    };
}
