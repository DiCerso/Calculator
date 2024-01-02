package org.example;

import org.example.Client.ClientDao;
import org.example.Transaction.Impl.TransaccionImpl;
import org.example.Transaction.Interface.Transaction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    
    public static void main(String[] args) {
        ClientDao usuarionuevo = new ClientDao();
        usuarionuevo.setLastname("Cersocimo");
        usuarionuevo.setName("Lautaro");
        usuarionuevo.setMail("lautaro_cer@hotmail.com");
        usuarionuevo.setNumber(1156442637);

        Transaction trans = new TransaccionImpl();

        trans.ConfirmarTransaccion(usuarionuevo);
        //trans.hola();//no se puede utilizar porque no esta definido en la interface pese a estar en la impl
        trans.EliminarTransaccion(usuarionuevo);

        TransaccionImpl nuevo = new TransaccionImpl();

        nuevo.ConfirmarTransaccion(usuarionuevo);
        nuevo.hola();
    }
}