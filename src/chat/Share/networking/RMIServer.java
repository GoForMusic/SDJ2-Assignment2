package chat.Share.networking;

import chat.Share.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote {
    public String message(String str) throws RemoteException;
    public List<Message> getMessages() throws RemoteException;
    public void registerClient(ClientCallback client) throws RemoteException;

    public void unRegisterClient(ClientCallback client) throws  RemoteException;
}
