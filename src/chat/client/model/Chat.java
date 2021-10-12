package chat.Client.model;

import chat.Share.transferobjects.Message;
import chat.Share.util.Subject;

import java.util.List;

public interface Chat extends Subject {
    public String sendMessage(String username,String text);
    public List<Message> getMessage();
}
