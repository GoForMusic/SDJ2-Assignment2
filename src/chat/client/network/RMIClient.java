package chat.Client.network;

import chat.Share.networking.ClientCallback;
import chat.Share.networking.RMIServer;
import chat.Share.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback {
    private RMIServer server;
    private PropertyChangeSupport support;

    public RMIClient(){
        support = new PropertyChangeSupport(this);
    }


    @Override
    public String message(String str) {
        try {
            return server.message(str);
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public List<Message> getMessages() {
        try {
            return server.getMessages();
        } catch (RemoteException e) {
            throw new RuntimeException("Could not contact server");
        }
    }

    @Override
    public void startClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            server = (RMIServer) registry.lookup("ChatServer");
            server.registerClient(this);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void unRegisterClient() {
        try {
            server.unRegisterClient(this);
        } catch (RemoteException e) {
        }
    }

    @Override
    public void update(Message message) throws RemoteException {
        support.firePropertyChange("NewMessageEntry", null, message);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
