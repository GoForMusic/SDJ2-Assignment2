package chat.server;

import chat.server.model.TextManagerImp;
import chat.server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManagerImp());
        ss.startServer();
    }
}
