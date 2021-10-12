package chat.Client.model;

import chat.Client.network.Client;
import chat.Share.transferobjects.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatManager implements Chat{
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    private Client client;

    public ChatManager(Client client)
    {
        this.client=client;
        client.startClient();
        client.addListener("NewTextEntry", this::onNewTextEntry);
    }

    private void onNewTextEntry(PropertyChangeEvent propertyChangeEvent) {
        support.firePropertyChange(propertyChangeEvent);
    }


    @Override
    public String sendMessage(String username,String text) {
        return client.message(username, text);
    }

    @Override
    public List<Message> getMessage() {
        return client.getMessages();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);
    }
}
