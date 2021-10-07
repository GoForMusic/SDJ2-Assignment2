package chat.server.model;

import chat.shared.transferoobjects.Messages;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TextManagerImp implements TextManager{
    private PropertyChangeSupport support;
    private List<Messages> stringEntries;

    public TextManagerImp(){
        support=new PropertyChangeSupport(this);
        stringEntries=new ArrayList<>();
    }


    @Override
    public String sendMessages(String str) {
        String result = str.toUpperCase();
        Messages textEntry = new Messages(str, result);
        stringEntries.add(textEntry);
        support.firePropertyChange("NewTextEntry", null, textEntry);
        return result;
    }

    @Override
    public List<Messages> getMessages() {
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
