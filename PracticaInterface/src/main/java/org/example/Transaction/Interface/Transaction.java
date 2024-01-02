package org.example.Transaction.Interface;

import org.example.Client.ClientDao;

public interface Transaction {
    public void ConfirmarTransaccion(ClientDao user);
    public void EliminarTransaccion(ClientDao user);
}
