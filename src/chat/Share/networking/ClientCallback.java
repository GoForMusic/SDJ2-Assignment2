package chat.Share.networking;

import chat.Share.transferobjects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote {
    void update(Message message) throws RemoteException;
}
