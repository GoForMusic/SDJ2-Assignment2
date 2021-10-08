package chat.Server;

import chat.Server.model.ChatImpl;
import chat.Server.networking.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException{
        RMIServerImpl ss = new RMIServerImpl(new ChatImpl());
        ss.startServer();
    }
}
