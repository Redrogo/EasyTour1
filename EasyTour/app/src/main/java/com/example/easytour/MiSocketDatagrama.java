package com.example.easytour;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//Subclase de DatagramSocket que contiene métodos para mandar y recibir mensajes.
public class MiSocketDatagrama extends DatagramSocket {
    static final int longitudPaquete = 10;

    MiSocketDatagrama(int numPuerto) throws SocketException{
        super(numPuerto);
    }

    public void enviaMensaje(InetAddress maquinaReceptora, int puertoReceptor, String mensaje) throws IOException{
        byte[] almacenEnvio = mensaje.getBytes();
        DatagramPacket datagrama = new DatagramPacket(almacenEnvio, almacenEnvio.length, maquinaReceptora, puertoReceptor);
        this.send(datagrama);
    }

    public String recibeMensaje() throws IOException{
        byte[] almacenRecepcion = new byte[longitudPaquete];
        DatagramPacket datagrama = new DatagramPacket(almacenRecepcion, longitudPaquete);
        this.receive(datagrama);
        String mensaje = new String(almacenRecepcion);
        return mensaje;

    }

}
