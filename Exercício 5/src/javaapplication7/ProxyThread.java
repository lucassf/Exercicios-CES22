package javaapplication7;

import java.net.*;
import java.io.*;

public class ProxyThread implements Runnable {

    private final Socket clientsocket;// socket que comunica-se com o cliente
    private final Socket serversocket;// socket que comunica-se com o servidor

    private final int REQUEST_MAX_SIZE = 1024; // Número máximo de bytes que pode
    // ter uma requisição do cliente ao servidor
    private final int REPLY_MAX_SIZE = 1024;// Número máximo de bytes que pode
    // ter uma resposta do servidor ao client

    public ProxyThread(Socket socket, String hostname, int remoteport) throws IOException {
        this.clientsocket = socket;
        serversocket = new Socket(hostname, remoteport);
    }

    @Override
    public void run() {
        // Cria um novo thread para transmitir mensagens do cliente para o servidor.
        new Thread() {
            @Override
            public void run() {
                uploadToServer();
            }
        }.start();
        // Transmite mensagens do servidor ao cliente
        downloadFromServer();
        // Fecha sockets
        closeSockets();
    }

    // Recebe a requisição do cliente e a envia ao servidor (upload)
    private void uploadToServer() {
        try (InputStream from_client = clientsocket.getInputStream();
                OutputStream to_server = serversocket.getOutputStream()){
            byte[] request = new byte[REQUEST_MAX_SIZE];
            while (from_client.read(request) != -1) {
                to_server.write(request);
                to_server.flush();
            }
        } catch (IOException e) {
            System.err.println("Erro ao fazer upload para o servidor");
        }
    }

    // Recebe a resposta do servidor e a envia ao cliente (download)
    private void downloadFromServer() {
        try (InputStream from_server = serversocket.getInputStream();
                OutputStream to_client = clientsocket.getOutputStream()){
            byte[] reply = new byte[REPLY_MAX_SIZE];
            while (from_server.read(reply) != -1) {
                to_client.write(reply);
                to_client.flush();
            }
        } catch (IOException e) {
            System.err.println("Erro ao fazer download");
        }
        
    }

    // Fecha os recursos criados (sockets)
    private void closeSockets() {
        try {
            if (serversocket!=null)serversocket.close();
            if (clientsocket!=null)clientsocket.close();
        } catch (IOException e) {
            System.err.println("Erro ao fechar recursos");
        }
    }

}
