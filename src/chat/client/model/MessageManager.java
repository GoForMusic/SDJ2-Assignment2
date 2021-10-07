package chat.client.model;

import chat.client.networking.Client;
import chat.shared.transferoobjects.Messages;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class MessageManager implements MessageModel {
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public MessageManager(Client client){
        this.client=client;
        client.startClient();
        client.addListener("NewLogEntry", this::onNewLogEntry);
    }

    private void onNewLogEntry(PropertyChangeEvent evt){
        support.firePropertyChange(evt);
    }

    @Override
    public String sendMessage(String text) {
        return client.sendMessage(text);
    }

    @Override
    public ArrayList<Messages> getMessages() {
        return client.getMessages();
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
