package client;

import java.net.*;
import java.io.*;

public class Client {
    
    public Client() {
        
    }
    
    //Cria um novo socket que se comunica com o servidor/proxy
    //A string na entrada do console é escrita na saída do socket. A resposta
    //enviada pelo servidor (entrada do socket) é exibida no console.
    public void startConnection(String host, int port) {
        try (
                Socket socket = new Socket(host, port);
                BufferedReader socketinput = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter socketoutput = new PrintWriter(socket.getOutputStream());
                BufferedReader userinput = new BufferedReader(
                        new InputStreamReader(System.in));) {
            String s;
            while ((s = userinput.readLine()) != null&&!s.isEmpty()) {
                socketoutput.println(s);
                socketoutput.flush();
                System.out.println(socketinput.readLine());
            }
            userinput.close();
            socketoutput.close();
            socketinput.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o servidor");
        }
    }
    
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(-1);
        }
        Client client = new Client();
        client.startConnection(args[0], Integer.parseInt(args[1]));
    }
    
}
