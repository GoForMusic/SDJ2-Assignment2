package chat.Server.model;

import chat.Share.transferobjects.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatImpl implements Chat{
    private PropertyChangeSupport support;
    private List<Message> messages;

    public ChatImpl()
    {
        support=new PropertyChangeSupport(this);
        messages=new ArrayList<>();
    }

    @Override
    public String sendMessage(String str) {
        String result = str.toUpperCase();
        Message logEntry = new Message(str, result);
        messages.add(logEntry);
        support.firePropertyChange("NewMessageEntry", null, logEntry);
        return result;
    }

    @Override
    public List<Message> getMessage() {
        return new ArrayList<>(messages);
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
