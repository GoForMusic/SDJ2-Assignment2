package chat.Server.model;

import chat.Share.transferobjects.Message;
import chat.Share.util.Subject;

import java.util.List;

public interface Chat extends Subject {
    String sendMessage(String str);
    List<Message> getMessage();
}
