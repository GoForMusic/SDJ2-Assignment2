package chat.Server.networking;

import chat.Server.model.Chat;
import chat.Share.networking.ClientCallback;
import chat.Share.networking.RMIServer;
import chat.Share.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServerImpl implements RMIServer {
    private final Chat chat;
    private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

    public RMIServerImpl(Chat chat) throws RemoteException{
        UnicastRemoteObject.exportObject(this,0);
        this.chat=chat;
    }

    public void startServer() throws RemoteException, AlreadyBoundException {
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("ChatServer", this);
    }

    @Override
    public String message(String username,String str) throws RemoteException {
        return chat.sendMessage(username,str);
    }

    @Override
    public List<Message> getMessages() throws RemoteException {
        return chat.getMessage();
    }

    @Override
    public void registerClient(ClientCallback client) throws RemoteException {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                try {
                    client.update((Message) evt.getNewValue());
                } catch (RemoteException e) {
                    e.printStackTrace();
                    chat.removeListener("NewTextEntry", this);
                }
            }
        };
        listeners.put(client, listener);
        chat.addListener("NewTextEntry", listener);
    }

    @Override
    public void unRegisterClient(ClientCallback client) throws RemoteException {
        PropertyChangeListener listener = listeners.get(client);
        if(listener != null) {
            chat.removeListener("NewTextEntry", listener);
        }
        int stopher=0;
    }
}
