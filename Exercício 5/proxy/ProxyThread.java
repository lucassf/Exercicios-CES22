package proxy;

import java.net.*;
import java.io.*;

public class ProxyThread implements Runnable {

    private final Socket clientsocket;// socket que comunica-se com o cliente
    private final Socket serversocket;// socket que comunica-se com o servidor

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
        try (BufferedReader from_client = new BufferedReader(
                        new InputStreamReader(clientsocket.getInputStream()));
                PrintWriter to_server = new PrintWriter(serversocket.getOutputStream());){
            String request;
            while ((request=from_client.readLine()) != null) {
                to_server.println(request);
                to_server.flush();
            }
        } catch (IOException e) {
            System.err.println("Erro ao fazer upload para o servidor");
        }
    }

    // Recebe a resposta do servidor e a envia ao cliente (download)
    private void downloadFromServer() {
        try (BufferedReader from_server = new BufferedReader(
                        new InputStreamReader(serversocket.getInputStream()));
                PrintWriter to_client = new PrintWriter(clientsocket.getOutputStream());){
            String reply;
            while ((reply=from_server.readLine()) !=null) {
                to_client.println(reply);
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
