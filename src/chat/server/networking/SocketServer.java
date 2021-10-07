package chat.server.networking;

import chat.server.model.TextManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private TextManager messageManager;

    public SocketServer(TextManager messageManager)
    {
        this.messageManager=messageManager;
    }

    public void startServer()
    {
        try {
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while (true) {
                Socket socket = welcomeSocket.accept();
                new Thread(new SocketHandler(socket,messageManager)).start();
            }
        }catch(IOException e){
                e.printStackTrace();
        }
    }
}
