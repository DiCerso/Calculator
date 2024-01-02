package org.example.Client.Impl;

import org.example.Client.ClientDao;
import org.example.Client.Interface.Client;

public class ClientImpl implements Client {
    @Override
    public void Guardar(ClientDao user) {
        System.out.println("El usuario se ah guardado y su nombre es " + user.getName());
    }

    @Override
    public void Eliminar(ClientDao user) {
        System.out.println("El usuario se ah eliminado y su nombre era " + user.getName());
    }
}
