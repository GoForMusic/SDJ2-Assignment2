package chat.Client.views.chat;

import chat.Client.model.Chat;
import chat.Share.transferobjects.Message;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ChatViewModel {

    private ObservableList<Message> messages;

    private Chat chat;

    public ChatViewModel(Chat chat)
    {
        this.chat =chat;
        loadMessages();
        chat.addListener("NewTextEntry", this::onNewMessageEntry);
    }

    public void onNewMessageEntry(PropertyChangeEvent  evt){
        messages.add((Message) evt.getNewValue());
    }

    public void sendMessage(String message)
    {
        chat.sendMessage(message);
    }

    public void loadMessages(){
        List<Message> messageList = chat.getMessage();
        messages= FXCollections.observableArrayList(messageList);
    }

    public ObservableList<Message> getMessages(){
        return messages;
    }

}
