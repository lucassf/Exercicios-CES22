package javaapplication7;

import java.io.*;
import java.net.*;

public class ProxyWeb {
    
    public static void main(String[] args) {
        int localport = 8080;// Porta referente ao cliente
        int remoteport = 80;// Porta referente ao servidor
        String hostname = "";// Nome do servidor
        boolean active = true;
        try{
            hostname = args[0];
            localport = Integer.parseInt(args[1]);
            remoteport = Integer.parseInt(args[2]);
        }catch(Exception e){
            System.out.println("Argumentos inválidos");
            System.exit(-1);
        }
        //Cria um servidor que comunica-se com o cliente
        try(ServerSocket serversocket = new ServerSocket(localport)){
            
            while (active){
                ProxyThread proxythread = new ProxyThread(serversocket.accept(),
                hostname,remoteport);
                Thread thread = new Thread(proxythread);
                thread.start();
            }
        }catch(IOException e){
            System.err.println("Erro na comunicação com o servidor ou cliente");
        }
    }

}
