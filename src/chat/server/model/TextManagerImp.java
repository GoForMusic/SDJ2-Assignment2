package chat.server.model;

import chat.shared.transferoobjects.Messages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class TextManagerImp implements TextManager{
    private PropertyChangeSupport support;
    private ArrayList<Messages> stringEntries;

    public TextManagerImp(){
        support=new PropertyChangeSupport(this);
        stringEntries=new ArrayList<>();
    }


    @Override
    public String sendMessages(String str) {
        String result = str;
        Messages logEntry = new Messages(str, result);
        stringEntries.add(logEntry);
        support.firePropertyChange("NewMessages", null, logEntry);
        return result;
    }

    @Override
    public ArrayList<Messages> getMessages() {
        return new ArrayList<>(stringEntries);
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
