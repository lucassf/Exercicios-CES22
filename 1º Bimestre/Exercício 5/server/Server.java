package server;

import java.net.*;
import java.io.*;

public class Server implements Runnable{

    
    private final Socket socket;
    
    //Cria um novo socket que se comunica com o cliente
    public Server(Socket socket){
        this.socket = socket;
    }
    
    // Comunica-se com o cliente, escrevendo a string de entrada invertida na saída.
    @Override
    public void run() {
        try (
                BufferedReader socketinput = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter socketoutput = new PrintWriter(socket.getOutputStream());) {
            char[] s;
            char temp;
            int size;
            String a;
            while ((a = socketinput.readLine()) != null) {
                s = a.toCharArray();
                size = s.length;
                for (int i = 0; i < size / 2; i++) {
                    temp = s[i];
                    s[i] = s[size - i - 1];
                    s[size - i - 1] = temp;
                }
                socketoutput.println(String.valueOf(s));
                socketoutput.flush();
            }
            socketoutput.close();
            socketinput.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Erro na comunicação com o cliente");
        }
    }

    public static void main(String[] args) {
        ServerSocket serversocket;
        if (args.length != 1) {
            System.exit(-1);
        }
        try {
            serversocket = new ServerSocket(Integer.parseInt(args[0]));
            while (true){
                // Cria uma nova thread para comunicar-se com cliente
                Thread thread = new Thread(new Server(serversocket.accept()));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Erro no servidor");
        }
    }

}
